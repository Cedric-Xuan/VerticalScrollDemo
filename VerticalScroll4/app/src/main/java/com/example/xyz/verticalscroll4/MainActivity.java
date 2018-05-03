package com.example.xyz.verticalscroll4;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.xyz.verticalscroll4.swipe.SwipeLayout;

public class MainActivity extends Activity {

    private RelativeLayout relativeLayout;
    private RelativeLayout floatLayout;
    private ImageView floatImage;
    private ViewGroup.LayoutParams fL;
    private ViewGroup.LayoutParams fI;
    private MyOnSwipeScrollListener myOnSwipeScrollListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        SwipeLayout swipeLayout=(SwipeLayout) findViewById(R.id.SwipeScorll);
        relativeLayout=(RelativeLayout) findViewById(R.id.bottom);
        floatLayout=(RelativeLayout) findViewById(R.id.floatLayout);
        floatImage=(ImageView) findViewById(R.id.floatImage);


        /*获得悬浮布局和图片*/
        fL=floatLayout.getLayoutParams();
        fI=floatImage.getLayoutParams();


        /*滑动监听器*/
        myOnSwipeScrollListener=new MyOnSwipeScrollListener();
        swipeLayout.setOnSwipeScrollListener(myOnSwipeScrollListener);//注册滑动监听器






    }



    class MyOnSwipeScrollListener implements SwipeLayout.OnSwipeScrollListener{//滑动监听器

        @Override
        public void onScroll(SwipeLayout layout, int leftOffset, int topOffset) {

                Log.e("滑动距离",""+topOffset);

            int height=relativeLayout.getHeight();//获得屏幕高度

                /*设置悬浮layout大小*/
            fL.height=topOffset;
            fL.width=RelativeLayout.LayoutParams.MATCH_PARENT;

                /*设置悬浮image大小*/
            fI.height=RelativeLayout.LayoutParams.WRAP_CONTENT;
            fI.width=RelativeLayout.LayoutParams.WRAP_CONTENT;


            floatLayout.setLayoutParams(fL);
            floatImage.setLayoutParams(fI);
        }
    }


}