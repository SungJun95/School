package com.example.ksjproject.network;
import com.example.ksjproject.PersonInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {

    static public int getUserInfoJson(String response, ArrayList<PersonInfo> userList) throws JSONException{
        String strID;
        String strPassword;
        String strName;
        String strBirth;
        String strSex;
        String strEmail;
        String strTel;

        JSONObject rootJSON = new JSONObject(response);
        JSONArray jsonArray = new JSONArray(rootJSON.getString("datas"));

        for(int i=0; i<jsonArray.length();i++){
            JSONObject jsonObj = (JSONObject)jsonArray.get(i);

            if(jsonObj.getString("ID").toString().equals("null"))
                strID="-";
            else
                strID=jsonObj.getString("ID").toString();

            if(jsonObj.getString("PASSWORD").toString().equals("null"))
                strPassword="-";
            else
                strPassword=jsonObj.getString("PASSWORD").toString();

            if(jsonObj.getString("NAME").toString().equals("null"))
                strName="-";
            else
                strName=jsonObj.getString("NAME").toString();

            if(jsonObj.getString("BIRTH").toString().equals("null"))
                strBirth="-";
            else
                strBirth=jsonObj.getString("BIRTH").toString();

            if(jsonObj.getString("SEX").toString().equals("null"))
                strSex="-";
            else
                strSex=jsonObj.getString("SEX").toString();

            if(jsonObj.getString("EMAIL").toString().equals("null"))
                strEmail="-";
            else
                strEmail=jsonObj.getString("EMAIL").toString();

            if(jsonObj.getString("TEL").toString().equals("null"))
                strTel="-";
            else
                strTel=jsonObj.getString("TEL").toString();


            userList.add(new PersonInfo(strID, strPassword, strName, strBirth, strSex, strEmail, strTel));
        }
        return jsonArray.length();
    }
    static public int getResultJson(String response) throws JSONException{
        JSONArray jsonArray = new JSONArray(response);
        JSONObject jsonObject = new JSONObject(jsonArray.getString(0));
        return Integer.parseInt(jsonObject.getString("RESULT_OK"));
    }
}
