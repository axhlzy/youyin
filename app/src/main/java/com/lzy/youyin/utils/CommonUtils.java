package com.lzy.youyin.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.SystemClock;

import androidx.fragment.app.FragmentActivity;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.vondear.rxtool.RxActivityTool;

/**
 * Created by Lzy On 2019/8/19
 * Describe:
 */
public class CommonUtils {

    private static long mBackPressedTime;

    private static final String SD_APP_DIR_NAME = "TestDir"; //存储程序在外部SD卡上的根目录的名字
    private static final String PHOTO_DIR_NAME = "photo";    //存储照片在根目录下的文件夹名字

    public static void doubleClickExitApp() {
        long curTime = SystemClock.uptimeMillis();
        if ((curTime - mBackPressedTime) < (3 * 1000)) {
            RxActivityTool.finishAllActivity();
            //根据进程ID，杀死该进程
            android.os.Process.killProcess(android.os.Process.myPid());
            //退出应用程序
            System.exit(0);
        } else {
            mBackPressedTime = curTime;
            SmartToast.show("再按一次退出");
        }
    }

    public static String getVersionName(Context context){
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String version = packInfo.versionName;
        return version;
    }

    /**
     * 复制内容到剪切板
     *
     * @param context 上下文
     * @param content 需要复制到剪切板的文字
     */
    public static void copyToClipboard(Context context, CharSequence content) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboard != null) {
            clipboard.setPrimaryClip(ClipData.newPlainText(null, content));//参数一：标签，可为空，参数二：要复制到剪贴板的文本
            if (clipboard.hasPrimaryClip()) {
                clipboard.getPrimaryClip().getItemAt(0).getText();
            }
        }
    }
}
