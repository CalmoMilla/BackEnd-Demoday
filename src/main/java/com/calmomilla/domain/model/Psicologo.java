package com.calmomilla.domain.model;

import com.calmomilla.domain.utils.ListToStringConverter;
import com.calmomilla.domain.utils.enums.Especializacoes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Psicologo extends Usuario{

    @ElementCollection
    private List<Especializacoes> especializacoes;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @NotBlank
    private String numeroRegistro;

    @Convert(converter = ListToStringConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<String> servicosOferecidos;

    @ManyToMany
    private List<Paciente> pacientes;

    @OneToMany(mappedBy = "autor")
    @JsonIgnore
    private List<Blog> postagem;

}
