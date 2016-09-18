package com.example.my.project1;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.my.project1.activity_for_community.Activity1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommunityFragment extends Fragment {

    private String[] names = new String[]
            {       "A座",
                    "B座",
                    "C座",
                    "D座",
                    "E座",
                    "F座",
                    "G座",
                    "至诚书院",
                    "弘毅书院",
                    "知行书院",
                    "思源书院",
                    "研究生宿舍",
                    "教师公寓"
            };
    private String[] descs = new String[]
            { "1", "2", "3", "4","5","6","7","8","9","10","11","12","13"};
    private int[] imageIds = new int[]
            {
                    R.drawable.a,
                    R.drawable.b,
                    R.drawable.c ,
                    R.drawable.d,
                    R.drawable.e,
                    R.drawable.f,
                    R.drawable.g,
                    R.drawable.j,
                    R.drawable.hy,
                    R.drawable.zx,
                    R.drawable.sy,
                    R.drawable.yjs,
                    R.drawable.js,
            };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);

        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header", imageIds[i]);
            listItem.put("personName", names[i]);
            listItem.put("desc", descs[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), listItems,
                R.layout.simple_item,
                new String[] { "personName", "header" , "desc"},
                new int[] { R.id.name, R.id.header , R.id.desc });
        ListView list = (ListView) view.findViewById(R.id.mylist);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);




        // 为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            final Intent intent = new Intent(getActivity(), Activity1.class);
            Bundle data = new Bundle();
            // 第position项被单击时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                switch (position){
                    case 0:
                        data.putInt("Num",1);
                        intent.putExtras(data);
                        startActivity(intent);
                        break;
                    case 1:
                        data.putInt("Num",2);
                        intent.putExtras(data);
                        startActivity(intent);
                        break;
                    case 2:
                        data.putInt("Num",3);
                        intent.putExtras(data);
                        startActivity(intent);
                        break;
                    case 3:
                        data.putInt("Num",4);
                        intent.putExtras(data);
                        startActivity(intent);
                        break;
                    case 4:
                        data.putInt("Num",5);
                        intent.putExtras(data);
                        startActivity(intent);
                        break;
                    case 5:
                        data.putInt("Num",6);
                        intent.putExtras(data);
                        startActivity(intent);
                        break;
                    case 6:
                        data.putInt("Num",7);
                        intent.putExtras(data);
                        startActivity(intent);
                        break;
                    case 7:
                        data.putInt("Num",8);
                        intent.putExtras(data);
                        startActivity(intent);
                        break;
                    case 8:
                        data.putInt("Num",9);
                        intent.putExtras(data);
                        startActivity(intent);
                        break;
                    case 9:
                        data.putInt("Num",10);
                        intent.putExtras(data);
                        startActivity(intent);
                        break;
                    case 10:
                        data.putInt("Num",11);
                        intent.putExtras(data);
                        startActivity(intent);
                        break;
                    case 11:
                        data.putInt("Num",12);
                        intent.putExtras(data);
                        startActivity(intent);
                        break;
                    case 12:
                        data.putInt("Num",13);
                        intent.putExtras(data);
                        startActivity(intent);
                        break;

                }
            }
        });
        // 为ListView的列表项的选中事件绑定事件监听器
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            // 第position项被选中时激发该方法
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id)
            {
                System.out.println(names[position]
                        + "被选中了");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
        return view;
    }
    public static CommunityFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        CommunityFragment fragment = new CommunityFragment();
        fragment.setArguments(args);
        return fragment;
    }
}