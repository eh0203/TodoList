package com.example.tm156navercom.myapplication;

import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.baoyz.swipemenulistview.*;
import android.view.View;
import java.util.ArrayList;
import java.util.Date;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity
        {

    SwipeMenuListView listView;
    MyListAdapter myListAdapter;
    ArrayList<list_item> list_itemArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (SwipeMenuListView)findViewById(R.id.my_listview);

        list_itemArrayList = new ArrayList<list_item>();



        list_itemArrayList.add(new list_item(R.mipmap.ic_launcher,"보라돌이","제목1",new Date(System.currentTimeMillis()),"내용1"));
        list_itemArrayList.add(new list_item(R.mipmap.ic_launcher,"뚜비","제목2",new Date(System.currentTimeMillis()),"내용2"));
        list_itemArrayList.add(new list_item(R.mipmap.ic_launcher,"나나","제목3",new Date(System.currentTimeMillis()),"내용3"));
        list_itemArrayList.add(new list_item(R.mipmap.ic_launcher,"뽀","제목4",new Date(System.currentTimeMillis()),"내용4"));
        list_itemArrayList.add(new list_item(R.mipmap.ic_launcher,"햇님","제목5",new Date(System.currentTimeMillis()),"내용5"));

        myListAdapter = new MyListAdapter(MainActivity.this,list_itemArrayList);
        listView.setAdapter(myListAdapter);


        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(170);
                // set item title
                openItem.setTitle("X");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem checkItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                checkItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                checkItem.setWidth(170);
                // set a icon
                checkItem.setIcon(R.drawable.ic_check);
                // add to menu
                menu.addMenuItem(checkItem);
            }
        };

        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        list_itemArrayList.get(position).setImportant();
                        break;
                    case 1:
                        list_itemArrayList.get(position).setImportant();
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });

    }
}
