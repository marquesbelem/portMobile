package com.example.camil.comilao.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.camil.comilao.graficos.Cores;


/**
 * Created by Dcarvalho on 01/11/2016.
 */
public class Pontuacao {
    private static final Paint BRANCO = Cores.getCorDaPontuacao();
    private int pontos = 0;

    public void desenhaNo(Canvas canvas){
        canvas.drawText(String.valueOf(pontos), 100, 100,BRANCO);
    }

    public void aumenta(){
        this.pontos++;
    }
}

