package com.zhi.mulactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/29.
 */
public class BatchParameterActivity extends Activity{
    private TextView mTvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_parameter);

        initViews();
        initData();
    }

    private void initData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("person");
        String  name = bundle.getString("name");
        int age = bundle.getInt("age");
        mTvShow.setText(name + ":" + age);
    }

    private void initViews() {
        mTvShow = (TextView) findViewById(R.id.tv_show);
    }
}