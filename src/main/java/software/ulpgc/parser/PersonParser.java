package software.ulpgc.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import software.ulpgc.model.Person;

import java.lang.reflect.Type;
import java.util.List;

public class PersonParser {

    private final Gson gson;

    public PersonParser() {
        this.gson = new Gson();
    }

    public List<Person> parse(String json) {

        Type type = new TypeToken<List<Person>>() {}.getType();

        return gson.fromJson(json, type);
    }
}
