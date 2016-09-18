package com.example.my.project1;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MeFragment extends Fragment {
    @Nullable

    //手机图库请求码
    public static final int SHOW_MAP_DEPOT = 1;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        RelativeLayout myLayout1 = (RelativeLayout) view.findViewById(R.id.re_myinfo);
        myLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),MyUserInfoActivity.class));
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
        return view;
    }
    public static MeFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }



}