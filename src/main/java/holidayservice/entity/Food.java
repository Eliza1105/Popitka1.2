package holidayservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "foods")
@Entity
@Getter
@Setter
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_food")
    private Integer id;
    @Column(name = "food_name")
    private String name;
    @Column(name = "food_description")
    private String description;
    @Column(name = "food_unit")
    private double unit;
    @Column(name = "food_image")
    private String image;

  /*  @OneToMany()
    @JoinColumn(name = "id_food")
    List<Marinades> marinades=new ArrayList<>();

   */
}
