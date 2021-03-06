package com.qingluan.darkh.oldhelper.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by darkh on 11/6/14.
 */
public class JsonTools {
    JSONObject json_obj;
    private String tag = JsonTools.class.getName();

    public JsonTools(){
        this.json_obj = new JSONObject();

    }

    public JsonTools(String json_data){
        try {
            this.json_obj = new JSONObject(json_data);

        }catch (JSONException e){
            Log.d(tag, "this string can not be resolved as a json ");
            e.printStackTrace();
        }
    }

    public JSONArray getDatas(String key){
        try {
            JSONArray array = this.json_obj.getJSONArray(key);

            return  array;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Object getData(String key){
        try{
            Object obj =   this.json_obj.get(key);
//            Log.d(tag,"obj :" + obj.toString());
            return obj;
        }catch (NullPointerException e){
            Log.d(tag, "json is not init");
        }catch (JSONException e){
            Log.d(tag, "can not be decode");
            e.printStackTrace();
        }
        return  null;
    }

    public String getString(String key){

        try{
            String obj = this.json_obj.getString(key);
            return obj;
        }catch (NullPointerException e) {
            Log.d(tag, "json is not exist");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  null;
    }
    /*
        this area is about construct a json structure
     */
    public void addData(String key,String data) {
        try {
            json_obj.put(key, data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void addData(String key,int data) {
        try {
            json_obj.put(key, data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void addData(String key,Collection<?> collections) {
        try {
            JSONArray array  = new JSONArray(collections);

            json_obj.put(key, array);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void addData(String key,HashMap<String,String> data) {
        try {
            JSONObject map_json = new JSONObject();
            String[] keys = data.keySet().toArray(new String[0]);
            for (String each_key : keys ){
                map_json.put(each_key,data.get(each_key));
            }
            this.json_obj.put(key,map_json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void addData(String key,JSONObject json_sub_obj){
        try{
            this.json_obj.put(key,json_sub_obj);
        }catch (JSONException e ){
            e.printStackTrace();
        }
    }

    public String toString(){
        return  this.json_obj.toString();
    }

    public JSONObject getJsonObj(){
        return  this.json_obj;
    }
}
