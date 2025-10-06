package com.example.aula2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> nomes;
    ListView listView;
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        nomes = new ArrayList<String>(); //Inicializa ArrayList
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        button.setOnClickListener(v-> {
            nomes.add(editText.getText().toString());
            adapter.notifyDataSetChanged();
        });
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            nomes.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });

    }
}