package ee.ken.auto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter

public class Toit {
    String nimi;
    int kogus;
    List<String> toiduained;
}
