package restaurant.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.CascadeType.MERGE;

@Entity
@Table(name = "cheques")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cheque {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cheque_seq")
    @SequenceGenerator(name = "cheque_seq", allocationSize = 1)
    private Long id;
    private BigDecimal priceAvg;
    private LocalDate createdAt;

    @ManyToMany(cascade = {DETACH, MERGE})
    private List<MenuItem> menuItems = new ArrayList<>();

    @ManyToOne(cascade = {DETACH})
    private User user;

    public void addMenuItem(MenuItem menuItem){
        if (this.menuItems == null) this.menuItems = new ArrayList<>();
        this.menuItems.add(menuItem);
    }
}
