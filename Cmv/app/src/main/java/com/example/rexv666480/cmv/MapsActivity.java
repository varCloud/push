package com.example.rexv666480.cmv;

import android.Manifest;
import android.app.assist.AssistContent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double latitude;
    private double longitdue;
   CordenadasSucursales cordenadasSucursales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
/*        Intent intent = getIntent();*/

        Bundle b = getIntent().getExtras();
/*        latitude =Double.parseDouble(intent.getStringExtra("Latitude"));
        longitdue=Double.parseDouble(intent.getStringExtra("Longitude"));*/
        latitude = b.getDouble("Latitude");
        longitdue = b.getDouble("Longitude");
        cordenadasSucursales = new CordenadasSucursales();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        ArrayList<CordenadasSucursales> lstSucursales = this.cordenadasSucursales.ObtenerSucursales();
        mMap = googleMap;
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);

        for(int i =0 ; i< lstSucursales.size(); i++)
        {

            LatLng coorSucursal = new LatLng( lstSucursales.get(i).getLati(), lstSucursales.get(i).getLongi());
            mMap.addMarker(new MarkerOptions()
                    .position(coorSucursal)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker25))
                    .title(lstSucursales.get(i).getDescripcion()));
        }

        LatLng morelia = new LatLng(latitude, longitdue);
        mMap.addMarker(
                new MarkerOptions()
                        .position(morelia)
                        .title("Usted está Aquí")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.men))


        );
        mMap.moveCamera(CameraUpdateFactory.newLatLng(morelia));
    }
}
