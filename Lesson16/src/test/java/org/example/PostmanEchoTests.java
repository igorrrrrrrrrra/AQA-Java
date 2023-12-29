package org.example;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTests {

    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testGetRequest() {
        given()
                .when()
                .get(BASE_URL + "/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostRequest() {
        Person person = new Person(1,"Igor");

        given()
                .header("Content-Type", "application/json")
                .body(person)
                .when()
                .post(BASE_URL + "/post")
                .then()
                .statusCode(200)
                .body("json.id", equalTo(person.getId()))
                .body("json.name", equalTo(person.getName()));
    }

    @Test
    public void testPutRequest() {
        Person person = new Person(1, "Igor");

        given()
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("id", person.getId())
                .formParam("name", person.getName())
                .when()
                .put(BASE_URL + "/put")
                .then()
                .log().all()
                .statusCode(200)
                .body("form.id", equalTo("1"))
                .body("form.name", equalTo("Igor"));
    }

    @Test
    public void testDeleteRequest() {
        given()
                .when()
                .delete(BASE_URL + "/delete")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPatchRequest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .param("1", "Nick")
                .param("2", "Michail")
                .when()
                .patch("https://postman-echo.com/patch")
                .then()
                .log().all()
                .statusCode(200);
    }

    public static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
