package senappen.atic.api.atendimento;

public record Dadosdetalhadosatendimento(Long id, String nome, String cargo, String setor, String requisição) {

public Dadosdetalhadosatendimento(atendimento atendimento){
    this(atendimento.getId(), atendimento.getNome(),atendimento.getCargo(), atendimento.getSetor(),atendimento.getRequisição() );
}

}
