package org.goodfood2.utils;

import java.util.HashMap;

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

    public static String prepareFilter(HashMap<String,Object> params){
        String where = " where ";
        // Print keys and values
        for (String key : params.keySet()) {
            where = where + " " + key + " like " + params.get(key) + " AND";
        }

        return where.substring(0, where.length() - 3);
    }

}