package com.superhardcode.test.horizontalscroll;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private HorizontalScrollView horizontal_scroll_view;
    private ImageView icon_left;
    private ImageView icon_right;

    private Display display;
    private int mWidth = 0;
    private int viewWidth = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        display = getWindowManager().getDefaultDisplay();
        mWidth = display.getWidth(); // deprecated
        viewWidth = mWidth / 4;

        horizontal_scroll_view = (HorizontalScrollView) findViewById(R.id.horizontal_scroll_view);
        horizontal_scroll_view.setSmoothScrollingEnabled(true);
        icon_left = (ImageView) findViewById(R.id.icon_left);
        icon_right = (ImageView) findViewById(R.id.icon_right);

        icon_left.setOnClickListener(this);
        icon_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.icon_left:

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        horizontal_scroll_view.smoothScrollTo(
                                (int) horizontal_scroll_view.getScrollX()
                                        - viewWidth,
                                (int) horizontal_scroll_view.getScrollY());
                    }
                }, 100L);
                break;
            case R.id.icon_right:

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        horizontal_scroll_view.smoothScrollTo(
                                (int) horizontal_scroll_view.getScrollX()
                                        + viewWidth,
                                (int) horizontal_scroll_view.getScrollY());
                    }
                }, 100L);
                break;
            default:
                break;
        }
    }
}
