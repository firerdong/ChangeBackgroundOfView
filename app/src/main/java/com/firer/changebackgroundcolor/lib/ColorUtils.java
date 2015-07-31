package com.firer.changebackgroundcolor.lib;

import android.graphics.Color;

public class ColorUtils {
    public static int getGradualColor(int startColor, int endColor,int div,int total){
        if( total <= 1 || div > total || div==0) {
            return startColor;
        }

        int alpha = cal( Color.alpha(startColor), Color.alpha(endColor),div,total );
        int red = cal(Color.red(startColor), Color.red(endColor), div, total);
        int green = cal(Color.green(startColor), Color.green(endColor), div, total);
        int blue = cal(Color.blue(startColor), Color.blue(endColor), div, total);
        return Color.argb(alpha, red, green, blue);
    }

    private static int cal(int startColor, int endColor, int div,int total){
        if( total == 0 || div > total ){
            return startColor;
        }
        return startColor + (endColor - startColor)*div/total;
    }
}
