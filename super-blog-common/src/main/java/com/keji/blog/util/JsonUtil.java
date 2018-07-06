package com.keji.blog.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jackson 工具类
 *
 * @author wb-ny291824
 * @version $Id: JsonUtil.java, v 0.1 2018-03-21 15:41 wb-ny291824 Exp $$
 */
public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

        private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);


    public static String object2Json(Object object) {

        try {
            return MAPPER.writeValueAsString(object);
        }catch (JsonProcessingException e){
            LogUtil.warn(LOGGER,e,"[JsonUtil#object2Json]解析json发生错误。object=%s",object);
            return null;
        }

    }

    public static <T> T json2Object(String json,Class<T> clazz) throws IOException {
        try {
            return MAPPER.readValue(json, clazz);
        }catch (JsonProcessingException e){
            LogUtil.warn(LOGGER,e,"[JsonUtil#json2Object]解析json发生错误。json=%s",json);
            return null;
        }
    }

    public static <T> List<T> json2List(String json,Class<T> clazz) throws IOException {
        try {
            JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, clazz);
            return MAPPER.readValue(json, javaType);
        }catch (JsonProcessingException e){
            LogUtil.warn(LOGGER,e,"[JsonUtil#json2List]解析json发生错误。json=%s",json);
            return null;
        }
    }


}
