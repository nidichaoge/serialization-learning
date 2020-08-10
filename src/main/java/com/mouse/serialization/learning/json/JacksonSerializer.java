package com.mouse.serialization.learning.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author mouse
 * @date 2020/8/10 08:45
 * @description 不需要实现java.io.Serializable接口
 */
public class JacksonSerializer {

    ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        User user = new User("mouse", 23);
        JacksonSerializer jacksonSerializer = new JacksonSerializer();

        byte[] serialize = jacksonSerializer.serialize(user);

        //调用了空构造器
        User deserialize = (User) jacksonSerializer.deserialize(serialize);

        System.out.println(new String(serialize));
        System.out.println(deserialize);
        System.out.println(user == deserialize);
        System.out.println(user.equals(deserialize));
    }

    public byte[] serialize(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(object);
    }

    public Object deserialize(byte[] object) throws IOException {
        return objectMapper.readValue(object, User.class);
    }

}
