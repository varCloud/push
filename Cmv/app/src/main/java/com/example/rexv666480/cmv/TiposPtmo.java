package com.example.rexv666480.cmv;

import android.widget.ImageView;

/**
 * Created by rexv666480 on 20/01/2016.
 */
public class TiposPtmo {

    private int Image;
    private String descPrestamo;
    public TiposPtmo(int image, String descPrestamo) {
        Image = image;
        this.descPrestamo = descPrestamo;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getDescPrestamo() {
        return descPrestamo;
    }

    public void setDescPrestamo(String descPrestamo) {
        this.descPrestamo = descPrestamo;
    }


}
