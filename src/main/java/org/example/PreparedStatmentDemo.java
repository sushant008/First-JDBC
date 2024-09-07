package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Hello world!
 *
 */
public class PreparedStatmentDemo
{
    public static String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static String URL = "jdbc:mysql://localhost:3306/studentdb";

    public static String Password = "Sushant@0809";

    public static String USERNAME = "root";

    public static void main( String[] args )
    {

        try {

            //Load Driver
            Class.forName(LOAD_DRIVER);


            //making connection
            Connection connection = DriverManager.getConnection(URL, USERNAME, Password);
//
//            String query = "delete from students where id=?";
//
//            //create statmanet
//           PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            //create query
//            preparedStatement.setInt(1,4);

            String insetquery  = "Insert into students (id,name,course) values(?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insetquery);

            preparedStatement.setInt(1,4);
            preparedStatement.setString(2,"Arnav");
            preparedStatement.setString(3,"Marketing");


            int effectedrows = preparedStatement.executeUpdate();

            System.out.println("EffectRows :" + effectedrows);
            connection.close();
        }



        catch (Exception e){
            e.printStackTrace();
        }
    }
}