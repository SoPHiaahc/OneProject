package com.example.my.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import cn.finalteam.rxgalleryfinal.RxGalleryFinal;
import cn.finalteam.rxgalleryfinal.imageloader.ImageLoaderType;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusResultSubscriber;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageMultipleResultEvent;

public class PushPostActivity extends AppCompatActivity {

    private final static String[] TYPE_ARRAY = new String[]{"普通动态", "网站/推文等"};

    private Spinner select_type_spinner;
    private EditText post_url_edit;
    private EditText post_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        select_type_spinner = (Spinner) findViewById(R.id.content_type_spinner);
        post_url_edit = (EditText) findViewById(R.id.post_url_edit);
        post_content = (EditText) findViewById(R.id.new_post_content);

        select_type_spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TYPE_ARRAY));
        select_type_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                if (pos == 0) {
                    post_url_edit.setVisibility(View.GONE);
                }
                else {
                    post_url_edit.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
        Button addPhotoButton= (Button) findViewById(R.id.add_photo_button);
        addPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxGalleryFinal
                        .with(PushPostActivity.this)
                        .image()
                        .multiple()
                        .maxSize(9)
                        .imageLoader(ImageLoaderType.GLIDE)
                        .subscribe(new RxBusResultSubscriber<ImageMultipleResultEvent>() {
                            @Override
                            protected void onEvent(ImageMultipleResultEvent imageMultipleResultEvent) throws Exception {
                                Toast.makeText(getBaseContext(), "已选择" + imageMultipleResultEvent.getResult().size() +"张图片", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .openGallery();
            }
        });
    }

}

