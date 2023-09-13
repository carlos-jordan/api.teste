package senappen.atic.api.atendimento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "atendimento")
@Entity(name = "atendimento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class atendimento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String nome;
    private String cargo;
    private String setor;
    private String requisição;

    private boolean ativo;


    public atendimento(Dadossolicitacaoatendimento dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.cargo = dados.cargo();
        this.setor = dados.setor();
        this.requisição = dados.requisição();
    }

    public void atualizarInformacoes(Dadosatualizacaoatendimento dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.requisição() != null){
            this.requisição = dados.requisição();
        }
        if(dados.cargo() != null){
            this.cargo = dados.cargo();
        }
        if(dados.setor() != null);{
            this.setor = dados.setor();

        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
