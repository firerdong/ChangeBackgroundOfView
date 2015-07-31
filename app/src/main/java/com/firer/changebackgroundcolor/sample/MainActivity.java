package com.firer.changebackgroundcolor.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.firer.changebackgroundcolor.lib.BgColorGradualLayout;

public class MainActivity extends Activity {
    private boolean state = true;
    private BgColorGradualLayout layout;
    private int startColor;
    private int endColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (BgColorGradualLayout)findViewById(R.id.layout);
        startColor = getResources().getColor(R.color.start_color);
        endColor = getResources().getColor(R.color.end_color);
    }

    public void click_change_color(View v){
        if( state ){
            layout.changeColor(startColor,endColor);
            state = false;
        } else {
            layout.changeColor(endColor,startColor);
            state = true;
        }
    }

}
