package com.aliindustries.groceryshoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {
    CountDownTimer mCountDownTimer;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        title = (TextView) findViewById(R.id.splashscreentitle);


        android.graphics.Typeface custom_font2 = android.graphics.Typeface.createFromAsset(getAssets(),  "fonts/blanka.ttf");
        title.setTypeface(custom_font2);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        }
        title.startAnimation(AnimationUtils.loadAnimation(splashscreen.this, R.anim.fade_in_anim));
        mCountDownTimer=new CountDownTimer(2400,1000) {
            @Override
            public void onTick(long millisUntilFinished) {


            }

            @Override
            public void onFinish() {

                Intent i = new Intent(splashscreen.this, MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        };
        mCountDownTimer.start();


    }
}
