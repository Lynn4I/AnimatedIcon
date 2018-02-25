package com.lynn.cc.animatedicon.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lynn.cc.animatedicon.R;
import com.lynn.cc.animatedicon.utils.UIUtils;

/**
 *
 * Created by Lynn on 2018/2/24.
 */

public class ShortCutView extends LinearLayout {

    public ShortCutView(Context context) {
        super(context);
        init();
    }

    public ShortCutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShortCutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.shortcut, this, true);
    }

    public void anim(Animator.AnimatorListener listener){
        final View view  = findViewById(R.id.line);
        UIUtils.measureView(this);
        final int width = getMeasuredWidth();
        final ViewGroup.LayoutParams params = view.getLayoutParams();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                params.width = (int) (width * animation.getAnimatedFraction());
                view.setLayoutParams(params);
            }
        });
        valueAnimator.addListener(listener);
        valueAnimator.setDuration(2000);
        valueAnimator.start();
    }
}
