package com.salesianos.monumentosrest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Monumento {

    @Id
    @GeneratedValue
    private Long id;

    private String codigoPais;
    private String nombrePais;
    private String nombreCiudad;
    private String latitud;
    private String nombreMonumento;
    private String descripcion;
    private String urlFoto;



}
