package ifrn.nc.sigaai.servicoimoveis.exception;

public class FotoNaoEncontradaException extends RuntimeException {
    public FotoNaoEncontradaException(Long id) {
        super("Foto não encontrada: " + id);
    }
}