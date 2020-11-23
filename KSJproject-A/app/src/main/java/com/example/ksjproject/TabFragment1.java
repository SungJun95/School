package com.example.ksjproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.ksjproject.network.NetworkPersonLogin;

public class TabFragment1 extends Fragment
{

    Button btnLogin, btnPJoin;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);

        String id = ((EditText) view.findViewById(R.id.edtPID)).getText().toString();
        String password = ((EditText) view.findViewById(R.id.edtPPWD)).getText().toString();

        btnLogin = (Button) view.findViewById(R.id.btnPLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NetworkPersonLogin(TabFragment1.this).execute(id,password);
            }
        });

        btnPJoin = (Button) view.findViewById(R.id.btnPJoin);
        btnPJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PersonJoinIntent = new Intent(getActivity(), PersonJoin.class);
                startActivity(PersonJoinIntent);
            }
        });

        return view;
    }


    public void LoginSucess(){
        Toast myToast = Toast.makeText(getActivity(),"로그인 성공", Toast.LENGTH_SHORT);
        myToast.show();
        Intent PersonMain = new Intent(getActivity(), PersonMain.class);
        startActivity(PersonMain);
    }

    public void LoginFail(){
        Toast myToast = Toast.makeText(getActivity(),"로그인 실패", Toast.LENGTH_SHORT);
        myToast.show();
    }


}
