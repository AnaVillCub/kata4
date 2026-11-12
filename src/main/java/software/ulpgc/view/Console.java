package software.ulpgc.view;

import software.ulpgc.model.Person;

import java.util.List;

public class Console {

    public void display(List<Person> people) {

        System.out.println("=== PERSONAS OBTENIDAS ===");

        for (Person person : people) {
            System.out.println("ID: " + person.getId());
            System.out.println("Nombre: " + person.getName());
            System.out.println("Usuario: " + person.getUsername());
            System.out.println("Email: " + person.getEmail());
            System.out.println("-------------------------");
        }

        System.out.println("Total de personas: " + people.size());
    }
}
