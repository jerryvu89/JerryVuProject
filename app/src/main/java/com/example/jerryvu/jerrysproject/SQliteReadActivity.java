package com.example.jerryvu.jerrysproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SQliteReadActivity extends AppCompatActivity {

    DataBaseHelper myDb;
    TextView txtResult;
    Button btnClick, btnClick2;
    EditText txtId;

    Button btnViewpagerActivity;
    Button btnListviewActivity;
    Button btnCheckboxActivity;
    Button btnSQliteActivty;
    Button btnAnimationActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_read);
        myDb = new DataBaseHelper(this);
        txtId = (EditText) findViewById(R.id.idID);
        txtResult = (TextView) findViewById(R.id.idResult);
        btnClick = (Button) findViewById(R.id.idBtn);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickMe();
            }
        });
        btnClick2 = (Button) findViewById(R.id.idBtn2);
        btnClick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickMe2();
            }
        });

        btnListviewActivity = (Button)findViewById(R.id.Listview_btn);
        btnViewpagerActivity = (Button)findViewById(R.id.Viewpager_btn);
        btnCheckboxActivity = (Button)findViewById(R.id.Checkbox_btn);
        btnSQliteActivty = (Button)findViewById(R.id.SQlite_btn);
        btnAnimationActivity = (Button) findViewById(R.id.Animation_btn);

        txtResult();
    }

    public void clickExit(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(SQliteReadActivity.this);
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

    private void ClickMe(){
        Cursor res = myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if(res!=null && res.getCount()>0){
            while (res.moveToNext()){
                stringBuffer.append("Id: "+res.getString(0)+"\n");
                stringBuffer.append("Name: "+res.getString(1)+"\n");
                stringBuffer.append("iPhone: "+res.getString(2)+"\n");
                stringBuffer.append("Price: "+res.getString(3)+"\n"+"\n");
            }
            txtResult.setText(stringBuffer.toString());
            Toast.makeText(this,"Reservation Data Retrieved Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"No Reservation Data to Retrieve", Toast.LENGTH_SHORT).show();
        }
    }

    private void ClickMe2(){
        String id = txtId.getText().toString();
        int result = myDb.deleteData(id);
        Toast.makeText(this, result + " Reservation deleted", Toast.LENGTH_SHORT).show();
    }

    // This will enable scrolling with the textview
    public void txtResult(){
        String s = "";
        txtResult.setMovementMethod(new ScrollingMovementMethod());
        txtResult.setText(s);
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

    public void btnSQlite(View v){
        Intent i = new Intent(this, SQliteActivity.class);
        startActivity(i);
    }

}
