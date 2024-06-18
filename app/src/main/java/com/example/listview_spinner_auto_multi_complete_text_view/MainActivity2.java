package com.example.listview_spinner_auto_multi_complete_text_view;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    EditText e1,e2,e3,e4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        e1=findViewById(R.id.fruitsName);
        e2=findViewById(R.id.totalprices);
        e3=findViewById(R.id.Autopass);
        e4=findViewById(R.id.Multipass);

        String data =getIntent().getExtras().getString("key1");
        e1.setText(data);

        String data2 =getIntent().getExtras().getString("key2");
        e2.setText(data2);

        String data3 =getIntent().getExtras().getString("key3");
        e3.setText(data3);

        String data4 =getIntent().getExtras().getString("key4");
        e4.setText(data4);

    }
}