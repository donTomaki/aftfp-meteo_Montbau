package com.aftfp.meteomontbau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.aftfp.tools.GetFileFromUrl;
import com.aftfp.tools.Utils;

import org.json.JSONObject;


public class CurrentWeatherActivity extends AppCompatActivity {
    private TextView textTemp;
    private TextView textTempMax;
    private TextView textTempMin;

    private TextView textHumedad;
    private TextView textHumedadMax;
    private TextView textHumedadMin;

    private TextView textVientoVel;
    private TextView textVientoAvg;
    private TextView textVientoAvgMax;
    private TextView textVientoRafagaAvg;
    private TextView textVientoRafagaMax;
    private TextView textVientoComponente;

    private TextView textLluvia;
    private TextView textLluviaLast;
    private TextView textLastSyncro;
    private ImageButton btnRefresh;

    public static final int progress_bar_type = 0;

    private DataModel myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_weather_activity);
        this.setLayout();
        this.setBehaviour();
        this.myData = new DataModel();
        setData();
    }



    protected void setLayout(){
        textTemp = (TextView) findViewById(R.id.text_temperatura);
        textTempMax = (TextView) findViewById(R.id.txt_temp_max);
        textTempMin = (TextView) findViewById(R.id.txt_temp_min);

        textHumedad = (TextView) findViewById(R.id.text_humedad);
        textHumedadMax = (TextView) findViewById(R.id.txt_humedad_max);
        textHumedadMin = (TextView) findViewById(R.id.txt_humedad_min);

        textVientoVel = (TextView) findViewById(R.id.text_viento_velocidad);
        textVientoAvg = (TextView) findViewById(R.id.txt_viento_avg_10);
        textVientoAvgMax = (TextView) findViewById(R.id.txt_viento_max_avg_10);
        textVientoComponente = (TextView) findViewById(R.id.txt_viento_componente);
        textVientoRafagaAvg = (TextView) findViewById(R.id.txt_viento_max_rafaga_avg_10);
        textVientoRafagaMax = (TextView) findViewById(R.id.txt_viento_max_rafaga_10);

        textLluvia = (TextView) findViewById(R.id.text_llvuia);
        textLluviaLast= (TextView) findViewById(R.id.txt_lluvia_last);

        textLastSyncro = (TextView) findViewById(R.id.text_lastSyncro);

        btnRefresh =(ImageButton) findViewById(R.id.btn_refresh);
    }

    protected void setBehaviour(){
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myData.fillData();
                setData();
            }
        });
    }



    protected void setData(){
        try{
            textTemp.setText(myData.temp);
            textTempMax.setText(myData.tempMax);
            textTempMin.setText(myData.tempMin);

            textHumedad.setText(myData.humedad);
            textHumedadMin.setText(myData.humedadMin);
            textHumedadMax.setText(myData.humedadMax);

            textVientoVel.setText(myData.viento_velocidad);
            textVientoAvg.setText(myData.viento_velocidad_avg);
            textVientoAvgMax.setText(myData.viento_velocidad_max_avg);
            textVientoRafagaAvg.setText(myData.viento_velocidad_rafaga_max_avg);
            textVientoRafagaMax.setText(myData.viento_velocidad_rafaga_max);
            textVientoComponente.setText(myData.viento_component);

            textLluvia.setText(myData.lluvia);
            textLluviaLast.setText(myData.lluvia_last);
            textLastSyncro.setText(myData.lastSyncro);


        }
        catch (Exception ex)
        {
            Utils.log.e(this,ex);
        }
    }


}
