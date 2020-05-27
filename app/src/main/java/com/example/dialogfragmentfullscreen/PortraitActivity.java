package com.example.dialogfragmentfullscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PortraitActivity extends AppCompatActivity {

    Button btn_showFragment;
    Button btn_switchActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait);

        btn_showFragment = findViewById(R.id.btn_show_fragment);
        btn_showFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PortraitDialogFragment fragment = new PortraitDialogFragment();
                fragment.show(getSupportFragmentManager(),"");
            }
        });

        btn_switchActivity = findViewById(R.id.btn_switch_activity);
        btn_switchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
