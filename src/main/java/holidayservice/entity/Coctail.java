package holidayservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "coctails")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coctail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coctail")
    private Integer id;
    @Column(name = "coctail_name")
    private String name;
    @Column(name = "coctail_description")
    private String description;
    @Column(name = "coctail_image")
    private String link;
    @ManyToOne
    @JoinColumn(name = "id_alcohol", nullable = false)
    private Alcohol alcohol;

    @ManyToOne
    @JoinColumn(name = "id_alcoholfree", nullable = false)
    private AlcoholFree alcoholFree;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Alcohol getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Alcohol alcohol) {
        this.alcohol = alcohol;
    }

    public AlcoholFree getAlcoholFree() {
        return alcoholFree;
    }

    public void setAlcoholFree(AlcoholFree alcoholFree) {
        this.alcoholFree = alcoholFree;
    }
}
