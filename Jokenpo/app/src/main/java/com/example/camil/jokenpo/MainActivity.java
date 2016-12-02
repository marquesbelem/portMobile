package com.example.camil.jokenpo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int placarJogador = 0;
    int placarComputador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void jogar(View view){
        setContentView(R.layout.tela_inicial);
    }
    public void pedra(View view) {
        int escolhaComputador = (int) (Math.random() * 3) + 1; //gerar numeros randomicos de 1 á 3

        if (escolhaComputador == 1) {

            ImageView img = (ImageView) findViewById(R.id.jogador);
            img.setImageResource(R.drawable.pedra2);

            ImageView img2 = (ImageView) findViewById(R.id.computador);
            img2.setImageResource(R.drawable.pedra2);

            Toast.makeText(MainActivity.this, "Sua jogada gerou um Empate", Toast.LENGTH_SHORT).show(); //gera um tost


        } else if (escolhaComputador == 2) {

            ImageView img = (ImageView) findViewById(R.id.jogador);
            img.setImageResource(R.drawable.pedra2);


            ImageView img2 = (ImageView) findViewById(R.id.computador);
            img2.setImageResource(R.drawable.papel2);

            placarComputador++;
            TextView pontos = (TextView) findViewById(R.id.placarComputador);
            pontos.setText(String.valueOf(this.placarComputador)); //converte um valor numerico pra string


        } else if (escolhaComputador == 3) {

            ImageView img = (ImageView) findViewById(R.id.jogador);
            img.setImageResource(R.drawable.pedra2);


            ImageView img2 = (ImageView) findViewById(R.id.computador);
            img2.setImageResource(R.drawable.tesoura2);

            placarJogador++;
            TextView pontos = (TextView) findViewById(R.id.placarJogador);
            pontos.setText(String.valueOf(this.placarJogador));

        }
    }

    public void tesoura(View view) {
        int escolhaComputador = (int) (Math.random() * 3) + 1; //gerar numeros randomicos de 1 á 3

        if (escolhaComputador == 1) {

            ImageView img = (ImageView) findViewById(R.id.jogador);
            img.setImageResource(R.drawable.tesoura2);

            ImageView img2 = (ImageView) findViewById(R.id.computador);
            img2.setImageResource(R.drawable.pedra2);

            placarComputador++;
            TextView pontos = (TextView) findViewById(R.id.placarComputador);
            pontos.setText(String.valueOf(this.placarComputador));

        } else if (escolhaComputador == 2) {

            ImageView img = (ImageView) findViewById(R.id.jogador);
            img.setImageResource(R.drawable.tesoura2);


            ImageView img2 = (ImageView) findViewById(R.id.computador);
            img2.setImageResource(R.drawable.papel2);

            placarJogador++;
            TextView pontos = (TextView) findViewById(R.id.placarJogador);
            pontos.setText(String.valueOf(this.placarJogador));


        } else if (escolhaComputador == 3) {

            ImageView img = (ImageView) findViewById(R.id.jogador);
            img.setImageResource(R.drawable.tesoura2);


            ImageView img2 = (ImageView) findViewById(R.id.computador);
            img2.setImageResource(R.drawable.tesoura2);

            Toast.makeText(MainActivity.this, "Sua jogada gerou um Empate", Toast.LENGTH_SHORT).show();

        }

    }

    public void papel(View view) {
        int escolhaComputador = (int) (Math.random() * 3) + 1; //gerar numeros randomicos de 1 á 3

        if (escolhaComputador == 1) {

            ImageView img = (ImageView) findViewById(R.id.jogador);
            img.setImageResource(R.drawable.papel2);

            ImageView img2 = (ImageView) findViewById(R.id.computador);
            img2.setImageResource(R.drawable.pedra2);

            placarJogador++;
            TextView pontos = (TextView) findViewById(R.id.placarJogador);
            pontos.setText(String.valueOf(this.placarJogador));


        } else if (escolhaComputador == 2) {

            ImageView img = (ImageView) findViewById(R.id.jogador);
            img.setImageResource(R.drawable.papel2);


            ImageView img2 = (ImageView) findViewById(R.id.computador);
            img2.setImageResource(R.drawable.papel2);
            Toast.makeText(MainActivity.this, "Sua jogada gerou um Empate", Toast.LENGTH_SHORT).show();
        } else if (escolhaComputador == 3) {

            ImageView img = (ImageView) findViewById(R.id.jogador);
            img.setImageResource(R.drawable.papel2);


            ImageView img2 = (ImageView) findViewById(R.id.computador);
            img2.setImageResource(R.drawable.tesoura2);

            placarComputador++;
            TextView pontos = (TextView) findViewById(R.id.placarComputador);
            pontos.setText(String.valueOf(this.placarComputador));


        }

    }
}