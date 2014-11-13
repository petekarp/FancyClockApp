package net.karp.javed.fancyclockapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class MainActivity extends Activity {

    SimpleDateFormat timeFormat, dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateClock("hh:mm:ss a", "MMMM dd, yyyy");

    }

    public void updateClock(final String timeString, final String dateString){
        // Updates Simple Clock every second
        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String time, date;
                                Calendar cal = Calendar.getInstance();
                                Date c = cal.getTime();
                                timeFormat = new SimpleDateFormat(timeString);
                                time = timeFormat.format(c);
                                dateFormat = new SimpleDateFormat(dateString);
                                date = dateFormat.format(c);
                                TextView timeView = (TextView) findViewById(R.id.time_view);
                                TextView dateView = (TextView) findViewById(R.id.date_view);
                                timeView.setText(time);
                                dateView.setText(date);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
