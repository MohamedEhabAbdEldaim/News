package com.midooabdaim.news.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

import androidx.databinding.DataBindingUtil;

import com.midooabdaim.news.R;
import com.midooabdaim.news.databinding.FragmentSplashBinding;
import com.midooabdaim.news.ui.fragment.viewCountery.CountryViewFragment;

import static com.midooabdaim.news.helper.HelperMethod.replaceFragment;


public class SplashFragment extends BaseFragment {
    FragmentSplashBinding binding;

    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        //return inflater.inflate(R.layout.fragment_splash, container, false);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false);
        View view = binding.getRoot();
        binding.setLifecycleOwner(getActivity());
        setAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                replaceFragment(getActivity().getSupportFragmentManager(), R.id.main_Activity_frame_layout_id, new CountryViewFragment());
            }
        }, 6800);
        return view;
    }

    void setAnimation() {
        AlphaAnimation alphaAnimationStart = new AlphaAnimation(.2f, 1.0f);
        alphaAnimationStart.setDuration(2500);
        ScaleAnimation scaleAnimation = new ScaleAnimation(.3f, 1.0f, .3f, 1.0f, Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        scaleAnimation.setDuration(2000);
        RotateAnimation rotateAnimationRight = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        rotateAnimationRight.setStartOffset(2500);
        rotateAnimationRight.setDuration(2000);
        RotateAnimation rotateAnimationLeft = new RotateAnimation(360f, 0f, Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        rotateAnimationLeft.setStartOffset(4600);
        rotateAnimationLeft.setDuration(2000);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimationStart);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimationRight);
        animationSet.addAnimation(rotateAnimationLeft);
        binding.fragmentSplashImvImageSplash.setAnimation(animationSet);
    }


    @Override
    public void onStart() {
        super.onStart();
        intialFragment();
    }

    @Override
    public void BackPressed() {
        getActivity().finish();
    }
}