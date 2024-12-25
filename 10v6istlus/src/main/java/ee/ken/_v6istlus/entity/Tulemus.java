package ee.ken._v6istlus.entity;

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

public class Tulemus {
    @Id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int tulemus;

    @ManyToOne
    Sportlane sportlane;
}
