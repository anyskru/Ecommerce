package com.example.ecommerce.Activity;


import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.ecommerce.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init(){
        image=findViewById(R.id.image);
        glide();
    }


    private void glide(){
        Glide.with(this)
                //.load("https://moodle.htwchur.ch/pluginfile.php/124614/mod_page/content/4/example.jpg")
                // .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRuzTBZsDV4fHjfuVz1CpF226F5R0NTbZdIA&usqp=CAU")
                .load("https://d13genyhhfmqry.cloudfront.net/large/mcs_Departmental_Store_09_2020-05-26-13-44-29-000510.jpg")
               // .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSN6t_Uh466EczdqYbRe7pEyrlO_O6HnxPpAw&usqp=CAU")
                .fitCenter()
                .into(image);

    }




}

