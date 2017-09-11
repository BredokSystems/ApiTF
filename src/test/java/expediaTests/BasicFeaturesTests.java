package expediaTests;

import Pages.Expedia;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class BasicFeaturesTests {

    Expedia expediaPage = new Expedia();

    @Test
    public void testStatuscode(){
        given().get(expediaPage.EXPEDIA_HOME_PAGE_URL).
        then().statusCode(200).contentType(ContentType.HTML);
    }
    @Test
    public void testExtractDetailsUsingResponse(){
       Response response = when().get(expediaPage.EXPEDIA_HOME_PAGE_URL).
                           then().extract().response();
        System.out.println("Content Type: "+response.getContentType());
        System.out.println("Href: "+response.path("url"));
        System.out.println("Status code: "+response.statusCode());
    }
    @Test
    public void testTopVacationRentals(){
        given().get(expediaPage.EXPEDIA_VACATION_RENTALS_URL).
                then().statusCode(200).log().all();
        //Response response = when().get(expediaPage.EXPEDIA_VACATION_RENTALS_URL).
                //then().extract().response();

        //System.out.println("Href: "+response.path("url"));
       // System.out.println("Status code: "+response.statusCode());
    }
}
