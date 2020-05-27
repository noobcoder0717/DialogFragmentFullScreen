package com.example.dialogfragmentfullscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    Button btn_showfragment;
    Button btn_switchActivity;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this.getApplicationContext();


        btn_showfragment = findViewById(R.id.btn_show_fragment);
        btn_showfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseLandscapeDialogFragment fragment = new CustomizedDialogFragment(R.layout.dialog_fragment_layout,R.style.AnimLandscapeDialogFragment);
                fragment.show(getSupportFragmentManager(),"");
            }
        });

        btn_switchActivity = findViewById(R.id.btn_switch_activity);
        btn_switchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PortraitActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart(){
        Log.i(TAG,"onStart");
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //隐藏导航栏
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;//
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);
        super.onStart();
    }

    @Override
    protected void onResume(){
        Log.i(TAG,"onResume");
        super.onResume();
    }
}
