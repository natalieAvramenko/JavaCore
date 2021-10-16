package lesson6;

import okhttp3.*;

import java.io.IOException;

public class RestfulBookerExamples {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("restful-booker.herokuapp.com")
                .addPathSegment("auth")
                .build();

        String authBody = "{\n" +
                " \"username\" : \"admin\",\n" +
                " \"password\" : \"password123\"\n" +
                "}";

        RequestBody authRequestBody = RequestBody.create(authBody, MediaType.parse("JSON"));

        Request authRequest = new Request.Builder()
                .url(httpUrl)
                .addHeader("Content-Type", "application/json")
                .post(authRequestBody)
                .build();

        Response response = okHttpClient.newCall(authRequest).execute();

        System.out.println((response.isSuccessful()));
        String responseWithToken = response.body().string();

        System.out.println(responseWithToken);

        String token = responseWithToken.split(":")[1];
//        token = token.replace("\"", "");
//        token = token.replace("}", "");
        token = token.replace("[}\"]", "");
        System.out.println(token);

        String createBookingJson = "{\n" +
                "   \"firstname\" : \"Jim\",\n" +
                "   \"lastname\" : \"Brown\",\n" +
                "   \"totalprice\" : 111,\n" +
                "   \"depositpaid\" : true,\n" +
                "   \"bookingdates\" : {\n" +
                "       \"checkin\" : \"2018-01-01\",\n" +
                "       \"checkout\" : \"2019-01-01\"\n" +
                "   },\n" +
                "   \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RequestBody requestBody = RequestBody.create(createBookingJson, MediaType.parse("JSON"));

        Request request = new Request.Builder()
                .url("https://restful-booker.herokuapp.com/booking")
                .addHeader("Content-Type", "application/json")
                .addHeader("accept", "application/json")
                .addHeader("Cookie", String.format("token=%s", token))
                .post(requestBody)
                .build();

        Response response1 = okHttpClient.newCall(request).execute();

        System.out.println(response1.body().string());

    }
}
