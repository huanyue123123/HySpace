package com.cs;

import java.util.List;

public class SomeTest {
    public static void main(String[] args) {
        Builder builder = new Builder.BuildBuilder().setId("231").setAge(2).build();
        System.out.println(builder);
    }
}
