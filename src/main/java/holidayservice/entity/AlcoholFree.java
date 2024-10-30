package holidayservice.entity;

import holidayservice.entity.Coctail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "alcoholfrees")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlcoholFree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alcoholfree")
    private Integer id;
    @Column(name = "alcoholfree_name")
    private String name;
    @Column(name = "alcoholfree_description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "alcoholfree_unit")
    private double unit;
    @Column(name = "alcoholfree_image")
    private String link;

    @OneToMany(mappedBy = "alcoholFree", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coctail> coctails=new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Coctail> getCoctails() {
        return coctails;
    }

    public void setCoctails(List<Coctail> coctails) {
        this.coctails = coctails;
    }
}
