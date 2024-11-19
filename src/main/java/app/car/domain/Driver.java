package app.car.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Driver {

    @Id
    @GeneratedValue
    Long id;
    String name;
    Date birthDate;
}
