package com.firer.changebackgroundcolor.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

import com.firer.changebackgroundcolor.sample.R;

public class BgColorGradualLayout extends RelativeLayout {

    private int baseColor;
    private int targetColor;

    private Handler canvasHandler;
    private Paint paint;
    private int animationDuration = 500;
    private int animationStage = 0;
    private boolean animationRunning = false;
    private int frameRate = 10;

    public BgColorGradualLayout(Context context) {
        super(context);
        init();
    }

    public BgColorGradualLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        canvasHandler = new Handler();

        baseColor = getResources().getColor(R.color.start_color);
        targetColor = getResources().getColor(R.color.end_color);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
    }


    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    public void changeColor() {
        if( !animationRunning ) {
            ColorDrawable dr = (ColorDrawable)getBackground();
            int color = dr.getColor();
            if( color == baseColor || color == targetColor ){
                animationRunning = true;
                animationStage = 0;
                invalidate();
            } else {
                //正在疯狂点击
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (animationRunning) {
            if (animationStage > animationDuration) {
                animationRunning = false;
                int temp = baseColor;
                baseColor = targetColor;
                targetColor = temp;
                return;
            }
            setBackgroundColor(ColorUtils.getGradualColor(baseColor, targetColor, animationStage, animationDuration));
            animationStage += 10;
            canvasHandler.postDelayed(runnable, frameRate);
        }
    }


    public void setCurrentState(int baseColor,int targetColor){
        this.baseColor = baseColor;
        this.targetColor = targetColor;
        setBackgroundColor(baseColor);

    }

    public int getCurrentState(){
        return baseColor;
    }
}
