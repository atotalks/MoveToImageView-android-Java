package com.example.movetoimageview_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.BounceInterpolator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView i1;
    private ImageView i2;
    private ImageView i3;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initailizeUI();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.MoveButton:

                rotate();
                break;
        }
    }

    public void initailizeUI() {

        i1 = (ImageView) findViewById(R.id.android);
        i2 = (ImageView) findViewById(R.id.android2);
        i3 = (ImageView) findViewById(R.id.android3);
        b1 = (Button) findViewById(R.id.MoveButton);
        b1.setOnClickListener(this);

    }


    private void rotate() {

        ObjectAnimator r1 = ObjectAnimator.ofFloat(i1, View.ROTATION, 0f, 90f)
                .setDuration(1000);
        r1.setInterpolator(new BounceInterpolator());

        ObjectAnimator r2 = ObjectAnimator.ofFloat(i1, View.TRANSLATION_X, 0f, 1400f)
                .setDuration(1000);
        r2.setInterpolator(new BounceInterpolator());


        AnimatorSet ani1 = new AnimatorSet();
        ani1.play( r1 ).before( r2 );


        AnimatorSet ani2 = new AnimatorSet();
        ani2.play(ani1);
        ani2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
//                Toast.makeText(MainActivity.this, "Animation Start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animator) {
//                Toast.makeText(MainActivity.this, "Animation Fininsed", Toast.LENGTH_SHORT).show();
                rotate_after();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        ani2.start();
    }


    private void rotate_after() {

        ObjectAnimator r3 = ObjectAnimator.ofFloat(i2, View.TRANSLATION_X, 0f, 1400f)
                .setDuration(1000);
        r3.setInterpolator(new BounceInterpolator());

        AnimatorSet ani4 = new AnimatorSet();
        ani4.play( r3 );

        AnimatorSet ani3 = new AnimatorSet();
        ani3.play(ani4);
        ani3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
//                Toast.makeText(MainActivity.this, "Animation Start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animator) {
//                Toast.makeText(MainActivity.this, "Animation Fininsed", Toast.LENGTH_SHORT).show();
                rotate_after3();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        ani3.start();
    }


    private void rotate_after3() {

        i3.setVisibility(View.VISIBLE);

        ObjectAnimator r4 = ObjectAnimator.ofFloat(i3, View.TRANSLATION_X, 0f, 1400f)
                .setDuration(1000);
        r4.setInterpolator(new BounceInterpolator());

        AnimatorSet ani1 = new AnimatorSet();
        ani1.play( r4 );


        AnimatorSet ani3 = new AnimatorSet();
        ani3.play(ani1);
        ani3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
//                Toast.makeText(MainActivity.this, "Animation Start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animator) {
//                Toast.makeText(MainActivity.this, "Animation Fininsed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        ani3.start();
    }


}
