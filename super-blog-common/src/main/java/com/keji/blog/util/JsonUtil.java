package com.keji.blog.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson 工具类
 *
 * @author wb-ny291824
 * @version $Id: JsonUtil.java, v 0.1 2018-03-21 15:41 wb-ny291824 Exp $$
 */
public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String object2Json(Object object) throws JsonProcessingException {
        return MAPPER.writeValueAsString(object);
    }

    public static <T> T json2Object(String json,Class<T> clazz) throws IOException {
        return MAPPER.readValue(json, clazz);
    }

    public static <T> List<T> json2List(String json,Class<T> clazz) throws IOException {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, clazz);
        return MAPPER.readValue(json, javaType);

    }


}
