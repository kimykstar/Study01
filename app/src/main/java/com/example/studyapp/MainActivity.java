package com.example.studyapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText id, pw, pw_check, name, phone;
    Button id_Check_Btn, join_Btn, cancel_Btn;
    TextView id_Check_Text, pw_Check_Text, msg;

    // id, pw_check, name, phone
    int[] check = {0, 0, 0, 0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.id);
        pw = (EditText) findViewById(R.id.pw);
        pw_check = (EditText) findViewById(R.id.pw_check);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);

        id_Check_Btn = (Button) findViewById(R.id.id_Check_Btn);
        join_Btn = (Button) findViewById(R.id.join_Btn);
        cancel_Btn = (Button) findViewById(R.id.cancel_Btn);

        id_Check_Text = (TextView) findViewById(R.id.id_Check_Text);
        pw_Check_Text = (TextView) findViewById(R.id.pw_check_text);
        msg = (TextView) findViewById(R.id.msg);

        EditText[] texts = {id, pw_check, name, phone};

        id_Check_Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(id.getText().length() > 1) {
                    AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                    ad.setIcon(R.mipmap.ic_launcher);
                    ad.setTitle("아이디 중복확인");
                    ad.setMessage("사용가능한 아이디입니다.");

                    ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            id_Check_Text.setText("사용가능한 ID입니다.");
                            id_Check_Text.setTextColor(Color.parseColor("#1A47CC"));
                        }
                    });

                    ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    ad.show();
                }else{
                    id_Check_Text.setText("ID를 입력해야 합니다.");
                }
            }
        });

        pw_check.addTextChangedListener(new TextWatcher() {
            String pw_text, pw_check_txt;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            // 텍스트가 변할때마다
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                pw_text = pw.getText().toString();
                pw_check_txt = pw_check.getText().toString();
                if(pw_text.equals(pw_check_txt)){
                    pw_Check_Text.setTextColor(Color.parseColor("#1A47CC"));
                    pw_Check_Text.setText("PASSWORD가 일치합니다.");
                }else{
                    pw_Check_Text.setTextColor(Color.parseColor("#D30D0D"));
                    pw_Check_Text.setText("PASSWORD가 일치하지 않습니다.");
                }
            }

            // 텍스트가 변한 후에
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        join_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkbit = true;
                for(int i = 0; i < check.length; i++){
                    if(check[i] == 0) checkbit = false;
                }
                if(checkbit == true){
                   // Intent intent = new Intent(MainActivity.this, );
                }else{
                    for(int i = 0; i < check.length; i++){
                        if(check[i] == 0)
                            msg.append(texts[i].getHint().toString() + ",  ");
                    }
                    msg.append("칸을 입력해주세요");
                }
            }
        });
    }

}