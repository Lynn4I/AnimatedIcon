package com.lynn.cc.animatedicon.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lynn.cc.animatedicon.R;
import com.lynn.cc.animatedicon.utils.ShortcutUtils;

public class MainActivity extends Activity {

    private TextView mAddShortCut;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_main);
        mAddShortCut = findViewById(R.id.add_shortcut);

        mAddShortCut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(mContext, AnimatedIconActivity.class);
                ShortcutUtils.showShortcut(mContext, "click me", R.mipmap.ic_launcher, intent, false);
                Toast.makeText(MainActivity.this, "添加成功",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
