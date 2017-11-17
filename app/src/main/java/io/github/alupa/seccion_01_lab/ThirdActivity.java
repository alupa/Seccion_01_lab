package io.github.alupa.seccion_01_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    // Elementos UI
    private Button buttonResult;
    private Button buttonShare;

    private String name;
    private int age;
    private int option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Activar la flecha para volver al activity principal
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Recogemos el nombre del activity anterior
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            name = bundle.getString("name");
            age = bundle.getInt("age");
            option = bundle.getInt("option");
        }

        // Instanciamos los elementos de la UI con sus referencias
        buttonResult = (Button) findViewById(R.id.buttonResult);
        buttonShare = (Button) findViewById(R.id.buttonShare);

        // Evento click del botón para mostrar los resultados
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonResult.setVisibility(View.INVISIBLE);
                Toast.makeText(ThirdActivity.this, showMessage(name, age, option) , Toast.LENGTH_LONG).show();
                buttonShare.setVisibility(View.VISIBLE);
            }
        });

        // Evento click botón para compartir
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, showMessage(name, age, option));
                startActivity(intent);
            }
        });
    }

    private String showMessage(String name, int age, int option){
        //option valdrá 1 si el usuario eligió boton de saludo, si no 0 en caso de despedida
        if (option == SecondActivity.OPCION_SALUDO)
            return "Hola " + name + ", ¿Cómo llevas esos " + age + " años? #MyForm";
        else
            return "Espero verte pronto " + name + ", antes que cumplas " + (age + 1) + ".. #MyForm";
    }
}
