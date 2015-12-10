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
import hkhoi.fcard.SplashScreenFragments.SplashFragment;

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
                new ParallaxPageTransformer.ParallaxTransformInformation(R.id.fragment_splash_imageView, 2, 2)
        );
        parallaxPageTransformer.addViewToParallax(
                new ParallaxPageTransformer.ParallaxTransformInformation(R.id.fragment_splash_textView, -0.65f,
                        ParallaxPageTransformer.ParallaxTransformInformation.PARALLAX_EFFECT_DEFAULT)
        );
        parallaxPageTransformer.addViewToParallax(
                new ParallaxPageTransformer.ParallaxTransformInformation(R.id.fragment_splash_button, -0.5f,
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
        final String type = "drawable";
        final String packageName = getPackageName();
        final int limit = 4;
        for (int i = 1; i <= limit; ++i)
        {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isFinal", (i == limit));
            String counter = ((i < 10) ? "0" : "") + String.valueOf(i);
            bundle.putString("Title", "SCREEN " + counter);
            String imageName = "background" + counter;
            bundle.putInt("Image", getResources().getIdentifier(imageName, type, packageName));

            Fragment fragment = new SplashFragment();
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
    }

    /**
     * @param view To handle onClick event of splash screen
     */
    public void SplashScreenOnclick(View view) {
        switch (view.getId()) {
            case R.id.fragment_splash_button:
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
