package com.example.my.project1.activity_for_community;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.example.my.project1.R;

public class Activity1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_of_community);
        Intent intent = getIntent();
        int i = intent.getIntExtra("Num",1);
        //顶部栏
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        switch (i){
            case 1:
                toolbar.setTitle("A宿舍");
                break;
            case 2:
                toolbar.setTitle("B宿舍");
                break;
            case 3:
                toolbar.setTitle("C宿舍");
                break;
            case 4:
                toolbar.setTitle("D宿舍");
                break;
            case 5:
                toolbar.setTitle("E宿舍");
                break;
            case 6:
                toolbar.setTitle("F宿舍");
                break;
            case 7:
                toolbar.setTitle("G宿舍");
                break;
            case 8:
                toolbar.setTitle("至诚书院");
                break;
            case 9:
                toolbar.setTitle("弘毅书院");
                break;
            case 10:
                toolbar.setTitle("知行书院");
                break;
            case 11:
                toolbar.setTitle("思源书院");
                break;
            case 12:
                toolbar.setTitle("研究生宿舍");
                break;
            case 13:
                toolbar.setTitle("教师公寓");
                break;
        }

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back_button);//设置导航栏图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}
