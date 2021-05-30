package org.goodfood2.utils;

import java.util.HashMap;

/**
 * Requetes utilisees dans plusieurs routes. 
 */
public class QueryUtils {

    /**
     * Requetes renvoyant toutes les donnees d une table.
     * @param className Le nom de la table.
     * @return La requete.
     */
    public static String makeFindAllQuery(String className){
        return "from " + className + " obj";
    }
    
    /**
     * Requetes renvoyant toutes les donnees d une table avec un filtre sur un nombre.
     * @param className Le nom de la table.
     * @param param Le nom de la colonne filtree.
     * @param value La valeur du filtre.
     * @return La requete.
     */
    public static String makeFindByParamQueryInt(String className, String param, String value){
        return "from " + className + " obj where " + param + " = " + value;
    }

    /**
     * Requetes renvoyant toutes les donnees d une table avec un filtre sur une chaine de caracteres.
     * @param className Le nom de la table.
     * @param param Le nom de la colonne filtree.
     * @param value La valeur du filtre.
     * @return La requete.
     */
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