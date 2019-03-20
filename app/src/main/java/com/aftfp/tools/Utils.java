package com.aftfp.tools;


import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Utils {
    public static void Tostar(CharSequence mensaje, Context context) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

    public static class log {

        public static void e(Object object, Exception ex) {
            Log.e(object.getClass().getSimpleName(), ex.getMessage());
        }

        public static void i(Object object, String msg) {
            Log.i(object.getClass().getSimpleName(), msg);
        }

        public static void d(Object object, String msg) {
            Log.i(object.getClass().getSimpleName(), msg);
        }

    }



    public static class Geo{
        public static String Street(Context c, double lat, double lon, int maxResults)
        {
            Geocoder geocoder = new Geocoder(c);
            List<Address> addresses;
            try {
                addresses = geocoder.getFromLocation(lat, lon, maxResults);
            } catch (IOException ioException) {
                Log.e("ChangeLocation", "Error al coger dirección");
                return "No address found";
            }

            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                // Thoroughfare seems to be the street name without numbers
                String street = address.getThoroughfare();
                return street;
            }
            else {
                return "No address found";
            }
        }
    }


    public static class Time {
        public static String NowToString(String _pattern) {
            String pattern = _pattern.length() > 0 ? _pattern : "dd/MM/yyyy HH:mm:ss";
            DateFormat df = new SimpleDateFormat(pattern);
            return df.format(Calendar.getInstance().getTime());
        }

        public static Date Now() {
            return Calendar.getInstance().getTime();
        }
    }

    public static class Double {
        public static String toString(double number, int decimals) {
            return String.format(Locale.getDefault(), "%." + decimals + "f", number);
        }
    }

}
