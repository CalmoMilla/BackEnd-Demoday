package com.calmomilla.api.dto.output.tarefa;


import com.calmomilla.domain.model.Rotina;
import com.calmomilla.domain.utils.enums.CategoriaTarefa;
import com.calmomilla.domain.utils.enums.Focos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class CadastroTarefaOutput {

    private String id;

    private String titulo;

    private String link;

    private boolean status;

    private CategoriaTarefa categoriaTarefa;

    private List<Focos> focos;

}
