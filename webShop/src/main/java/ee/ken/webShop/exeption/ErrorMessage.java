package ee.ken.webShop.exeption;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorMessage {
    String message;
    String code;  // 400, 404 vüi mis koodi veaks annab
    Date date;

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
