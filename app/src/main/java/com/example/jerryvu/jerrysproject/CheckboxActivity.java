package com.example.jerryvu.jerrysproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import java.util.HashMap;
import java.util.Map;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckboxActivity extends BaseActivity {

    Button btnViewpagerActivity;
    Button btnListviewActivity;
    Button btnAnimationActivity;
    Button btnSQliteActivty;
    Button btnSQliteReadActivity;

    private HashMap<String, Boolean> list = new HashMap<String, Boolean>(); // To remember all the states of the checkbox

    @BindView(R.id.checkBox1)
    CheckBox checkBox1;
    @BindView(R.id.checkBox2)
    CheckBox checkBox2;
    @BindView(R.id.checkBox3)
    CheckBox checkBox3;
    @BindView(R.id.checkBox4)
    CheckBox checkBox4;
    @BindView(R.id.checkBox5)
    CheckBox checkBox5;
    @BindView(R.id.checkBox6)
    CheckBox checkBox6;
    @BindView(R.id.checkBox7)
    CheckBox checkBox7;
    @BindView(R.id.checkBox8)
    CheckBox checkBox8;
    @BindView(R.id.checkBox9)
    CheckBox checkBox9;
    @BindView(R.id.checkBox10)
    CheckBox checkBox10;

    @OnClick(R.id.buttonselect)
    public void submit(View view){
        String s = "You selected:";
        for(Map.Entry<String, Boolean> entry: list.entrySet()){
            if(entry.getValue()){
                s=s+" "+entry.getKey();
            }
        }
        shortToast(s);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        ButterKnife.bind(this);
        btnViewpagerActivity = (Button) findViewById(R.id.Viewpager_btn);
        btnAnimationActivity = (Button) findViewById(R.id.Animation_btn);
        btnListviewActivity = (Button) findViewById(R.id.Listview_btn);
        btnSQliteActivty = (Button)findViewById(R.id.SQlite_btn);
        btnSQliteReadActivity = (Button)findViewById(R.id.SQliteRead_btn);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });

        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });

        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });

        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });

        checkBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });

        checkBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });

        checkBox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });

        checkBox10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });

    }

    public void clickExit(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(CheckboxActivity.this);
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

    public void btnSQlite(View v){
        Intent i = new Intent(this, SQliteActivity.class);
        startActivity(i);
    }

    public void btnSQliteRead(View v){
        Intent i = new Intent(this, SQliteReadActivity.class);
        startActivity(i);
    }
}
