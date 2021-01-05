package com.mingrisoft.denglu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static EditText metloginactivityusername;
    public EditText metloginactivitypassword;
    private Button mbtloginactivitylogin;
    private Button mbtloginactivityregister;
    private Button mbtloginactivitywangji;
    private DBOpenHelper mDBOpenHelper;//数据辅助类实例
    private SQLiteDatabase db;//数据库实例
    private ContentValues values;//数据库操作参数
    private final String mTableName = "students";//表名称
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mDBOpenHelper = new DBOpenHelper(this); }
    //   db = dbHelper.getWritableDatabase();
    //  values = new ContentValues();


    private void initView() {
        mbtloginactivitylogin = findViewById(R.id.bt_loginactivity_login);
        mbtloginactivitywangji = findViewById(R.id.bt_loginactivity_wangji);
        mbtloginactivityregister = findViewById(R.id.bt_loginactivity_register);
        metloginactivityusername = findViewById(R.id.et_loginactivity_username);
        metloginactivitypassword = findViewById(R.id.et_loginactivity_password);
        mbtloginactivitylogin.setOnClickListener(this);
        mbtloginactivityregister.setOnClickListener(this);
        mbtloginactivitywangji.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = metloginactivityusername.getText().toString().trim();
        String password = metloginactivitypassword.getText().toString().trim();
        Intent intent=new Intent(this,LoginafterActivity.class);
        String massage=metloginactivityusername.getText().toString();
        intent.putExtra("MESSAGE",massage);
        startActivity(intent);
        //String n = null;
        //String p = null;
       // String uname=mDBOpenHelper.getpassword(name);
        //String upassword=mDBOpenHelper.getpassword(password);
        ArrayList<User> list = mDBOpenHelper.getall();
      // ArrayList<User> user=mDBOpenHelper.getall();
        boolean match1 = false;
        boolean match2 = false;
        for (int i = 0; i < list.size(); i++) {
          User user = list.get(i);
          if (name.equals(user.getname())) {
              match1 = true;
               break;
            } else {
              //用sql（getpassward()）语句直接查，如果
                match1 = false;
            }
          if (password.equals(user.getpassword())){
              match2=true;
              break;
          }else {
              match2=false;
          }
       }

        switch (view.getId()) {
            case R.id.bt_loginactivity_wangji:
                Intent intent1 = new Intent(MainActivity.this, PasswordActivity.class);
                startActivities(new Intent[]{intent1});
                break;
            case R.id.bt_loginactivity_register:
                Intent intent2 = new Intent(MainActivity.this, RegisterActivity.class);
                startActivities(new Intent[]{intent2});
                break;
            case R.id.bt_loginactivity_login:
                if (match1) {
                    Toast.makeText(this, "用户存在", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "用户不存在", LENGTH_SHORT).show();
                }
                if (match1&&match2){
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(MainActivity.this, LoginafterActivity.class);
                    startActivities(new Intent[]{intent3});
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                }
                if (match2) {
                    Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
                }

        }
    }
}
//}



