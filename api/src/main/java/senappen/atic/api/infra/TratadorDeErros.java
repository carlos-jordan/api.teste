package senappen.atic.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity TratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();

         return ResponseEntity.badRequest().body(erros.stream().map(DadosErrovalidacao::new).toList());

    }


    private record DadosErrovalidacao(String campo, String mensagem){

        public DadosErrovalidacao(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
