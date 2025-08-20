package io.github.kiber2009.yesnoapi;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public record YesNo(Answer answer, boolean forced, URL image) {
    private static final String BASE_URL = "https://yesno.wtf/api";
    private static final String FORCE_URL = BASE_URL + "?force=";
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public static YesNo get() throws IOException, InterruptedException {
        return GSON.fromJson(HTTP_CLIENT.send(HttpRequest.newBuilder(URI.create(BASE_URL)).build(),
                HttpResponse.BodyHandlers.ofString()).body(), YesNo.class);
    }

    public static YesNo get(final Answer forced) throws IOException, InterruptedException {
        return GSON.fromJson(HTTP_CLIENT.send(HttpRequest.newBuilder(URI.create(FORCE_URL +
                        URLEncoder.encode(forced.getValue(), StandardCharsets.UTF_8))).build(),
                HttpResponse.BodyHandlers.ofString()).body(), YesNo.class);
    }
}
