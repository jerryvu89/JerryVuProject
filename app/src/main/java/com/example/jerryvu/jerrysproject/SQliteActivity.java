package com.example.jerryvu.jerrysproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQliteActivity extends AppCompatActivity {

    Button btnViewpagerActivity;
    Button btnAnimationActivity;
    Button btnCheckboxActivity;
    Button btnListviewActivity;
    Button btnSQliteReadActivity;

    DataBaseHelper myDb;
    EditText txtName, txtiPhone, txtPrice;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        myDb = new DataBaseHelper(this);
        txtName = (EditText) findViewById(R.id.idName);
        txtiPhone = (EditText) findViewById(R.id.idiPhone);
        txtPrice = (EditText) findViewById(R.id.idPrice);
        btnClick = (Button) findViewById(R.id.idBtn);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickMe();
            }
        });

        btnViewpagerActivity = (Button) findViewById(R.id.Viewpager_btn);
        btnAnimationActivity = (Button) findViewById(R.id.Animation_btn);
        btnListviewActivity = (Button) findViewById(R.id.Listview_btn);
        btnCheckboxActivity = (Button)findViewById(R.id.Checkbox_btn);
        btnSQliteReadActivity = (Button)findViewById(R.id.SQliteRead_btn);
    }

    public void clickExit(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(SQliteActivity.this);
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

    private void ClickMe() {
        String name = txtName.getText().toString();
        String iPhone = txtiPhone.getText().toString();
        String price = txtPrice.getText().toString();
        Boolean result = myDb.insertData(name, iPhone, price);
        if (result == true){
            Toast.makeText(this, "Reservation Entered Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Reservation Entered Failed", Toast.LENGTH_SHORT).show();
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

    public void btnSQliteRead(View v){
        Intent i = new Intent(this, SQliteReadActivity.class);
        startActivity(i);
    }
}
