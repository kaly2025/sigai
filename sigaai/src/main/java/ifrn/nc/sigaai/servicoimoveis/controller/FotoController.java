package ifrn.nc.sigaai.servicoimoveis.controller;

import ifrn.nc.sigaai.servicoimoveis.DTO.FotoRequestDTO;
import ifrn.nc.sigaai.servicoimoveis.DTO.FotoResponseDTO;
import ifrn.nc.sigaai.servicoimoveis.service.FotoService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/fotos")
public class FotoController {

    private final FotoService service;

    public FotoController(FotoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FotoResponseDTO> criar(
            @Valid @RequestBody FotoRequestDTO dto) {

        FotoResponseDTO foto = service.criar(dto);

        URI location = URI.create("/fotos/" + foto.getId());

        return ResponseEntity
                .created(location)
                .body(foto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FotoResponseDTO> buscarPorId(
            @PathVariable Long id) {

        FotoResponseDTO foto = service.buscarPorId(id);

        return ResponseEntity.ok(foto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FotoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody FotoRequestDTO dto) {

        FotoResponseDTO foto =
                service.atualizar(id, dto);

        return ResponseEntity.ok(foto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}