package ifrn.nc.sigaai.servicoimoveis.service;

import ifrn.nc.sigaai.servicoimoveis.DTO.FotoRequestDTO;
import ifrn.nc.sigaai.servicoimoveis.DTO.FotoResponseDTO;
import ifrn.nc.sigaai.servicoimoveis.exception.FotoNaoEncontradaException;
import ifrn.nc.sigaai.servicoimoveis.model.Foto;
import ifrn.nc.sigaai.servicoimoveis.exception.ImovelNaoEncontradoException; // Ajuste o pacote caso a sua classe esteja em outro diretório
import ifrn.nc.sigaai.servicoimoveis.repository.FotoRepository;
import org.springframework.stereotype.Service;
import ifrn.nc.sigaai.servicoimoveis.model.Imovel;
import ifrn.nc.sigaai.servicoimoveis.repository.ImovelRepository;

@Service
public class FotoService {

    private final FotoRepository repository;
    private final ImovelRepository imovelRepository;

    public FotoService(FotoRepository repository, ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
        this.repository = repository;
    }

    public FotoResponseDTO criar(FotoRequestDTO dto) {

        Foto salvo = repository.save(toEntity(dto));

        return toResponseDTO(salvo);
    }

    public FotoResponseDTO buscarPorId(Long id) {

        Foto foto = repository.findById(id)
                .orElseThrow(() -> new FotoNaoEncontradaException(id));

        return toResponseDTO(foto);
    }

    // public FotoResponseDTO atualizar(
    //         Long id,
    //         FotoRequestDTO dto) {

    //     Foto foto = repository.findById(id)
    //             .orElseThrow(() -> new FotoNaoEncontradaException(id));

    //     foto.setImovel(dto.getImovel());
    //     foto.setUrl(dto.getUrl());
    //     foto.setLegenda(dto.getLegenda());
    //     foto.setPrincipal(dto.getPrincipal());

    //     Foto atualizado = repository.save(foto);

    //     return toResponseDTO(atualizado);
    // }
    public FotoResponseDTO atualizar(Long id, FotoRequestDTO dto) {

    Foto foto = repository.findById(id)
            .orElseThrow(() -> new FotoNaoEncontradaException(id));

    // Busca e valida o imóvel informado no DTO
    Imovel imovel = imovelRepository.findById(dto.getImovelId())
            .orElseThrow(() -> new ImovelNaoEncontradoException(dto.getImovelId()));

    foto.setImovel(imovel);
    foto.setUrl(dto.getUrl());
    foto.setLegenda(dto.getLegenda());
    foto.setPrincipal(dto.getPrincipal());

    Foto atualizado = repository.save(foto);

    return toResponseDTO(atualizado);
}

    public void deletar(Long id) {

        repository.findById(id)
                .orElseThrow(() -> new FotoNaoEncontradaException(id));

        repository.deleteById(id);
    }

    private Foto toEntity(FotoRequestDTO dto) {

        Imovel imovel = imovelRepository.findById(dto.getImovelId())
                .orElseThrow(() -> new ImovelNaoEncontradoException(dto.getImovelId()));

        return new Foto(
                null,
                imovel,
                dto.getUrl(),
                dto.getLegenda(),
                dto.getPrincipal()
        );

    }

    private FotoResponseDTO toResponseDTO(Foto foto) {

        Imovel imovel = foto.getImovel();
        Long imovelId = imovel.getId();

        return new FotoResponseDTO(
                foto.getId(),
                imovelId,
                foto.getUrl(),
                foto.getLegenda(),
                foto.getPrincipal()
        );
    }
}