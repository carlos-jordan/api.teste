package senappen.atic.api.atendimento;

import jakarta.validation.constraints.NotNull;

public record Dadosatualizacaoatendimento(
       @NotNull
        Long id,
        String nome,
        String requisição,
        String cargo,
        String setor) {

}
