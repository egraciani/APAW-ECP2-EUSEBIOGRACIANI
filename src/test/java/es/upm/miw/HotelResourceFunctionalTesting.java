package es.upm.miw;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.api.resources.HotelResource;
import es.upm.miw.api.resources.ReservationResource;
import es.upm.miw.http.HttpClientService;
import es.upm.miw.http.HttpException;
import es.upm.miw.http.HttpMethod;
import es.upm.miw.http.HttpRequest;
import es.upm.miw.http.HttpRequestBuilder;

public class HotelResourceFunctionalTesting {

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private void createHotel() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(HotelResource.THEMES).body("uno").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateHotel() {
        this.createHotel();
    }

    @Test(expected = HttpException.class)
    public void testCreateHotelNameEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(HotelResource.THEMES).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateWithoutHotelName() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(HotelResource.THEMES).build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testReadHotel() {
        this.createHotel();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(HotelResource.THEMES).path(HotelResource.ID)
                .expandPath("1").build();
        assertEquals("{\"id\":1,\"name\":\"uno\"}", new HttpClientService().httpRequest(request).getBody());

    }

    @Test
    public void testHotelList() {
        this.createHotel();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(HotelResource.HOTELS).build();
        assertEquals("[{\"id\":1,\"name\":\"uno\"}]", new HttpClientService().httpRequest(request).getBody());
    }

    @Test
    public void testHotelListEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(HotelResource.HOTELS).build();
        assertEquals("[]", new HttpClientService().httpRequest(request).getBody());
    }

    @Test
    public void testHotelOverage() {
        this.createHotel();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ReservationResource.RESERVATIONS).body("1:4").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(ReservationResource.VOTES).body("1:5").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(HotelResource.THEMES).path(HotelResource.ID_OVERAGE).expandPath("1")
                .build();
        assertEquals("4.5", new HttpClientService().httpRequest(request).getBody());
    }

    @Test
    public void testHotelOverageWithoutReservation() {
        this.createHotel();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(HotelResource.THEMES).path(HotelResource.ID_OVERAGE)
                .expandPath("1").build();
        assertEquals("NaN", new HttpClientService().httpRequest(request).getBody());
    }

    @Test(expected = HttpException.class)
    public void testHotelOverageHotelIdNotFound() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(HotelResource.HOTELS).path(HotelResource.ID_OVERAGE)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testHotelReservations() {
        this.createHotel();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ReservationResource.RESERVATIONS).body("1:4").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(ReservationResource.RESERVATIONS).body("1:5").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(HotelResource.HOTELS).path(HotelResource.ID_RESERVATIONS).expandPath("1")
                .build();
        assertEquals("{{\"id\":1,\"name\":\"uno\"},[4, 5]}", new HttpClientService().httpRequest(request).getBody());
    }

    @Test(expected = HttpException.class)
    public void testHotelReservationsHotelIdNotFound() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(HotelResource.HOTELS).path(HotelResource.ID_OVERAGE)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }

}
