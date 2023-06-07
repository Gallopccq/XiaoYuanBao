package com.example.fastdevelop.fragment;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.coorchice.library.SuperTextView;
import com.example.fastdevelop.HomeActivity;
import com.example.fastdevelop.R;
import com.example.fastdevelop.SignUpActivity;
import com.example.fastdevelop.base.BaseFragment;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.ClickListener;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends Fragment implements View.OnClickListener {

    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_mine, container, false);

        Log.d(getTag(),"MineFargment Started");
        // add SuperTextView ClickListener
        addSuperTextViewClickListener();

        // add ClickListener
        Button logout = (Button) view.findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });




        return view;
    }

    private void addSuperTextViewClickListener() {

        RelativeLayout shou_cang = (RelativeLayout) view.findViewById(R.id.shou_cang);
        RelativeLayout gou_wu_dan = (RelativeLayout) view.findViewById(R.id.gou_wu_dan);
        RelativeLayout zu_ji = (RelativeLayout) view.findViewById(R.id.zu_ji);
        RelativeLayout li_shi_ding_dan = (RelativeLayout) view.findViewById(R.id.li_shi_ding_dan);
        RelativeLayout li_shi_shang_jia = (RelativeLayout) view.findViewById(R.id.li_shi_shang_jia);
        RelativeLayout shou_huo_di_zhi = (RelativeLayout) view.findViewById(R.id.shou_huo_di_zhi);
        List<RelativeLayout> relativeLayoutList = new ArrayList<>();
        relativeLayoutList.add(shou_cang);
        relativeLayoutList.add(gou_wu_dan);
        relativeLayoutList.add(zu_ji);
        relativeLayoutList.add(li_shi_ding_dan);
        relativeLayoutList.add(li_shi_shang_jia);
        relativeLayoutList.add(shou_huo_di_zhi);
        for(RelativeLayout superTextView:relativeLayoutList){
            superTextView.setClickable(true);
            superTextView.setOnClickListener(this);
        }

//        shou_cang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(getTag(),"click");
//                startActivity(new Intent(getActivity(),SignUpActivity.class));
//            }
//        });
    }
/*
    @Override
    public void onClickListener(SuperTextView v) {
        switch (v.getId()){
            case R.id.shou_cang:
                startActivity(new Intent(getActivity(), SignUpActivity.class));
                break;
            case R.id.gou_wu_dan:
//                startActivity(new Intent(MineFragment.this,GouWuDanActivity.class));
                break;
            case R.id.zu_ji:
//                startActivity(new Intent(MineFragment.this,ZujiActivity.class));
                break;
            case R.id.li_shi_ding_dan:
//                startActivity(new Intent(MineFragment.this,LiShiDingDanActivity.class));
                break;
            case R.id.li_shi_shang_jia:
//                startActivity(new Intent(MineFragment.this,LiShiShangJiaActivity.class));
                break;
            case R.id.shou_huo_di_zhi:
//                startActivity(new Intent(MineFragment.this,ShouHuoDiZhiActivity.class));
                break;
            default:
        }

    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shou_cang:
                startActivity(new Intent(getActivity(), SignUpActivity.class));
                break;
            case R.id.gou_wu_dan:
//                startActivity(new Intent(MineFragment.this,GouWuDanActivity.class));
                break;
            case R.id.zu_ji:
//                startActivity(new Intent(MineFragment.this,ZujiActivity.class));
                break;
            case R.id.li_shi_ding_dan:
//                startActivity(new Intent(MineFragment.this,LiShiDingDanActivity.class));
                break;
            case R.id.li_shi_shang_jia:
//                startActivity(new Intent(MineFragment.this,LiShiShangJiaActivity.class));
                break;
            case R.id.shou_huo_di_zhi:
//                startActivity(new Intent(MineFragment.this,ShouHuoDiZhiActivity.class));
                break;
            default:
        }
    }

    class mAdjuster extends SuperTextView.Adjuster{

        @Override
        protected void adjust(SuperTextView v, Canvas canvas) {

        }

        @Override
        public boolean onTouch(SuperTextView v, MotionEvent event) {


            return true;
        }
    }
}