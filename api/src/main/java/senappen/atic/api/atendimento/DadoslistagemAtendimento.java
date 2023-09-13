package senappen.atic.api.atendimento;

public record DadoslistagemAtendimento(Long id, String nome, String cargo, String setor, String requisição) {

    public DadoslistagemAtendimento(atendimento atendimento){
        this(atendimento.getId(),atendimento.getNome(), atendimento.getCargo(), atendimento.getSetor(), atendimento.getRequisição());

    }


}


