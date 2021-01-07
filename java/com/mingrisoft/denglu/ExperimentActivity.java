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
public class ExperimentActivity extends Activity implements View.OnClickListener {
    private Button btsetbin;
    private DBOpenHelper mDBOpenHelper;//数据辅助类实例
    private SQLiteDatabase db;//数据库实例

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment);
        initView();
        mDBOpenHelper = new DBOpenHelper(this);
    }

    private void initView() {
        btsetbin = findViewById(R.id.bt_setbind);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_setbind:
                Intent intent1 = new Intent(ExperimentActivity.this, LoginafterActivity.class);
                startActivities(new Intent[]{intent1});
                break;
        }
    }
}

