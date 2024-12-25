package ee.ken.webShop.exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice // <-- Igakord kui juhtub controlleris error(exeption) siis pannakse veateade

public class ExeptionCatcher {

    @ExceptionHandler // Kui juhtub RunTime exeption mõnes kontrolleris siis tagastakse hoopis error message
    public ResponseEntity<ErrorMessage> handleExeption(RuntimeException e) {
        ErrorMessage message = new ErrorMessage();
        message.setDate(new Date());
        message.setCode("400"); // 400 on üldine viga
        message.setMessage(e.getMessage()); // message tuleb see mis on controlleris: throw new RunTimeExeptoin("SIIN SEES ON")
        return ResponseEntity.badRequest().body(message);
    }
}
