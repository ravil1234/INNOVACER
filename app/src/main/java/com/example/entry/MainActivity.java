package com.example.entry;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public String name,cont,mail1,chost,nhost,emailhost,add,disp=" ",time_in;
    public void submit(View view)
    {
        EditText text=(EditText)findViewById(R.id.name);
        name=text.getText().toString();
        EditText text1=(EditText)findViewById(R.id.mail);
        mail1=text1.getText().toString();
        EditText text2=(EditText)findViewById(R.id.contact);
        cont=text2.getText().toString();
        EditText texta=(EditText)findViewById(R.id.address);
        add=texta.getText().toString();
        EditText text3=(EditText)findViewById(R.id.namehost);
        nhost=text3.getText().toString();
        EditText text4=(EditText)findViewById(R.id.mailhost);
        emailhost=text4.getText().toString();
        EditText text5=(EditText)findViewById(R.id.contacthost);
        chost=text5.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy G 'at' HH:mm:ss z");
        time_in = sdf.format(new Date());
        disp="Name:"+name+"\n"+"Contact:"+cont+"\n"+"Address:"+add+"\n"+"HostName:"+name+"\n"+"CHECK IN :"+time_in;

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
        //Get the SmsManager instance and call the sendTextMessage method to send message
        SmsManager sms=SmsManager.getDefault();
        sms.sendTextMessage(chost, null, disp, pi,null);
        Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                Toast.LENGTH_LONG).show();
        Intent intent1=new Intent(Intent.ACTION_SEND);
        intent1.setData(Uri.parse("mailto:"));
        intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{ emailhost});
        intent1.putExtra(Intent.EXTRA_SUBJECT,"mail for visitor's details:\n"+disp);
        intent1.putExtra(Intent.EXTRA_TEXT,mail1);
        intent1.setType("message/rfc822");
        startActivity(Intent.createChooser(intent1, "Choose Email client :"));
    }
    public void newsc(View view)
    {
        Intent i = new Intent(MainActivity.this, host.class);
        i.putExtra("keyName",disp);
        i.putExtra("mailv",mail1);
        i.putExtra("mailh",emailhost);
        i.putExtra("chost",chost);
        startActivity(i);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(cont, null,name, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }

}

