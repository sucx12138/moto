package com.soft.moto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sucx
 * @title: LamdbaTest
 * @projectName springboot_demo
 * @date 2020/4/1411:33
 */
public class LamdbaTest {

    @Test
    public void test1(){
        //方法引用
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println(names);
        Collections.sort(names,String::compareTo);
        System.out.println(names);
    }

}
