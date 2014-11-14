package net.karp.javed.fancyclockapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;


public class SimpleClockSettings extends Activity {

    boolean militaryTime;
    String clockColor, clockSize;

    final String MILITARY_TIME = "military_time",
        CLOCK_COLOR = "clock_color",
        CLOCK_SIZE = "clock_size";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_clock_settings);
        setTitle(R.string.title_activity_simple_clock_settings);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());;

        // Settings for 24 hour time
        final Switch militaryTimeSwitch = (Switch) findViewById(R.id.militaryTimeSwitch);
        // Restore settings (if any)
        militaryTimeSwitch.setChecked(prefs.getBoolean(MILITARY_TIME, false));
        // Listener
        militaryTimeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    militaryTime = true;
                } else {
                    // The toggle is disabled
                    militaryTime = false;
                }
                SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean(MILITARY_TIME, militaryTime);
                    editor.commit();
            }
        });



        // Settings for Clock Color
        final Spinner clockColorSpinner = (Spinner) findViewById(R.id.clockColorSpinner);
        // Populating dropdown
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.colors_array, R.layout.spinner_layout);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clockColorSpinner.setAdapter(adapter);
        // Restore settings (if any)
        int pos = adapter.getPosition(prefs.getString(CLOCK_COLOR, getResources().getStringArray(R.array.colors_array)[0]));
        clockColorSpinner.setSelection(pos);
        // Listener
        clockColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                clockColor = (String) parent.getItemAtPosition(pos);
                SharedPreferences.Editor editor = prefs.edit();
                    editor.putString(CLOCK_COLOR, clockColor);
                    editor.commit();
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Do Nothing
            }
        });

        // Settings for Clock Size
        final Spinner clockSizeSpinner = (Spinner) findViewById(R.id.clockSizeSpinner);
        // Populating dropdown
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.size_array, R.layout.spinner_layout);
        //adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clockSizeSpinner.setAdapter(adapter2);
        // Restore settings (if any)
        int pos2 = adapter2.getPosition(prefs.getString(CLOCK_SIZE, getResources().getStringArray(R.array.size_array)[0]));
        clockSizeSpinner.setSelection(pos2);
        // Listener
        clockSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                clockSize = (String) parent.getItemAtPosition(pos);
                SharedPreferences.Editor editor = prefs.edit();
                    editor.putString(CLOCK_SIZE, clockSize);
                    editor.commit();
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Do Nothing
            }
        });

    }

    protected void onSaveInstanceStat(Bundle b){
        b.putBoolean(MILITARY_TIME, militaryTime);
        b.putString(CLOCK_COLOR, clockColor);
        b.putString(CLOCK_SIZE, clockSize);

    }

}
