/* STD22023
 * PLEASE NOTE THAT:
 * this project was designed with vsCode
 * so I took the precaution of avoiding incompatibility
 * of our tools (environment variable) by doing the following:
 * 
 * ---------------------
 * Make sure you modify this connection information
 * to your database
 * ---------------------
 */

package com.madatrans.configuration;

public class ManualEnv {
    public static String DB_URL = "jdbc:postgresql://localhost/madatrans";
    public static String DB_USERNAME = "postgres";
    public static String DB_PASSWORD = "12345678";
}