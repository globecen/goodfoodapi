package org.goodfood2.utils;

public class QueryUtils {

    public static String makeFindAllQuery(String className){
        return "from " + className + " obj";
    }
    
    public static String makeFindByParamQueryInt(String className, String param, String value){
        return "from " + className + " obj where " + param + " = " + value;
    }

    public static String makeFindByParamQueryString(String className, String param, String value){
        return "from " + className + " obj where " + param + " = '" + value + "'";
    }

    public static String makeFindBy2ParamQueryString(String className, String param, String value, String param2, String value2){
        return "from " + className + " obj where " + param + " = '" + value + "' and " + param2 + " = '" + value2 + "'";
    }
}