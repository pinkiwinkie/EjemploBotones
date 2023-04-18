package com.example.ejemplobotones;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private CheckBox checkBox;
    private TextView tvCB,tvSelection;
    private RadioGroup sexoRG;
    //el array ya es serializable.
    private ArrayList<User> users;
    private TextInputEditText name, surname;
    private Button accept;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        checkBox = findViewById(R.id.checkBox01);
        tvCB = findViewById(R.id.textViewCB);
        sexoRG = findViewById(R.id.radioGroup);
        tvSelection = findViewById(R.id.textViewSeleccion);
        name = findViewById(R.id.nombre);
        surname = findViewById(R.id.apellidos);
        accept = findViewById(R.id.buttonAdd);
        spinner = findViewById(R.id.spinner);

        if (savedInstanceState != null)
            users = (ArrayList<User>) savedInstanceState.getSerializable("users");
        else {
            users = new ArrayList<>();
            users.add(new User("pinki","winki"));
            users.add(new User("coti","doli"));
        }

        //solo con spinners o para aquello que tengas que desplazar una lista de informacion
        ArrayAdapter<User> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,users);
        spinner.setAdapter(myAdapter);
        //para ver si hay algun item seleccionado en el spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tvSelection.setText(users.get(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = name.getText().toString();
                String ape = surname.getText().toString();
                users.add(new User(nom, ape));
                name.setText("");
                surname.setText("");
                myAdapter.notifyDataSetChanged();
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked())
                    tvCB.setText("CheckBox activado");
                else
                    tvCB.setText("CheckBox desactivado");
            }
        });

        sexoRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButtonHombre)
                    tvSelection.setText("HOMBRE");
                else if (i == R.id.radioButtonMujer) {
                    tvSelection.setText("MUJER");
                }else if (i == R.id.radioButtonOtro) {
                    tvSelection.setText("OTRO");
                }else
                    tvSelection.setText("SIN SELECCION");
            }
        });
    }
//NonNull -> denotes that a parameter, field or method return value can never be null.
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable("users", users);
    }
}
