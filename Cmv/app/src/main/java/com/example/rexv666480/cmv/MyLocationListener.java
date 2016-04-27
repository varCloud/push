package com.example.rexv666480.cmv;

import android.app.AlertDialog;
import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Service;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;

import java.security.Provider;
import java.util.List;
import java.util.Map;

/**
 * Created by rexv666480 on 20/01/2016.
 */
public class MyLocationListener extends Service implements LocationListener {
    private final Context  context;
    double latitude;
    double longitude;
    Location location; // location
    private LocationManager locationManager;
    private boolean gpsHabilitado;
    private boolean wifiActivado;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;

    public MyLocationListener(Context context) {

        this.context = context;
        obtenerUbicacion();
    }



    @Override

    public void onLocationChanged(Location location) {

        location.getLatitude();
        location.getLongitude();
        latitude = location.getLatitude();
        longitude = location.getLongitude();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public double getLatitude() {
        if(location != null){
            latitude = location.getLatitude();
        }
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        if(location != null){
            longitude = location.getLongitude();
        }
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Location obtenerUbicacion() {

        if (Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && context.checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }

        locationManager = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);

        try {
            gpsHabilitado = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
        }

        try {
            wifiActivado = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }

        if (!gpsHabilitado && !wifiActivado) {
            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Error");
            alert.setMessage("No se puede localizar tu ubicacion porfavo encienda el GPS");
            alert.setPositiveButton("Activar GPS", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent myIntent = new Intent(
                            Settings.ACTION_SECURITY_SETTINGS);
                    startActivity(myIntent);
                    dialog.cancel();

                }
            });
            alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            alert.create().show();
        }
        if (gpsHabilitado) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
            if (locationManager != null) {
                location = locationManager.getLastKnownLocation(android.location.LocationManager.GPS_PROVIDER);
                if (location != null) {
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                }
                else{
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    if (location != null) {
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                    }
                }
            }
        }
        return location;

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}