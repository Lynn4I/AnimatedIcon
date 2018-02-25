package com.lynn.cc.animatedicon.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.lynn.cc.animatedicon.R;
import com.lynn.cc.animatedicon.utils.UIUtils;
import com.lynn.cc.animatedicon.widget.ShortCutView;

/**
 * Created by lynn on 2018/2/24.
 */

public class AnimatedIconActivity extends Activity {

    private ShortCutView mShortcutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0,0);
        setContentView(R.layout.activity_shortcut);
        mShortcutView = findViewById(R.id.shortcut);

        //获取快捷方式位置
        Rect rect = getIntent().getSourceBounds();
        resetPosition(mShortcutView, rect);

        mShortcutView.anim(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent intent = new Intent(AnimatedIconActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, 0);
                finish();
            }
        });
    }

    private void resetPosition(View view, Rect rect) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        params.topMargin = rect.top - UIUtils.getStatusBarHeight(this);
        params.leftMargin = rect.left;
        params.height = rect.bottom - rect.top;
        params.width = rect.right - rect.left;
        view.setLayoutParams(params);
    }
}
