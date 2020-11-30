package com.example.ksjproject.network;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.ksjproject.MainActivity;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkPersonInsert extends AsyncTask<String, Void, String> {
    private URL Url;
    private String URL_Address = "http://192.168.35.185/KSJproject/Person_insert.jsp";
    private Activity act;


    public NetworkPersonInsert(Activity act){
        this.act = act;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String res = "";
        try {
            Url = new URL(URL_Address);
            HttpURLConnection conn = (HttpURLConnection) Url.openConnection();

            conn.setDefaultUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=utf-8");

            StringBuffer buffer = new StringBuffer();
            buffer.append("id").append("=").append(strings[0]);
            buffer.append("&password").append("=").append(strings[1]);
            buffer.append("&name").append("=").append(strings[2]);
            buffer.append("&birth").append("=").append(strings[3]);
            buffer.append("&sex").append("=").append(strings[4]);
            buffer.append("&email").append("=").append(strings[5]);
            buffer.append("&tel").append("=").append(strings[6]);

            OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            StringBuilder builder = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null){
                builder.append(line +"\n");
            }

            res = builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);
        int res = 0;
        try {
            res = JsonParser.getResultJson(s);
        }catch (JSONException e){
            e.printStackTrace();
        }
        if(res == 0){   // 회원가입 실패
            Toast.makeText(act,"회원가입 실패", Toast.LENGTH_SHORT).show();
        }else if (res == 1) { // 회원가입 성공
            Toast.makeText(act,"회원가입 성공", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(act, MainActivity.class);
            act.startActivity(intent);
        }else if (res == 2) { // ID중복
            Toast.makeText(act,"아이디 중복", Toast.LENGTH_SHORT).show();
        }
    }
}
