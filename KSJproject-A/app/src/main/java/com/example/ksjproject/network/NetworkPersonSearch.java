package com.example.ksjproject.network;

import android.os.AsyncTask;
import android.util.Log;
import com.example.ksjproject.Adapter.PlistAdapter;
import com.example.ksjproject.Person.PListinfo;

import org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NetworkPersonSearch extends AsyncTask<String, Void, String> {
    private URL Url;
    private String URL_Address = "http://192.168.35.185/KSJproject/Person_Search.jsp";
    private PlistAdapter adapter;

    public NetworkPersonSearch(PlistAdapter adapter){
        this.adapter = adapter;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override                       //String[] strings랑 같다
    protected String doInBackground(String[] strings) {//이안에 있는게 실행됨 스레드로 치면 run이다
        String res = "";
        try{
            Url = new URL(URL_Address);
            HttpURLConnection conn = (HttpURLConnection) Url.openConnection();

            conn.setDefaultUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=utf-8");

            StringBuffer buffer = new StringBuffer();
            buffer.append("title").append("=").append(strings[0]);

            OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(),"utf-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            StringBuilder builder= new StringBuilder();
            BufferedReader in = new BufferedReader((new InputStreamReader(conn.getInputStream(),"utf-8")));
            String line;
            while ((line = in.readLine()) != null){
                builder.append(line + "\n");
            }
            res = builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.v("mango",res);
        return res;
    }

    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);

        ArrayList<PListinfo> userList = new ArrayList<PListinfo>();
        int count = 0;
        try{
            count = JsonParser.getPlistJson(s, userList);
        }catch (JSONException e){
            e.printStackTrace();
        }
        if(count ==0){

        }else{
            adapter.setDatas(userList);
            adapter.notifyDataSetInvalidated();
        }
    }

}
