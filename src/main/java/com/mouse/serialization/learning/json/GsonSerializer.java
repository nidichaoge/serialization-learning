package com.mouse.serialization.learning.json;

import com.google.gson.Gson;

/**
 * @author mouse
 * @date 2020/8/10 08:42
 * @description 不需要实现java.io.Serializable接口
 */
public class GsonSerializer {

    Gson gson = new Gson();

    public static void main(String[] args) {
        User user = new User("mouse", 23);
        GsonSerializer gsonSerializer = new GsonSerializer();

        String serialize = gsonSerializer.serialize(user);

        //调用了空构造器
        User deserialize = (User) gsonSerializer.deserialize(serialize);

        System.out.println(serialize);
        System.out.println(deserialize);
        System.out.println(user == deserialize);
        System.out.println(user.equals(deserialize));
    }

    public String serialize(Object object) {
        return gson.toJson(object);
    }

    public Object deserialize(String object) {
        return gson.fromJson(object, User.class);
    }

}
