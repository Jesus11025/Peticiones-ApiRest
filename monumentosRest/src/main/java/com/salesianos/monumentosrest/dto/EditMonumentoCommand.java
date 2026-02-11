package com.salesianos.monumentosrest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record EditMonumentoCommand(
        @Schema(description = "nombre del pais", example = "ESPANIA") String nombrePais,
        @Schema(description = "nombre ciudad", example = "SEVILLA") String nombreCiudad,
        String nombreMonumento,
        String descripcion,
        String urlFoto

) {}
