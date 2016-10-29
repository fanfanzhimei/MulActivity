package com.zhi.mulactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/29.
 */
public class ParameterActivity extends Activity{
    private TextView mTvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter);

        initViews();
        initData();
    }

    private void initData(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0);
        mTvShow.setText(name+":"+age);
    }

    private void initViews() {
        mTvShow = (TextView) findViewById(R.id.tv_show);
    }
}
