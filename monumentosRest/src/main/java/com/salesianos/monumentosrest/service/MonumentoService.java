package com.salesianos.monumentosrest.service;

import com.salesianos.monumentosrest.dto.EditMonumentoCommand;
import com.salesianos.monumentosrest.error.MonumentoNotFoundException;
import com.salesianos.monumentosrest.model.Monumento;
import com.salesianos.monumentosrest.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumentoService {

    private final MonumentoRepository monumentoRepository;

    public List<Monumento> findAll() {
        List<Monumento> result = monumentoRepository.findAll();

        if(result.isEmpty()) {
            throw  new MonumentoNotFoundException();
        }

        return result;
    }

    public Monumento findById(Long id) {
        return monumentoRepository.findById(id)
                .orElseThrow(() -> new MonumentoNotFoundException());
    }

    public Monumento save(EditMonumentoCommand cmd) {
        return monumentoRepository.save(
                Monumento.builder()
                        .nombrePais(cmd.nombrePais())
                        .nombreCiudad(cmd.nombreCiudad())
                        .nombreMonumento(cmd.nombreMonumento())
                        .descripcion(cmd.descripcion())
                        .urlFoto(cmd.urlFoto())
                        .build()
        );
    }

    public Monumento edit(EditMonumentoCommand cmd, Long id) {
        return monumentoRepository.findById(id)
                .map(m -> {
                    m.setNombrePais(cmd.nombrePais());
                    m.setNombreCiudad(cmd.nombreCiudad());
                    m.setNombreMonumento(cmd.nombreMonumento());
                    m.setDescripcion(cmd.descripcion());
                    m.setUrlFoto(cmd.urlFoto());
                    return monumentoRepository.save(m);
                })
                .orElseThrow(() -> new MonumentoNotFoundException());
    }

    public void delete(Long id) {
        monumentoRepository.deleteById(id);
    }

}
