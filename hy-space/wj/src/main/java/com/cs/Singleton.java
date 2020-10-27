package com.cs;

public class Singleton {

    private Integer id ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Singleton(){

    }

    private static class SingletonBuild{
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonBuild.singleton;
    }
}
