package com.example.ksjproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class TabFragment1 extends Fragment
{

    Button btnPJoin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);

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


}
