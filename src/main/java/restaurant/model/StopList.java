package restaurant.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.CascadeType.MERGE;

@Entity
@Table(name = "stop-lists")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StopList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stop_seq")
    @SequenceGenerator(name = "stop_seq", allocationSize = 1)
    private Long id;
    private String reason;
    private LocalDate date;

    @OneToOne(cascade = {DETACH, MERGE})
    private MenuItem menuItem;
}
