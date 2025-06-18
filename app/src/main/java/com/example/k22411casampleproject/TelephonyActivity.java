package com.example.k22411casampleproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.adapters.TelephonyInforAdapter;
import com.example.models.TelephonyInfor;

import java.util.ArrayList;
import java.util.List;

public class TelephonyActivity extends AppCompatActivity {

    ListView lvTelephonyInfor;
    TelephonyInforAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telephony);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        readAllContacts();
    }

    private void addViews() {
        lvTelephonyInfor = findViewById(R.id.lvTelephonyInfo);
        adapter = new TelephonyInforAdapter(this, R.layout.item_telephony_infor);
        lvTelephonyInfor.setAdapter(adapter);
    }

    private void readAllContacts() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        List<TelephonyInfor> telephonyInfoList = new ArrayList<>();

        while (cursor.moveToNext()) {
            int nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            String name = cursor.getString(nameIndex);
            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            String phone = cursor.getString(phoneIndex);

            TelephonyInfor ti = new TelephonyInfor();
            ti.setDisplayName(name);
            ti.setPhoneNumber(phone);
            telephonyInfoList.add(ti);
        }
        cursor.close();

        adapter.addAll(telephonyInfoList);
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    public void sendSms(TelephonyInfor ti, String content) {
        final SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(ti.getPhoneNumber(), null, content, null, null);
        Toast.makeText(TelephonyActivity.this, "Đã gửi tin nhắn tới " + ti.getPhoneNumber(), Toast.LENGTH_LONG).show();
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    public void sendSmsPendingIntent(TelephonyInfor ti, String content) {
        final SmsManager sms = SmsManager.getDefault();
        Intent msgSent = new Intent("ACTION_MSG_SENT");
        final PendingIntent pendingMsgSent =
                PendingIntent.getBroadcast(this, 0, msgSent, PendingIntent.FLAG_IMMUTABLE);

        registerReceiver(new BroadcastReceiver() {
            @SuppressLint("UnspecifiedRegisterReceiverFlag")
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg = result == Activity.RESULT_OK ? "Send OK" : "Send failed";
                Toast.makeText(TelephonyActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        }, new IntentFilter("ACTION_MSG_SENT"));

        sms.sendTextMessage(ti.getPhoneNumber(), null, content, pendingMsgSent, null);
    }

    public void callDirect(TelephonyInfor ti) {
        Uri uri = Uri.parse("tel:" + ti.getPhoneNumber());
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        startActivity(intent);
    }

    public void callDialup(TelephonyInfor ti) {
        Uri uri = Uri.parse("tel:" + ti.getPhoneNumber());
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_filter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.filter_viettel) {
            adapter.filterByCarrier("Viettel");
            return true;
        } else if (item.getItemId() == R.id.filter_mobifone) {
            adapter.filterByCarrier("MobilePhone");
            return true;
        } else if (item.getItemId() == R.id.filter_vinaphone) {
            adapter.filterByCarrier("Vinaphone");
            return true;
        } else if (item.getItemId() == R.id.filter_others) {
            adapter.filterByCarrier("Others");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}