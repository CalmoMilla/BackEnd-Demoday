package com.calmomilla.api.dto.input.endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizarEnderecoInput {

    @NotBlank
    private String id;

    @NotBlank
    private String cep;

    @NotBlank
    private String bairro;

    @NotBlank
    private String localidade;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;

    @NotBlank
    private String uf;

}
