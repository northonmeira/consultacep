package com.consultaCEP.consulta.service;

import com.consultaCEP.consulta.converter.ViaCepResponseToCepResponseConverter;
import com.consultaCEP.consulta.gateway.CepGateway;
import com.consultaCEP.consulta.model.CepResponse;
import com.consultaCEP.consulta.model.ViaCepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService implements ICepService {

    @Autowired
    private CepGateway cepGateway;

    @Autowired
    private ViaCepResponseToCepResponseConverter viaCepResponseToCepResponseConverter;

    @Override
    public CepResponse consultaCep(String cep){

        ViaCepResponse viaCepResponse = cepGateway.findEnderecoByCep(cep);

        return viaCepResponseToCepResponseConverter.convert(viaCepResponse);
    }

//    @Override
//    public void enviaEnderecoJms(CepResponse cepResponse) {
//        cepGateway.enviaEnderecoJms(cepResponse);
//    }

}
