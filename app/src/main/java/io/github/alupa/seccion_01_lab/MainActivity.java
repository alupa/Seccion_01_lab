package io.github.alupa.seccion_01_lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Elementos UI
    private EditText editTextName;
    private Button buttonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Forzar el logo, en todas las versiones android
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Instanciamos los elementos de la UI con sus referencias
        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonMain = (Button) findViewById(R.id.buttonMain);

        // Evento click del botón para pasar al siguiente Activity
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                if ( !name.isEmpty()){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Falta tu nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
