package restaurant.model;

import jakarta.persistence.*;
import lombok.*;
import restaurant.model.enums.Role;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.DETACH;

@Entity
@Table(name = "job_advertisements")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_seq")
    @SequenceGenerator(name = "job_seq", allocationSize = 1)
    private Long id;
    private String lastName;
    private String firstName;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;
    private int experience;

    @ManyToOne(cascade = {DETACH})
    Restaurant restaurant;
}
