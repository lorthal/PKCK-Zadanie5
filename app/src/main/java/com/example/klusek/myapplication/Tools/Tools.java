package com.example.klusek.myapplication.Tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

import com.example.klusek.myapplication.Mapping.Gry;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Klusek on 15.01.2017.
 */

public class Tools {

    private static void copy(InputStream in, File dst) throws IOException {

        File dest = dst;

        dest.createNewFile();
        OutputStream out = new FileOutputStream(dest);

        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    public static Gry readXML(Context context, String fileName) {
        try {
            Serializer serializer = new Persister();

            File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), fileName);

            if(!file.exists()) {
                copy(context.getAssets().open(fileName), new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), fileName));
            }


            Gry gry = serializer.read(Gry.class, file);
            return  gry;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void openPdf(Context context, String fileName)
    {
        try {
            copy(context.getAssets().open(fileName), new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), fileName));
            File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), fileName);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
            context.startActivity(intent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
