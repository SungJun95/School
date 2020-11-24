package com.example.ksjproject.Person;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ksjproject.R;

public class PListinfo extends AppCompatActivity {

    public String title, content, job, area;

    public PListinfo(String title, String content, String job, String area){
        this.title = title;
        this.content = content;
        this.job = job;
        this.area = area;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personmainpage);
    }
}
