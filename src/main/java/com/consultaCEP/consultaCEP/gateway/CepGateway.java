package com.consultaCEP.consultaCEP.gateway;

import com.consultaCEP.consultaCEP.model.CepResponse;
import com.consultaCEP.consultaCEP.model.ViaCepResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@AllArgsConstructor
public class CepGateway {

    private final JmsTemplate jmsTemplate;

    private final RestTemplate restTemplate;

    private final String apiUrl = "https://viacep.com.br/ws/";

    public ViaCepResponse findEnderecoByCep(String cep){
        return restTemplate.getForObject(apiUrl + cep + "/json/", ViaCepResponse.class);

    }

    public void enviaEnderecoJms(CepResponse message){
        jmsTemplate.convertAndSend("cep-channel", message);
    }

}
