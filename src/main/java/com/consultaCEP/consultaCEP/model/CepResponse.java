package com.consultaCEP.consultaCEP.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CepResponse implements Serializable {

    private Regiao regiao;
    private String logradouro;
    private Dados dados;

}
