package com.consultaCEP.consulta.service;

import com.consultaCEP.consulta.model.CepResponse;

public interface ICepService {

    CepResponse consultaCep(String cep);
//    public void enviaEnderecoJms(CepResponse cepResponse);

}
