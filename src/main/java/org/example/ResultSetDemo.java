package org.example;





        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class ResultSetDemo
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
            Statement statement =connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

            //create query
            String query = "select * from students";

            ResultSet resultSet = statement.executeQuery(query);

            resultSet.last();
            System.out.println("Fetching Last Raw");
            System.out.println("ID :"+resultSet.getInt("id"));
            System.out.println("Name :"+resultSet.getString("name"));
            System.out.println("Course :"+ resultSet.getString("course"));

            resultSet.first();
            System.out.println("Fetching First Raw");
            System.out.println("ID :"+resultSet.getInt("id"));
            System.out.println("Name :"+resultSet.getString("name"));
            System.out.println("Course :"+ resultSet.getString("course"));

            resultSet.updateString("name","Pooja");
            resultSet.updateRow();
            resultSet.updateString("name","Chotu");
            resultSet.updateRow();

            resultSet.moveToInsertRow();
            resultSet.updateInt("id",5);
            resultSet.updateString("name","Harshit");
            resultSet.updateString("course","Bussiness Ananlyst");
            resultSet.insertRow();

            resultSet.last();
            System.out.println("Fetching Last Row");
            System.out.println("ID :"+resultSet.getInt("id"));
            System.out.println("Name :"+resultSet.getString("name"));
            System.out.println("Course :"+ resultSet.getString("course"));



            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

