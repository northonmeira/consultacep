package com.consultaCEP.consultaCEP.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Regiao implements Serializable {

    private String cidade;
    private String estado;

}
