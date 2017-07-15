package com.example.jerryvu.jerrysproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Jerry Vu on 7/13/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public void shortToast(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void goToActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

}
