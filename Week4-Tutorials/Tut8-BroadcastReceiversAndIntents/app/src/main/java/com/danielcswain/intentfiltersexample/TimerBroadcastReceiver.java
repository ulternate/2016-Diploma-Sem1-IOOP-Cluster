package com.danielcswain.intentfiltersexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ulternate on 28/02/2016.
 */
public class TimerBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm Notification", Toast.LENGTH_SHORT).show();
    }
}
