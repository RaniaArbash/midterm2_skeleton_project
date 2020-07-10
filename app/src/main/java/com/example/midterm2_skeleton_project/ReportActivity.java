package com.example.midterm2_skeleton_project;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {
ImageView sImage;
ListView simpleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
       ArrayList<Car> list =  getIntent().getParcelableArrayListExtra("students");
        simpleList = (ListView) findViewById(R.id.simpleList);
        CarAdapter adapter= new CarAdapter(getApplicationContext(),list);
        simpleList.setAdapter(adapter);
     //  s.allCourses = getIntent().getParcelableArrayListExtra("courseList");

     //   Log.d("course",((Course)s.allCourses.get(0)).courseName);
     //   CourseList newList = CourseList.newInstance(s.allCourses);
       // getSupportFragmentManager().beginTransaction()
         //       .replace(R.id.frameLayout, newList).commit();




    }


}
