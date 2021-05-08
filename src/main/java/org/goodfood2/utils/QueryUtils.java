package org.goodfood2.utils;

public class QueryUtils {

    public static String makeFindAllQuery(String className){
        return "from " + className + " obj";
    }
    
    public static String makeFindByIdQuery(String className, long id, String idPropertyName){
        return "from " + className + " obj where id = " + id;
    }
}