package com.example.my.project1;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MyUserInfoActivity extends AppCompatActivity {

    ImageView iv_avatar;//头像
    TextView tv_name;//昵称
    TextView tv_sex;//性别
    TextView tv_region;//地区
    TextView tv_sign;//个性签名

    String name;
    String sex;
    String region;
    String sign;

    RelativeLayout re_avatar;//头像布局
    RelativeLayout re_name;//昵称布局
    RelativeLayout re_sex;//性别布局
    RelativeLayout re_region;//地区布局
    RelativeLayout re_sign;//签名布局

    EditText et_change;//更改信息输入

    String items[]={"男","女"};

    SharedPreferences preferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_myinfo);

        preferences = getSharedPreferences("yan",MODE_PRIVATE);
        editor=preferences.edit();

        name=preferences.getString("name1",null);
        sex=preferences.getString("sex1",null);
        region=preferences.getString("region1",null);
        sign=preferences.getString("sign1",null);

        if(name==null){
            name = "留下大名";
            editor.putString("name1",name);
            editor.commit();
        }
        if(sex==null){
            sex = "帅哥/美女";
            editor.putString("sex1",sex);
            editor.commit();
        }
        if(region==null){
            region="哪里人";
            editor.putString("region1",region);
            editor.commit();
        }
        if(sign==null){
            sign="写点啥？";
            editor.putString("sign1",sign);
            editor.commit();
        }

        iv_avatar = (ImageView) findViewById(R.id.iv_avatar);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_region = (TextView) findViewById(R.id.tv_region);
        tv_sign = (TextView) findViewById(R.id.tv_sign);



        re_avatar = (RelativeLayout) findViewById(R.id.re_avatar);
        re_name = (RelativeLayout) findViewById(R.id.re_name);
        re_sex = (RelativeLayout) findViewById(R.id.re_sex);
        re_region = (RelativeLayout) findViewById(R.id.re_region);
        re_sign = (RelativeLayout) findViewById(R.id.re_sign);


        tv_name.setText(preferences.getString("name1",null));
        tv_sex.setText(preferences.getString("sex1",null));
        tv_region.setText(preferences.getString("region1",null));
        tv_sign.setText(preferences.getString("sign1",null));

        re_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog();
            }
        });

        re_sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1();
            }
        });

        re_region.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog2();
            }
        });

        re_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog3();
            }
        });

    }


    protected void dialog() {
        LinearLayout layout = (LinearLayout) getLayoutInflater()
                .inflate(R.layout.layout_of_alert,null);
        et_change = (EditText) layout.findViewById(R.id.et_change);
        AlertDialog.Builder builder = new AlertDialog.Builder(MyUserInfoActivity.this);
        builder.setTitle("修改昵称");
        builder.setView(layout);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String string=et_change.getText().toString();
                tv_name.setText(string);
                editor.putString("name1",string);
                editor.commit();
            }
        })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        builder.create().show();
    }

    protected void dialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MyUserInfoActivity.this);
        builder.setTitle("修改性别");
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String string = items[i];
                tv_sex.setText(string);
                editor.putString("sex1",string);
                editor.commit();
            }
        });
        builder.create().show();
    }
    protected void dialog2() {
        LinearLayout layout = (LinearLayout) getLayoutInflater()
                .inflate(R.layout.layout_of_alert,null);
        et_change = (EditText) layout.findViewById(R.id.et_change);
        AlertDialog.Builder builder = new AlertDialog.Builder(MyUserInfoActivity.this);
        builder.setTitle("修改地区");
        builder.setView(layout);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String string=et_change.getText().toString();
                tv_region.setText(string);
                editor.putString("region1",string);
                editor.commit();
            }
        })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        builder.create().show();
    }

    protected void dialog3() {
        LinearLayout layout = (LinearLayout) getLayoutInflater()
                .inflate(R.layout.layout_of_alert,null);
        et_change = (EditText) layout.findViewById(R.id.et_change);
        AlertDialog.Builder builder = new AlertDialog.Builder(MyUserInfoActivity.this);
        builder.setTitle("修改个性签名");
        builder.setView(layout);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String string=et_change.getText().toString();
                tv_sign.setText(string);
                editor.putString("sign1",string);
                editor.commit();
            }
        })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        builder.create().show();
    }

}
