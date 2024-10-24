package holidayservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "marinades")
public class Marinade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marinade")
    private Integer id;
    @Column(name = "marinade_name")
    private String name;
    @Column(name = "marinade_description")
    private String description;
    @Column(name = "marinade_image")
    private String link;
    @ManyToOne
    @JoinColumn(name = "id_food", nullable = false)
    private Food food;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
