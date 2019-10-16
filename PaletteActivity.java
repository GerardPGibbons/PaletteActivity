package edu.temple.coloractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    public static final String color = "edu.temple.PaletteActivity.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Resources res = this.getResources();
        final String [] colors = res.getStringArray(R.array.colors);

//        ArrayAdapter adapter = new ArrayAdapter<>(PaletteActivity.this, android.R.layout.simple_list_item_1, colors );
        ColorAdapter adapter = new ColorAdapter(PaletteActivity.this, colors);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                view.setBackgroundColor(Color.WHITE);
                findViewById(R.id.layoutID).setBackgroundColor(Color.parseColor(translate(colors[i])));
                if(i!=0) {
                    Intent intent = new Intent(getApplicationContext(), CanvasActivity.class);
                    intent.putExtra(color, translate(colors[i]));
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

        spinner1.setAdapter(adapter);

    }

    public String translate(final String spanishColor){
        String translatedColor = "";
        switch(spanishColor){
            case "Rojo": translatedColor = "Red";
            break;
            case "Azul": translatedColor = "Blue";
            break;
            case "Verde": translatedColor = "Green";
            break;
            case "Gris": translatedColor = "Gray";
            break;
            case "Cian": translatedColor = "Cyan";
            break;
            case "Magenta": translatedColor = "Magenta";
            break;
            case "Lima": translatedColor = "Lime";
            break;
            case "Amarillo": translatedColor = "Yellow";
            break;
            case "Agua": translatedColor = "Aqua";
            break;
            case "Púrpura": translatedColor = "Purple";
            break;
            default: translatedColor = spanishColor;

        }
        return translatedColor;
    }
}
