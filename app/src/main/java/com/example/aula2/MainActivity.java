package com.example.aula2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Variáveis principais
    String[] nomes = new String[] {
            "Natan", "Sarah", "Anaju",
            "Maria Clara", "Clara"
    };

    ListView lv; //lista

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //layout da tela principal
        lv = findViewById(R.id.listview);//recupera

        ArrayAdapter<String> a = new ArrayAdapter(
                this,
                R.layout.item_lista,
                R.id.textView,//ta recebendo aqui
                nomes
        );
        lv.setAdapter(a);
    }
}