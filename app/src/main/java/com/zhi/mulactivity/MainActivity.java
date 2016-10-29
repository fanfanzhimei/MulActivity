package com.zhi.mulactivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button mBtnJump1;
    private Button mBtnJump2;
    private Button mBtnJump3;
    private Button mBtnJump4;
    private Button mBtnJump5;
    private Button mBtnJump6;
    private Button mBtnJump7;
    private Button mBtnJump8;
    private Button mBtnJump9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
    }

    private void initEvents() {
        mBtnJump1.setOnClickListener(this);
        mBtnJump2.setOnClickListener(this);
        mBtnJump3.setOnClickListener(this);
        mBtnJump4.setOnClickListener(this);
        mBtnJump5.setOnClickListener(this);
        mBtnJump6.setOnClickListener(this);
        mBtnJump7.setOnClickListener(this);
        mBtnJump8.setOnClickListener(this);
        mBtnJump9.setOnClickListener(this);
    }

    private void initViews() {
        mBtnJump1 = (Button) findViewById(R.id.btn_jump_1);
        mBtnJump2 = (Button) findViewById(R.id.btn_jump_2);
        mBtnJump3 = (Button) findViewById(R.id.btn_jump_3);
        mBtnJump4 = (Button) findViewById(R.id.btn_jump_4);
        mBtnJump5 = (Button) findViewById(R.id.btn_jump_5);
        mBtnJump6 = (Button) findViewById(R.id.btn_jump_6);
        mBtnJump7 = (Button) findViewById(R.id.btn_jump_7);
        mBtnJump8 = (Button) findViewById(R.id.btn_jump_8);
        mBtnJump9 = (Button) findViewById(R.id.btn_jump_9);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_jump_1:
                jump1();
                break;
            case R.id.btn_jump_2:
                jump2();
                break;
            case R.id.btn_jump_3:
                jump3();
                break;
            case R.id.btn_jump_4:
                jump4();
                break;
            case R.id.btn_jump_5:
                jump5();
                break;
            case R.id.btn_jump_6:
                jump6();
                break;
            case R.id.btn_jump_7:
                jump7();
                break;
            case R.id.btn_jump_8:
                jump8();
                break;
            case R.id.btn_jump_9:
                jump9();
                break;
        }
    }

    private void jump1(){  //  跳转方式1：(最常见)
        Intent intent = new Intent(MainActivity.this, NoParameterActivity.class);
        startActivity(intent);
    }
    private void jump2(){  // 跳转方式2：(组件：context方式)
        Intent intent =new Intent();
        intent.setComponent(new ComponentName(MainActivity.this, NoParameterActivity.class));
        startActivity(intent);
    }
    private void jump3(){  // 跳转方式3：(组件：包名及要跳转的类的完整名称)
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.zhi.mulactivity", "com.zhi.mulactivity.NoParameterActivity"));
        startActivity(intent);
    }
    private void jump4(){  // 跳转方式4：(用setClass方式)
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, NoParameterActivity.class);
        startActivity(intent);
    }
    private void jump5(){  // 跳转方式5：(用setClassName+context方式)
        Intent intent = new Intent();
        intent.setClassName(MainActivity.this, "com.zhi.mulactivity.NoParameterActivity");
        startActivity(intent);
    }
    private void jump6(){  // 跳转方式6：(用setClassName + 包名方式)
        Intent intent = new Intent();
        intent.setClassName("com.zhi.mulactivity", "com.zhi.mulactivity.NoParameterActivity");
        startActivity(intent);
    }

    private void jump7(){  // 带参数跳转
        Intent intent = new Intent(MainActivity.this, ParameterActivity.class);
        intent.putExtra("name", "璐璐");
        intent.putExtra("age",20);
        startActivity(intent);
    }
    private void jump8(){  // 批量带参数跳转
        Intent intent = new Intent(MainActivity.this, BatchParameterActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", "小于");
        bundle.putInt("age", 30);
        intent.putExtra("person", bundle);
        startActivity(intent);
    }
    private void jump9(){  // 带结果值的跳转
        Intent intent = new Intent(MainActivity.this, ForResultActivity.class);
        startActivityForResult(intent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(1000 == requestCode && 1001 == resultCode && null != data){
            Toast.makeText(MainActivity.this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
        }
    }
}
