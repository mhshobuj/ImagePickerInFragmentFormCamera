package com.dma.fragmentcamerapicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dma.fragmentcamerapicker.ui.main.OpenCameraFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, OpenCameraFragment.newInstance())
                    .commitNow();
        }
    }
}