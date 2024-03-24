package com.example.tarea2_3;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class SetData {
    String descripcion;
    Bitmap fotoBitmap;

    SetData(String descripcion, Bitmap fotoBitmap){
        this.descripcion = descripcion;
        this.fotoBitmap = fotoBitmap;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Bitmap getFotoBitmap() {
        return fotoBitmap;
    }
}
