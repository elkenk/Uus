package ee.ken.auto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor


public class Personal {
    String eesnimi;
    String perenimi;
    int vanus;
    String elukoht;
}
