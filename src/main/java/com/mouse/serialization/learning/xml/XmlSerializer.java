package com.mouse.serialization.learning.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author mouse
 * @date 2020/8/9 23:50
 * @description
 */
public class XmlSerializer {

    public static void main(String[] args) {
        User user = new User("mouse", 23);
        XmlSerializer xmlSerializer = new XmlSerializer();

        //调用了空构造器
        byte[] serialize = xmlSerializer.serialize(user);

        //调用了空构造器
        User deserialize = (User) xmlSerializer.deserialize(serialize);

        System.out.println(new String(serialize));
        System.out.println(deserialize);
        System.out.println(user == deserialize);
        System.out.println(user.equals(deserialize));
    }

    public byte[] serialize(Object object) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        XMLEncoder xe = new XMLEncoder(os);
        xe.writeObject(object);

        //必须close 否则os为空
        xe.close();

        return os.toByteArray();
    }

    public Object deserialize(byte[] object) {
        ByteArrayInputStream in = new ByteArrayInputStream(object);
        XMLDecoder xd = new XMLDecoder(in);
        return xd.readObject();
    }

}
