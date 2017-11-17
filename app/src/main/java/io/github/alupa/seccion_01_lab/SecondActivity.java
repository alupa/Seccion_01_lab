package io.github.alupa.seccion_01_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    // Elementos UI
    private RadioButton radioButtonSaludo;
    private RadioButton radioButtonDespedida;
    private SeekBar seekBarEdad;
    private TextView textViewEdad;
    private Button buttonSecond;

    private String name = "";
    private int age = 18;
    public static final int OPCION_SALUDO = 1;
    public static final int OPCION_DESPEDIDA = 0;
    private final int MAX_AGE = 60;
    private final int MIN_AGE = 16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Activar la flecha para volver al activity principal
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Recogemos el nombre del activity anterior
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            name = bundle.getString("name");
        }

        // Instanciamos los elementos de la UI con sus referencias
        radioButtonSaludo = (RadioButton) findViewById(R.id.radioButtonSaludo);
        radioButtonDespedida = (RadioButton) findViewById(R.id.radioButtonDespedida);
        seekBarEdad = (SeekBar) findViewById(R.id.seekBarEdad);
        textViewEdad = (TextView) findViewById(R.id.textViewEdad);
        buttonSecond = (Button) findViewById(R.id.buttonSecond);

        // Evento change para el seekbar
        seekBarEdad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int currentAge, boolean fromUser) {
                age = currentAge;
                textViewEdad.setText(age + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Aunque no lo sobreescribamos con alguna funcionalidad, OnSeekBarChangeListener es una interfaz
                // y como interfaz que es, necesitamos sobreescribir todos sus métodos, aunque lo dejemos vacío.
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                age = seekBar.getProgress();
                textViewEdad.setText(age + "");

                if (age < MIN_AGE){
                    buttonSecond.setVisibility(View.INVISIBLE);
                    Toast.makeText(SecondActivity.this, "Edad es menor a la permitida (16 años)", Toast.LENGTH_SHORT).show();
                } else if (age > MAX_AGE){
                    buttonSecond.setVisibility(View.INVISIBLE);
                    Toast.makeText(SecondActivity.this, "Edad es mayor a la permitida (60 años)", Toast.LENGTH_SHORT).show();
                } else {
                    buttonSecond.setVisibility(View.VISIBLE);
                }
            }
        });

        // Evento click del botón para pasar al siguiente Activity
        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("age", age);
                // Si el botón de saludo esta activo, option valdrá 1, si no 0
                int option = (radioButtonSaludo.isChecked()) ? OPCION_SALUDO : OPCION_DESPEDIDA;
                intent.putExtra("option", option);
                startActivity(intent);
            }
        });
    }


}
