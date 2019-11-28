package com.example.entry;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
public class host  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);


    /*
    public void check_in(View v)
    {
        String disp = getIntent().getExtras().getString("keyName");
        String emailhost=getIntent().getExtras().getString("mailh");
        String mail1=getIntent().getExtras().getString("mailv");
        String chost=getIntent().getExtras().getString("chost");
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
        //Get the SmsManager instance and call the sendTextMessage method to send message
        SmsManager sms= SmsManager.getDefault();
        sms.sendTextMessage(chost, null, disp, pi,null);
        Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                Toast.LENGTH_LONG).show();
        /*
        Intent intent1=new Intent(Intent.ACTION_SEND);
        intent1.setData(Uri.parse("mailto:"));
        intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{ emailhost});
        intent1.putExtra(Intent.EXTRA_SUBJECT,"mail for visitor's details:\n"+disp);
        intent1.putExtra(Intent.EXTRA_TEXT,mail1);
        intent1.setType("message/rfc822");
        startActivity(Intent.createChooser(intent1, "Choose Email client :"));
public void check_out(View v) {
         */

        String data = getIntent().getExtras().getString("keyName");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy G 'at' HH:mm:ss z");
        String time_out = sdf.format(new Date());
        String di[] = {data + "\n" + "CHECK OUT : " + time_out + "\n" + "thanks for visiting!"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item, di);
        ListView mlistView = (ListView) findViewById(R.id.list);
        mlistView.setAdapter(adapter);
}
}
