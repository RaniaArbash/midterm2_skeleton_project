package com.example.midterm2_skeleton_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends BaseAdapter {

    Context context;
    ArrayList<Car> carsList;
    LayoutInflater inflater;
    View view;

    public CarAdapter(Context appContext, ArrayList<Car> list){
        this.context = appContext;
        this.carsList = list;
        inflater = LayoutInflater.from(appContext);
    }

    @Override
    public int getCount() {
        return carsList.size();
    }

    @Override
    public Object getItem(int position) {
        return carsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        view = inflater.inflate(R.layout.student_item_layout,null);
        TextView studetName = (TextView)view.findViewById(R.id.StudentName);
        TextView yearandlevelText = (TextView) view.findViewById(R.id.year_level);
        ImageView studentImage = (ImageView)view.findViewById(R.id.image) ;

        studetName.setText((carsList.get(position)).OwnerName);
        yearandlevelText.setText("Model: " + carsList.get(position).model +" Year: " +carsList.get(position).year);
        studentImage.setImageBitmap(carsList.get(position).imageData);
        return view;
    }
}
