package com.consultaCEP.consulta.Service;

import com.consultaCEP.consulta.model.Lance;
import com.consultaCEP.consulta.model.Leilao;
import com.consultaCEP.consulta.service.LeilaoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class TestaLeilaoService {

    @Autowired
    LeilaoService leilaoService;

    @Test
    public void deveRetornarMaiorLance(){

        List<Lance> lances = new ArrayList<>();

        Lance lance1 = Lance.builder()
                .valor(100)
                .comprador("Oswaldo")
                .build();

        Lance lance2 = Lance.builder()
                .valor(200)
                .comprador("Raphael")
                .build();

        lances.add(lance1);
        lances.add(lance2);

        Leilao leilao = Leilao.builder()
                .lances(lances)
                .build();

        Assert.assertEquals(200, leilaoService.avalia(leilao).getMaiorLance(), 0.0001);
    }

}
