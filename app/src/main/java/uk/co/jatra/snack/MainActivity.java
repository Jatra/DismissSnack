package uk.co.jatra.snack;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final SparseArrayCompat<String> dismissReasons = new SparseArrayCompat<String>(){{
        put(Snackbar.Callback.DISMISS_EVENT_SWIPE, "DISMISS_EVENT_SWIPE");
        put(Snackbar.Callback.DISMISS_EVENT_ACTION, "DISMISS_EVENT_ACTION");
        put(Snackbar.Callback.DISMISS_EVENT_TIMEOUT, "DISMISS_EVENT_TIMEOUT");
        put(Snackbar.Callback.DISMISS_EVENT_MANUAL, "DISMISS_EVENT_MANUAL");
        put(Snackbar.Callback.DISMISS_EVENT_CONSECUTIVE, "DISMISS_EVENT_CONSECUTIVE");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Toast for a snack", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setCallback(new Snackbar.Callback() {
                            /**
                             * Called when the given {@link Snackbar} has been dismissed, either through a time-out,
                             * having been manually dismissed, or an action being clicked.
                             *
                             * @param snackbar The snackbar which has been dismissed.
                             * @param event    The event which caused the dismissal. One of either:
                             *                 {@link #DISMISS_EVENT_SWIPE}, {@link #DISMISS_EVENT_ACTION},
                             *                 {@link #DISMISS_EVENT_TIMEOUT}, {@link #DISMISS_EVENT_MANUAL} or
                             *                 {@link #DISMISS_EVENT_CONSECUTIVE}.
                             * @see Snackbar#dismiss()
                             */
                            @Override
                            public void onDismissed(Snackbar snackbar, int event) {
                                super.onDismissed(snackbar, event);
                                Toast.makeText(MainActivity.this, "Dismissed snack: "+dismissReasons.get(event), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
