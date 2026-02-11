package com.salesianos.monumentosrest.controller;

import com.salesianos.monumentosrest.dto.EditMonumentoCommand;
import com.salesianos.monumentosrest.model.Monumento;
import com.salesianos.monumentosrest.service.MonumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumento/")
@RequiredArgsConstructor
@Tag(name = "monumento", description = "Controllador de todos los monumentos")
public class MonumentoController {

    private final MonumentoService monumentoService;

    @Operation(summary = "Endpoint para obtener todos los monumentos")
    @GetMapping
    public List<Monumento> getAll() {
        return monumentoService.findAll();
    }


    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Se han encontrado productos",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EditMonumentoCommand.class)),
                            examples = @ExampleObject(
                                    value = "[{ \"name\":\"ESPAÑA\", \"nombre ciudad\":\"SEVILLA\", \"ISO\":1234.56 }]"
    )
                )
                        ),
    @ApiResponse(
            responseCode = "404",
            description = "Monumento no encontrado"
    )
})

@GetMapping("{id}")
public Monumento getById(@PathVariable Long id) {
    return monumentoService.findById(id);
}

@PostMapping
public ResponseEntity<Monumento> create(
        @RequestBody EditMonumentoCommand cmd
) {
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(monumentoService.save(cmd));

}

@PutMapping("/{id}")
public Monumento edit(@RequestBody EditMonumentoCommand cmd, @PathVariable Long id) {
    return monumentoService.edit(cmd, id);
}

@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) {
    monumentoService.delete(id);
    return ResponseEntity.noContent().build();
}
}
