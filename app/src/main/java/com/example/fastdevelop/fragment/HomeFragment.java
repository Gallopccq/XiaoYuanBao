package com.example.fastdevelop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdevelop.R;
import com.example.fastdevelop.fragment.model.Goods;
import com.example.fastdevelop.fragment.model.GoodsAdapter;
import com.example.fastdevelop.home.model.IconAdapter;
import com.example.fastdevelop.home.model.IconTitleModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<IconTitleModel> iconList = new ArrayList<>();
    private List<Goods> goodsList = new ArrayList<>();

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_home, container, false);

        //initModuleModule();
        initGoodsModule();

        return view;
    }

    private void initGoodsModule() {
        initGoods(); // 初始化（加载）图标（各个模块）数据
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.module_home_goods);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        GoodsAdapter goodsAdapter = new GoodsAdapter(goodsList);
        recyclerView.setAdapter(goodsAdapter);

    }

    private void initGoods() {
        final int[] goodsImages = {
                R.mipmap.homepage_icon_light_food_b,
                R.mipmap.homepage_icon_light_movie_b,
                R.mipmap.homepage_icon_light_hotel_b,
                R.mipmap.homepage_icon_light_amusement_b,
                R.mipmap.homepage_icon_light_takeout_b,
        };

        //大类模块的标题数组
        final String[] goodsTitles = {
                "美食", "电影/演出", "酒店住宿", "休闲娱乐", "外卖"
        };
        for(int j=0;j<3;j++)
            for(int i=0;i<goodsImages.length;i++){
                Goods goods = new Goods(goodsImages[i],goodsTitles[i],goodsTitles[i]);
                goodsList.add(goods);
            }
    }

    /* 初始化大类模块 */
    /*private void initModuleModule(){

        initIcon(); // 初始话图标（各个模块）数据
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.module_fragment_home);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        IconAdapter iconAdapter = new IconAdapter(iconList);
        recyclerView.setAdapter(iconAdapter);
    }*/


    private void initIcon(){
        /* 加载大类模块数据 */

        final int[] iconImages = {
                R.mipmap.homepage_icon_light_food_b,
                R.mipmap.homepage_icon_light_movie_b,
                R.mipmap.homepage_icon_light_hotel_b,
                R.mipmap.homepage_icon_light_amusement_b,
                R.mipmap.homepage_icon_light_takeout_b,
        };

        //大类模块的标题数组
        final String[] iconTitles = {
                "美食", "电影/演出", "酒店住宿", "休闲娱乐", "外卖"
        };
        for(int i=0;i<iconImages.length;i++){
            IconTitleModel iconTitleModel = new IconTitleModel(iconImages[i],iconTitles[i]);
            iconList.add(iconTitleModel);
        }
    }
}