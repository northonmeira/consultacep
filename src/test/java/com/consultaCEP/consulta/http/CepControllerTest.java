package com.consultaCEP.consulta.http;

import com.consultaCEP.consulta.gateway.CepGateway;
import com.consultaCEP.consulta.model.CepResponse;
import com.consultaCEP.consulta.model.Dados;
import com.consultaCEP.consulta.model.Regiao;
import com.consultaCEP.consulta.model.ViaCepResponse;
import com.consultaCEP.consulta.service.CepService;
import com.consultaCEP.consulta.service.ICepService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CepController.class)
public class CepControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CepService cepService;

    private CepResponse cepResponse;
    private ViaCepResponse viaCepResponse;

    @Before
    public void montaTeste(){
        Regiao regiao = Regiao.builder()
                .cidade("São Paulo")
                .estado("São Paulo")
                .build();
        Dados dados = Dados.builder()
                .bairro("Peri Peri")
                .cep("05537030")
                .build();

    }

    @Test
    public void shouldReturnCepResponseByCep() throws Exception {
        Mockito.when(cepService.consultaCep("05537030")).thenReturn(new CepResponse());
        mockMvc.perform(get("/cep/05537030"))
                .andExpect(status().isOk());
    }

}
