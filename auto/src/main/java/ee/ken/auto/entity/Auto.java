package ee.ken.auto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public class Auto {
    String make;
    String model;
    int year;
    int price;
}
