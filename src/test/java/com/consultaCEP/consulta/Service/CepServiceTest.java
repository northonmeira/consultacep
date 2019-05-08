package com.consultaCEP.consulta.Service;

import com.consultaCEP.consulta.gateway.CepGateway;
import com.consultaCEP.consulta.http.CepController;
import com.consultaCEP.consulta.model.CepResponse;
import com.consultaCEP.consulta.model.ViaCepResponse;
import com.consultaCEP.consulta.service.CepService;
import com.consultaCEP.consulta.service.ICepService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CepServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CepGateway cepGateway;

    @Autowired
    private ICepService iCepService;

    private ViaCepResponse viaCepResponse;

    private CepResponse cepResponse;

    @Before
    public void setUp(){
        viaCepResponse = ViaCepResponse.builder()
                .cep("05537-030")
                .bairro("Jardim Peri Peri")
                .complemento("")
                .localidade("São Paulo")
                .logradouro("Praça Dom Henrique Mourão")
                .uf("SP")
                .unidade("")
                .ibge("")
                .gia("")
                .build();
    }

    @Test
    public void shoudReturnCepResponse_WhenConsultaCepp() {
        Mockito.when(cepGateway.findEnderecoByCep("05537030")).thenReturn(viaCepResponse);
        cepResponse = iCepService.consultaCep("05537030");
        Assert.assertEquals("Jardim Peri Peri", cepResponse.getDados().getBairro());
        Assert.assertEquals("05537-030", cepResponse.getDados().getCep());
    }
}