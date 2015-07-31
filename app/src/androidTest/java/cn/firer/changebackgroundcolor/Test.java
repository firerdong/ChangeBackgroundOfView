package cn.firer.changebackgroundcolor;

import android.test.AndroidTestCase;

import com.firer.changebackgroundcolor.lib.ColorUtils;

import junit.framework.Assert;

public class Test extends AndroidTestCase {
    public void test(){
        int max = 10;
        int i=5;

        int startColor = 0x00000000;
        int endColor = 0xff000000;
        int temp = ColorUtils.getGradualColor(startColor, endColor, i, max);
        Assert.assertEquals(0x7f000000, temp);

        startColor = 0xff000000;
        endColor = 0x00ffffff;
        temp = ColorUtils.getGradualColor(startColor,endColor,i,max);
        Assert.assertEquals(0x807f7f7f, temp);

        startColor = 0x00000000;
        endColor = 0xffffffff;
        temp = ColorUtils.getGradualColor(startColor,endColor,i,max);
        Assert.assertEquals(0x7f7f7f7f, temp);
    }
}
