package app.car.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class TravelRequest {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    Passenger passenger;
    String origin;
    String Destination;

    @Enumerated(EnumType.STRING)
    TravelRequestStatus status;
    LocalDateTime creationDate;
}
