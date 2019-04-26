package com.consultaCEP.consultaCEP.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dados implements Serializable {

    private String cep;
    private String bairro;
}
