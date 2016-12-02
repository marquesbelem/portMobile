package com.example.camil.comilao.engine;

import com.example.camil.comilao.elementos.Canos;
import com.example.camil.comilao.elementos.Passaro;

/**
 * Created by camil on 02/12/2016.
 */
public class VerificadorDeColisao {private final Passaro passaro;
    private final Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos){
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao(){
        return canos.temColisaoCom(passaro);
    }
}
