package com.example.dialogfragmentfullscreen;

import android.view.View;
import android.view.Window;

public final class UIUtil {

    public static void setFullScreen(Window window,boolean showStatusBar,boolean showNavigationBar){
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        if (!showStatusBar) {
            uiOptions |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }
        if (!showNavigationBar) {
            uiOptions |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            uiOptions |= View.SYSTEM_UI_FLAG_IMMERSIVE;
        }

        if(window != null) {
            window.getDecorView().setSystemUiVisibility(uiOptions);
        }
    }


}

