package com.example.vvats.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        t3 = (TextView) findViewById(R.id.t3);
        Bundle bundle = getIntent().getExtras();
        String textValue = bundle.getString("userData");
        t3.setText(textValue);
    }
}
