package br.ulbra.gasolinaoualcool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
   private EditText edtAlcool, edtGasolina;
   private Button btnCompara;
   private TextView txtResult1, txtResult2;
   public double valorAl, valorGas, percentual, resultado;
   public  String textoResult = "";
   DecimalFormat f = new  DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//oculta o titulo da aplicação
        iniciarComponentes();//inicializado os componentes
        /* clique do botão verificar */
        btnCompara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorAl = Double.parseDouble(edtAlcool.getText().toString());
                valorGas = Double.parseDouble(edtGasolina.getText().toString());
                percentual = valorAl/valorGas * 100;
                txtResult1.setText(f.format(percentual)+"%");
                if(percentual > 73){
                    textoResult = "Opte por abastecer com Gasolina";
                }else{
                    textoResult = "Opte por abastecer com Álcool";
                }
                txtResult2.setText(textoResult);
            }
        });
    }

    private void iniciarComponentes() {
        edtAlcool = findViewById(R.id.edtAlcool);
        edtGasolina = findViewById(R.id.edtGasolina);
        btnCompara = findViewById(R.id.btnVerificar);
        txtResult1 = findViewById(R.id.txtResutado1);
        txtResult2 = findViewById(R.id.txtResultado2);
    }
}