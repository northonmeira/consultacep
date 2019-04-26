package com.consultaCEP.consultaCEP.service;

import com.consultaCEP.consultaCEP.converter.ViaCepResponseToCepResponseConverter;
import com.consultaCEP.consultaCEP.gateway.CepGateway;
import com.consultaCEP.consultaCEP.model.CepResponse;
import com.consultaCEP.consultaCEP.model.ViaCepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepServiceImpl implements CepService {

    @Autowired
    private CepGateway cepGateway;

    @Autowired
    private ViaCepResponseToCepResponseConverter viaCepResponseToCepResponseConverter;

    public CepResponse consultaCep(String cep){

        ViaCepResponse viaCepResponse = cepGateway.findEnderecoByCep(cep);

        return viaCepResponseToCepResponseConverter.convert(viaCepResponse);
    }

    @Override
    public void enviaEnderecoJms(CepResponse cepResponse) {
        cepGateway.enviaEnderecoJms(cepResponse);
    }

}
