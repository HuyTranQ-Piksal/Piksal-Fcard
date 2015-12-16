package hkhoi.fcard.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import hkhoi.fcard.Others.CommonUtility;
import hkhoi.fcard.R;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private String firstTimeKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        firstTimeKey = getString(R.string.preferences_firstTime);
        /* If this is the first-time run, then go to splash-screen */
        if (CommonUtility.isFirstTimeRun(this, firstTimeKey)) {
            Log.d("MainActivity", "GO TO SPLASH SCREEN");
//            CommonUtility.setFirstTimeRun(this, firstTimeKey, false);
            intent = new Intent(this, SplashScreenActivity.class);
        } else {
            /* Else, go to menu */
            Log.d("MainActivity", "GO TO MENU");
            intent = new Intent(this, MenuActivity.class);
        }

        intent.putExtra("layout" , R.layout.activity_menu);
        startActivity(intent);
        finish();
    }
}
