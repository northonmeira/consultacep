package com.consultaCEP.consulta.model;

import com.consultaCEP.consulta.model.Lance;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Leilao {

    private String descricao;
    private List<Lance> lances;
    private Double maiorLance = Double.NEGATIVE_INFINITY;

}
