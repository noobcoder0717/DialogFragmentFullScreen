package com.example.dialogfragmentfullscreen;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.fragment.app.DialogFragment;

public class PortraitDialogFragment extends DialogFragment {

    private Dialog mDialog;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE,R.style.CustomizedDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        View view = inflater.inflate(R.layout.dialog_fragment_select_photo,container,false);
        mDialog = getDialog();
        mDialog.getWindow().setWindowAnimations(R.style.AnimPortraitDialogFragment);

        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        Window window = mDialog.getWindow();
        WindowManager.LayoutParams params = window.getAttributes();

        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.gravity = Gravity.BOTTOM;
        window.setAttributes(params);

    }
}
