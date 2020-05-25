package com.example.a72intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btnLook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= findViewById(R.id.editText);
        btnLook = findViewById(R.id.btnLook);

        btnLook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                if (Character.isLetter('т')) {
                    Uri uri = Uri.parse("geo:q?=" + editText);
                    intent.setData(uri);
                } else{
                    Uri uri = Uri.parse("geo:q?=" + editText);
                    intent.setData(uri);
                }
                startActivity(intent);
            }
        });

    }
}
