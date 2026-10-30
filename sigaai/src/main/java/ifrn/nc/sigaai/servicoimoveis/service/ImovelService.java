package ifrn.nc.sigaai.servicoimoveis.service;

import ifrn.nc.sigaai.servicoimoveis.DTO.ImovelRequestDTO;
import ifrn.nc.sigaai.servicoimoveis.DTO.ImovelResponseDTO;
import ifrn.nc.sigaai.servicoimoveis.exception.ImovelNaoEncontradoException;
import ifrn.nc.sigaai.servicoimoveis.model.Imovel;
import ifrn.nc.sigaai.servicoimoveis.repository.ImovelRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelService {

    private final ImovelRepository repository;

    public ImovelService(ImovelRepository repository) {
        this.repository = repository;
    }

    public ImovelResponseDTO criar(ImovelRequestDTO dto) {
        Imovel salvo = repository.save(toEntity(dto));
        return toResponseDTO(salvo);
    }

    public List<Imovel> listar() {
        return repository.findAll();
    }

    public ImovelResponseDTO buscarPorId(Long id) {
        Imovel imovel = repository.findById(id)
                .orElseThrow(() -> new ImovelNaoEncontradoException(id));

        return toResponseDTO(imovel);
    }

    public ImovelResponseDTO atualizar(Long id, ImovelRequestDTO dto) {
        Imovel imovel = repository.findById(id)
                .orElseThrow(() -> new ImovelNaoEncontradoException(id));

        imovel.setEndereco(dto.getEndereco());
        imovel.setValorAluguel(dto.getValorAluguel());
        imovel.setDescricao(dto.getDescricao());

        Imovel atualizado = repository.save(imovel);

        return toResponseDTO(atualizado);
    }

    public void deletar(Long id) {
        Imovel imovel = repository.findById(id)
                .orElseThrow(() -> new ImovelNaoEncontradoException(id));

        repository.deleteById(id);
    }

    public List<Imovel> buscarPorEndereco(String endereco) {
        return repository.findByEnderecoContainingIgnoreCase(endereco);
    }

    private Imovel toEntity(ImovelRequestDTO dto) {
        return new Imovel(
                null,
                dto.getEndereco(),
                dto.getValorAluguel(),
                dto.getDescricao()
        );
    }

    private ImovelResponseDTO toResponseDTO(Imovel imovel) {
        return new ImovelResponseDTO(
                imovel.getId(),
                imovel.getEndereco(),
                imovel.getValorAluguel()
        );
    }
}