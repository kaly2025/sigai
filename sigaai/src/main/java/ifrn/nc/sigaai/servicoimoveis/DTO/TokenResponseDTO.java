package ifrn.nc.sigaai.servicoimoveis.DTO;

public class TokenResponseDTO {
    private final String token;
    private final String type;

    public TokenResponseDTO(String token, String type) {
        this.token = token;
        this.type = type;
    }
    public String getToken() {
        return token;
    }
    public String getType() {
        return type;
    }
}