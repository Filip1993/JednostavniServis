package com.filipkesteli.jednostavniservis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnStartService;
    private Button btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        btnStartService = (Button) findViewById(R.id.btnStartService);
        btnStopService = (Button) findViewById(R.id.btnStopService);
    }

    private void setupListeners() {
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kreiramo objekt tipa Intent i startamo ga:
                Intent intent = getServiceIntent();
                startService(intent);
            }
        });
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kreiramo objekt tipa Intent i stopamo ga
                Intent intent = getServiceIntent();
                stopService(intent);
            }
        });
    }

    //pomocna private metoda unutar klase
    private Intent getServiceIntent() {
        return new Intent(this, ObicniServis.class);
    }
    //Startanje eksplicitnim intentom:
}