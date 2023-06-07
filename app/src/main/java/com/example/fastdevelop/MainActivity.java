package com.example.fastdevelop;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fastdevelop.base.BaseActivity;
import com.example.fastdevelop.signature.GenerateTestUserSig;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.interfaces.TUICallback;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {
    // 调用Actvity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 关联activity.xml
        setContentView(R.layout.activity_log_in);

        // 创建数据库
        DBOpenHelper dbsqLiteOpenHelper = new DBOpenHelper(MainActivity.this,"users.db",null,1);
        final SQLiteDatabase db = dbsqLiteOpenHelper.getWritableDatabase();

        // 关联用户名、密码和登录、注册按钮
        EditText userName = (EditText) this.findViewById(R.id.UserNameEdit);
        EditText passWord = (EditText) this.findViewById(R.id.PassWordEdit);
        Button loginButton = (Button) this.findViewById(R.id.LoginButton);
        Button signUpButton = (Button) this.findViewById(R.id.SignUpButton);
        // 登录按钮监听器
        loginButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 获取用户名和密码
                        String strUserName = userName.getText().toString().trim();
                        String strPassWord = passWord.getText().toString().trim();

                        /* Debug */
                        final boolean DEBUG = true;
                        if (DEBUG) {
                            strUserName = "123456";
                            strPassWord = "123456";
                        }

                        // 判断如果用户名为"123456"密码为"123456"则登录成功
                        if (strUserName.equals("123456") && strPassWord.equals("123456") || queryAccount(strUserName,strPassWord)) {
                            Toast.makeText(MainActivity.this, "登录成功！",
                                    Toast.LENGTH_SHORT).show();

                            // 链接Tencent 数据库
                            UtilLogin(strUserName);

                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "请输入正确的用户名或密码！",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        // 注册按钮监听器
        signUpButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 跳转到注册界面
                        Intent intent = new Intent(MainActivity.this,
                                SignUpActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

    private void UtilLogin(String userID) {

        // 在用户 UI 点击登录的时候调用
        TUILogin.login(this.getApplication(), GenerateTestUserSig.SDKAPPID, userID, GenerateTestUserSig.genTestUserSig(userID), new TUICallback() {
            @Override
            public void onError(final int code, final String desc) {
            }


            @Override
            public void onSuccess() {
            }
        });
    }

    private boolean queryAccount(String username,String passwd){
        boolean result=false;

        List<String> weUsers = new ArrayList<>();
        weUsers.add("wym");weUsers.add("htj");weUsers.add("hd");weUsers.add("qcc");weUsers.add("zjw");


        if(weUsers.contains(username)) result=true;

        //创建游标对象
        /*Cursor cursor = db.query("user", new String[]{"username","password"}, "username=?", new String[]{username}, null, null, null);
        //利用游标遍历所有数据对象
        while(cursor.moveToNext()){
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String username = cursor.getString(cursor.getColumnIndex("username"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            if (password.equals(passwd)) result=true;
            Log.i("Mainactivity","result: id="  + id +" username: " + username +"  login:" + result);
        }
        // 关闭游标，释放资源
        cursor.close();*/
        return result;
    }

}

