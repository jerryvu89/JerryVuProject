package com.example.jerryvu.jerrysproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class ViewpagerActivity extends AppCompatActivity {

    List<Integer> lstImages = new ArrayList<>();

    Button btnListviewActivity;
    Button btnAnimationActivity;
    Button btnCheckboxActivity;
    Button btnSQliteActivty;
    Button btnSQliteReadActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        btnListviewActivity = (Button)findViewById(R.id.Listview_btn);
        btnAnimationActivity = (Button)findViewById(R.id.Animation_btn);
        btnCheckboxActivity = (Button)findViewById(R.id.Checkbox_btn);
        btnSQliteActivty = (Button)findViewById(R.id.SQlite_btn);
        btnSQliteReadActivity = (Button)findViewById(R.id.SQliteRead_btn);
        
        initData();

        HorizontalInfiniteCycleViewPager pager = (HorizontalInfiniteCycleViewPager)findViewById(R.id.horizontal_cycle);
        ViewpagerAdapter adapter = new ViewpagerAdapter(lstImages, getBaseContext());
        pager.setAdapter(adapter);

    }

    public void clickExit(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(ViewpagerActivity.this);
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

    private void initData() {
        lstImages.add(R.drawable.drawingb);
        lstImages.add(R.drawable.drawingg);
        lstImages.add(R.drawable.applebackground);
    }

    public void btnListview(View v) {
        Intent i = new Intent(this, ListviewActivity.class);
        startActivity(i);
    }

    public void btnAnimation(View v){
        Intent i = new Intent(this, MainActivity.class);
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
