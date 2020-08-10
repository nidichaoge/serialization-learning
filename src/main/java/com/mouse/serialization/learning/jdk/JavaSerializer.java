package com.mouse.serialization.learning.jdk;

import java.io.*;

/**
 * @author mouse
 * @date 2020/8/9 23:50
 * @description
 * 必须实现java.io.Serializable接口否则抛出异常
 */
public class JavaSerializer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("mouse", 23);
        JavaSerializer javaSerializer = new JavaSerializer();

        byte[] serialize = javaSerializer.serialize(user);

        User deserialize = (User) javaSerializer.deserialize(serialize);

        System.out.println(new String(serialize));
        System.out.println(deserialize);
        System.out.println(user == deserialize);
        System.out.println(user.equals(deserialize));
    }

    public byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
        objectOutputStream.writeObject(object);
        return byteOutputStream.toByteArray();
    }

    public Object deserialize(byte[] object) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(object);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();
    }

}
