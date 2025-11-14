package com.salesianos.monumentosrest.dto;

public record EditMonumentoCommand(
        String nombrePais,
        String nombreCiudad,
        String nombreMonumento,
        String descripcion,
        String urlFoto

) {
}
