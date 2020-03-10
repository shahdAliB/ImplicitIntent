package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openWebSite(View v) {

        EditText link = (EditText) findViewById(R.id.httpLink);
        String url = "http://" + link.getText().toString();

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
    }
    public void sendSMS(View v) {

        EditText num = (EditText) findViewById(R.id.numberTXT);
        String number = "smsto:" + num.getText().toString();

        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse(number));
        startActivity(i);
    }
    public void call(View v) {

        EditText num = (EditText) findViewById(R.id.numberTXT);
        String number = "tel://" + num.getText().toString();

        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse(number));
        startActivity(i);
    }

    public void showContactList(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
        startActivity(i);
    }
    public void srchTxt(View v) {

        EditText txt = (EditText) findViewById(R.id.editText3);
        String search = txt.getText().toString();
        Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
        i.putExtra(SearchManager.QUERY,search);
        startActivity(i);
    }

    public void showLoc(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?"+"saddr=26.3942364,43.9359818&"
                                                                                          +"daddr=24.738312,46.756187"));
        startActivity(i);
    }
}
