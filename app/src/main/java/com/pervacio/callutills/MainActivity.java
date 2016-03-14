package com.pervacio.callutills;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickDial(View view) {

        EditText editText = (EditText) findViewById(R.id.num_edit_text);
        String text = editText.getText().toString();
        Log.d(TAG, "Dial number " + text);
        CallUtil callUtil = new CallUtil(this);
        callUtil.dialNumber("121");
//        callUtil.callNumber(text);
//        callUtil.disableMobileData();
    }
}
