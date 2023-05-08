package com.example.fastdevelop;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fastdevelop.base.BaseActivity;
import com.example.fastdevelop.fragment.HomeFragment;
import com.example.fastdevelop.fragment.ScrollingFragment;
import com.example.fastdevelop.fragment.MineFragment;
//import com.example.fastdevelop.home.HomeFragment;


public class HomeActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imgView1,imgView2,imgView3,imgView4;

    // 调用Actvity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 关联activity.xml
        setContentView(R.layout.activity_home);
        Log.d("HomeActivity","in HomeActivity");
//        // 创建数据库
//        DBOpenHelper dbsqLiteOpenHelper = new DBOpenHelper(MainActivity.this,"users.db",null,1);
//        final SQLiteDatabase db = dbsqLiteOpenHelper.getWritableDatabase();

        // 关联用户名、密码和登录、注册按钮


        // 为底部导航栏设置监听器
        imgView1 = (ImageView)findViewById(R.id.image1);//获取布局文件的第一个导航图片
        imgView2 = (ImageView) findViewById(R.id.image2);//获取布局文件的第二个导航图片
        imgView3 = (ImageView) findViewById(R.id.image3);//获取布局文件的第三个导航图片
        imgView4 = (ImageView) findViewById(R.id.image4);//获取布局文件的第四个导航图片
        imgView1.setOnClickListener(this);//为第一个导航图片添加单机事件
        imgView2.setOnClickListener(this);//为第二个导航图片添加单机事件
        imgView3.setOnClickListener(this);//为第三个导航图片添加单机事件
        imgView4.setOnClickListener(this);//为第四个导航图片添加单机事件

        FragmentManager fm=getSupportFragmentManager();//获取Fragment的管理器
        FragmentTransaction transaction = fm.beginTransaction();// 开启一个事务
        transaction.add(R.id.fl_content,new HomeFragment()).commit();//设置初始的fragment



    }

    @Override
    public void onClick(View v) {
        FragmentManager fm=getSupportFragmentManager();//获取Fragment的管理器
        FragmentTransaction transaction = fm.beginTransaction();// 开启一个事务
        Fragment fragment=null;
        switch (v.getId()) {    //通过获取点击的id判断点击了哪个张图片
            case R.id.image1:
                fragment = new HomeFragment(); //创建第一个Fragment
                break;
            case R.id.image2:
                fragment = new ScrollingFragment();//创建第二个Fragment
                break;
            case R.id.image3:
                fragment = new HomeFragment();//创建第三个Fragment
                break;
            case R.id.image4:
                fragment = new MineFragment();//创建第四个Fragment
                break;
            default:
                break;
        }
        transaction.replace(R.id.fl_content, fragment); //替换Fragment
        transaction.commit(); //提交事务
    }
}
