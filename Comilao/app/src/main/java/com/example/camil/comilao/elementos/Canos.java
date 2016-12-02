package com.example.camil.comilao.elementos;

import android.content.Context;
import android.graphics.Canvas;

import com.example.camil.comilao.graficos.Tela;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


/**
 * Created by Dcarvalho on 01/11/2016.
 */
public class Canos {
    private List<Cano> canos = new ArrayList<Cano>();
    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS = 250;
    private Tela tela;
    private Pontuacao pontuacao;

    private Context context;

    public void desenhaNo(Canvas canvas){
        for (Cano cano : canos){
            cano.desenhaNo(canvas);
        }
    }
    public Canos(Tela tela, Pontuacao pontuacao, Context context){
        this.tela = tela;
        this.pontuacao = pontuacao;
        int posicaoInicial = 200;
        this.context = context;

        for(int i=0; i < QUANTIDADE_DE_CANOS; i++){
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicaoInicial,context));
        }
    }
    public void move(){
        ListIterator<Cano> iterator = canos.listIterator();
        while(iterator.hasNext()){
            Cano cano = (Cano) iterator.next();
            cano.move();
            if(cano.saiuDaTela()){
                pontuacao.aumenta();
                iterator.remove();
                Cano outroCano = new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS, context);
                iterator.add(outroCano);
            }
        }
    }
    private int getMaximo(){
        int maximo = 0;
        for(Cano cano : canos){
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }
    public boolean temColisaoCom(Passaro passaro){
        for(Cano cano : canos){
            if(cano.temColisaoHorizontalCom(passaro) && cano.temColisaoVerticalCom(passaro)){
                return true;
            }
        }
        return false;
    }

}
