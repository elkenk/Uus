package ee.ken.salat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Toit {
    @Id
    String nimi;
    int kogus;
    // @OneToMany--> Ainult ühele
    //@ManyToMany--> Saab kasutada ka mujal
    @ManyToMany
    List<Toiduaine> toiduained;
}
