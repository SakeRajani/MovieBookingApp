package com.example.moviebookingapp;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.ArrayList;


public class MovieDescriptionFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    String str="";
    String str1="";
    String[] seats={"1","2","3","4","5","6","7","8","9","10"};
    String number;
    RadioButton radioButton2,radioButton3,radioButton4,radioButton5;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_movie_description, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       TextView text= view.findViewById(R.id.textview3);
       String moviename=getArguments().getString("message");
       text.setText(moviename);

       TextView text2=view.findViewById(R.id.textview4);
        RadioGroup radioGroup1=view.findViewById(R.id.radiogroup1);
        TextView text3=view.findViewById(R.id.textview5);
        RadioGroup radioGroup2=view.findViewById(R.id.radiogroup2);
        radioButton2 =radioGroup1.findViewById(R.id.radioButton2);
        radioButton3 =radioGroup1.findViewById(R.id.radioButton3);
        radioButton4 =radioGroup2.findViewById(R.id.radioButton4);
        radioButton5 =radioGroup2.findViewById(R.id.radioButton5);
        Button button =view.findViewById(R.id.button1);
        Spinner spin = view.findViewById(R.id.seatsspinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, seats);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spin.setAdapter(ad);


        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                         case R.id.radioButton2:
                            str1="Telugu";
                            //str = "2D";
                            break;
                        case R.id.radioButton3:
                            str1="Hindi";
                            //str = "3D";
                            break;
                            }
                        }
        });


      radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

          public void onCheckedChanged(RadioGroup group, int checkedId) {
              switch (checkedId) {
                      case R.id.radioButton4:
                          //str1="Hindi";
                          str = "2D";
                          break;
                      case R.id.radioButton5:
                         // str1="Hindi";
                          str = "3D";
                          break;
                            }
                        }
                    });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getContext(), moviename + str1 + str+ number+" seats", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder Dialog=new AlertDialog.Builder(getContext());
                Dialog.setTitle(moviename+str1+str);
                Dialog.setMessage(number+" Tickets booked successfully");
                Dialog.setCancelable(false);
                Dialog.setPositiveButton("OK", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // When the user click yes button then app will close
                    dialog.cancel();
                });
                AlertDialog alertDialog = Dialog.create();
                // Show the Alert Dialog box
                alertDialog.show();
            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        number=seats[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
