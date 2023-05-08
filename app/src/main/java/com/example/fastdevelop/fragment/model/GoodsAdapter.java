package com.example.fastdevelop.fragment.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdevelop.R;

import java.util.List;

/* 要修改点击事件相应逻辑请修改：onCreateViewHolder */

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder>{
    private List<Goods> mGoodsList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View goodsView;
        ImageView goodsImage;
        TextView goodsTitle;
        TextView goodsDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            goodsView = itemView;
            goodsImage = (ImageView) itemView.findViewById(R.id.goods_image);
            goodsTitle = (TextView) itemView.findViewById(R.id.goods_title);
            goodsDescription = (TextView) itemView.findViewById(R.id.goods_description);
        }
    }
    public GoodsAdapter(List<Goods> goodsList){
        mGoodsList = goodsList;
    }

    @NonNull
    @Override
    public GoodsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_goods,parent,false);
        final GoodsAdapter.ViewHolder holder = new GoodsAdapter.ViewHolder(view);
        holder.goodsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAbsoluteAdapterPosition();
                Goods goods = mGoodsList.get(position);
                Toast.makeText(v.getContext(),goods.getTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsAdapter.ViewHolder holder, int position) {
        Goods goods = mGoodsList.get(position);
        holder.goodsImage.setImageResource(goods.getImageResource());
        holder.goodsTitle.setText(goods.getTitle());
        holder.goodsDescription.setText(goods.getDescription());
    }


    @Override
    public int getItemCount() {
        return mGoodsList.size();
    }
}
