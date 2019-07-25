package com.example.bookshelf;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceconfig {
    private SharedPreferences sharedPreferences;
    private Context context;
    public SharedPreferenceconfig(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preferences),Context.MODE_PRIVATE);

    }
    public void WriteLoginStatus(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preferences),status);
        editor.commit();
    }

    public boolean ReadLoginStatus(){
        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preferences),false);
        return status;
    }
}
