package net.karp.javed.fancyclockapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
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
    Color clockColor;
    int clockSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_clock_settings);
        setTitle(R.string.title_activity_simple_clock_settings);

        final Switch militaryTimeSwitch = (Switch) findViewById(R.id.militaryTimeSwitch);
        // TODO - add onClickListener to Switch
        militaryTimeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    militaryTime = true;
                } else {
                    // The toggle is disabled
                    militaryTime = false;
                }
            }


        });

        final Spinner clockColorSpinner = (Spinner) findViewById(R.id.clockColorSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.colors_array, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clockColorSpinner.setAdapter(adapter);

        clockColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                //DO STUFF HERE
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Do Nothing
            }
        });

        final Spinner clockSizeSpinner = (Spinner) findViewById(R.id.clockSizeSpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.size_array, android.R.layout.simple_spinner_item);
        //adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clockSizeSpinner.setAdapter(adapter2);

        clockSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                //DO STUFF HERE
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Do Nothing
            }
        });


    }




}
