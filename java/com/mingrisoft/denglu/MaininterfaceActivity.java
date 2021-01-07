package com.mingrisoft.denglu;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MaininterfaceActivity extends Activity implements View.OnClickListener {
    private Button btmainback, btmainset;
    private Button btmainmassage, btmainleaving, btmainclock, btmainexperiment;
    private DBOpenHelper mDBOpenHelper;//数据辅助类实例
    private SQLiteDatabase db;//数据库实例

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maininterface);
        initView();
        mDBOpenHelper = new DBOpenHelper(this);
    }

    private void initView() {
        btmainback = findViewById(R.id.maininterface_back);
        btmainset = findViewById(R.id.maininterface_set);
        btmainmassage = findViewById(R.id.maininterface_massage);
        btmainclock = findViewById(R.id.maininterface_clock);
        btmainexperiment = findViewById(R.id.maininterface_experiment);
        btmainleaving = findViewById(R.id.maininterface_leaving);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.maininterface_back:
                Intent intent1 = new Intent(MaininterfaceActivity.this, MainActivity.class);
                startActivities(new Intent[]{intent1});
                break;
            case R.id.maininterface_set:
                Intent intent2 = new Intent(MaininterfaceActivity.this, SetActivity.class);
                startActivities(new Intent[]{intent2});
                break;
            case R.id.maininterface_massage:
                Intent intent3 = new Intent(MaininterfaceActivity.this, MassageActivity.class);
                startActivities(new Intent[]{intent3});
                break;
            case R.id.maininterface_clock:
                Intent intent4 = new Intent(MaininterfaceActivity.this, ClockActivity.class);
                startActivities(new Intent[]{intent4});
                break;
            case R.id.maininterface_experiment:
                Intent intent5 = new Intent(MaininterfaceActivity.this, ExperimentActivity.class);
                startActivities(new Intent[]{intent5});
                break;
            case R.id.maininterface_leaving:
                Intent intent6 = new Intent(MaininterfaceActivity.this, LeavingActivity.class);
                startActivities(new Intent[]{intent6});
                break;
        }
    }
}
