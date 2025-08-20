package io.github.kiber2009.yesnoapi.serialization;

import com.google.gson.*;
import io.github.kiber2009.yesnoapi.Answer;

import java.lang.reflect.Type;

public final class AnswerJsonSerializer implements JsonSerializer<Answer>, JsonDeserializer<Answer> {
    @Override
    public Answer deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        final String string = jsonElement.getAsString();

        for (final Answer answer : Answer.values()) if (answer.getValue().equalsIgnoreCase(string)) return answer;

        throw new JsonParseException("Unknown enum value: " + string);
    }

    @Override
    public JsonElement serialize(final Answer answer, final Type type, final JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(answer.getValue());
    }
}
