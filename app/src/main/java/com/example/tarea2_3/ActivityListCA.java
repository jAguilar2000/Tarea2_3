package com.example.tarea2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Configuracion.SQLiteConexion;
import Configuracion.Transacciones;
import Models.Fotos;

public class ActivityListCA extends AppCompatActivity {

    ListView listView;
    SQLiteConexion conexion;
    ArrayList<Fotos> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ca);
        listView = findViewById(R.id.list);
        conexion = new SQLiteConexion(this, Transacciones.DBName, null, 1);
        List<SetData> setData;
        setData = new ArrayList<>();


        //ObtenerInfo();
        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(Transacciones.SelectAllFotos, null);

        while(cursor.moveToNext()){
            setData.add(new SetData(cursor.getString(2), "http://res.cloudinary.com/dxweztzam/image/upload/v1709171216/LaEconomica/Categorias/limpieza.png.png"));
        }
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.list_items, setData);

        listView.setAdapter(customAdapter);
    }

    private void ObtenerInfo() {
        SQLiteDatabase db = conexion.getReadableDatabase();
    }
}