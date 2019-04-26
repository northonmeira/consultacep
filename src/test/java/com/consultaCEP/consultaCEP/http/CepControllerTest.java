package com.consultaCEP.consultaCEP.http;

import com.consultaCEP.consultaCEP.model.CepResponse;
import com.consultaCEP.consultaCEP.service.CepService;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CepController.class)
public class CepControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CepService cepService;

    @Test
    public void shouldReturnCepResponseByCep() throws Exception {
        Mockito.when(cepService.consultaCep("05537030")).thenReturn(new CepResponse());
        mockMvc.perform(get("/cep/05537030"))
                .andExpect(status().isOk());
    }

}
