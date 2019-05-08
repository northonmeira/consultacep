package com.consultaCEP.consulta.http;

import com.consultaCEP.consulta.model.CepResponse;
import com.consultaCEP.consulta.service.ICepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private ICepService cepService;

    @GetMapping("/{cep}")
    public Object get(@PathVariable String cep){
        try {
            CepResponse cepResponse = cepService.consultaCep(cep);
//            cepService.enviaEnderecoJms(cepResponse);

            return cepResponse;
        } catch (HttpClientErrorException a){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
