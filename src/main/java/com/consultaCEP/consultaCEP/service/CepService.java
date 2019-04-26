package com.consultaCEP.consultaCEP.service;

import com.consultaCEP.consultaCEP.model.CepResponse;

public interface CepService {

    public CepResponse consultaCep(String cep);
    public void enviaEnderecoJms(CepResponse cepResponse);

}
