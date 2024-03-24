package com.example.tarea2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import Configuracion.SQLiteConexion;
import Configuracion.Transacciones;
import Models.Fotos;

public class ActivityList extends AppCompatActivity {
    Button btnRegresar;
    SQLiteConexion conexion;
    ListView listfotos;
    ArrayList<Fotos> lista;
    ArrayList<String> Arreglo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btnRegresar = (Button) findViewById(R.id.btnRegresarMenu);
        conexion = new SQLiteConexion(this, Transacciones.DBName, null, 1);
        listfotos = (ListView) findViewById(R.id.list_item);

        ObtenerInfo();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Arreglo);
        listfotos.setAdapter(adp);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void ObtenerInfo() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Fotos person = null;
        lista = new ArrayList<Fotos>();

        Cursor cursor = db.rawQuery(Transacciones.SelectAllFotos, null);

        while(cursor.moveToNext()){
            person = new Fotos();
            person.setId(cursor.getInt(0));
            person.setDescripcion(cursor.getString(1));
            person.setFotografia(cursor.getString(2));


            lista.add(person);
        }

        cursor.close();

        FillData();
    }

    private void FillData() {
        Arreglo = new ArrayList<String>();
        for(int i = 0; i < lista.size(); i++){
            Arreglo.add(lista.get(i).getId() + " - " +
                    lista.get(i).getDescripcion() + " " +
                    lista.get(i).getFotografia());
        }
    }
}