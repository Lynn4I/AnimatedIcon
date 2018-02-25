package com.lynn.cc.animatedicon.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;

/**
 * Created by lynn on 2018/2/24.
 */

public class ShortcutUtils {


    public static void showShortcut(Context context, String name, int iconId, Intent intent, boolean isDuplicate) {
        Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        shortcut.putExtra("duplicate", isDuplicate);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON, BitmapFactory.decodeResource(context.getResources(), iconId));
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(context, iconId));
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
        context.sendBroadcast(shortcut);
    }

    public static void deleteShortcut(Context context, String name, Intent intent, boolean isDuplicate) {
        Intent shortcut = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
        shortcut.putExtra("duplicate", isDuplicate);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
        context.sendBroadcast(shortcut);
    }

}
