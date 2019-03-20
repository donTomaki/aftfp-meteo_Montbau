package com.aftfp.tools;

import android.content.Context;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.Toast;


public class Cronometro {
    private final Chronometer _crono;
    private String CRON_FORMAT = "HH:MM:SS";
    private final Context _context;
    public boolean Stopped = true;
    private long lastPause;
    private boolean resume;

    public Cronometro(Context context, Chronometer crono) {
        _crono = crono;
        _crono.setBase(SystemClock.elapsedRealtime());
        _context = context;
        lastPause = SystemClock.elapsedRealtime();
        _crono.stop();
        resume = true;
        //Format();
    }

    public void Stop() {
        lastPause = SystemClock.elapsedRealtime();
        _crono.stop();
        resume = true;
    }

    public void Reset() {
        _crono.setBase(SystemClock.elapsedRealtime());
        _crono.start();
        lastPause = SystemClock.elapsedRealtime();
        _crono.stop();
        resume = true;
    }

    public void Start() {
        String INIT_CRON = "Inicio Cronómetro";
        Toast.makeText(_context,
                INIT_CRON, Toast.LENGTH_SHORT).show();
        if (resume) {
            _crono.setBase(_crono.getBase() + SystemClock.elapsedRealtime() - lastPause);
        }
        _crono.start();
    }

    public void SetNewFormat(String newFormat) {
        this.CRON_FORMAT = newFormat;
        this.Format();
    }

    private void Format() {
        _crono.setFormat(CRON_FORMAT);
    }

}

