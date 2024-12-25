package ee.ken.webShop.controller;

import ee.ken.webShop.entity.Person;
import ee.ken.webShop.model.LoginResponse;
import ee.ken.webShop.model.SignupResponse;
import ee.ken.webShop.repository.PersonRepository;
import ee.ken.webShop.sevice.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

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
        personService.checkForErrors(person);
        LoginResponse response = new LoginResponse();
        response.setExpiration(new Date());
        response.setToken("Base-64-kujul-tähed-ja-numbrid");
        return response;
    }
}
