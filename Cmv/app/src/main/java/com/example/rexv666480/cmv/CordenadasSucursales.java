package com.example.rexv666480.cmv;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by rexv666480 on 21/01/2016.
 */
public class CordenadasSucursales implements Comparable<CordenadasSucursales>  {

    private  String descripcion;
    private Double lati;
    private  Double longi;
    private ArrayList<CordenadasSucursales> cordenadasSucursales;
    private Float diferenciaPuntoAcutal;


    public Float getDiferenciaPuntoAcutal() {
        return diferenciaPuntoAcutal;
    }

    public void setDiferenciaPuntoAcutal(Float diferenciaPuntoAcutal) {
        this.diferenciaPuntoAcutal = diferenciaPuntoAcutal;
    }

    public CordenadasSucursales()
    {}
    public CordenadasSucursales(String descripcion, Double lati, Double longi) {
        this.descripcion = descripcion;
        this.lati = lati;
        this.longi = longi;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getLati() {
        return lati;
    }

    public void setLati(Double lati) {
        this.lati = lati;
    }

    public Double getLongi() {
        return longi;
    }

    public void setLongi(Double longi) {
        this.longi = longi;
    }

    public ArrayList<CordenadasSucursales> ObtenerSucursales()
    {
        try{
        if(cordenadasSucursales == null)
        {
            cordenadasSucursales = new ArrayList<CordenadasSucursales>();
            cordenadasSucursales.add(new CordenadasSucursales("SUC.ABASTOS", 20.5713, -100.382938));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.ACAMBARO", 20.03437, -100.722736));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.ACOCOTA", 19.037585, -98.212227));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.AMERICAS", 20.588674, -100.372055));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.CD.HIDALGO", 19.692883, -100.554623));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.CENTRO", 19.749334, -101.203632));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.CORREGIDORA", 20.595932, -100.392732));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.COSMOS", 19.685107, -101.218844));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.LAS TORRES", 21.147753, -101.656383));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.INDEPENDENCIA", 19.695373, -101.190574));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.JEREZ", 21.097713, -101.642605));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.VALLE DEL SOL", 19.811122, -97.362038));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.LA PIEDAD", 19.543304, -99.141047));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.LEON CENTRO", 21.120168, -101.679248));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.MADERO", 19.708138, -101.170302));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.MARAVATIO", 19.891371, -100.44273));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.MERIDA", 21.120561, -101.667662));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.MOROLEON", 20.130544, -101.19121));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.NORTE", 19.709842, -101.189417));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.ORIENTE", 19.697362, -101.158458));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.PATZCUARO", 19.518401, -101.608848));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.PONIENTE", 19.707046, -101.215409));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.QUERENDARO", 19.807401, -100.880954));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.QUIROGA", 19.673766, -101.393499));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.SAHUAYO", 20.058046, -102.719122));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.STA.MARIA", 19.674048, -101.190429));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.SUR",19.668651, -101.19898390000003));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.TACAMBARO", 19.234959, -101.457936));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.TARIMBARO", 19.796004, -101.176153));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.TECNOLOGICO", 20.611275, -100.433632));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.TUXPAN", 19.568162, -100.463195));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.UCAREO", 19.8997, -100.685226));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.URUAPAN CENTRO", 19.417543, -102.063375));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.ZACAPU", 19.818406, -101.792851));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.ZAMORA PLAZA MADERO", 19.98316, -102.288019));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.ZINAPECUARO", 19.860389, -100.829189));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.ZITACUARO", 19.436378, -100.356014));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.TINIJARO", 19.696226, -101.263721));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.TORREON NUEVO", 19.748698, -101.20386));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.SAN JUAN", 19.704546, -101.185433));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.CONTEPEC", 19.955915, -100.164843));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.INDAPARAPEO", 19.792467, -100.967758));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.CUITZEO", 19.969379, -101.142151));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.ARIO DE ROSALES", 19.208102, -101.707812));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.HUETAMO", 19.811537, -101.795767));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.OCAMPO", 19.691197, -101.197013));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.BENITO JUAREZ", 19.691197, -101.197013));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.TEMASCALCINGO", 19.912732, -100.006388));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.TLALPUJAHUA", 19.805565, -100.172564));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.SAN JUAN NUEVO", 19.444992, -99.108265));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.ACUITZIO", 19.4951, -101.333087));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.COENEO", 19.82123, -101.585286));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.LA HUACANA", 18.960159, -101.810508));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.TARETAN", 19.334963, -101.917446));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.PURUARAN", 19.644415, -101.231997));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.SALAMANCA", 20.568986, -101.200264));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.DOLORES HIDALGO", 21.155841, -100.931949));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.SAN MIGUEL DE ALLENDE", 20.924356, -100.7411));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.CORTAZAR", 20.484329, -100.962493));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.ZAMORA VIRREY DE MENDOZA", 19.975846, -102.292175));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.LA BARCA", 20.279413, -102.54847));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.PUEBLA REFORMA", 19.061854, -98.23316));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.URUAPAN FUENTE", 19.419891, -102.050448));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.PIE DE LA CUESTA", 21.141389, -99.509167));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.SATELITE", 20.631363, -100.468956));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.JUNGAPEO", 19.460101, -100.494161));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.APATZINGAN", 19.08788, -102.356152));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.OCOTLAN", 20.337582, -102.765687));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.PURUANDIRO", 20.088136, -101.513713));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.LAGOS DE MORENO", 21.370989, -101.935308));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.CELAYA CENTRO", 20.520143, -100.817722));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.CELAYA IRRIGACION", 20.536848, -100.810316));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.JUVENTINO ROSAS", 20.642746, -100.994832));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.URUAPAN LAS BRISAS", 19.416597, -102.040742));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.LOS REYES", 19.590245, -102.47325));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.VILLA VICTORIA", 19.437673, -99.995416));
            cordenadasSucursales.add(new CordenadasSucursales("SUC.ATLIXCO", 18.901421, -98.437093));

        }
        }catch (Exception ex)
        {
            Log.i("error",ex.getMessage());
        }
        return  cordenadasSucursales;
    }


    @Override
    public int compareTo(CordenadasSucursales o) {
        if (diferenciaPuntoAcutal < o.getDiferenciaPuntoAcutal()) {
            return -1;
        }
        if (diferenciaPuntoAcutal > o.getDiferenciaPuntoAcutal()) {
            return 1;
        }
        return 0;
    }
}
