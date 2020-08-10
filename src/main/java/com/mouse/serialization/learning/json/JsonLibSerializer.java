package com.mouse.serialization.learning.json;

import net.sf.json.JSONObject;

/**
 * @author mouse
 * @date 2020/8/10 08:49
 * @description 不需要实现java.io.Serializable接口
 */
public class JsonLibSerializer {

    public static void main(String[] args) {
        User user = new User("mouse", 23);
        JsonLibSerializer jsonLibSerializer = new JsonLibSerializer();

        String serialize = jsonLibSerializer.serialize(user);

        //调用了空构造器
        User deserialize = (User) jsonLibSerializer.deserialize(serialize);

        System.out.println(serialize);
        System.out.println(deserialize);
        System.out.println(user == deserialize);
        System.out.println(user.equals(deserialize));
    }

    public String serialize(Object object) {
        return JSONObject.fromObject(object).toString();
    }

    public Object deserialize(String object) {
        return JSONObject.toBean(JSONObject.fromObject(object), User.class);
    }

}
