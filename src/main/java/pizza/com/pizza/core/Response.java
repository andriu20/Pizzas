package pizza.com.pizza.core;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public class Response<T> {
    private boolean success;
    private String message;
    private T body;

    public Response(boolean success, String message, T body) {
        this.success = success;
        this.message = message;
        this.body = body;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    // Método para generar una respuesta de éxito.
    public static <T> ResponseEntity<Response<T>> successResponse(String message, T body) {
        return ResponseEntity.ok(new Response<>(true, message, body));
    }
    // Método para generar una respuesta de error personalizado.

    @SuppressWarnings("unchecked")
    public static <T> ResponseEntity<Response<T>> errorResponse(String message, Map<String, String> errors) {
        System.out.println("**** Entrando en errorResponse ****");
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", message);
        responseBody.put("errors", errors);
        return ResponseEntity.badRequest().body(new Response<>(false, "Error en la operación", (T) responseBody));
    }

}
