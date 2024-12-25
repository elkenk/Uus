package ee.ken.webShop.model;

import lombok.Data;

import java.util.Date;

@Data //Kui ei lähe andmebaasi siis on @Data, kui läheb siis @Entity

public class LoginResponse {
    String token;
    Date expiration;

    public Date getExpiration() {
        return expiration;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}
