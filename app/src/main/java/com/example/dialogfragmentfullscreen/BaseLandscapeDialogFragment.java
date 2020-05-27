package com.example.dialogfragmentfullscreen;

import android.accessibilityservice.AccessibilityService;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.fragment.app.DialogFragment;

public abstract class BaseLandscapeDialogFragment extends DialogFragment {

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

        return view;
    }

    @Override
    public void onStart(){
        super.onStart();

        WindowManager.LayoutParams layoutParams = mDialog.getWindow().getAttributes();

        //以下两行可以调整DialogFragment弹出时，背景是否可见。背景在这里指的是DialogFragment所在的activity
        //dimAmount的范围为0.0f-1.0f，0.0f表示背景完全可见，1.0f表示背景完全不可见。
//        layoutParams.dimAmount = 0;
//        layoutParams.flags|=WindowManager.LayoutParams.FLAG_DIM_BEHIND;

        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.gravity = Gravity.RIGHT;

        mDialog.getWindow().setAttributes(layoutParams);

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
//                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        mDialog.getWindow().getDecorView().setSystemUiVisibility(uiOptions);
    }



}
