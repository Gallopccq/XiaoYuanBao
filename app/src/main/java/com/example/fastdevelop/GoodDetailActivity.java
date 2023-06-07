package com.example.fastdevelop;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.fastdevelop.base.BaseActivity;
import com.tencent.qcloud.tuikit.timcommon.component.PopupInputCard;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.classicui.util.ContactStartChatUtils;
import com.tencent.qcloud.tuikit.tuicontact.presenter.AddMorePresenter;

public class GoodDetailActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_details);

        TextView name = (TextView)findViewById(R.id.name);
        Button iwant = (Button) findViewById(R.id.iwant);
        iwant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddMorePresenter presenter = new AddMorePresenter();
                String id = name.getText().toString();
                Log.d("GoodDetailActivity",id);
                presenter.getUserInfo(id, new IUIKitCallback<ContactItemBean>() {
                    @Override
                    public void onSuccess(ContactItemBean data) {
                        Log.d("GoodDetailActivity", data.getId());
                        ContactStartChatUtils.startChatActivity(data.getId(), ContactItemBean.TYPE_C2C, data.getId(), "");
                    }

                    @Override
                    public void onError(String module, int errCode, String errMsg) {
                        Toast.makeText(GoodDetailActivity.this, "用户不存在",
                                Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

}
