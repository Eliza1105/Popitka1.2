package holidayservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Transient;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private Integer id;
    private String name;
    private String description;
    private double unit;
    @Transient
    private String image;
}
