package com.example.ksjproject.Person;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Network;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ksjproject.Adapter.ClistAdapter;
import com.example.ksjproject.Adapter.PlistAdapter;
import com.example.ksjproject.MainActivity;
import com.example.ksjproject.R;
import com.example.ksjproject.network.NetworkGetContent;
import com.example.ksjproject.network.NetworkGetPlist;
import com.example.ksjproject.network.NetworkPersonSearch;

import java.util.ArrayList;

public class PersonMain extends AppCompatActivity {

    //슬라이드 열기/닫기 플래그
    boolean isPageOpen = false;
    //슬라이드 열기 애니메이션
    Animation translateLeftAnim;
    //슬라이드 닫기 애니메이션
    Animation translateRightAnim;
    //슬라이드 레이아웃
    LinearLayout PSlideLayout;
    // 버튼역할 이미지뷰
    ImageView PImageView;

    Button PSearchBtn,PprofileUpdate;
    EditText PSearchEdt;

    ListView Plistview;

    ArrayList<PListinfo> arrayList;

    PlistAdapter Padapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personmainpage);
        setTheme(android.R.style.Theme);


        //UI
        PSlideLayout = (LinearLayout)findViewById(R.id.PSlideLayout);
        PImageView = (ImageView) findViewById(R.id.PImageView);

        //애니메이션
        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        //애니메이션 리스너 설정
        SlidingPageAnimationListener animationListener = new SlidingPageAnimationListener();
        translateLeftAnim.setAnimationListener(animationListener);
        translateRightAnim.setAnimationListener(animationListener);

        Plistview = findViewById(R.id.Plistview);
        Padapter = new PlistAdapter(PersonMain.this, R.layout.adapter_jobinfo, new ArrayList<PListinfo>());
        Plistview.setAdapter(Padapter);


        new NetworkGetPlist((PlistAdapter) Plistview.getAdapter()).execute("");
//        new NetworkGetPlist((PlistAdapter) Plistview.getAdapter()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");

        Plistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {   
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String strId = String.valueOf(id);

                Intent intent = new Intent(getApplicationContext(), PListContent.class);
                intent.putExtra("number" , strId);
                startActivity(intent);
            }
        });


        PSearchBtn = (Button) findViewById(R.id.PSearchBtn);
        PSearchEdt = (EditText) findViewById(R.id.PSearchEdt);
        PSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SearchTitle = PSearchEdt.getText().toString();

                new NetworkPersonSearch((PlistAdapter) Plistview.getAdapter()).execute(SearchTitle);
            }
        });

        PprofileUpdate = (Button) findViewById(R.id.PprofileUpdate);
        PprofileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "TEST", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), PersonUpdate.class);
                startActivity(intent);
            }
        });


    }                   // onCreate

    //버튼
    public void onImageViewClicked(View v){
        //닫기
        if(isPageOpen){
            //애니메이션 시작
            PSlideLayout.startAnimation(translateRightAnim);
        }
        //열기
        else{
            PSlideLayout.setVisibility(View.VISIBLE);
            PSlideLayout.startAnimation(translateLeftAnim);
        }
    }       // onImageViewClicked

    //애니메이션 리스너
    private class SlidingPageAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationEnd(Animation animation) {
            //슬라이드 열기->닫기
            if(isPageOpen){
                PSlideLayout.setVisibility(View.INVISIBLE);
                isPageOpen = false;
            }
            //슬라이드 닫기->열기
            else{
                isPageOpen = true;
            }
        }
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
        @Override
        public void onAnimationStart(Animation animation) {

        }
    }       // SlidingPageAnimationListener

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        final  View v = getLayoutInflater().inflate(R.layout.logoutdialog,null);
        new AlertDialog.Builder(PersonMain.this)
                .setView(v)
                .setNegativeButton("아니오", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 아니오
                        dialogInterface.cancel();
                    }
                })
                .setPositiveButton("네", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        // 네
                    }
                })
                .setCancelable(false)
                .show();
    }           // onBackPressed

    public void PmainLogout(View view){
        final  View v = getLayoutInflater().inflate(R.layout.logoutdialog,null);
        new AlertDialog.Builder(PersonMain.this)
                .setView(v)
                .setNegativeButton("아니오", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 아니오
                        dialogInterface.cancel();
                    }
                })
                .setPositiveButton("네", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        // 네
                    }
                })
                .setCancelable(false)
                .show();
    }        // PmainLogout
}
