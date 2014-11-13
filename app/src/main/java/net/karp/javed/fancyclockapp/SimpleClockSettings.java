package net.karp.javed.fancyclockapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class SimpleClockSettings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_clock_settings);
        setTitle(R.string.title_activity_simple_clock_settings);
    }


}
