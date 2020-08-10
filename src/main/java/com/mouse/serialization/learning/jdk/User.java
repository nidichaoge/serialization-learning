package com.mouse.serialization.learning.jdk;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author mouse
 * @date 2020/8/9 23:53
 * @description
 */
public class User implements Serializable {

    private static final long serialVersionUID = 823264725742316954L;

    private String name;

    private Integer age;

    public User() {
        System.out.println("empty constructor");
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("full constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
