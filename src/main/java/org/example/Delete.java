package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Delete
{
    public static String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static String URL = "jdbc:mysql://localhost:3306/studentdb";

    public static String Password = "Sushant@0809";

    public static String USERNAME = "root";

    public static void main( String[] args )
    {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();

        try{

            //Load Driver
            Class.forName(LOAD_DRIVER);


            //making connection
            Connection connection = DriverManager.getConnection(URL,USERNAME,Password);

            //create statmanet
            Statement statement =connection.createStatement();

            //create query
            String query = "delete from students where id=4";

           int effectrows = statement.executeUpdate(query);

            System.out.println("EffectRows :"+ effectrows);
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}