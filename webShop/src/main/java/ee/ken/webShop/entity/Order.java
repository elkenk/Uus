package ee.ken.webShop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders") //Tabeli nime vahetuseks
@SequenceGenerator(name = "seq", initialValue = 1020030000, allocationSize = 1)

public class Order { //Order tabel on PostgreSQL sees reserveeritud. User tabel ka
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    public Long id;
    public Date created;
    public double totalSum;

    @ManyToOne
    public Person orderer;

    @OneToMany(cascade = CascadeType.ALL)
    public List<OrderRow> orderRows;
}
