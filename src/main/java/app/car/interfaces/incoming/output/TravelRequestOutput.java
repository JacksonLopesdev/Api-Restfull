package app.car.interfaces.incoming.output;

import app.car.domain.TravelRequestStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class TravelRequestOutput {

    Long id;
    String origin;
    String destination;
    TravelRequestStatus status;
    LocalDateTime creationDate;


}