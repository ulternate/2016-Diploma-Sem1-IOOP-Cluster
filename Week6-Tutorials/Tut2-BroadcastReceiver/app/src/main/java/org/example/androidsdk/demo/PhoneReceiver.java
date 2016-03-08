package org.example.androidsdk.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by NicholaKerr on 12-Jan-15.
 *
 * Edited by Daniel on 08/03/2016
 *
 */
public class PhoneReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
    //create an instance of a Bundle (map) and get the extras that have been passed in by the intent
       Bundle extras = intent.getExtras();
        //if there are extras lets doing something
        if (extras != null)
        {
            //lets get the new phone state
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.d("PhoneReceiver", state);

            //lets find out if the phone is ringing
            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                //if it is ringing get the number
                String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.d("PhoneReceiver", phoneNumber);
            }
        }
    }
}
