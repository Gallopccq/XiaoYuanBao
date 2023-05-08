package com.example.fastdevelop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.widget.TextView;

public class Test3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_details);
        TextView textView = (TextView) findViewById(R.id.text_view);
        SpannableString spannableString = new SpannableString(this.getString(R.string.large_text));
        ImageSpan imageSpan = new ImageSpan(this, R.drawable.ic_right_next, DynamicDrawableSpan.ALIGN_CENTER);
        spannableString.setSpan(imageSpan, 4, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);

    }
}