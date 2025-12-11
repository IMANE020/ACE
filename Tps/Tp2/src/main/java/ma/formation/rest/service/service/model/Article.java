package ma.formation.rest.service.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Article implements Serializable {
    private Long id;
    private String description;
    private double price;
    private double quantity;

}

