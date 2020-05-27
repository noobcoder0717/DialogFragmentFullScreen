package com.example.dialogfragmentfullscreen;

public class CustomizedDialogFragment extends BaseLandscapeDialogFragment {

    @Override
    public void setAttrs(int layoutID, int styleID){
        this.layoutID = layoutID;
        this.styleID = styleID;
    }

    public CustomizedDialogFragment(int layoutID,int styleID){
        setAttrs(layoutID,styleID);
    }
}
