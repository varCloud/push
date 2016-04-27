package com.example.rexv666480.cmv;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;

import static android.support.v7.widget.TintTypedArray.obtainStyledAttributes;

/**
 * Created by rexv666480 on 20/01/2016.
 */
public class ImageAdapter extends BaseAdapter {

 /*   Integer[] imageIDs = {
            R.drawable.avio,
            R.drawable.ordinario,
            R.drawable.especial,
            R.drawable.quiro
    };*/
    ArrayList<TiposPtmo> lstTiposPTMO = new ArrayList<TiposPtmo>();

    private Context context;
    private int itemBackground;
    private  int colorFondo;
    public ImageAdapter(Context c)
    {
        lstTiposPTMO.add(new TiposPtmo( R.drawable.avio, "AVIO"));
        lstTiposPTMO.add(new TiposPtmo( R.drawable.ordinario, "ORDINARIO"));
        lstTiposPTMO.add(new TiposPtmo( R.drawable.quiro, "QUIRO"));
        lstTiposPTMO.add(new TiposPtmo( R.drawable.especial, "ESPECIAL"));
        context = c;

        TypedArray a = c.obtainStyledAttributes(R.styleable.MyGallery);
        itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 1);
        colorFondo = a.getResourceId(R.styleable.MyGallery_android_background,R.color.colorPrimary);
        a.recycle();
    }
    // returns the number of images
    public int getCount() {
        return lstTiposPTMO.size();
    }
    // returns the ID of an item
    public Object getItem(int position) {
        return position;
    }
    // returns the ID of an item
    public long getItemId(int position) {
        return position;
    }
    // returns an ImageView view
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        imageView.setImageResource(lstTiposPTMO.get(position).getImage());
        imageView.setLayoutParams(new Gallery.LayoutParams(350, 350));
        imageView.setPadding(0,5,20,5);
        imageView.setBackgroundResource(itemBackground);
        return imageView;
    }

    public String NombreProuctos(int position)
    {
        return  lstTiposPTMO.get(position).getDescPrestamo();
    }
}

