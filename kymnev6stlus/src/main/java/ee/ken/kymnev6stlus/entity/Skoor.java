package ee.ken.kymnev6stlus.entity;

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

public class Skoor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int skoor;

    @ManyToOne
    Mangija mangija;
}
