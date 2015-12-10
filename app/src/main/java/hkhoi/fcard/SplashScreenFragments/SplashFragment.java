package hkhoi.fcard.SplashScreenFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import hkhoi.fcard.R;

/**
 * Created by huytr on 10-12-2015.
 */
public class SplashFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int imageLink = getArguments().getInt("Image");
        String title = getArguments().getString("Title");
        View view;
        if (!getArguments().getBoolean("isFinal"))
            view = inflater.inflate(R.layout.fragment_splash , container , false);
        else
            view = inflater.inflate(R.layout.fragment_splash_final, container, false);
        Picasso.with(getContext()).load(imageLink).into((ImageView) view.findViewById(R.id.fragment_splash_imageView));
        ((TextView) view.findViewById(R.id.fragment_splash_textView)).setText(title);
        return view;
    }
}
