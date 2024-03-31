
package com.example.assignment2;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvRest;
    Button btAdd;
    EditText etSearch;
    ArrayList<Restaurant> restaurants;
    RestaurantAdapter adapter;
    ActivityResultLauncher<Intent> activitylauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onActivityResult(ActivityResult o) {
                    Log.d(TAG ,"onActivityResult();");
                    if(o.getResultCode()==55)
                    {
                        Intent intent=o.getData();
                        if(intent!=null){
                            Restaurant restaurant = (Restaurant) intent.getSerializableExtra("restaurantObject");
                            if(restaurant!=null){
                                restaurants.add(restaurant);
                                adapter.notifyDataSetChanged();
                                //  Toast.makeText(MainActivity.this, restaurant.getName()+" "+restaurant.getDesc()+" "+restaurant.getLoc()+" "+restaurant.getPhone()+" "+restaurant.getRating(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                }
            });
    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvRest=findViewById(R.id.rvRestaurants);
        btAdd=findViewById(R.id.btAdd);
        etSearch=findViewById(R.id.etsearch);
        restaurants=new ArrayList<>();
        adapter=new RestaurantAdapter(restaurants);
        restaurants.add(new Restaurant("Tuscany Courtyard","Italian food","0337467239","gulberg MM Alam","4.3"));
        restaurants.add(new Restaurant("The Villa","Several different cuisines","0926483887","gulberg MM Alam","4.4"));
        restaurants.add(new Restaurant("Gauchos","By steak house","0337725584","gulberg MM Alam","4.9"));
        restaurants.add(new Restaurant("Urban Kitchen","Miscellanous","02136712356","gulberg Main Bolevard","3.9"));
        restaurants.add(new Restaurant("Howdy","Australian food","0333242344","gulberg MM Alam","3.5"));



        rvRest.setLayoutManager(new LinearLayoutManager(this));
        rvRest.setAdapter(adapter);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,addRestaurant.class);
                activitylauncher.launch(intent);
            }
        });
        etSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (etSearch.getRight() - etSearch.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // DrawableEnd clicked
                        float rating=Float.parseFloat(etSearch.getText().toString());
                        Toast.makeText(MainActivity.this, "Searching "+rating+"+ restaurants", Toast.LENGTH_SHORT).show();
                        for(int i=0;i<restaurants.size();i++)
                        {
                            if(Float.parseFloat(restaurants.get(i).getRating())<rating)
                            {
                                restaurants.add(restaurants.remove(i));
                                adapter.notifyDataSetChanged();
                            }
                        }
                        return true; // Consume the touch event
                    }
                }
                return false; // Let the system handle the touch event
            }
        });

    }
}