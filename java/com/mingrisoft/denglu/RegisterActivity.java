package com.mingrisoft.denglu;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static com.mingrisoft.denglu.R.id.bt_registeractivity_register;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    //private String realCode;
    private DBOpenHelper mDBOpenHelper;
    private EditText mEtRegisteractivityUsername;
    private EditText mEtRegisteractivityPassword1;
    private EditText mEtRegisteractivityPassword2;
    private Button mBtRegisteractivityRegister;
    private Button mBtRegisteractivitylogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        mDBOpenHelper = new DBOpenHelper(this);
    }

    private void initView() {
        mBtRegisteractivityRegister = findViewById(bt_registeractivity_register);
        mBtRegisteractivitylogin = findViewById(R.id.bt_registeractivity_login);
        mEtRegisteractivityUsername = findViewById(R.id.et_registeractivity_username);
        mEtRegisteractivityPassword1 = findViewById(R.id.et_registeractivity_password1);
        mEtRegisteractivityPassword2 = findViewById(R.id.et_registeractivity_password2);

        mBtRegisteractivityRegister.setOnClickListener(this);
        mBtRegisteractivitylogin.setOnClickListener(this);
    }

    public void onClick(View view) {
        String username = mEtRegisteractivityUsername.getText().toString().trim();
        String password1 = mEtRegisteractivityPassword1.getText().toString().trim();
        String password2 = mEtRegisteractivityPassword2.getText().toString().trim();
        //User user=mDBOpenHelper.getUser(username);
        ArrayList<User> list = mDBOpenHelper.getall();
        boolean match1 = false;
        boolean match2 = false;
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (username.equals(user.getname())) {
                match1 = true;
                break;
            } else {
                //用sql（getpassward()）语句直接查，如果
                match1 = false;
            }
            if (!(password1==password2)) {
                match2 = true;
                break;
            } else {
                //用sql（getpassward()）语句直接查，如果
                match2 = false;
            }
        }
        switch (view.getId()) {
            case R.id.bt_registeractivity_login: //返回登录页面
                Intent intent4 = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent4);
                finish();
                break;

            case R.id.bt_registeractivity_register:    //注册按钮
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password1) && !TextUtils.isEmpty(password2)) {
                    // String uuname=mDBOpenHelper.getpassword(username);
                    // String upassword=mDBOpenHelper.getPassword(password1);
//                    User user=null;
//                    ArrayList<User> list = mDBOpenHelper.getlist();
//                    boolean match = false;
//                    for (int i = 0; i < list.size(); i++) {
//                        user = list.get(i);
//                        if (username.equals(user.getname())) {
//                            match = true;
//                            break;
//                        } else {
//                           match = false;
//                        }
//                    }
                    if (match1) {
                        Toast.makeText(this, "用户名重复", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "用户名可注册", Toast.LENGTH_SHORT).show();
                        if (match2) {
                            mDBOpenHelper.add(username, password2);
                            Intent intent3 = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent3);
//                            System.out.println("软件设计师");
                            finish();
                            Toast.makeText(this, "验证通过，注册成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                        Toast.makeText(this, "注册信息不完整", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
        }
    }
