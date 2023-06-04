package com.example.fastdevelop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.fastdevelop.base.BaseActivity;
import com.example.fastdevelop.main.FragmentAdapter;
import com.example.fastdevelop.utils.TUIUtils;
import com.tencent.qcloud.tuikit.tuicontact.TUIContactConstants;
import com.tencent.qcloud.tuikit.tuiconversation.classicui.page.TUIConversationFragment;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_message);

        Button back = (Button)findViewById(R.id.back);
        Button addmore = (Button)findViewById(R.id.addmore);

        List<Fragment> fragments = new ArrayList<>();
        // 添加 tuiconversation 组件提供的经典版会话界面
        fragments.add(new TUIConversationFragment());

        // 添加 tuicontact 组件提供的经典版联系人界面
//        fragments.add(new TUIContactFragment());

        ViewPager2 mainViewPager = findViewById(R.id.view_pager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this);
        fragmentAdapter.setFragmentList(fragments);
        mainViewPager.setOffscreenPageLimit(2);
        mainViewPager.setAdapter(fragmentAdapter);
        mainViewPager.setCurrentItem(0, false);

        addmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(TUIContactConstants.GroupType.GROUP, false);
                TUIUtils.startActivity("AddMoreActivity", bundle);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
