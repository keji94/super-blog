package com.keji.blog.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson 工具类
 *
 * @author wb-ny291824
 * @version $Id: JsonUtil.java, v 0.1 2018-03-21 15:41 wb-ny291824 Exp $$
 */
public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String object2Json(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static <T> T json2Object(String json,Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }

}
