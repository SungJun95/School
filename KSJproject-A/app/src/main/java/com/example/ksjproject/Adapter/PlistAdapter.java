package com.example.ksjproject.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ksjproject.Person.PListinfo;
import com.example.ksjproject.Person.PersonMain;
import com.example.ksjproject.R;

import java.util.ArrayList;

public class PlistAdapter extends BaseAdapter
{
    private Activity Act;
    int ListLayout;
    ArrayList<PListinfo> PListArr;
    LayoutInflater Inflater;




    public PlistAdapter(PersonMain personMain, int adapter_jobinfo, ArrayList<PListinfo> pListinfos) {
        Act = personMain;
        ListLayout = adapter_jobinfo;
        PListArr = pListinfos;
        Inflater = (LayoutInflater) personMain.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<PListinfo> arrayList){
        PListArr = arrayList;
    }

    @Override
    public int getCount() {
        return PListArr.size();
    }

    @Override
    public Object getItem(int position) {
        return PListArr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view = Inflater.inflate(ListLayout, viewGroup, false);

        final TextView tvTitle = (TextView) view.findViewById(R.id.jobTitle);
        tvTitle.setText(PListArr.get(i).title);

        final TextView tvContent = (TextView) view.findViewById(R.id.jobContent);
        tvContent.setText(PListArr.get(i).content);

        final TextView tvJob = (TextView) view.findViewById(R.id.jobHash1);
        tvJob.setText( "#" + PListArr.get(i).job);

        final TextView tvArea = (TextView) view.findViewById(R.id.jobHash2);
        tvArea.setText( "#" + PListArr.get(i).area);

        return view;
    }
}
