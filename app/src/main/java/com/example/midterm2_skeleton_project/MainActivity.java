package com.example.midterm2_skeleton_project;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddYearAndModelDialog.saveYearandLevelEventListener {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView myImage;
    Car myCar;
    ArrayList<Car> carsArrayList;
    EditText myName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myImage = (ImageView) findViewById(R.id.personalImageID);
        myName = (EditText) findViewById(R.id.studentName);
        myCar = new Car();
        carsArrayList = new ArrayList<Car>(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void uploade(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            myImage.setImageBitmap(imageBitmap);
            myCar.imageData = imageBitmap;
        }
    }

    @Override
    public void saveYearAndLevelFun(int year,String model) {
        myCar.year = year;
        myCar.model = model;
        Toast.makeText(getApplicationContext(),"Year "+myCar.year+" level: " + myCar.model,Toast.LENGTH_LONG).show();
    }

    public void addNewCourse(View view) {
        AddYearAndModelDialog newDialog = new AddYearAndModelDialog();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        newDialog.show(transaction,"fragment");

    }


    public void saveStudent(View view) {
        myCar.OwnerName = myName.getText().toString();
        carsArrayList.add(myCar);
        //Toast.makeText(getApplicationContext()," Car " + myself.studentName + " is saved correcttly ",Toast.LENGTH_LONG).show();
        Intent reportIntent = new Intent(this,ReportActivity.class);
        reportIntent.putParcelableArrayListExtra("students",carsArrayList);
        startActivity(reportIntent);
        myCar = new Car();

    }
}
