package krishna.examples;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class ReqResTestExamples {

    @Test(priority = 1)
    public void testGetAllUsersPaged() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("data[0].id", equalTo(7))
                .body("data[0].first_name", equalTo("Michael"))
                .body("data[0].last_name", equalTo("Lawson"))
                .body("data[0].avatar", equalTo("https://reqres.in/img/faces/7-image.jpg"));
    }

    @Test(priority = 2)
    public void testGetAllUsersPagedDelayed() {
        given()
                .when()
                .get("https://reqres.in/api/users?delay=3")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("data[0].id", equalTo(1))
                .body("data[0].first_name", equalTo("George"))
                .body("data[0].last_name", equalTo("Bluth"))
                .body("data[0].avatar",equalTo("https://reqres.in/img/faces/1-image.jpg"))

                .time(lessThan(4000L));
    }

    @Test(priority = 3)
    public void testGetOnlyUser() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar",equalTo("https://reqres.in/img/faces/2-image.jpg"));

    }

    @Test
    public void testPostRegisterUser() {
        final String json = "{\"email\": \"sydney@fife\", \"password\": \"pistol\"}";

        given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(400)
                .contentType("application/json")
                .body("token", equalTo(null));
    }

    @Test
    public void testPostRegisterUserUnsuccessful() {
        final String json = "{\"email\": \"sydney@fife\"}";

        given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(400)
                .contentType("application/json")
                .body("error", equalTo("Missing password"));
    }

    @Test(priority = 4)
    public void testGetSingleUserNotFound() {
        given()
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .statusCode(404);

    }
    @Test(priority = 5)
    public void testGetApiUnknown() {
        given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .statusCode(200)
                .body("data[0].id", equalTo(1))
                .body("data[0].name", equalTo("cerulean"))
                .body("data[0].year", equalTo(2000))
                .body("data[0].color", equalTo("#98B2D1"))
                .body("data[0].pantone_value", equalTo("15-4020"));

    }
    @Test(priority = 6)
    public void testGetApiSingleOnlyUnknown() {
        given()
                .when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.name", equalTo("fuchsia rose"))
                .body("data.year", equalTo(2001))
                .body("data.color", equalTo("#C74375"))
                .body("data.pantone_value", equalTo("17-2031"));

    }
    @Test(priority = 7)
    public void testGetApiSingleOnlyUnknownNotFound() {
        given()
                .when()
                .get("https://reqres.in/api/unknown/23")
                .then()
                .statusCode(404);
    }
    @Test
    public void testPostCreate() {
        final String json = "{\"name\": \"morpheus\", \"job\": \"leader\"}";

        given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .contentType("application/json")
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));
    }
    @Test
    public void testPutUpdate() {
        final String json = "{\"name\": \"Krishna\", \"job\": \"Software Developer\"}";

        given()
                .contentType("application/json")
                .body(json)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("name", equalTo("Krishna"))
                .body("job", equalTo("Software Developer"))
                .log().all();
    }
    @Test
    public void testPatch() {
        final String json = "{\"name\": \"morpheus\", \"job\": \"zion resident\"}";

        given()
                .contentType("application/json")
                .body(json)
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion resident"));
    }
    @Test
    public void testDelete() {
        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204);
    }
    @Test
    public void testLoginSuccessful() {
        final String json = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";

        given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }
    @Test
    public void testLoginUnsuccessful() {
        final String json = "{\"email\": \"peter@klaven\"}";

        given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(400)
                .contentType("application/json")
                .body("error", equalTo("Missing password"));
    }

}
