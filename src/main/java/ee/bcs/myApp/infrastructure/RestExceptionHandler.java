package ee.bcs.myApp.infrastructure;

import ee.bcs.myApp.infrastructure.error.ApiError;
import ee.bcs.myApp.infrastructure.error.MyAppError;
import ee.bcs.myApp.infrastructure.exception.SomeBusinessException;
import ee.bcs.myApp.infrastructure.exception.DataNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<MyAppError> handleDataNotFoundException(DataNotFoundException exception) {
        MyAppError myAppError = new MyAppError();
        myAppError.setMessage(exception.getMessage());
        myAppError.setErrorCode(exception.getErrorCode());
        return new ResponseEntity<>(myAppError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<MyAppError> handleBankServiceException(SomeBusinessException exception) {
        MyAppError myAppError = new MyAppError();
        myAppError.setMessage(exception.getMessage());
        myAppError.setErrorCode(exception.getErrorCode());
        return new ResponseEntity<>(myAppError, HttpStatus.FORBIDDEN);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        final List<String> errors = new ArrayList<>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Not valid request body", errors);
        return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
    }
}
