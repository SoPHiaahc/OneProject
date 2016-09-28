package com.example.my.project1;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MeFragment extends Fragment {
    @Nullable

    TextView textView1;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    //手机图库请求码
    public static final int SHOW_MAP_DEPOT = 1;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_me, container, false);
        RelativeLayout myLayout1 = (RelativeLayout) view.findViewById(R.id.re_myinfo);
        preferences=getActivity().getSharedPreferences("yan", Context.MODE_PRIVATE);
        textView1= (TextView) view.findViewById(R.id.tv_name_of_fragment_me);
        textView1.setText(preferences.getString("name1","昵称"));

        myLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getActivity(),MyUserInfoActivity.class);
                startActivity(intent1);
            }
        });


        RelativeLayout myLayout2 = (RelativeLayout) view.findViewById(R.id.re_xiangce);
        myLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if (Build.VERSION.SDK_INT < 19) {
                    intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setType("image/*");
                } else {
                    intent = new Intent(
                            Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                }
                startActivityForResult(intent, SHOW_MAP_DEPOT);
            }
        });

        RelativeLayout myLayout3 = (RelativeLayout) view.findViewById(R.id.re_setting);
        myLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Setting_Activity.class));
            }
        });
        return view;
    }

    public static MeFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        super.onActivityResult(requestCode, resultCode, intent);
//        if(requestCode==0 && resultCode==0){
//            Bundle data = intent.getExtras();
//            String resultOfName=data.getString("Name");
//            textView1.setText(resultOfName);
//        }
//    }
}