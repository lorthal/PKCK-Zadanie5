package com.example.klusek.myapplication.Tools;

import android.content.Context;
import android.os.Environment;

import com.example.klusek.myapplication.Mapping.Gry;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

/**
 * Created by Klusek on 15.01.2017.
 */

public class XMLManager {

    public static Gry readXML(Context context, String fileName) {
        try {
            Serializer serializer = new Persister();

            File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), fileName);

            if(!file.exists()) {
                Tools.copy(context.getAssets().open(fileName), file);
            }

            Gry gry = serializer.read(Gry.class, file);
            return  gry;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveXML(Gry gry, String fileName){
        try {
            Serializer serializer = new Persister();

            File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), fileName);
            serializer.write(gry,file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
