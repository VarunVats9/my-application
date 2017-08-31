package com.example.vvats.myapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    ToggleButton button;
    CheckBox ch1, ch2;
    RadioButton radioButton1, radioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.editText3);
        e2 = (EditText) findViewById(R.id.editText4);
        button = (ToggleButton) findViewById(R.id.toggleButton);
        ch1 = (CheckBox) findViewById(R.id.checkBox1);
        ch2 = (CheckBox) findViewById(R.id.checkBox2);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);


        button.setText("Click me");
        button.setTextOn("Show Age");
        button.setTextOff("Show Name");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.isChecked()) {
                    Toast.makeText(MainActivity.this, "Your name is " + e1.getText().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Your age is " + e2.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "You have selected " + ch1.getText().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You have unselected " + ch1.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "You have selected " + ch2.getText().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You have unselected " + ch2.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "You have selected " + radioButton1.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "You have selected " + radioButton2.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerForContextMenu(e1);
        registerForContextMenu(e2);
    }

    public void openAlert(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Exit");
        dialog.setMessage("Are you sure ?");
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }

    public void openProgress(View view) {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Downloading");
        dialog.setMessage("Please Wait .....");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id1:
                Toast.makeText(this, "You have selected Status", Toast.LENGTH_SHORT).show();
                break;
            case R.id.id2:
                Toast.makeText(this, "You have selected Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.id3:
                Toast.makeText(this, "You have selected Mic", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.editText3:
                getMenuInflater().inflate(R.menu.edit1_menu, menu);
                break;
            case R.id.editText4:
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ed1:
                Toast.makeText(this, "You have selected Capital", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ed2:
                Toast.makeText(this, "You have selected Small", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
