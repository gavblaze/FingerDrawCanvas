package com.gavblaze.android.fingerdrawcanvas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // No XML file; just one custom view created programmatically.
        DrawCanvasView drawCanvasView = new DrawCanvasView(this);
        drawCanvasView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(drawCanvasView);
    }
}
