package sa.elm.hr.drivers;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class MySharedPrefence {

    //2
    private static SharedPreferences prf;

    //1
    private MySharedPrefence() {

    }

    //3
    public static SharedPreferences getInstance(Context context) {

        if (prf == null)
            prf = context.getSharedPreferences("user_detals", MODE_PRIVATE);
        return prf;
    }

    public static void clearData(Context context) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.clear();
        editor.commit();

    }

    public static void clearValue(Context context, String key) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.remove(key);
        editor.commit();
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void putint(Context context, String key, int value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void putBoolean(Context context, String key, Boolean value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void putFloat(Context context, String key, Float value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public static String getString(Context context, String key, String valueDefault) {

        return getInstance(context).getString(key, valueDefault);
    }

    public static int getint(Context context, String key, int valueDefault) {

        return getInstance(context).getInt(key, valueDefault);
    }

    public static Boolean getBoolean(Context context, String key, Boolean valueDefault) {

        return getInstance(context).getBoolean(key, valueDefault);
    }

    public static Long getLonf(Context context, String key, Long valueDefault) {

        return getInstance(context).getLong(key, valueDefault);
    }

    public static Float getFloat(Context context, String key, Float valueDefault) {

        return getInstance(context).getFloat(key, valueDefault);
    }
}
