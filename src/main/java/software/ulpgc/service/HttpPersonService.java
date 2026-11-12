package software.ulpgc.service;

import software.ulpgc.model.Person;
import software.ulpgc.parser.PersonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpPersonService implements PersonService {

    private final HttpClient client;
    private final PersonParser parser;
    private final String baseUrl;

    public HttpPersonService(String baseUrl, PersonParser parser) {
        this.client = HttpClient.newHttpClient();
        this.baseUrl = baseUrl;
        this.parser = parser;
    }

    @Override
    public List<Person> findAll() {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/users"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            if (response.statusCode() != 200) {
                throw new RuntimeException(
                        "Error HTTP: " + response.statusCode()
                );
            }

            return parser.parse(response.body());

        } catch (IOException e) {
            throw new RuntimeException(
                    "No se pudo conectar con el servicio HTTP.", e
            );
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(
                    "La petición HTTP fue interrumpida.", e
            );
        }
    }
}
