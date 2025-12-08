package com.example.aula2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {

    int mResource; // layout do item da lista (item_lista.xml)

    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //a a view se já existir
        View v = convertView;
        if (v == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            v = layoutInflater.inflate(mResource, parent, false);
        }
        // Pega o planeta
        Planeta planeta = getItem(position);

        TextView tv = v.findViewById(R.id.textView);
        ImageView imageView = v.findViewById(R.id.imageView);

        if (planeta != null) { //dados do planeta
            tv.setText(planeta.nome);
            imageView.setImageResource(planeta.foto);
        }
        return v;
    }
}
