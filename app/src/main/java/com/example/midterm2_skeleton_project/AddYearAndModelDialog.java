package com.example.midterm2_skeleton_project;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;

public class AddYearAndModelDialog extends DialogFragment implements View.OnClickListener {
    private saveYearandLevelEventListener saveYearAndLevel;


    public interface saveYearandLevelEventListener {
        public void saveYearAndLevelFun(int year, String model);
    }

    EditText text;
    NumberPicker year_picker;
    Spinner modelSpinner;
    Context app_context;

    String[] models = new String[]{"Nissan","Mazda","Kia","Ford"};
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity a;
        app_context = context;
        if (context instanceof Activity){
            a = (Activity) context;
            saveYearAndLevel = (saveYearandLevelEventListener) a;
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_model_year,container,false);
        modelSpinner = (Spinner) view.findViewById(R.id.modelspinnerID);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(app_context,R.layout.model_row_layout,R.id.modelTextID,models);
        modelSpinner.setAdapter(adapter);

        year_picker = (NumberPicker) view.findViewById(R.id.yearpicker);
        year_picker.setMinValue(2000);
        year_picker.setMaxValue(2021);
        year_picker.setValue(2019);



        Button button = (Button)view.findViewById(R.id.saveCourse);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Bundle result = new Bundle();
        result.putString("bundleKey", "result");
        int year = year_picker.getValue();
       // int level = level_picker.getValue();
      //  Course newCourse = new Course(text.getText().toString(), (double) grade);


        saveYearAndLevel.saveYearAndLevelFun(year,models[modelSpinner.getSelectedItemPosition()]);
        dismiss();
    }


}
