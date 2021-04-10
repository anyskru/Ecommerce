package com.example.ecommerce.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.example.ecommerce.Items.GridList;
import com.example.ecommerce.R;

import java.util.ArrayList;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.MyViewHolder> {

    private ArrayList<GridList> gridLists;
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_product_name;
        ImageView image_product;



        public MyViewHolder(View view) {
            super(view);
            txt_product_name = (TextView) itemView.findViewById(R.id.txt_product_name);
            image_product= (ImageView) itemView.findViewById(R.id.image_product);


        }

    }

    public GridViewAdapter(Context mcontext,ArrayList<GridList> gridLists) {
        context=mcontext;
        this.gridLists=gridLists;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridview_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final GridList productList = gridLists.get(position);

        holder.txt_product_name.setText(productList.getProductname());
        Glide.with(context)
                .load(productList.getImageURL())
                .fitCenter()
                .into(holder.image_product);
    }




    @Override
    public int getItemCount() {
        return gridLists.size();
    }
}

