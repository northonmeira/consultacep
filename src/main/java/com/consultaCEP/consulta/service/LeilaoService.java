package com.consultaCEP.consulta.service;

import com.consultaCEP.consulta.model.Lance;
import com.consultaCEP.consulta.model.Leilao;
import org.springframework.stereotype.Service;

@Service
public class LeilaoService {


    public Leilao avalia(Leilao leilao){

        for (Lance lance:leilao.getLances()) {
            if(lance.getValor() > leilao.getMaiorLance())
                leilao.setMaiorLance(lance.getValor());
        }

        return leilao;
    }
}
