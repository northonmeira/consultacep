package com.consultaCEP.consultaCEP.converter;

import com.consultaCEP.consultaCEP.model.CepResponse;
import com.consultaCEP.consultaCEP.model.Dados;
import com.consultaCEP.consultaCEP.model.Regiao;
import com.consultaCEP.consultaCEP.model.ViaCepResponse;
import org.springframework.stereotype.Component;

@Component
public class ViaCepResponseToCepResponseConverter {

    public CepResponse convert(ViaCepResponse viaCepResponse){

        Dados dados = Dados.builder()
                .bairro(viaCepResponse.getBairro())
                .cep(viaCepResponse.getCep())
                .build();

        Regiao regiao = Regiao.builder()
                .cidade(viaCepResponse.getLocalidade())
                .estado(viaCepResponse.getUf())
                .build();

        CepResponse cepResponse = CepResponse.builder()
                .dados(dados)
                .logradouro(viaCepResponse.getLogradouro())
                .regiao(regiao)
                .build();

        return cepResponse;
    }
}
