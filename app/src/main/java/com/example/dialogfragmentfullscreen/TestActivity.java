package com.example.dialogfragmentfullscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        int uiOptions =
                View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                |View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        int uiOptions2 =
//                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                |WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions2);
    }
}
