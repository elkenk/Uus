package ee.ken.webShop.entity;

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

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public double price;
    public String description;

    @ManyToOne // Ühe kategooria all saab olla mitu toodet.
    public Category category;

    public String image;
    public boolean active;

    @OneToOne(cascade = CascadeType.ALL) // Kõik liikumised Ratinguga (lisamine,kustutamine) toimuvad koos tootega. Kui kaob toode kaob ka rating.
    public Rating rating;
}
