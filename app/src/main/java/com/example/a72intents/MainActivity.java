package com.example.a72intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button btnLook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        btnLook = findViewById(R.id.btnLook);
        final Pattern geoPattern = Pattern.compile("^[+-]?([0-9]*[.])?[0-9]+,[+-]?([0-9]*[.])?[0-9]+$");

        btnLook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Editable text = editText.getText();
                if (geoPattern.matcher(text).matches()) {
                    Uri uri = Uri.parse("geo:" + editText);
                    intent.setData(uri);
                } else {
                    Uri uri = Uri.parse("geo:?q=" + text);
                    intent.setData(uri);
                }
                startActivity(intent);
            }
        });
    }
}
