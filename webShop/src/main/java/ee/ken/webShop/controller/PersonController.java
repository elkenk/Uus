package ee.ken.webShop.controller;

import ee.ken.webShop.entity.Person;
import ee.ken.webShop.model.LoginResponse;
import ee.ken.webShop.model.SignupResponse;
import ee.ken.webShop.repository.PersonRepository;
import ee.ken.webShop.sevice.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")

public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonService personService;
    // Controllerisse ei panda funktsioone milel pole getMapping, PutMapping Post...jne...
    @PostMapping("signup")
    public SignupResponse signup(@RequestBody Person person) {
        SignupResponse response = new SignupResponse();

        SignupResponse errorResponse = personService.checkIfAllCorrect(person, response);
        if (errorResponse != null) return errorResponse;

        personRepository.save(person);
            response.setMessage("Registreerimine õnnestus!");
            response.setSuccessful(true);
            return response;
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody Person person) {
        Long id = personService.checkForErrorsAndGetId(person);

        LoginResponse response = new LoginResponse();
        response.setExpiration(new Date());
        response.setToken(id.toString()); //TODO : Hiljem tagastada õige token mille sees on ID peidetud
        return response;
    }

    @GetMapping("person")
    public Person getPerson(@RequestParam Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    @PutMapping ("person")
    public Person editPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }
}
