package com.example.dialogfragmentfullscreen;

import android.accessibilityservice.AccessibilityService;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.fragment.app.DialogFragment;

public abstract class BaseLandscapeDialogFragment extends DialogFragment {
    private static final String TAG = "BaseDialogFragment";
    Dialog mDialog;
    int layoutID;
    int styleID;


    public abstract void setAttrs(int layoutID,int styleID);

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE,R.style.CustomizedDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(layoutID,container,false);
        view.setAlpha(1.0f);
        mDialog = getDialog();
        mDialog.getWindow().setWindowAnimations(R.style.AnimLandscapeDialogFragment);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setCanceledOnTouchOutside(true);


        mDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);//不让DialogFragment获得焦点，导航栏不会弹出
        mDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                getDialog().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
            }
        });
        Log.i(TAG,"onCreateView");
        return view;
    }

    @Override
    public void onStart(){
        //以下两行可以调整DialogFragment弹出时，背景是否可见。背景在这里指的是DialogFragment所在的activity
        //dimAmount的范围为0.0f-1.0f，0.0f表示背景完全可见，1.0f表示背景完全不可见。
//        layoutParams.dimAmount = 0.5f;
//        layoutParams.flags|=WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        mDialog.getWindow().getDecorView().setSystemUiVisibility(uiOptions);


        WindowManager.LayoutParams layoutParams = mDialog.getWindow().getAttributes();
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.gravity = Gravity.RIGHT;
        mDialog.getWindow().setAttributes(layoutParams);
        Log.i(TAG,"onStart");
        super.onStart();
    }



}
