CREATE TABLE fotos (
    id BIGSERIAL PRIMARY KEY,
    imovel_id BIGINT NOT NULL REFERENCES imoveis(id),
    url VARCHAR(255) NOT NULL,
    legenda VARCHAR(500),
    principal BOOLEAN DEFAULT FALSE
);
