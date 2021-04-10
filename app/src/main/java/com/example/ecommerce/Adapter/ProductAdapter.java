package com.example.ecommerce.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.Items.ProductList;
import com.example.ecommerce.R;


import java.util.ArrayList;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private ArrayList<ProductList> productLists;
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_product_name,txt_mrp,txt_dmart,txt_save,txt_quantity,btn_quantity,btn_add_cart;
        LinearLayout layout_quantity;
        ImageView image_product;

        public MyViewHolder(View view) {
            super(view);
            txt_product_name = (TextView) itemView.findViewById(R.id.txt_product_name);
            txt_mrp = (TextView) itemView.findViewById(R.id.txt_mrp);
            txt_dmart = (TextView) itemView.findViewById(R.id.txt_dmart);
            txt_save = (TextView)itemView.findViewById(R.id.txt_save);
            txt_quantity = (TextView) itemView.findViewById(R.id.txt_quantity);
            btn_quantity = (TextView)itemView.findViewById(R.id.btn_quantity);
            btn_add_cart = (TextView)itemView.findViewById(R.id.btn_add_cart);
            image_product= (ImageView) itemView.findViewById(R.id.image_product);


            layout_quantity= (LinearLayout) itemView.findViewById(R.id.layout_quantity);

        }

    }

    public ProductAdapter(Context mcontext,ArrayList<ProductList> productLists) {
        context=mcontext;
        this.productLists=productLists;
    }

    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_items, parent, false);
        return new ProductAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ProductAdapter.MyViewHolder holder, final int position) {
        final ProductList productList = productLists.get(position);


        holder.txt_product_name.setText(productList.getProductname());
        holder.txt_mrp.setText("MRP \u20B9"+productList.getMrpPrice());
        holder.txt_dmart.setText("Dmart \u20B9"+productList.getDmartPrice());
        holder.txt_save.setText("Save \u20B9"+productList.getSavedPRice());

        if(productList.getQuantity().contains("L")) {
            holder.layout_quantity.setVisibility(View.VISIBLE);
            holder.txt_quantity.setText(productList.getQuantity());
            holder.btn_quantity.setVisibility(View.GONE);
        }else{
            holder.layout_quantity.setVisibility(View.GONE);
            holder.btn_quantity.setText(productList.getQuantity());
            holder.btn_quantity.setVisibility(View.VISIBLE);
        }
        holder.txt_mrp.setPaintFlags(holder.txt_mrp.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        Glide.with(context)
                .load(productList.getImageURL())
                .into(holder.image_product);

        holder.btn_add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,holder.txt_product_name.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return productLists.size();
    }
}
