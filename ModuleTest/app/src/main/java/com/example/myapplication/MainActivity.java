package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText inputSMS;
    Integer[] btnIndex = { R.id.shortURLbtn, R.id.longURLbtn, R.id.typoURLbtn,
            R.id.randomURLbtn, R.id.korURLbtn, R.id.specificKeywordbtn,
            R.id.specialCharacterbtn, R.id.senderNumberbtn, R.id.fuckingFontbtn};
    Button[] btns = new Button[btnIndex.length];

    Integer[] resIndex = { R.id.shortURLres, R.id.longURLres, R.id.typoURLres,
            R.id.randomURLres, R.id.korURLres, R.id.specificKeywordres,
            R.id.specialCharacterres, R.id.senderNumberres, R.id.fuckingFontres};
    TextView[] restxt = new TextView[resIndex.length];
    int i;

    TestModule module = new TestModule();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputSMS = (EditText) findViewById(R.id.inputSMS);

        // btns, restxt connect
        for (i = 0; i < btnIndex.length; i++) {
            btns[i] = (Button) findViewById(btnIndex[i]);
            restxt[i] = (TextView) findViewById(resIndex[i]);
        }

        for (i = 0; i < btnIndex.length; i++) {
            btns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inputSMS.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "분석할 문자 메시지를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        module.setContent(inputSMS.toString());
                    }
                }
            });
        }

        // R.id.shortURLbtn
        btns[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 축약형 URL 검사
            }
        });

        // R.id.longURLbtn
        btns[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 장문 URL 검사
            }
        });

        // R.id.typoURLbtn
        btns[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 눈속임 URL 검사
            }
        });

        // R.id.randomURLbtn
        btns[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 무작위 URL 검사
            }
        });

        // R.id.korURLbtn
        btns[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 한국어 URL 검사
            }
        });

        // R.id.specificKeywordbtn
        btns[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 특정 키워드 검사
                module.specialKeywordDetect();
                restxt[5].setText(module.getContent().toString());
            }
        });

        // R.id.specialCharacterbtn
        btns[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 특수 문자 검사
            }
        });

        // R.id.senderNumberbtn
        btns[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 바시자 번호 검사
            }
        });

        // R.id.fuckingFontbtn
        btns[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버디체 검사
            }
        });



    }
}
