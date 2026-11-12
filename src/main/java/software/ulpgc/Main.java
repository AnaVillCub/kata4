package software.ulpgc;

import software.ulpgc.model.Person;
import software.ulpgc.parser.PersonParser;
import software.ulpgc.service.HttpPersonService;
import software.ulpgc.service.PersonService;
import software.ulpgc.view.Console;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String baseUrl = "https://jsonplaceholder.typicode.com";

        PersonParser parser = new PersonParser();

        PersonService service =
                new HttpPersonService(baseUrl, parser);

        Console console = new Console();

        List<Person> people = service.findAll();

        console.display(people);
    }
}
