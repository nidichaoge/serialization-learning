package com.mouse.serialization.learning.json;

import com.alibaba.fastjson.JSON;

/**
 * @author mouse
 * @date 2020/8/9 23:50
 * @description 不需要实现java.io.Serializable接口
 */
public class FastJsonSerializer {

    public static void main(String[] args) {
        User user = new User("mouse", 23);
        FastJsonSerializer fastJsonSerializer = new FastJsonSerializer();

        byte[] serialize = fastJsonSerializer.serialize(user);

        //调用了空构造器
        User deserialize = (User) fastJsonSerializer.deserialize(serialize);

        System.out.println(new String(serialize));
        System.out.println(deserialize);
        System.out.println(user == deserialize);
        System.out.println(user.equals(deserialize));
    }

    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    public Object deserialize(byte[] object) {
        return JSON.parseObject(object, User.class);
    }

}
