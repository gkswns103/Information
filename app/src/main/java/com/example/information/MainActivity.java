package com.example.information;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_INFO = 1;
    TextView tVResult,tVResultLabel;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnReq = (Button)findViewById(R.id.btnRequest);
        Button btnEnd = (Button)findViewById(R.id.btnEnd);
        EditText editText = findViewById(R.id.editTextID);
        tVResultLabel = (TextView)findViewById(R.id.tVResultLabel);
        tVResult = (TextView)findViewById(R.id.tVResult);
        btnReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(),InformationActivity.class);
                intent.putExtra("id",str);
                startActivityForResult(intent,REQUEST_INFO);
            }
        });
        btnEnd.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        }));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}