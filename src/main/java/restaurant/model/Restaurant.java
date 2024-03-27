package restaurant.model;

import jakarta.persistence.*;
import lombok.*;
import restaurant.model.enums.RestType;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
    @SequenceGenerator(name = "restaurant_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String location;
    @Enumerated(EnumType.STRING)
    private RestType restType;
    private int numberOfEmployees;
    private int service;

    @OneToMany(cascade = {PERSIST, REMOVE, MERGE}, mappedBy = "restaurant")
    private List<User> users;

    @OneToMany(cascade = {REMOVE, MERGE}, mappedBy = "restaurant")
    private List<MenuItem> menuItems;

    @OneToMany(cascade = {REMOVE}, mappedBy = "restaurant")
    private List<JobAdvertisement> jobAdvertisements;

    @OneToMany(cascade = {REMOVE}, mappedBy = "restaurant")
    private List<Category> categories;

    public void addUser(User user){
        if (this.users == null) this.users = new ArrayList<>();
        this.users.add(user);
    }

    public void addMenuItem(MenuItem menuItem){
        if (this.menuItems == null) this.menuItems = new ArrayList<>();
        this.menuItems.add(menuItem);
    }

    public void addJobApp(JobAdvertisement jobAdvertisement){
        if (this.jobAdvertisements == null) this.jobAdvertisements = new ArrayList<>();
        this.jobAdvertisements.add(jobAdvertisement);
    }
    public void addCategories(Category category){
        if (this.categories == null) this.categories = new ArrayList<>();
        this.categories.add(category);
    }
}
