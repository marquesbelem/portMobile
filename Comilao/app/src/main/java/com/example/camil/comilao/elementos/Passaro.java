package com.example.camil.comilao.elementos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.camil.comilao.R;
import com.example.camil.comilao.graficos.Cores;
import com.example.camil.comilao.graficos.Tela;


/**
 * Created by Dcarvalho on 01/11/2016.
 */
public class Passaro {
    public static final int X = 100;
    public static final int RAIO = 50;
    private static final Paint vermelho = Cores.getCorDoPassaro();
    private Tela tela;

    private int altura;

    private Bitmap passaro;

    public  Passaro(Tela tela, Context context){
        this.altura = 360;
        this.tela = tela;
        Bitmap bp = BitmapFactory.decodeResource(
                context.getResources(), R.drawable.passaro
        );
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO * 2, RAIO * 2, false);
    }
    public void desenhaNo(Canvas canvas){
        //canvas.drawCircle(X, altura, RAIO, vermelho);
        canvas.drawBitmap(passaro, X - RAIO, altura - RAIO, null);
    }
    public void cai(){
        boolean chegouNoChao = altura + RAIO > tela.getAltura();
        if(!chegouNoChao){
            this.altura += 5;
        }
    }
    public void pula(){
        if(altura > RAIO){
            this.altura -= 100;
        }
    }

    public int getAltura() {
        return altura;
    }
}
