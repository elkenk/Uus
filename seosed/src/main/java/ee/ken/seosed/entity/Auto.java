package ee.ken.seosed.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String mark;
    double pikkus;
    int mass;
    int aasta;

    //@OnetoOne --> Omanikul ei tohi olla rohkem kui üks auto
    //@ManytoOne --> Omaniku klassil võib olla mitu autot

    //@OneToMany --> Peab olema List tüübiks
    //@ManytoMany -->       --//--

    @ManyToOne
    Omanik omanik;
}
