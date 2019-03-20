package com.aftfp.meteomontbau;

import com.aftfp.tools.GetFileFromUrl;
import com.aftfp.tools.Utils;

import org.json.JSONObject;

public class DataModel {
    private String URL_DATA = "http://www.montbaumeteo.com/dades/customclientraw.txt";
    private JSONObject JsonData;
    public String temp;
    public String tempMax;
    public String tempMin;
    public String tempTend;
    public String humedad;
    public String humedadMin;
    public String humedadMax;
    public String viento_velocidad;
    public String viento_velocidad_avg;
    public String viento_velocidad_max_avg;
    public String viento_velocidad_rafaga_max_avg;
    public String viento_velocidad_rafaga_max;
    public String viento_component;
    public String lluvia;
    public String lluvia_last;
    public String lastSyncro;

    protected void SetData(){
        temp = this.getJsonData("temp") + " " + this.getJsonData("tempunit");
        tempMax = "Màxima: " + this.getJsonData("tempTH") + "º a les " + this.getJsonData("TtempTH");
        tempMin = "Mínima: " + this.getJsonData("tempTL") + "º a les " + this.getJsonData("TtempTL");
        tempTend = "Tendència: " + this.getJsonData("temptrend") + "Cº/h";
        humedad = this.getJsonData("hum") + " %";
        humedadMin = this.getJsonData("humTL") + " % a les " + this.getJsonData("ThumTL");
        humedadMax = this.getJsonData("humTH") + " % a les " + this.getJsonData("ThumTH");
        viento_velocidad = this.getJsonData("wlatest") + " " + this.getJsonData("windunit");
        viento_velocidad_avg = "Avg.10': " + this.getJsonData("wspeed") + " " + this.getJsonData("windunit");
        viento_velocidad_max_avg = "Max.Avg.10': " + this.getJsonData("windTM") + " " + this.getJsonData("windunit");
        viento_velocidad_rafaga_max_avg = "R.Max.10': " + this.getJsonData("wgust") + " " + this.getJsonData("windunit");
        viento_velocidad_rafaga_max = "R.Max.: " + this.getJsonData("wgustTM") + " " + this.getJsonData("windunit") + " a les " + this.getJsonData("TwgustTM");
        viento_component = "Direcció: " + this.getJsonData("bearingTM") + "º";
        lluvia = this.getJsonData("hourlyrainTH") + " " + this.getJsonData("rainunit");
        lluvia_last = "Últim dia " + this.getJsonData("LastRainTipISO");

        lastSyncro = this.getJsonData("date");
    }

    public DataModel(){
        this.fillData();
    }

    public void fillData(){
        try{
            //Paja mental: Recogo los datos desde la URL en formato string y lo parseo a JSON
            this.JsonData = new JSONObject(new GetFileFromUrl().execute(URL_DATA).get());
            this.SetData();
        }
        catch (Exception ex)
        {
            Utils.log.e(this,ex);
        }

    }

    protected String getJsonData(String key)
    {
        try{
            return this.JsonData.getString(key);
        }
        catch (Exception ex)
        {
            Utils.log.e(this,ex);
            return "Error";
        }
    }

}
