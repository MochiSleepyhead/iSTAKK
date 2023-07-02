package com.capstone.istakk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class homeRecyclerViewAdapter extends RecyclerView.Adapter<homeRecyclerViewAdapter.MyViewHolder> {
    //context needed for inflating our layout
    // arraylist which holds all of our model
    Context context;
    ArrayList<homeRecyclerModel> homeRecyclerModels;

    public homeRecyclerViewAdapter(Context context, ArrayList<homeRecyclerModel> homeRecyclerModels){
        this.context = context;
        this.homeRecyclerModels = homeRecyclerModels;

    }

    @NonNull
    @Override
    public homeRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the layout (Giving the layout to each of our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_recycler_view_row, parent, false);

        return new homeRecyclerViewAdapter.MyViewHolder(view);
        //constructor to get the values out of the values of the variable line:18, 19
    }

    @Override
    public void onBindViewHolder(@NonNull homeRecyclerViewAdapter.MyViewHolder holder, int position) {
        // assigning values to the views we created in the home_recycler_view_row layout file
        //based on the position of the recycler view
        //change the data based on the recycler view's position for each of our items

        holder.tvProductName.setText(homeRecyclerModels.get(position).getProductName());
        holder.tvStock.setText(homeRecyclerModels.get(position).getStockNumber());
        holder.tvProductStat.setText(homeRecyclerModels.get(position).getProductStatus());
        holder.productImage.setImageResource(homeRecyclerModels.get(position).getProductImage());

    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of items you want displayed
        return homeRecyclerModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //grabbing the views from our home_recycler_view_row layout file
        //kinda like in the onCreate method

        ImageView productImage;
        TextView tvProductName, tvProductStat, tvStock;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.productImage);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvStock = itemView.findViewById(R.id.tvStock);
            tvProductStat = itemView.findViewById(R.id.tvProductStatus);
        }
    }
}
