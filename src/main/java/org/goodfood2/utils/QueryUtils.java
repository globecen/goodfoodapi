package org.goodfood2.utils;

public class QueryUtils {

    public static String makeFindAllQuery(String className){
        return "SELECT obj FROM " + className + " obj";
    }

    public static String makeFindByIdQuery(String className, long id, String idPropertyName){
        return "SELECT obj FROM " + className + " obj WHERE obj."+ idPropertyName + " = :idParam";
    }
}