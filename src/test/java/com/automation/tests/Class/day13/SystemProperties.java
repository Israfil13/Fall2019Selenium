package com.automation.tests.Class.day13;

import org.testng.annotations.Test;


public class SystemProperties {


    @Test
    public void test(){
//        C:\Users\hajiy\IdeaProjects\Fall2019Selenium\pom.xml
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.home"));
        String pathDownload=System.getProperty("user.home")+"\\Downloads";
        System.out.println(pathDownload);
        System.out.println(System.getProperty("os.arch"));
    }}
