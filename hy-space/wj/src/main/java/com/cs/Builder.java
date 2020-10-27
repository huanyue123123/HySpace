package com.cs;

public class Builder {

    private String id;

    private Integer age;

    private String name;

    private String text;

    static class BuildBuilder{
        String id = null;
        Integer age = 0;
        String name = null;
        String text = null;
        public  BuildBuilder setId(String id){
            this.id = id;
            return this;
        }
        public BuildBuilder setAge(Integer age){
            this.age = age;
            return this;
        }
        public BuildBuilder setName(String name){
            this.name = name;
            return this;
        }
        public BuildBuilder setText(String text){
            this.text = text;
            return this;
        }
        public Builder build(){
            return new Builder(this);
        }

    }

    public Builder(BuildBuilder buildBuilder){
        this.id = buildBuilder.id;
        this.age = buildBuilder.age;
        this.name = buildBuilder.name;
        this.text = buildBuilder.text;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
