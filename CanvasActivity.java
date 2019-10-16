package edu.temple.coloractivity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CanvasActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas_activity);
        setTitle("Canvas Activity");
        ConstraintLayout layout = findViewById(R.id.canvasLayout);
        layout.setBackgroundColor(Color.parseColor(getIntent().getStringExtra(PaletteActivity.color)));
    }
}
