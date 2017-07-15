package com.example.jerryvu.jerrysproject;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class GestureActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;

    Button btnViewpagerActivity;
    Button btnListviewActivity;
    Button btnCheckboxActivity;
    Button btnAnimationActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        btnListviewActivity = (Button)findViewById(R.id.Listview_btn);
        btnViewpagerActivity = (Button)findViewById(R.id.Viewpager_btn);
        btnCheckboxActivity = (Button)findViewById(R.id.Checkbox_btn);
        btnAnimationActivity = (Button)findViewById(R.id.Animation_btn);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
        // learnGesture is class file
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    // create the gesture Object Class
    class LearnGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
            if(event2.getX() > event1.getX()){
                // code for swipe left to right
                Intent intent = new Intent(GestureActivity.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
            else
            if(event2.getX() < event1.getX()){
                // code for swipe right to left
                Intent intent = new Intent(GestureActivity.this, ViewpagerActivity.class);
                finish();
                startActivity(intent);
            }
            return true;
        }
    }

    public void btnViewpager(View v){
        Intent i = new Intent(this, ViewpagerActivity.class);
        startActivity(i);
    }

    public void btnAnimation(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void btnListview(View v){
        Intent i = new Intent(this, ListviewActivity.class);
        startActivity(i);
    }

    public void btnCheckbox(View v){
        Intent i = new Intent(this, CheckboxActivity.class);
        startActivity(i);
    }
}
