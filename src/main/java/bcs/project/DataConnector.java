/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcs.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salva
 */

import java.sql.*;

public class DataConnector
{




private Connection conn;
private PreparedStatement statement;
private final String connectionStr = "jdbc:sqlserver://bcs430group1.database.windows.net:1433;database=SeniorProject;user=CloudSA1799e7e9@bcs430group1;password=Password!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
public DataConnector()
{
connectToDB();
}

private void connectToDB()
{
        try
{
            conn = DriverManager.getConnection(connectionStr);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
}


// now using conn , u can create methods to modify the data in the DB for example..
public void printUserInfoFromDB(String userName)
{
ResultSet result = null;
        try {
            Statement stmt = conn.createStatement();
   //create an SQL query statement you want to run on the DB, such as this one below
            result = stmt.executeQuery("Select * From " + "UserInfo" + " Where Username =\'"+ userName+"\'");
            //result now contains all the rows returned by the query statement
while(result.next())
{
 // make sure the column string is spelled the same as it is in the DB
 String uName = result.getString("Username");
 String uID = result.getString("UserID");
 String email = result.getString("Email");
 System.out.println("Username="+uName+" , UserID="+uID+" , Email=" +email);

}

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


}
/*public void printSelect()
{
ResultSet result = null;
        try {
            Statement stmt = conn.createStatement();
   //create an SQL query statement you want to run on the DB, such as this one below
            result = stmt.executeQuery("Select * From UserInfo");
            //result now contains all the rows returned by the query statement
while(result.next())
{
 // make sure the column string is spelled the same as it is in the DB
 String uName = result.getString("Username");
 String uID = result.getString("UserID");
 String email = result.getString("Email");
 System.out.println("Username="+uName+" , UserID="+uID+" , Email=" +email);

}

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


}
*/

public static void main(String[] args){
DataConnector test = new DataConnector(); 
test.printUserInfoFromDB("Mike1");
//DataConnector test2 = new DataConnector();
//test2.printSelect();



}


}

    
