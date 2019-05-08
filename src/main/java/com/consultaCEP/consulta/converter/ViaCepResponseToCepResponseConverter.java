package com.consultaCEP.consulta.converter;

import com.consultaCEP.consulta.model.CepResponse;
import com.consultaCEP.consulta.model.Dados;
import com.consultaCEP.consulta.model.Regiao;
import com.consultaCEP.consulta.model.ViaCepResponse;
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
