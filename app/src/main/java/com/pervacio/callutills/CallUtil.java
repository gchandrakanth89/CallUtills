package com.pervacio.callutills;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.android.internal.telephony.ITelephony;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Pervacio on 13-03-2016.
 */
public class CallUtil {
    private static final String TAG = "CallUtil";
    private ITelephony iTelephony;
    private Context context;

    public CallUtil(Context context) {
        try {
            this.context = context.getApplicationContext();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            Class<? extends TelephonyManager> aClass = telephonyManager.getClass();
            Method getITelephony = aClass.getDeclaredMethod("getITelephony");
            getITelephony.setAccessible(true);
            iTelephony = (ITelephony) getITelephony.invoke(telephonyManager);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void dialNumber(String number) {
        try {
            iTelephony.dial(number);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void callNumber(String number) {
        try {
           iTelephony.call(number);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void disableMobileData(){
        try {
            boolean b = iTelephony.disableDataConnectivity();
            Log.d(TAG,"Result = "+b);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void enableMobileData(){
        try {
            boolean b = iTelephony.enableDataConnectivity();
            Log.d(TAG,"Result = "+b);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
