package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {
	public static void main(String[] args) throws Exception {
		final String servername = "localhost";
        final String databasename   = "yui";
        final String user = "yui";
        final String password = "spc";
        final String tablename = "human";
        final String url =  "jdbc:mysql://" + servername + "/" + databasename;

        Connection con = null;

        try{
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();

            System.out.println( "Connecting...." );
            con = DriverManager.getConnection( url, user, password );
            System.out.println( "Connected...." );

            Statement st = con.createStatement();
            String sqlStr = "SELECT * FROM " + tablename;
            ResultSet result = st.executeQuery( sqlStr );

            while( result.next() )
            {
                String str1 = result.getString( "id" );
                Date str2 = result.getDate( "date" );
                String str3 = result.getString( "name" );
                System.out.println( str1 + ", " + str2 + ", " + str3);
            }

            result.close();
            st.close();
            con.close();
        }
        catch( SQLException e ){
            System.out.println( "Connection Failed. : " + e.toString() );
            throw new Exception();
        }catch (ClassNotFoundException e){
            System.out.println("ドライバを読み込めませんでした " + e);
        }
        finally{
            try{
                if( con != null ){ 
                    con.close();
                }
            }
            catch(Exception e){
                System.out.println( "Exception2! :" + e.toString() );
                throw new Exception();
            }
        }
    }
}
