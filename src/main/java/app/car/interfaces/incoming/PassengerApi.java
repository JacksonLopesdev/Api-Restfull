package app.car.interfaces.incoming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import app.car.domain.Passenger;
import app.car.domain.PassengerRepository;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import org.springframework.http.MediaType;

@Service
@RestController
@RequestMapping(path="/passengers", produces = MediaType.APPLICATION_JSON_VALUE)
public class PassengerApi {

    @Autowired
    PassengerRepository passengerRepository;

    @GetMapping()
    public List<Passenger> listPassengers() {
        return passengerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Passenger findPassenger(@PathVariable("id")Long id) {
        return passengerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @PutMapping("/{id}")
    public Passenger fullUpdatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger) {
        Passenger pass = findPassenger(id);
        pass.setName(passenger.getName());
        return passengerRepository.save(pass);
    }

    @PatchMapping("/{id}")
    public Passenger incrementalUpdatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger) {
        Passenger foundPassenger = findPassenger(id);
        foundPassenger.setName(Optional.ofNullable(passenger.getName()).orElse(foundPassenger.getName()));
        return passengerRepository.save(findPassenger(id));
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable("id") Long id) {
        passengerRepository.delete(findPassenger(id));
    }
}
