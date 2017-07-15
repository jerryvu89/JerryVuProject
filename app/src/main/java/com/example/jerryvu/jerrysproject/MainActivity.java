package com.example.jerryvu.jerrysproject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private GestureDetectorCompat gestureObject;

    Button btnViewpagerActivity;
    Button btnListviewActivity;
    Button btnCheckboxActivity;
    Button btnSQliteActivty;
    Button btnSQliteReadActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        btnListviewActivity = (Button)findViewById(R.id.Listview_btn);
        btnViewpagerActivity = (Button)findViewById(R.id.Viewpager_btn);
        btnCheckboxActivity = (Button)findViewById(R.id.Checkbox_btn);
        btnSQliteActivty = (Button)findViewById(R.id.SQlite_btn);
        btnSQliteReadActivity = (Button)findViewById(R.id.SQliteRead_btn);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
        // learnGesture is class file
    }

    public void clickExit(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to exit?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
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
                Intent intent = new Intent(MainActivity.this, ViewpagerActivity.class);
                finish();
                startActivity(intent);
            }
            else
            if(event2.getX() < event1.getX()){
                // code for swipe right to left
                Intent intent = new Intent(MainActivity.this, ListviewActivity.class);
                finish();
                startActivity(intent);
            }
            return true;
        }
    }


    public void btnListview(View v) {
        Intent i = new Intent(this, ListviewActivity.class);
        startActivity(i);
    }

    public void btnViewpager(View v){
        Intent i = new Intent(this, ViewpagerActivity.class);
        startActivity(i);
    }

    public void btnCheckbox(View v){
        Intent i = new Intent(this, CheckboxActivity.class);
        startActivity(i);
    }

    public void btnSQlite(View v){
        Intent i = new Intent(this, SQliteActivity.class);
        startActivity(i);
    }

    public void btnSQliteRead(View v){
        Intent i = new Intent(this, SQliteReadActivity.class);
        startActivity(i);
    }
}
