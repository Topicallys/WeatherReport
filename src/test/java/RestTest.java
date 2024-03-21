import io.restassured.http.ContentType;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static io.restassured.RestAssured.given;

public class RestTest {
    @Test
    public void getWeather(){


        double temp = given()
                .contentType(ContentType.JSON)
                .when().get("https://api.openweathermap.org/data/2.5/weather?lat=59.57&lon=30.19&appid=c47a9c64f44fb78b1d284a5b3d266493")
                .then()
                .statusCode(200)
                .extract().jsonPath().getDouble("main.temp");

        double feels_like = given()
                .contentType(ContentType.JSON)
                .when().get("https://api.openweathermap.org/data/2.5/weather?lat=59.57&lon=30.19&appid=c47a9c64f44fb78b1d284a5b3d266493")
                .then()
                .statusCode(200)
                .extract().jsonPath().getDouble("main.feels_like");

        int humidity = given()
                .contentType(ContentType.JSON)
                .when().get("https://api.openweathermap.org/data/2.5/weather?lat=59.57&lon=30.19&appid=c47a9c64f44fb78b1d284a5b3d266493")
                .then()
                .statusCode(200)
                .extract().jsonPath().getInt("main.humidity");

        int pressure = given()
                .contentType(ContentType.JSON)
                .when().get("https://api.openweathermap.org/data/2.5/weather?lat=59.57&lon=30.19&appid=c47a9c64f44fb78b1d284a5b3d266493")
                .then()
                .statusCode(200)
                .extract().jsonPath().getInt("main.pressure");

        double windSpeed = given()
                .contentType(ContentType.JSON)
                .when().get("https://api.openweathermap.org/data/2.5/weather?lat=59.57&lon=30.19&appid=c47a9c64f44fb78b1d284a5b3d266493")
                .then()
                .statusCode(200)
                .extract().jsonPath().getDouble("wind.speed");

        String description = given()
                .contentType(ContentType.JSON)
                .when().get("https://api.openweathermap.org/data/2.5/weather?lat=59.57&lon=30.19&appid=c47a9c64f44fb78b1d284a5b3d266493")
                .then()
                .statusCode(200)
                .extract().jsonPath().getString("weather.description");

        int dt = given()
                .contentType(ContentType.JSON)
                .when().get("https://api.openweathermap.org/data/2.5/weather?lat=59.57&lon=30.19&appid=c47a9c64f44fb78b1d284a5b3d266493")
                .then()
                .statusCode(200)
                .extract().jsonPath().getInt("dt");

        long timestamp = Long.parseLong(String.valueOf(dt)) * 1000;

        SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy'г. |' h:mm a");
        String datetime = sdf.format(timestamp);


        System.out.println("Погода в Санкт-Петербурге");
        System.out.println("-------------------------");
        System.out.println("Температура: " + Math.round(temp-273.15) + "°C");
        System.out.println("Ощущается как: " + Math.round(feels_like-273.15) + "°C");
        System.out.println("Влажность: " + humidity + "%");
        System.out.println("Атмосферное давление: " + pressure + " гПа");
        System.out.println("Ветер: " + windSpeed + " м/с");
        System.out.println("Описание погоды: " + description.substring(1, description.length() - 1));
        System.out.println("Дата и время: " + datetime);

    }

}
