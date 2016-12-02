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
public class Cano {
    private static final int TAMANHO_DO_CANO = 150;
    private static final int LARGURA_DO_CANO = 100;

    private final Tela tela;

    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    private int posicao;

    private static final Paint VERDE = Cores.getCorDoCano();

    private Bitmap canoImageC;
    private Bitmap canoImageB;

    public Cano(Tela tela, int posicao, Context context) {
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        this.alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio();

        Bitmap bp = BitmapFactory.decodeResource(
                context.getResources(), R.drawable.chao3
        );
        this.canoImageC = Bitmap.createScaledBitmap(bp,100, TAMANHO_DO_CANO, false);

        Bitmap bpd = BitmapFactory.decodeResource(
                context.getResources(), R.drawable.chao2
        );
        this.canoImageB = Bitmap.createScaledBitmap(bpd,100, TAMANHO_DO_CANO, false);
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 300);
    }

    public void desenhaNo(Canvas canvas){
        desenhaCanoSuperiorNo(canvas);
        desenhaCanoInferiorNo(canvas);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas) {

        canvas.drawBitmap(canoImageC, posicao, alturaDoCanoSuperior,null);

      // canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, VERDE);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawBitmap(canoImageB, posicao, alturaDoCanoInferior,null);
        //canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), VERDE);
    }
    public void move(){
        posicao -= 5;
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoVerticalCom(Passaro passaro){
        return passaro.getAltura() - Passaro.RAIO <
                this.alturaDoCanoSuperior
                || passaro.getAltura() + Passaro.RAIO >
                this.alturaDoCanoInferior;
    }
    public boolean temColisaoHorizontalCom(Passaro passaro){
        return this.posicao - Passaro.X < Passaro.RAIO;
    }
}
