package com.sdlabs.gpstracking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import static android.R.attr.type;

/**
 * Created by saransh on 27-04-2017.
 */

public class SMSBroadcastReceiver extends BroadcastReceiver {



    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG = "SMSBroadcastReceiver";



    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Intent received: " + intent.getAction());

        if (intent.getAction().equals(SMS_RECEIVED)) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[])bundle.get("pdus");
                final SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                }
                if (messages.length > -1) {
                    Toast.makeText(context, "Message received: " + messages[0].getMessageBody(), 7000).show();


                    Intent newIntent = new Intent(context, login_success.class);
                    newIntent.putExtra("msg",messages[0].getMessageBody());
                    newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(newIntent);


                }



            }
        }


    }






}
