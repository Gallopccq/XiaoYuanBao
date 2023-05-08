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

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder>{
    private List<IconTitleModel> mIconTitleModelList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View iconView;
        ImageView iconImage;
        TextView iconName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconView = itemView;
            iconImage = (ImageView) itemView.findViewById(R.id.icon_image);
            iconName = (TextView) itemView.findViewById(R.id.icon_name);
        }
    }
    public IconAdapter(List<IconTitleModel> iconList){
        mIconTitleModelList = iconList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_icon_title,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAbsoluteAdapterPosition();
                IconTitleModel iconTitleModel = mIconTitleModelList.get(position);
                Toast.makeText(v.getContext(),iconTitleModel.getIconTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        IconTitleModel iconTitleModel = mIconTitleModelList.get(position);
        holder.iconImage.setImageResource(iconTitleModel.getIconResource());
        holder.iconName.setText(iconTitleModel.getIconTitle());
    }


    @Override
    public int getItemCount() {
        return mIconTitleModelList.size();
    }
}
