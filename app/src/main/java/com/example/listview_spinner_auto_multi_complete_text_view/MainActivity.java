package com.example.listview_spinner_auto_multi_complete_text_view;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView l1;
    Spinner sp1,sp2;
    EditText e1,e2,e3;
    AutoCompleteTextView Auto;
    MultiAutoCompleteTextView Multi;
    Button b1;


//String[] array = {"Apple","Banana","JackFruits","Watermalon","Lici","Orange"};

    Integer  [] prices={10,20,30,40,50,60,70,56,34,34,45,56,45,45,2,34,5,23,3};
    Integer [] quantity={2,3,5,6,8,20,67,45,34,22,23,112,23,34,45,56,22};

    String[] fruitsName;

    String[] country ={"Bangladesh","Brazil","Belgiam","Australia","Argentina","Austia"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        l1=findViewById(R.id.listView);
        sp1=findViewById(R.id.sp1);
        sp2=findViewById(R.id.sp2);
        e1=findViewById(R.id.edit1);
        e2=findViewById(R.id.edit2);
        e3=findViewById(R.id.eidt3);
        Auto=findViewById(R.id.auto);
        Multi=findViewById(R.id.multi);
        b1=findViewById(R.id.button);


//        Resources res = getResources();
//        fruitsName= res.getStringArray(R.array.name);

        fruitsName=getResources().getStringArray(R.array.name);

//
//        For Custom Layout============>>>>>

//        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>
//                (MainActivity.this,R.layout.custom_layout,R.id.customLayout,array);


        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>
                (MainActivity.this, android.R.layout.simple_list_item_1,fruitsName);

        l1.setAdapter(arrayAdapter);


        ArrayAdapter<Integer>arrayAdapter1=new ArrayAdapter<>
                (MainActivity.this, android.R.layout.simple_list_item_1,prices);

        sp1.setAdapter(arrayAdapter1);

        ArrayAdapter<Integer>arrayAdapter2=new ArrayAdapter<>
                (MainActivity.this, android.R.layout.simple_list_item_1,quantity);

        sp2.setAdapter(arrayAdapter2);


        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String a=((TextView)view).getText().toString().trim();
                e1.setText(a);
            }
        });

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String b=((TextView)view).getText().toString().trim();
                e2.setText(b);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String c=((TextView)view).getText().toString().trim();
                e3.setText(c);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String>arrayAdapter3=new ArrayAdapter<>
                (MainActivity.this, android.R.layout.simple_list_item_1,country);

        Auto.setAdapter(arrayAdapter3);

        ArrayAdapter<String>arrayAdapter4=new ArrayAdapter<>
                (MainActivity.this, android.R.layout.simple_list_item_1,country);

        Multi.setAdapter(arrayAdapter4);
        Multi.setThreshold(1);
        Multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(MainActivity.this,MainActivity2.class);
                String a=e1.getText().toString().trim();
                String b=e2.getText().toString().trim();
                String c=e3.getText().toString().trim();

                Integer b1=Integer.parseInt(b);
                Integer c1=Integer.parseInt(c);
                Integer d1=b1*c1;
                String e=String.valueOf(d1);

                String auto =Auto.getText().toString().trim();
                String multi=Multi.getText().toString().trim();

                ii.putExtra("key1",a);
                ii.putExtra("key2",e);
                ii.putExtra("key3",auto);
                ii.putExtra("key4",multi);

                startActivity(ii);

            }
        });


    }
}