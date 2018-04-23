package wastengage.valian.com.wastengage.Intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;

import wastengage.valian.com.wastengage.MainActivity;


public class IntroductionActivity extends AppIntro   {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setFadeAnimation();
        //setZoomAnimation();
        //setFlowAnimation();
        //setSlideOverAnimation();
        //setDepthAnimation();
        showSeparator(true);
        addSlide(new IntroFrag1().getInstance("Giving Back To Nature What Belongs To Nature","http://wastengage.com/wp/wp-content/uploads/2017/07/1.jpg"));
        addSlide(new IntroFrag1().getInstance("Nature Doesn't Need People, People Need Nature  ","http://wastengage.com/wp/wp-content/uploads/2017/07/3.jpg"));
        addSlide(new IntroFrag1().getInstance("We Work To Create Better Environment For The World  ","http://wastengage.com/wp/wp-content/uploads/2017/07/4.jpg"));
        addSlide(new IntroFrag1().getInstance("Wastengage - The New Password To Reset Swatch Bharat Mission  ","http://wastengage.com/wp/wp-content/uploads/2017/07/2.jpg"));
        addSlide(new IntroFrag1().getInstance("Facilitate Recyclers By Segregating Into Dry, Wet And Hazardous Waste  ","http://wastengage.com/wp/wp-content/uploads/2017/07/5.jpg"));
        //addSlide(new IntroFrag2());



    }
    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent i = new Intent(IntroductionActivity.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        //Toast.makeText(IntroductionActivity.this,"Done",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(IntroductionActivity.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        //Toast.makeText(IntroductionActivity.this,"Changed",Toast.LENGTH_SHORT).show();
    }

}
