package com.example.assignment2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class addRestaurant extends AppCompatActivity {

    Button btAddtoList;
    EditText etName,etPhone,etLocation,etRatings,etDesc;
    ImageView ivback;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);
        etName=findViewById(R.id.etname);
        etPhone=findViewById(R.id.etphone);
        etLocation=findViewById(R.id.etloc);
        etRatings=findViewById(R.id.etRatings);
        etDesc=findViewById(R.id.etdesc);
        ivback=findViewById(R.id.ivback);
        btAddtoList=findViewById(R.id.btaddtolist);
        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btAddtoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String name=etName.getText().toString();
                String desc=etDesc.getText().toString();
                String phone=etPhone.getText().toString();
                String loc=etLocation.getText().toString();
                String rating=etRatings.getText().toString();
                if(name.isEmpty() || desc.isEmpty()|| phone.isEmpty() || loc.isEmpty() || rating.isEmpty())
                {
                    Toast.makeText(addRestaurant.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else {
                    Restaurant restaurant = new Restaurant(name, desc, phone, loc, rating);
                    //intent.putExtra("yuh","heheheheeeeeee");
                    intent.putExtra("restaurantObject", restaurant);
                    setResult(55, intent);
                    finish();
                }

            }
        });
    }
}