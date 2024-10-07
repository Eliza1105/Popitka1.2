package holidayservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;

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
    @Lob
    @Column(name = "food_image")
    private byte[] image;

    public Food(Integer id, String name, String description, double unit, byte[] image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.image = image;
    }

    public String generateBase64Image(){
    return Base64.encodeBase64String(this.image);
}
  /*  @OneToMany()
    @JoinColumn(name = "id_food")
    List<Marinades> marinades=new ArrayList<>();

   */
}
