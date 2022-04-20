package ee.bcs.myApp.infrastructure;


import ee.bcs.myApp.infrastructure.error.ApiError;
import ee.bcs.myApp.infrastructure.exception.BusinessException;
import ee.bcs.myApp.infrastructure.exception.DataNotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

// See annotatsioon loob võimekuse kuulata pealt vigu
// ja siis klassis saame ära defineerida, et mis täpsemalt edasi peab nende vigadega toimuma.
// See enda loodud 'RestExceptionHandler' klass laiendab ResponseEntityExceptionHandler klassi
// Sellega saadakse ResponseEntityExceptionHandler klassi omadused
// Saame näiteks Override'da (üle kirjutada) mingid meetodid, mis on selles ResponseEntityExceptionHandler klassis,
// see tähendab, et saame ise kirjeldada, et mis peaks toimuma, kui need meetodid välja kutsutakse.
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // Selle annotatsiooniga, saame anda märku, et me soovime mingit tüüpi vea (DataNotFoundException) käsitlust teha.
    // Kogu see meetod on enda loodud.
    // Siin me händlime enda loodud/väljamõeldud vigu
    @ExceptionHandler
    public ResponseEntity<ApiError> handleDataNotFoundException(DataNotFoundException exception) {
        ApiError apiError = new ApiError();
        apiError.setTitle(exception.getTitle());
        apiError.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiError.setDetail(exception.getDetail());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }


    // Selle annotatsiooniga, saame anda märku, et me soovime mingit tüüpi vea (BusinessException) käsitlust teha.
    // kogu see meetod on enda loodud.
    // Siin me händlime enda loodud/väljamõeldud vigu
    @ExceptionHandler
    public ResponseEntity<ApiError> handleBusinessException(BusinessException exception) {
        ApiError apiError = new ApiError();
        apiError.setTitle(exception.getTitle());
        apiError.setStatusCode(HttpStatus.FORBIDDEN.value());
        apiError.setDetail(exception.getDetail());
        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }


    // Override'me handleHttpMessageNotReadable meetodi, mis on selles ResponseEntityExceptionHandler klassis.
    // See tähendab, et saame ise kirjeldada, et mis peaks toimuma, kui kusagil visatakse ülesse 'HttpMessageNotReadableException' tüüpi viga.
    // Mõte on see, et kui muidu läheks käima handleHttpMessageNotReadable() meetod, mis on selle 'ResponseEntityExceptionHandler' klassi sees,
    // siis nüüd läheb käima hoopis see all-olev meetod.
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTitle("Invalid request body content.");
        apiError.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiError.setDetail(exception.getMessage());
        return handleExceptionInternal(exception, apiError, headers, HttpStatus.BAD_REQUEST, request);
    }

    // Override'me handleTypeMismatch meetodi, mis on selles ResponseEntityExceptionHandler klassis.
    // See tähendab, et saame ise kirjeldada, et mis peaks toimuma, kui kusagil visatakse ülesse 'TypeMismatchException' tüüpi viga.
    // Mõte on see, et kui muidu läheks käima handleTypeMismatch() meetod, mis on selle 'ResponseEntityExceptionHandler' klassi sees,
    // siis nüüd läheb käima hoopis see all-olev meetod.
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTitle("Invalid parameter type.");
        apiError.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiError.setDetail(exception.getMessage());
        return handleExceptionInternal(exception, apiError, headers, HttpStatus.BAD_REQUEST, request);
    }


    // Override'me handleMethodArgumentNotValid meetodi, mis on selles ResponseEntityExceptionHandler klassis.
    // See tähendab, et saame ise kirjeldada, et mis peaks toimuma, kui kusagil visatakse ülesse 'MethodArgumentNotValidException' tüüpi viga.
    // Mõte on see, et kui muidu läheks käima handleMethodArgumentNotValid() meetod, mis on selle 'ResponseEntityExceptionHandler' klassi sees,
    // siis nüüd läheb käima hoopis see all-olev meetod.
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException exception, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTitle("Invalid request body content.");
        apiError.setStatusCode(HttpStatus.BAD_REQUEST.value());
        final List<String> errors = new ArrayList<>();
        for (final FieldError error : exception.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : exception.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        apiError.setDetail(errors.toString());
        return handleExceptionInternal(exception, apiError, headers, HttpStatus.BAD_REQUEST, request);
    }

}
