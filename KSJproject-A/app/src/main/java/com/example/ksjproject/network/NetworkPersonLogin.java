package com.example.ksjproject.network;


import android.os.AsyncTask;
import com.example.ksjproject.TabFragment1;

import org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkPersonLogin extends AsyncTask<String, Void, String> {
    private URL Url;
    private String URL_Address = "http://10.100.103.35/KSJproject/Person_login.jsp";
    private TabFragment1 tabFragment1;

    public NetworkPersonLogin(TabFragment1 tabFragment1) {
        tabFragment1 = this.tabFragment1;
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
        if(res == 0){
            tabFragment1.LoginFail();
        } else {
            tabFragment1.LoginSucess();
        }
    }
}
