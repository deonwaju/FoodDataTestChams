package com.deonolarewaju.foodapptest.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppUtil {
    public static boolean hasToken(Context context) {
        SharedPreferences mPrefs = PreferenceManager
                .getDefaultSharedPreferences(context.getApplicationContext());
        return mPrefs.getString("token", null) != null;
    }

    public static String getToken(Context context) {
        SharedPreferences mPrefs = PreferenceManager
                .getDefaultSharedPreferences(context.getApplicationContext());
        return mPrefs.getString("token", "");
    }

    public static void updateToken(String token, Context context) {
        SharedPreferences mPrefs = PreferenceManager
                .getDefaultSharedPreferences(context.getApplicationContext());
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("token", token);
        prefsEditor.commit();
        LogUtils.write("token >>>>>>>> : " + token);
    }
}
