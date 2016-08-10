package it.moov.moovandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;

public class BaseActivity extends AppCompatActivity {

    //--------------
    //--HELPERS
    //--------------

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                returnToParentActivity();
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onBackPressed() {
        returnToParentActivity();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            returnToParentActivity();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    protected void returnToParentActivity() {
        finish();
    }
}
