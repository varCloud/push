package com.example.rexv666480.cmv;

import android.Manifest;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import servicios.google.TareaRegistroGCM;

@SuppressWarnings("deprecation")
public class PrincipalActivity extends AppCompatActivity   {

    Intent intent;
    private boolean gpsHabilitado;
    private boolean wifiActivado;
    LocationManager locManager = null;
    MyLocationListener mlocListener;
    private static String DB_PATH = "/data/data/com.example.rexv666480.cmv/databases/";
    private static String DB_NAME = "ventas";
    private CordenadasSucursales lstSucursales;
    private Context context;
    private static final String PROPERTY_REG_ID = "registration_id";
    private static final String PROPERTY_APP_VERSION = "appVersion";
    private static final String PROPERTY_EXPIRATION_TIME = "onServerExpirationTimeMs";
    private static final String PROPERTY_USER = "user";
    private GoogleCloudMessaging gcm;
    private String regid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lstSucursales = new CordenadasSucursales();
        final ImageAdapter imageAdapter = new ImageAdapter(this);
        Gallery galleryTipoPtmo = (Gallery) findViewById(R.id.galleryTipoPtmo);
        galleryTipoPtmo.setAdapter(imageAdapter);
        galleryTipoPtmo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtProductoSeleccionado = (TextView) findViewById(R.id.txtProducto);
                TiposPtmo PtmoActual = (TiposPtmo) imageAdapter.lstTiposPTMO.get(position);
                txtProductoSeleccionado.setText("Producto Seleccionado :" + PtmoActual.getDescPrestamo());
            }
        });
         Button btnAceptar  = (Button) findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    context = getApplicationContext();

                    //Chequemos si está instalado Google Play Services
                    if(checkPlayServices())
                    {
                    gcm = GoogleCloudMessaging.getInstance(PrincipalActivity.this);

                    //Obtenemos el Registration ID guardado
                    regid = getRegistrationId(context);

                    //Si no disponemos de Registration ID comenzamos el registro
                    if (regid.equals("")) {
                        TareaRegistroGCM tarea = new TareaRegistroGCM(context,gcm,"victor");
                        tarea.execute("victor");
                    }
                    }
                    else
                    {
                        Log.i("error", "No se ha encontrado Google Play Services.");
                    }
                    //ObtenerMiCordenada();
                    //ObtenerSucursalCercana();
                }catch(Exception ex)
                {
                    Log.i("error",ex.getMessage());
                }
            }
        });

        intent = new Intent(this, MapsActivity.class);
      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                ObtenerMiCordenada();
                Bundle b = new Bundle();
                b.putDouble("Latitude", mlocListener.latitude); //Your id
                b.putDouble("Longitude", mlocListener.longitude); //Your id
                intent.putExtras(b);
                //intent.putExtra("Latitude", MyLocationListener.latitude);
                //intent.putExtra("Longitude", MyLocationListener.longitude);//*
                startActivity(intent);

        }
        });

    }

    public void  ObtenerMiCordenada()
    {
        try{
                mlocListener = new MyLocationListener(PrincipalActivity.this);
        }catch(Exception ex) {
            Log.i("error", ex.getMessage());
        }
    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS)
        {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode))
            {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this, 1).show();
            }
            else
            {
                Log.d("error en ","Dispositivo no soportado.");
                finish();
            }
            return false;
        }
        return true;
    }

    public void ObtenerSucursalCercana()
    {
        ArrayList<CordenadasSucursales>lstSuc = lstSucursales.ObtenerSucursales();
        ArrayList<Float> indices = new ArrayList<Float>();
        Location miposicion = new Location("mi posicion");
        miposicion.setLatitude(mlocListener.latitude);
        miposicion.setLongitude(mlocListener.longitude);
        try {
            ObtenerMiCordenada();
            for (int i = 0; i <lstSuc.size(); i++) {
                 Location l = new Location("posicion"+i);
                 l.setLatitude(lstSuc.get(i).getLati());
                 l.setLongitude(lstSuc.get(i).getLongi());
                 lstSuc.get(i).setDiferenciaPuntoAcutal(miposicion.distanceTo(l));

            }
            Collections.sort(lstSuc);
            Mensaje(lstSuc.get(0).getDescripcion()+" , "+lstSuc.get(1).getDescripcion()+" , "+lstSuc.get(2).getDescripcion());

        }catch (Exception ex)
        {
            Log.i("error", ex.getMessage());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void Mensaje(String mensaje)
    {
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        mensaje, Toast.LENGTH_SHORT);

        toast1.show();
    }

    private String getRegistrationId(Context context)
    {
        SharedPreferences prefs = getSharedPreferences(
                PrincipalActivity.class.getSimpleName(),
                Context.MODE_PRIVATE);

        String registrationId = prefs.getString(PROPERTY_REG_ID, "");

        if (registrationId.length() == 0)
        {
            Log.d("error en ", "Registro GCM no encontrado.");
            return "";
        }

        String registeredUser =
                prefs.getString(PROPERTY_USER, "user");

        int registeredVersion =
                prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);

        long expirationTime =
                prefs.getLong(PROPERTY_EXPIRATION_TIME, -1);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        String expirationDate = sdf.format(new Date(expirationTime));

        Log.d("error en ", "Registro GCM encontrado (usuario=" + registeredUser +
                ", version=" + registeredVersion +
                ", expira=" + expirationDate + ")");

        int currentVersion = getAppVersion(context);

        if (registeredVersion != currentVersion)
        {
            Log.d("error en ", "Nueva versión de la aplicación.");
            return "";
        }
        else if (System.currentTimeMillis() > expirationTime)
        {
            Log.d("error en", "Registro GCM expirado.");
            return "";
        }
/*        else if (!txtUsuario.getText().toString().equals(registeredUser))
        {
            Log.d("error en ", "Nuevo nombre de usuario.");
            return "";
        }*/

        return registrationId;
    }

    private static int getAppVersion(Context context)
    {
        PackageInfo packageInfo = null;
        try
        {
             packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);


        }
        catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }

        return packageInfo.versionCode;
    }
}
