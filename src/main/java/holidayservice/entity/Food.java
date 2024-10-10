package holidayservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "foods")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private String link;

  /*  @OneToMany()
    @JoinColumn(name = "id_food")
    List<Marinades> marinades=new ArrayList<>();

   */
}


