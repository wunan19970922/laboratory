package com.mingrisoft.denglu;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LoginafterActivity extends Activity implements View.OnClickListener {
    private EditText etloginafterphone, etloginaftercode;
    private Button btloginaftercode, btloginafterbind;
    private Button bt_back;
    private DBOpenHelper mDBOpenHelper;//数据辅助类实例
    private SQLiteDatabase db;//数据库实例

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginafter);
        initView();
        mDBOpenHelper = new DBOpenHelper(this);

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initView() {
        bt_back = findViewById(R.id.back);
        etloginafterphone = findViewById(R.id.etloginafter_input_phone);
        etloginaftercode = findViewById(R.id.etloginafter_input_code);
        btloginaftercode = findViewById(R.id.btloginafter_request_code);
        btloginafterbind = findViewById(R.id.btloginafter_bind);
    }

    @Override
    public void onClick(View view) {
        String phone = etloginafterphone.getText().toString().trim();
        String code = etloginaftercode.getText().toString().trim();

        switch (view.getId()) {
            case R.id.back:
                Intent intent1 = new Intent(LoginafterActivity.this, SetActivity.class);
                startActivities(new Intent[]{intent1});
                break;
            case R.id.btloginafter_bind:
               // ArrayList<User> list = mDBOpenHelper.getall();
                Intent intent = getIntent();
                String message = intent.getStringExtra("MESSAGE");
                startActivity(intent);
           //     ArrayList<User> user=mDBOpenHelper.getall();

//                boolean match3 = false;
//                for (int i = 0; i < list.size(); i++) {
//                    User user = list.get(i);
//                    if (){
//                        match3 = true;
//                        break;
//                    } else {
//                        //用sql（getpassward()）语句直接查，如果
//                        match3 = false;
//                    }
                  if (!TextUtils.isEmpty(phone)) {
                      DBOpenHelper.addphone1(phone);

                      //  startActivities(new Intent[]{intent2});
                      Toast.makeText(this, "已绑定", Toast.LENGTH_SHORT).show();
                      break;
                  }
                //    } else {
                //        Toast.makeText(this, "绑定失败", Toast.LENGTH_SHORT).show();
               //     }

        }
        }
    }

