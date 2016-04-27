package servicios.google;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

/**
 * Created by rexv666480 on 27/04/2016.
 */
public class TareaRegistroGCM extends AsyncTask<String,Integer,String> {

    private Context context;
    private GoogleCloudMessaging gcm;
    private String regid;

    public TareaRegistroGCM(Context context, GoogleCloudMessaging gcm, String regid) {
        this.context = context;
        this.gcm = gcm;
        this.regid = regid;
    }

    @Override
    protected String doInBackground(String... params) {
        String msg = "";
        try
        {
            if (gcm == null)
            {
                gcm = GoogleCloudMessaging.getInstance(context);
            }

            //Nos registramos en los servidores de GCM
            regid = gcm.register("185663083013");

            Log.d("error en ", "Registrado en GCM: registration_id=" + regid);

            //Nos registramos en nuestro servidor
            //boolean registrado = registroServidor(params[0], regid);

            //Guardamos los datos del registro
           // if(registrado)
           // {
           //     setRegistrationId(context, params[0], regid);
           // }
        }
        catch (IOException ex)
        {
            Log.d("error en ", "Error registro en GCM:" + ex.getMessage());
        }
        return msg;

    }
}
