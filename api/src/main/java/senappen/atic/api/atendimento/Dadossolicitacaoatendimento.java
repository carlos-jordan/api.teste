package senappen.atic.api.atendimento;

import jakarta.validation.constraints.NotBlank;


public record Dadossolicitacaoatendimento(
        @NotBlank
        String nome,
        @NotBlank
        String cargo,
        String setor,
        @NotBlank
        String requisição) {
}



