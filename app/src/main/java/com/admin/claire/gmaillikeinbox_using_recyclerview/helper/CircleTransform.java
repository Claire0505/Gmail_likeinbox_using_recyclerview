package com.admin.claire.gmaillikeinbox_using_recyclerview.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by claire on 2017/9/19.
 * 這個類用Glide顯示圓形的縮略圖
 */

public class CircleTransform extends BitmapTransformation{


    public CircleTransform(Context context) {
        super(context);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return circleCrop(pool, toTransform);
    }

    //BitmapPool接口就是用來重用Bitmap對象的
    private static Bitmap circleCrop(BitmapPool pool, Bitmap source){
        if (source == null)return null;

        int size = Math.min(source.getWidth(), source.getHeight());
        int x = (source.getWidth() - size)/2;
        int y = (source.getHeight() - size)/2;

        // TODO this could be acquired from the pool too
        Bitmap squared = Bitmap.createBitmap(source,x,y,size,size);

        /**
         *
         * Bitmap.Config ALPHA_8
         * Bitmap.Config ARGB_4444
         * Bitmap.Config ARGB_8888
         * Bitmap.Config RGB_565
         * A R G B
         * 透明度 红色 绿色 蓝色
         * Bitmap.Config ARGB_4444 每個pixel 佔四位
         * Bitmap.Config ARGB_8888 32 每個pixel 佔八位
         * Bitmap.Config RGB_565 16 R佔5位 G佔6位 B占5位 没有透明度(A)
         * 解析度越高圖檔就越大
         *
         */

        Bitmap result = pool.get(size,size, Bitmap.Config.ARGB_8888);
        if (result == null){
            result = Bitmap.createBitmap(size,size, Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float r = size / 2f;
        canvas.drawCircle(r,r,r,paint);
        return result;
    }

    @Override
    public String getId() {
        return getClass().getName();
    }
}
