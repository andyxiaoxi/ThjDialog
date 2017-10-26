package com.thj.dialog.thjdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thj.dialog.thj_dialog.CustomDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomDialog dialog = new CustomDialog(this);

        dialog.show("好人","这是一条消息");
    }
}
