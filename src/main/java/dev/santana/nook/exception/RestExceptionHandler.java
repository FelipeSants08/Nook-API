package dev.santana.nook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(IdNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail idNaoEncontrado(IdNaoEncontradoException e){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), e.getMessage());
        problemDetail.setTitle("Problema ao buscar ID");
        problemDetail.setProperty("timestamp", LocalDateTime.now().toString());
        problemDetail.setProperty("ajuda", "Verifique o ID que foi colocado");
        return problemDetail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail methodArgumentNotValid(MethodArgumentNotValidException e){
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Um ou mais campos estão inválidos.");
        problem.setTitle("Erro de validação");

        List<ValidationErrorMensage> errors =  e.getFieldErrors().stream()
                    .map(ValidationErrorMensage::new)
                    .toList();

        problem.setProperty("errors", errors);
        return problem;
    }

    @ExceptionHandler(ConflitoReservaException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ProblemDetail conflitoReserva(ConflitoReservaException ex){

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT, ex.getMessage());

        problemDetail.setTitle("Conflito de Agendamento");



        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setProperty("ajuda", "Verifique se a sala já não está ocupada no horário escolhido.");

        return problemDetail;
    }

}
