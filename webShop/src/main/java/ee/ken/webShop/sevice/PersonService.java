package ee.ken.webShop.sevice;

import ee.ken.webShop.entity.Person;
import ee.ken.webShop.model.SignupResponse;
import ee.ken.webShop.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service

public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public SignupResponse checkIfAllCorrect(Person person, SignupResponse response) {
        if (person.email == null || person.email.isEmpty()){
            response.setSuccessful(false);
            response.setMessage("Sisestage e-mail!");
            return response;
        }
        if (!validate(person.email)){
            response.setSuccessful(false);
            response.setMessage("E-mail ei ole korrektsel kujul!");
            return response;
        }
        if (person.phone == null || person.phone.isEmpty()){
            response.setSuccessful(false);
            response.setMessage("Sisestage telefoni number!");
            return response;
        }
        if (personRepository.findByUsername(person.username) != null) {
            response.setSuccessful(false);
            response.setMessage("Kasutajanimi on juba olemas!");
            return response;
        }

        if (person.username == null || person.username.isEmpty()) {
            response.setSuccessful(false);
            response.setMessage("Kasutajanimi puudub!");
            return response;
        }
        return null;
    }

    public Long checkForErrorsAndGetId(Person person) {
        if (person.username == null) {
            throw new RuntimeException("Sisestage kasutajanimi!");
        }
        if (person.password == null) {
            throw new RuntimeException("Sisestage parool!");
        }
        if (personRepository.findByUsername(person.username) == null) {
            throw new RuntimeException("Kasutajanimes on viga");
        }
        Person dbPerson = personRepository.findByUsername(person.username);
        if (!dbPerson.password.equals(person.password)) {
            throw new RuntimeException("Parool on vale");
        }
        return dbPerson.id;
    }

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }
}
