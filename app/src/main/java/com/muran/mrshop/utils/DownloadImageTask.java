package com.muran.mrshop.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import net.qiujuer.genius.blur.StackBlur;

import java.io.File;
import java.io.IOException;

/**
 * Created by muran001 on 16/10/24.
 */

public class DownloadImageTask extends AsyncTask<String, Void, Drawable> {

    private static final String TAG = "My";

    protected Drawable doInBackground(String... urls) {
        return GlideImageLoader.loadImageFromNetwork(urls[0]);
    }

    protected void onPostExecute(Drawable result) {
        BitmapDrawable bd = (BitmapDrawable) result;
        Bitmap bitmap = bd.getBitmap();
        Bitmap  blurred;
        File f = new File("./sdcard/DCIM/Camera/mrshop/avarter.png");
        if (f.exists()){
            f.delete();
        }
        blurred = StackBlur.blur(bitmap, 90, false);
        try {
            BitmapUtil.saveMyBitmap(blurred,"avarter");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

