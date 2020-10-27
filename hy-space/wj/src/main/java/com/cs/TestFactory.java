package com.cs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TestFactory {

    private TestFactory(){

    }

    public static List getArrayList(){
        return new ArrayList();
    }

    public static List getLinkedList(){
        return new LinkedList();
    }

    public static List getVector(){
        return new Vector();
    }
}
