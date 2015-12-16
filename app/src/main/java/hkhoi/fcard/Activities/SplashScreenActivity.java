package hkhoi.fcard.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

import hkhoi.fcard.Adapters.FragmentPagerAdapterImp;
import hkhoi.fcard.Others.CommonUtility;
import hkhoi.fcard.R;
import hkhoi.fcard.SplashScreenFragments.Help1Fragment;
import hkhoi.fcard.SplashScreenFragments.Help2Fragment;
import hkhoi.fcard.SplashScreenFragments.Help3Fragment;
import hkhoi.fcard.SplashScreenFragments.Help4Fragment;

/**
 * This class accounts for introduction screen
 */
public class SplashScreenActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<Fragment> fragments;
    private FragmentPagerAdapterImp fragmentPagerAdapterImp;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        initViews();
    }

    /**
     * Initialize all views
     */
    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.activity_splashScreen_viewPager_screen);
        initFragments();
        initAdapter();
        viewPager.setAdapter(fragmentPagerAdapterImp);
//        setViewPagerTransformer();
    }

    /**
     * Initialize adapter for the viewpager
     */
    private void initAdapter() {
        fragmentPagerAdapterImp =
                new FragmentPagerAdapterImp(getSupportFragmentManager(), fragments);
    }

    /**
     * Put all fragments in the list of fragments
     * TODO: Add more splash-screens here
     */
    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new Help1Fragment());
        fragments.add(new Help2Fragment());
        fragments.add(new Help3Fragment());
        fragments.add(new Help4Fragment());
    }

    /**
     * @param view To handle onClick event of splash screen
     */
    public void SplashScreenOnclick(View view) {
        switch (view.getId()) {
            case R.id.fragment_help_button_start:
                CommonUtility.setFirstTimeRun(this, getString(R.string.preferences_firstTime), false);
                intent = new Intent(this, MenuActivity.class);
                break;
            default:
                Log.d("SplashScreenActivity", "Something wrong with SplashScreenOnClick");
                break;
        }

        startActivity(intent);
        finish();
    }
}
