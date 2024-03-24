package com.example.tarea2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Configuracion.SQLiteConexion;
import Configuracion.Transacciones;
import Models.Fotos;

public class ActivityListCA extends AppCompatActivity {

    ListView listView;
    ArrayList<Fotos> lista;
    SQLiteConexion conexion;
    Bitmap bitmapGlobal;
    Button btnRegresar;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ca);
        listView = findViewById(R.id.list);
        btnRegresar = (Button)findViewById(R.id.btnRegresar_menu);

        conexion = new SQLiteConexion(this, Transacciones.DBName, null, 1);
        List<SetData> setData;
        setData = new ArrayList<>();

        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(Transacciones.SelectAllFotos, null);

        while(cursor.moveToNext()){
            VerImagen(cursor.getString(1));
            setData.add(new SetData(cursor.getString(2), bitmapGlobal));
        }
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.list_items, setData);

        listView.setAdapter(customAdapter);


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void VerImagen(String img) {
        byte[] decodedString = Base64.decode(img, Base64.DEFAULT);
        bitmapGlobal = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
}