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
public class ForResultActivity extends Activity implements View.OnClickListener{
    private Button mBtnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);

        initViews();
        initEvent();
    }

    private void initEvent() {
        mBtnClose.setOnClickListener(this);
    }

    private void initViews() {
        mBtnClose = (Button) findViewById(R.id.btn_close);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_close:
                close();
                break;
        }
    }

    private void close(){
        Intent intent = new Intent();
        intent.putExtra("result", "美美与共，和而不同");
        setResult(1001, intent);
        ForResultActivity.this.finish();
    }
}
