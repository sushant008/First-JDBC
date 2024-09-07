package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class ResultSetDemo1
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
            Statement statement =connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            //create query
            String query = "select * from students";

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
//                System.in.read();
//                System.in.read();
                Thread.sleep(2000);
                resultSet.refreshRow();
                System.out.println(resultSet.getInt("id")+" "+resultSet.getString("name")+" "+
                        resultSet.getString("course"));


            }
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
