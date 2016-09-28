package com.example.my.project1;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     ArrayList<Fragment> fragments;
    //手机图库请求码
    public static final int SHOW_MAP_DEPOT = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

        //顶部栏
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //底部栏
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.tab_home_normal, "主页").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.tab_notifications_normal, "社区").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.tab_explore_normal, "发现").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.tab_profile_normal, "我的").setActiveColorResource(R.color.blue))
                .initialise();

        //Fragment
        fragments = getFragments();
        setDefaultFragment();


        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                if (fragments != null) {
                    if (position < fragments.size()) {
                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment fragment = fragments.get(position);
                        ft.replace(R.id.layFrame, fragment);
                        ft.commitAllowingStateLoss();
                    }
                }

            }

            @Override
            public void onTabUnselected(int position) {
                if (fragments != null) {
                    if (position < fragments.size()) {
                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        Fragment fragment = fragments.get(position);
                        ft.remove(fragment);
                        ft.commitAllowingStateLoss();
                    }
                }
            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    /**
     * 设置默认的
     */
    public void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layFrame, HomeFragment.newInstance("Home"));
        transaction.commit();
    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance("Home"));
        fragments.add(CommunityFragment.newInstance("Community"));
        fragments.add(ExploreFragment.newInstance("Explore"));
        fragments.add(MeFragment.newInstance("Me"));
        return fragments;
    }


    //创建菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //菜单的选项
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }else if (id == R.id.action_update){
            Toast.makeText(MainActivity.this,"暂无更新",Toast.LENGTH_SHORT).show();
        }else if (id == R.id.action_abouts){
            simple();
        }

        return super.onOptionsItemSelected(item);
    }

    //主菜单项 关于 对话框
    public void simple(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("一级项目")
                .setMessage("项目名称：葡萄圈\n成员：启慧 梦丽 少荣");
        builder.create().show();
    }

}
