/*
 * A noter que cet projet a été conçu avec vsCode
 * donc j'ai pris la précaution d'eviter l'incompatibilité
 * de nos outils (variable de l' environnement) en faisant comme ça:
 * 
 * ---------------------
 * Veilliez modifier ces information de connection
 * conevenablement à votre base be donnée
 * ---------------------
 */

package com.madatrans.configuration;
public class ManualEnv {
    public static String DB_URL ="jdbc:postgresql://localhost/madatrans" ;
    public static String DB_USERNAME = "postgres";
    public static String DB_PASSWORD="12345678";
}