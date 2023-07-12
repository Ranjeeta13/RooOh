package com.example.project_1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.project_1.Adaptor.CategoryAdaptor;
import com.example.project_1.Adaptor.PopularAdaptor;
import com.example.project_1.Domain.CategoryDomain;
import com.example.project_1.Domain.FoodDomain;
import com.example.project_1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,MainActivity2.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.cartView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain>category=new ArrayList<>();
        category.add(new CategoryDomain("Chaat","chaat"));
        category.add(new CategoryDomain("Jalebi","jalebi"));
        category.add(new CategoryDomain("Samosa","samosa"));
        category.add(new CategoryDomain("Bread Bonda","breadbonda"));

        adapter=new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);

    }
    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain>foodList=new ArrayList<>();
        foodList.add(new FoodDomain("Fried Idli ","friedidli","6 piece per plate",80.00,24));
        foodList.add(new FoodDomain("Veg Biryani","vegbiryani","soya chunks -veg",90.00,10));
        foodList.add(new FoodDomain("Vada Sambhaar","vadasambhaar","2 piece per plate",40.00,45));
        foodList.add(new FoodDomain("Gulab Jamun","gulabjamun","sweet",12.00,100));

        adapter2=new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);

    }

}