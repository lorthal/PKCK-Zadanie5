package com.example.klusek.myapplication.Tools;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
/**
 * Created by Klusek on 15.01.2017.
 */

public class Tools {

    static void copy(InputStream in, File dst) throws IOException {

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

    public static void convertToHTML(Context context, String xstlFileName, String xmlFileName) {
        try {
            File fileXslt = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), xstlFileName);

            if (!fileXslt.exists())
                copy(context.getAssets().open(xstlFileName), new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), xstlFileName));


            File fileXml = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), xmlFileName);
            if (!fileXml.exists())
                copy(context.getAssets().open(xmlFileName), new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), xmlFileName));

            TransformerFactory tFactory = TransformerFactory.newInstance();

            Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource(fileXslt));

            File fileXhtml = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), "html-result.html");
            if(fileXhtml.exists())
            {
                fileXhtml.delete();
                transformer.transform(new javax.xml.transform.stream.StreamSource(fileXml),
                        new javax.xml.transform.stream.StreamResult((new FileOutputStream(fileXhtml))));
            }

            if (!fileXhtml.exists()) {
                transformer.transform(new javax.xml.transform.stream.StreamSource(fileXml),
                        new javax.xml.transform.stream.StreamResult((new FileOutputStream(fileXhtml))));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
