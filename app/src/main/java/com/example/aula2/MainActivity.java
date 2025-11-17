package com.example.aula02;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    SQLiteDatabase db;
    Button button;
    EditText editText;
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button=findViewById(R.id.button);
        editText=findViewById(R.id.editTextText);
        listView=findViewById(R.id.listView);

        db = openOrCreateDatabase("app_databese", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, texto TEXT)");

        button.setOnClickListener(v ->{
            String titulo = editText.getText().toString();

            ContentValues cv = new ContentValues();
            cv.put("titulo", "Nota do Usuario");
            cv.put("texto", titulo);
            db.insert("notas", null, cv);
            Toast.makeText(this, "Nota salva com sucesso!", Toast.LENGTH_SHORT).show();

            carregarListagen();
        });
        listView.setOnItemClickListener( (parent, view, position, id)->{

        });
        carregarListagen();
    }

    public void carregarListagen(){
        ArrayList<String> titulos = new ArrayList<String>();
        Cursor cursor =db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            String titulo=cursor.getString(cursor.getColumnIndex("titulo"));
            titulos.add(titulo);
            cursor.moveToNext();
        }

        ArrayAdapter<String> titulosAdpter = new ArrayAdapter<>(
                getApplicationContext(), android.R.layout.simple_list_item_1, titulos
        );
        listView.setAdapter(titulosAdpter);
    }
}