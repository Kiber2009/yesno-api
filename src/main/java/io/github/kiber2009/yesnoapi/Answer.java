package io.github.kiber2009.yesnoapi;

import com.google.gson.annotations.JsonAdapter;
import io.github.kiber2009.yesnoapi.serialization.AnswerJsonSerializer;

@JsonAdapter(AnswerJsonSerializer.class)
public enum Answer {
    YES("yes"),
    NO("no"),
    MAYBE("maybe");

    private final String value;

    Answer(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
