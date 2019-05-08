package com.consultaCEP.consulta.gateway;

import com.consultaCEP.consulta.model.CepResponse;
import com.consultaCEP.consulta.model.ViaCepResponse;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@AllArgsConstructor
public class CepGateway {

    private final JmsTemplate jmsTemplate;

    private final RestTemplate restTemplate;

    private static final String URL = "https://viacep.com.br/ws/";

    public ViaCepResponse findEnderecoByCep(String cep){
        return restTemplate.getForObject(URL + cep + "/json/", ViaCepResponse.class);

    }

//    public void enviaEnderecoJms(CepResponse message){
//        jmsTemplate.convertAndSend("cep-channel", message);
//    }

}
