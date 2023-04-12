package icu.zheteng;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * @author yancy
 * @date 2023年04月11日
 */

public class Http2ClientTest {

    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://http2.pro/api/v1"))
                .GET()
                .build();
        CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        responseFuture.thenAccept(response -> {
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());
        }).join();
    }
}
