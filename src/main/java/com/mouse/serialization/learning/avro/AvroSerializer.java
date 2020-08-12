package com.mouse.serialization.learning.avro;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

/**
 * @author mouse
 * @date 2020/8/10 09:20
 * @description 生成代码的方式 (使用maven插件)
 * org.apache.avro.io.DatumWriter 将Java对象转换为内存中的序列化格式
 * org.apache.avro.file.DataFileWriter 它将序列化的记录以及模式写入dataFileWriter.create调用中指定的文件中 。我们通过调用dataFileWriter.append方法将用户写入文件
 * org.apache.avro.io.DatumReader 将内存中的序列化项目转换为生成的类的实例
 * org.apache.avro.file.DataFileReader 它读取编写器使用的架构以及磁盘上文件中的数据。将使用文件中包含的编写者模式和读取器提供的模式（在本例中为User 类）读取数据
 */
public class AvroSerializer {

    public static void main(String[] args) throws IOException {
        AvroSerializer avroSerializer = new AvroSerializer();
        avroSerializer.serialize(null);

        avroSerializer.deserialize();
    }

    public void serialize(Object object) throws IOException {
        User user1 = new User();
        user1.setName("Alyssa");
        user1.setFavoriteNumber(256);

        User user2 = new User("Ben", 7, "red");

        User user3 = User.newBuilder()
                .setName("Charlie")
                .setFavoriteColor("blue")
                .setFavoriteNumber(null)
                .build();

        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);
        dataFileWriter.create(user1.getSchema(), new File("./users.avro"));
        dataFileWriter.append(user1);
        dataFileWriter.append(user2);
        dataFileWriter.append(user3);
        dataFileWriter.close();
    }

    public void deserialize() throws IOException {
        DatumReader<User> userDatumReader = new SpecificDatumReader<User>(User.class);
        DataFileReader<User> dataFileReader = new DataFileReader<User>(new File("./users.avro"), userDatumReader);
        User user = null;
        while (dataFileReader.hasNext()) {
            user = dataFileReader.next(user);
            System.out.println(user);
        }
    }

}
