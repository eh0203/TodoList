package com.example.tm156navercom.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.CheckBox;
import java.util.ArrayList;

/**
 * Created by HOON on 2017-11-13.
 */

public class MyListAdapter extends BaseAdapter {
    Context context;
    ArrayList<list_item> list_itemArrayList;

    TextView txtName;
    TextView txtTitle;
    TextView txtDate;
    TextView txtContent;
    ImageView imgProfile;

    public MyListAdapter(Context context, ArrayList<list_item> list_itemArrayList) {
        this.context = context;
        this.list_itemArrayList = list_itemArrayList;
    }

    @Override
    public int getCount() {
        return this.list_itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list_itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

   /* public void onCheckedChanged(CompoundButton view, boolean isChecked){
        if(isChecked){
           view.setBackgroundColor(Color.MAGENTA);
        }
        else  view.setBackgroundColor(Color.WHITE);

    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
            txtName = (TextView)convertView.findViewById(R.id.txtName);
            txtTitle = (TextView)convertView.findViewById(R.id.txtTitle);
            txtDate = (TextView)convertView.findViewById(R.id.txtDate);
            txtContent = (TextView)convertView.findViewById(R.id.txtContent);
            imgProfile = (ImageView)convertView.findViewById(R.id.imgProfile);

        }

        final View v1 =  convertView;
        convertView.findViewById(R.id.check1).setOnClickListener(new Button.OnClickListener(){
            public  void onClick(View v){
                CheckBox ch1 = (CheckBox)v.findViewById(R.id.check1);
                if(ch1.isChecked()){
                    v1.setBackgroundColor(Color.MAGENTA);
                }else {v1.setBackgroundColor(Color.WHITE);}
            }
        });


       if(list_itemArrayList.get(position).getImportant() == true){
            convertView.setBackgroundColor(Color.MAGENTA);
        }else{convertView.setBackgroundColor(Color.WHITE);}

        txtName.setText(list_itemArrayList.get(position).getNickname());
        txtTitle.setText(list_itemArrayList.get(position).getTitle());
        txtContent.setText(list_itemArrayList.get(position).getContent());
        txtDate.setText(list_itemArrayList.get(position).getWrite_date().toString());
        imgProfile.setImageResource(list_itemArrayList.get(position).getProfile_image());

        return convertView;
    }

}
