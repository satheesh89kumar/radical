package com.example.radical.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radical.Model.ResponseModel.ProductResponse;
import com.example.radical.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<ProductResponse.Item> productList;

    public ProductAdapter(List<ProductResponse.Item> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductResponse.Item productResponse = productList.get(position);
        holder.bind(productResponse);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void updateProductList(List<ProductResponse.Item> newProductList) {
        this.productList = newProductList;
        notifyDataSetChanged();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        TextView productColor;
        TextView quantity;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            //productColor = itemView.findViewById(R.id.productColor);
            quantity = itemView.findViewById(R.id.qty);
        }

        public void bind(ProductResponse.Item productResponse) {
            productName.setText(productResponse.getProduct_id().getProductName());
            //productColor.setText(productResponse.getItems().getProduct_id().getBodyColour());
            quantity.setText(String.valueOf(productResponse.getQuantity()));
        }
    }
}
