package com.example.videocallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collections;

public class profile extends AppCompatActivity {

    EditText targetUser;
    TextView caller;
    ZegoSendCallInvitationButton callbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        targetUser = findViewById(R.id.usertext);
        callbtn= findViewById(R.id.callbtn);
        caller= findViewById(R.id.caller);

        caller.setText("Welcome : " + getIntent().getStringExtra("caller"));

        targetUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    startVideoCall(targetUser.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void startVideoCall(String targetUser){
        callbtn.setIsVideoCall(true);
        callbtn.setResourceID("zego_uikit_call");
        callbtn.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUser,targetUser)));
    }
}