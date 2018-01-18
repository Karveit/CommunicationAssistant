package com.example.enlogty.communicationassistant.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.enlogty.communicationassistant.R;
import com.example.enlogty.communicationassistant.adapter.CloudSmsAdapter;

/**
 * Created by enlogty on 2017/11/21.
 */

public class CloudDataActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window=getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //获取样式中的属性值
            TypedValue typedValue = new TypedValue();
            this.getTheme().resolveAttribute(android.R.attr.colorPrimary, typedValue, true);
            int[] attribute = new int[] { android.R.attr.colorPrimary };
            TypedArray array = this.obtainStyledAttributes(typedValue.resourceId, attribute);
            int color = array.getColor(0, Color.TRANSPARENT);
            array.recycle();
            window.setStatusBarColor(color);
        }
        setContentView(R.layout.activity_clouddata);
        initView();
    }

    private void initView() {
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        Glide.with(this).load(R.mipmap.iv11).into(iv1);
        Glide.with(this).load(R.mipmap.iv2).into(iv2);
        Glide.with(this).load(R.mipmap.iv3).into(iv3);
        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
        iv3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv1:
                Intent contactIntent = new Intent(CloudDataActivity.this,CloudContactActivity.class);
                Intent thisIntent = getIntent();
                String localNumber = thisIntent.getStringExtra("localNumber");
                contactIntent.putExtra("localNumber",localNumber);
                startActivity(contactIntent);
                break;
            case R.id.iv2:
                Intent smsIntent = new Intent(CloudDataActivity.this, CloudSmsActivity.class);
                startActivity(smsIntent);
                break;
            case R.id.iv3:
                Intent intent = new Intent(CloudDataActivity.this,CloudImageActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
