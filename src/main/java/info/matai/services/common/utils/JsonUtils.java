package info.matai.services.common.utils;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JsonUtils {

    public static <T> T parseJsonFromFile(File file, Class<T> expectedType) {
        final T object;
        try {
            object = getMapper().readValue(file, expectedType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return object;
    }

    private static ObjectMapper getMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);

        return mapper;
    }
}
