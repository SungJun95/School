package com.example.ksjproject.Adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ksjproject.Person.CListinfo;
import com.example.ksjproject.R;

import java.util.ArrayList;

public class ClistAdapter extends BaseAdapter
{
    private Activity Act;
    int ListLayout;
    ArrayList<CListinfo> CListArr;
    LayoutInflater Inflater;

    ImageView PContentIV;
    Boolean IVboolean;

    int [] nDrawable = {R.drawable.heart1, R.drawable.heart2};


    public void setDatas(ArrayList<CListinfo> arrayList){
        CListArr = arrayList;
    }
    public ClistAdapter(Activity act, int activity_p_list_content, ArrayList<CListinfo> cListinfos) {
        Act = act;
        ListLayout = activity_p_list_content;
        CListArr = cListinfos;
        Inflater = (LayoutInflater) Act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view = Inflater.inflate(ListLayout, viewGroup, false);
        if(CListArr.size() == 0)
        Log.v("mango" , "TEST");

        final TextView tvTitle = (TextView) view.findViewById(R.id.PContentTitle);
        tvTitle.setText("Company Open recruitment");

        final TextView tvContent = (TextView) view.findViewById(R.id.PContentC);
        tvContent.setText("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.");

        final TextView tvCname = (TextView) view.findViewById(R.id.PContentName);
        tvCname.setText("KsjCompany");

        final TextView tvCemail = (TextView) view.findViewById(R.id.PContentEmail);
        tvCemail.setText("KsjC@gmail.com");

        final TextView tvCtel = (TextView) view.findViewById(R.id.PContentTel);
        tvCtel.setText("051-112-1112");


        IVboolean = false;
        PContentIV = (ImageView) view.findViewById(R.id.PContentIV);
        PContentIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(IVboolean){
                    PContentIV.setImageResource(nDrawable[0]);
                    IVboolean=false;
                    Toast.makeText(Act.getApplicationContext(), "찜하기해제!" , Toast.LENGTH_SHORT).show();
                    // DB에 찜하기 구현! 여유되면
                } else {
                    PContentIV.setImageResource(nDrawable[1]);
                    IVboolean=true;
                    Toast.makeText(Act.getApplicationContext(), "찜했습니다!" , Toast.LENGTH_SHORT).show();

                }
            }
        });

        return view;
    }

}
