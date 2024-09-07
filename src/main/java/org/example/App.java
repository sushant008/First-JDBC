package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App
{
    public static String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static String URL = "jdbc:mysql://localhost:3306/studentdb";

    public static String Password = "Sushant@0809";

    public static String USERNAME = "root";

    public static void main( String[] args )
    {

        try{

            //Load Driver
            Class.forName(LOAD_DRIVER);


            //making connection
            Connection connection = DriverManager.getConnection(URL,USERNAME,Password);

            //create statmanet
            Statement statement =connection.createStatement();

            //create query
            String query = "select * from students";

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");

                System.out.println(" ID : " +id + " ,"+" Name : " +name +" ," +" Course : "+ course);
            }
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}