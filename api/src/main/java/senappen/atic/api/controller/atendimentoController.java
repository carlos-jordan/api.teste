package senappen.atic.api.controller;



import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import senappen.atic.api.atendimento.*;



@RestController
@RequestMapping("atendimento")
public class atendimentoController {

    @Autowired
    private atendimentoRepository repository;




    @PostMapping
    @Transactional
    public ResponseEntity cadastrar (@RequestBody @Valid Dadossolicitacaoatendimento dados, UriComponentsBuilder uriBuilder) {
        var atendimento = new atendimento(dados);
        repository.save(atendimento);

        var uri = uriBuilder.path("/atendimento/{id}").buildAndExpand(atendimento.getId()).toUri();

        return ResponseEntity.created(uri).body(new Dadosdetalhadosatendimento(atendimento));

    }


    @GetMapping
    public ResponseEntity<Page<DadoslistagemAtendimento>> listar(@PageableDefault(size = 10) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadoslistagemAtendimento::new);
        return ResponseEntity.ok(page);
    }



    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid Dadosatualizacaoatendimento dados){
        var atendimento = repository.getReferenceById(dados.id());
        atendimento.atualizarInformacoes(dados);

        return ResponseEntity.ok(new Dadosdetalhadosatendimento(atendimento));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var atendimento = repository.getReferenceById(id);
        atendimento.excluir();

        return ResponseEntity.noContent().build();

    }


    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var atendimento = repository.getReferenceById(id);
        return ResponseEntity.ok(new Dadosdetalhadosatendimento(atendimento));

    }


}








