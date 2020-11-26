package com.example.ksjproject.Company;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.ksjproject.Company.CompanyJoin;
import com.example.ksjproject.R;

public class TabFragment2 extends Fragment
{
    Button btnCJoin;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);

        btnCJoin = (Button) view.findViewById(R.id.btnCJoin);
        btnCJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CompanyJoinIntent = new Intent(getActivity(), CompanyJoin.class);
                startActivity(CompanyJoinIntent);
            }
        });

        return view;
    }
}
