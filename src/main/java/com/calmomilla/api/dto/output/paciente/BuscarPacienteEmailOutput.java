package com.calmomilla.api.dto.output.paciente;

import com.calmomilla.domain.utils.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuscarPacienteEmailOutput {

    private String id;
    private String email;
    private String nome;
    private String foto;
    private UserRole role;

}
