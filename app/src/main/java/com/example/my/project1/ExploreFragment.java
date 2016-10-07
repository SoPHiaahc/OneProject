package com.example.my.project1;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ExploreFragment extends Fragment {

    Button postButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        postButton = (Button) view.findViewById(R.id.new_post_button);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),PushPostActivity.class));
            }
        });
        return view;
    }



    public static ExploreFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        ExploreFragment fragment = new ExploreFragment();
        fragment.setArguments(args);
        return fragment;
    }


}