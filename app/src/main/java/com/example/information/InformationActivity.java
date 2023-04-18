package com.example.information;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InformationActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_information);
        Intent it = getIntent();
        String str = it.getStringExtra("id");
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextAge = findViewById(R.id.editTextAge);
        RadioButton radioMale = findViewById(R.id.radioMale);
        RadioButton radioFaMale = findViewById(R.id.radioFamale);
        CheckBox cBInfo = findViewById(R.id.cBInfo);
        CheckBox cBAI = findViewById(R.id.cBAI);
        CheckBox cBSecurity = findViewById(R.id.cBSecurity);
        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.putExtra("name", editTextName.getText().toString());
                it.putExtra("age", editTextAge.getText().toString());
                if(radioMale.isChecked() == true)
                    it.putExtra("sex","남자");
                else
                    it.putExtra("sex", "여자");
                String strLicense = "";
                if(cBInfo.isChecked() == true)
                    strLicense += "\n 정보처리기사";
                if(cBAI.isChecked() == true)
                    strLicense += "\n 인공지능데이터전문가";
                if (cBSecurity.isChecked() == true)
                    strLicense += "\n 정보보안기사";

                it.putExtra("license",strLicense);
                setResult(RESULT_OK,it);
            }
        });
    }
}
