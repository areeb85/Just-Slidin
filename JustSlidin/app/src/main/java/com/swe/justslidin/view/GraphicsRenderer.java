package com.swe.justslidin.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

import androidx.annotation.NonNull;

import com.swe.justslidin.R;
import com.swe.justslidin.models.Background;
import com.swe.justslidin.models.Barrier;
import com.swe.justslidin.models.Character;
import com.swe.justslidin.models.Coin;
import com.swe.justslidin.models.Elements;
import com.swe.justslidin.models.HitBox;
import com.swe.justslidin.models.Position;
import com.swe.justslidin.models.Universe;


public class GraphicsRenderer implements SurfaceHolder.Callback, Universe.Callback {

    private static final String TAG = "GraphicsRenderer";
    private final Universe universe;
    private SurfaceHolder holder;
    private Bitmap coinBitmap;
    private Bitmap shortBarrierBitmap;
    private Bitmap longBarrierBitmap;
    private Bitmap bgBitmap;
    private Bitmap scaledBG;
//    private Background background;

    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;


    public GraphicsRenderer(Universe u, Resources context) {
        this.universe = u;
        this.universe.setCallBack(this);
        this.coinBitmap = BitmapFactory.decodeResource(context, R.mipmap.coin);
        this.longBarrierBitmap = BitmapFactory.decodeResource(context, R.mipmap.long_barrier);
        this.shortBarrierBitmap = BitmapFactory.decodeResource(context, R.mipmap.short_barrier);

        this.bgBitmap = BitmapFactory.decodeResource(context, R.mipmap.background);
        this.scaledBG = Bitmap.createScaledBitmap(this.bgBitmap, screenWidth, screenHeight, true);
        this.universe.setBackgroundBitmap(scaledBG);
//        this.background = new Background(scaledBG);
    }


    public void drawSurfaceView () {
        if (universe != null && holder != null) {
            Canvas canvas = holder.lockCanvas();
            this.draw(canvas);
            holder.unlockCanvasAndPost(canvas);
        }
    }


    private void draw(Canvas canvas) {

        canvas.drawARGB(255, 255, 255, 255);
        Paint ballPaint = new Paint();
        ballPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        ballPaint.setStrokeWidth(10);
        ballPaint.setARGB(135, 0, 0, 0);

        this.universe.getBackground().draw(canvas);

        for (Elements elem : universe.getElements()) {

            if (elem instanceof Coin) {
                Coin c = (Coin) elem;
                Position p = c.getPosition();
                float r = c.getRad();
                HitBox hb = c.getHitBox();
                Bitmap scaledCoin = Bitmap.createScaledBitmap(this.coinBitmap,
                        (int)r*2, (int)r*2, true);
                canvas.drawBitmap(scaledCoin, hb.getLeft(), hb.getTop(), null);

            } else if (elem instanceof Barrier) {

                Barrier b = (Barrier)elem;
                Position p = b.getPosition();
                HitBox hb = b.getHitBox();
                canvas.drawRect(hb.getLeft(), hb.getTop(), hb.getRight(), hb.getBottom(), ballPaint);
            }
        }
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        Log.i(TAG, "SurfaceCreated!");
        this.holder = surfaceHolder;
        this.drawSurfaceView();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        drawSurfaceView();
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        this.holder = null;
    }

    @Override
    public void universeChanged(Universe u) {
        drawSurfaceView();
    }


}
