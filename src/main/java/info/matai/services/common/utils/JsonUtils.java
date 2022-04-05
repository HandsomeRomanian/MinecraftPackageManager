package info.matai.services.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T parseJsonFromFile(File file, Class<T> expectedType) {
        final T object;
        try {
            object = mapper.readValue(file, expectedType);
        } catch (IOException e) {
            return null;
        }

        return object;
    }
}
