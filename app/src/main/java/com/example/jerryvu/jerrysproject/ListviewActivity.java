package com.example.jerryvu.jerrysproject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends Activity {

    private ListView lvProduct;
    private ProductListAdapter adapter;
    private List<Product> mProductList;

    Button btnViewpagerActivity;
    Button btnAnimationActivity;
    Button btnCheckboxActivity;
    Button btnSQliteActivty;
    Button btnSQliteReadActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        btnViewpagerActivity = (Button)findViewById(R.id.Viewpager_btn);
        btnAnimationActivity = (Button)findViewById(R.id.Animation_btn);
        btnCheckboxActivity = (Button)findViewById(R.id.Checkbox_btn);
        btnSQliteActivty = (Button)findViewById(R.id.SQlite_btn);
        btnSQliteReadActivity = (Button)findViewById(R.id.SQliteRead_btn);

        lvProduct = (ListView)findViewById(R.id.listview_product);

        mProductList = new ArrayList<>();
        // Add sample data for list
        // Get data from DB, webservice
        mProductList.add(new Product(1, "iPhone4", 200, "Apple iPhone4 16GB"));
        mProductList.add(new Product(2, "iPhone4S", 250, "Apple iPhone4S 16GB"));
        mProductList.add(new Product(3, "iPhone5", 300, "Apple iPhone5 16GB"));
        mProductList.add(new Product(4, "iPhone5S", 350, "Apple iPhone5S 16GB"));
        mProductList.add(new Product(5, "iPhone6", 400, "Apple iPhone6 16GB"));
        mProductList.add(new Product(6, "iPhone6S", 450, "Apple iPhone6S 16GB"));
        mProductList.add(new Product(7, "iPhone7", 500, "Apple iPhone7 16GB"));
        mProductList.add(new Product(8, "iPhone7S", 600, "Apple iPhone7S 16GB"));
        mProductList.add(new Product(9, "iPhone8", 700, "Apple iPhone8 16GB"));
        mProductList.add(new Product(10, "iPhone8S", 800, "Apple iPhone8S 16GB"));

        // Init adapter
        adapter = new ProductListAdapter(getApplicationContext(), mProductList);
        lvProduct.setAdapter(adapter);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Display msg with product id get from view.getTag
                Toast.makeText(getApplicationContext(), "Clicked product id =" + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clickExit(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(ListviewActivity.this);
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
