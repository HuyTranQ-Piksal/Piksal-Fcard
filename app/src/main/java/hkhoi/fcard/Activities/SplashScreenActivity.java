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
import hkhoi.fcard.Others.ParallaxPageTransformer;
import hkhoi.fcard.R;
import hkhoi.fcard.SplashScreenFragments.Splash01Fragment;
import hkhoi.fcard.SplashScreenFragments.Splash02Fragment;
import hkhoi.fcard.SplashScreenFragments.Splash03Fragment;
import hkhoi.fcard.SplashScreenFragments.Splash04Fragment;

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
        setViewPagerTransformer();
    }

    /**
     * Makes transforming animation more attractive :)
     */
    private void setViewPagerTransformer() {
        ParallaxPageTransformer parallaxPageTransformer = new ParallaxPageTransformer();
        parallaxPageTransformer.addViewToParallax(
                new ParallaxPageTransformer.ParallaxTransformInformation(R.id.fragment_splashScreen_imageView_background, 2, 2)
        );
        parallaxPageTransformer.addViewToParallax(
                new ParallaxPageTransformer.ParallaxTransformInformation(R.id.fragment_splashScreen_textView_title, -0.65f,
                        ParallaxPageTransformer.ParallaxTransformInformation.PARALLAX_EFFECT_DEFAULT)
        );
        parallaxPageTransformer.addViewToParallax(
                new ParallaxPageTransformer.ParallaxTransformInformation(R.id.fragment_splashScreen_button_start, -0.5f,
                        ParallaxPageTransformer.ParallaxTransformInformation.PARALLAX_EFFECT_DEFAULT)
        );
        viewPager.setPageTransformer(true, parallaxPageTransformer);
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

        int[] image = {
                R.drawable.background01,
                R.drawable.background02,
                R.drawable.background01,
                R.drawable.background02
        };
        String[] title = {
                "SCREEN 1",
                "SCREEN 2",
                "SCREEN 3",
                "SCREEN 4"
        };

        fragments.add(new Splash01Fragment());
        fragments.add(new Splash02Fragment());
        fragments.add(new Splash03Fragment());
        fragments.add(new Splash04Fragment());
    }

    /**
     * @param view To handle onClick event of splash screen
     */
    public void SplashScreenOnclick(View view) {
        switch (view.getId()) {
            case R.id.fragment_splashScreen_button_start:
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
