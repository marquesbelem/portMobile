package com.example.camil.comilao.elementos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.camil.comilao.R;
import com.example.camil.comilao.graficos.Cores;
import com.example.camil.comilao.graficos.Tela;

/**
 * Created by camil on 02/12/2016.
 */
public class GameOver { private final Tela tela;
    private Bitmap telaGameOver;

    public GameOver(Tela tela, Context context) {

        this.tela = tela;
        Bitmap bp = BitmapFactory.decodeResource(
                context.getResources(), R.drawable.gm
        );

        this.telaGameOver = Bitmap.createScaledBitmap(bp, bp.getWidth(), tela.getAltura(), false);


    }
    public void desenhaNo(Canvas canvas){
        canvas.drawBitmap(telaGameOver,-100,-100,null);
    }

}
