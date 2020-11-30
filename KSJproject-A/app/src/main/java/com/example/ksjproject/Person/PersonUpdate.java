package com.example.ksjproject.Person;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.ksjproject.R;


public class PersonUpdate extends AppCompatActivity {

    EditText PUpdateIdEdt, PupdatePwdEdt, PUpdateNameEdt, PUpdateBirthEdt, PUpdateEmailEdt, PUpdateTelEdt;
    RadioButton PUpdateManRadio, PUpdateWomanRadio;
    Button PUpdateSubmit, PUpdateCancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_update);


        
    }
}