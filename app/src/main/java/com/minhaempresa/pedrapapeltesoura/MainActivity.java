package com.minhaempresa.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView escolhaUsuario, escolhaAplicativo;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        escolhaUsuario = findViewById(R.id.escolhaUsuario);
        escolhaAplicativo = findViewById(R.id.escolhaAplicativo);
    }

    public void escolhidoPedra (View view) {
        escolhaUsuario.setImageResource(R.drawable.pedra);
        this.opcaoSelecionada("Pedra");
    }

    public void escolhidoPapel (View view) {
        escolhaUsuario.setImageResource(R.drawable.papel);
        this.opcaoSelecionada("Papel");
    }

    public void escolhidoTesoura (View view) {
        escolhaUsuario.setImageResource(R.drawable.tesoura);
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada (String opcaoSelecionada) {

        resultadoTextView = findViewById(R.id.resultadoTextView);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes[numero];
        // Imagens de acordo com a escolha do aplicativo
        switch (escolhaApp) {
            case "Pedra":
                escolhaAplicativo.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                escolhaAplicativo.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                escolhaAplicativo.setImageResource(R.drawable.tesoura);
                break;
        }
        // Se o Aplicativo ganhar
        if ((escolhaApp == "Pedra" && opcaoSelecionada == "Tesoura") ||
                (escolhaApp == "Papel" && opcaoSelecionada == "Pedra") ||
                (escolhaApp == "Tesoura" && opcaoSelecionada == "Papel")
        ){
            resultadoTextView.setText("O Aplicativo Venceu!");
        }
        // Se o Usuário ganhar
        else if ((opcaoSelecionada == "Pedra" && escolhaApp == "Tesoura") ||
                (opcaoSelecionada == "Papel" && escolhaApp == "Pedra") ||
                (opcaoSelecionada == "Tesoura" && escolhaApp == "Papel")
        ){
            resultadoTextView.setText("O Usuário Venceu!");

        }
        // Se houver empate
        else {
            resultadoTextView.setText("Empate!");
        }
    }
}
