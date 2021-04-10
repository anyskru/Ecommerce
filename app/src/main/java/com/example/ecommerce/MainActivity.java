package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.example.ecommerce.Activity.HomeActivity;
import com.example.ecommerce.Adapter.GridViewAdapter;
import com.example.ecommerce.Adapter.ProductAdapter;
import com.example.ecommerce.Items.GridList;
import com.example.ecommerce.Items.ProductList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout_main;
    ArrayList<ProductList> productListArrayList;
    ArrayList<GridList> gridListArrayList;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=MainActivity.this;
        init();
    }



    private void init(){
        layout_main=findViewById(R.id.layout_main);
        TextView btn_click_Image=findViewById(R.id.btn_click_Image);
        btn_click_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);
            }
        });

        jsonDataParsing();

    }

    private void jsonDataParsing(){
        try {
            JSONObject jsonObject=new JSONObject(new Utils().JsonDataFromAsset(context));
            JSONArray jsonArray=jsonObject.getJSONArray("data");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject data=jsonArray.getJSONObject(i);
                if(data.getString("type").equalsIgnoreCase("image")){
                    addImageView(data.getString("imageURL"));
                }

                if(data.getString("type").equalsIgnoreCase("list")){
                    ArrayList<ProductList> productListArrayList= new ArrayList<ProductList>();
                    JSONArray jsonArraylist=data.getJSONArray("listData");
                    Log.e("productName", String.valueOf(jsonArraylist.length()));
                    for(int ii=0;ii<jsonArraylist.length();ii++) {
                        JSONObject datalist=jsonArraylist.getJSONObject(ii);
                        productListArrayList.add(new ProductList(
                                datalist.getString("imageURL"),
                                datalist.getString("productName"),
                                datalist.getString("mrpPrice"),
                                datalist.getString("dmartPrice"),
                                datalist.getString("savedPRice"),
                                datalist.getString("quantity")));
                        Log.e("productName", datalist.getString("productName") + productListArrayList.size());
                    }
                    addList(productListArrayList);
                }

                if(data.getString("type").equalsIgnoreCase("grid")){
                    ArrayList<GridList> gridListArrayList= new ArrayList<GridList>();
                    JSONArray jsonArraylist=data.getJSONArray("listData");
                    Log.e("productName", String.valueOf(jsonArraylist.length()));
                    for(int ii=0;ii<jsonArraylist.length();ii++) {
                        JSONObject datalist=jsonArraylist.getJSONObject(ii);
                        gridListArrayList.add(new GridList(
                                datalist.getString("imageURL"),
                                datalist.getString("productName")));
                        Log.e("productName", datalist.getString("productName") + gridListArrayList.size());
                    }
                    addGrid(gridListArrayList, Integer.parseInt(data.getString("column")));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



    private void addImageView(String imageURL){
        View view = getLayoutInflater().inflate(R.layout.grid_view_items, null, false);
        ImageView image= new ImageView(this);
        Glide.with(this)
                .load(imageURL)
                .fitCenter()
                .into(image);
        layout_main.addView(image/*view*/);
    }

    private void addList(ArrayList<ProductList> productListArrayList){
        View viewSecond = getLayoutInflater().inflate(R.layout.recycleview_product_list, null, false);
        RecyclerView recyclerView = (RecyclerView) viewSecond.findViewById(R.id.recycleview_product_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        Log.e("productName",""+productListArrayList.toString());
        ProductAdapter adapter = new ProductAdapter(MainActivity.this,productListArrayList);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);Log.e("productName",""+recyclerView.getChildItemId(recyclerView));
        layout_main.addView(/*recyclerView*/viewSecond);

    }

    private void addGrid(ArrayList<GridList> gridListArrayList,int column){

        View viewThird = getLayoutInflater().inflate(R.layout.recycleview_grid_list, null, false);
        RecyclerView recycleview_grid = (RecyclerView) viewThird.findViewById(R.id.recycleview_grid);
        GridLayoutManager layoutManager=new GridLayoutManager(this,column);
        recycleview_grid.setLayoutManager(layoutManager);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(MainActivity.this,gridListArrayList);
        recycleview_grid.setAdapter(gridViewAdapter);
        layout_main.addView(viewThird /*recycleview_grid*/);
    }







}
