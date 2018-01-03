package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {
	public static void main(String[] args) throws Exception {
        /*接続先サーバー名を"localhost"で与えることを示している*/
//        String servername     = "192.168.0.8";
		String servername = "localhost";
        /*接続するデータベース名をsenngokuとしている*/
        String databasename   = "yui";

        /*データベースの接続に用いるユーザ名をrootユーザとしている*/
        String user = "yui";

        /*データベースの接続に用いるユーザのパスワードを指定している*/
        String password = "spc";

        /*取り扱う文字コードをUTF-8文字としている*/
        String serverencoding = "UTF-8";

        /*データベースをあらわすURLを設定している*/
        String url =  "jdbc:mysql://" + servername + "/" + databasename;

        /*MySQLの場合、URLの形式は次のようになります。
          jdbc:mysql://(サーバ名)/(データベース名)*/

        /*↑データベースをあらわすURL（データベースURL)は、データベースに接続する場合に
        必要となる情報をセットした文字列である。
        この文字列の構造は、"jdbc"、サブプロトコル、サブネームの３つの部分から構成される。*/

        /*接続を表すConnectionオブジェクトを初期化*/
        Connection con = null;

        try{

            /*クラスローダによりJDBCドライバを読み込んでいることを示している。
            引数は、データベースにアクセスするためのJDBCドライバのクラス名である。*/
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();

            /*DriverManagerクラスのgetConnectionメソッドを使ってデータベースに接続する。*/

            System.out.println( "Connecting...." );

            con = DriverManager.getConnection( url, user, password );

            System.out.println( "Connected...." );

            /*データベースの接続後に、sql文をデータベースに直接渡すのではなく、
            sqlコンテナの役割を果たすオブジェクトに渡すためのStatementオブジェクトを作成する。*/
            Statement st = con.createStatement();

            /*SQL文を作成する*/
            String sqlStr = "SELECT * FROM test";

            /*SQL文を実行した結果セットをResultSetオブジェクトに格納している*/
            ResultSet result = st.executeQuery( sqlStr );

            /*クエリ結果を1レコードずつ出力していく*/
            while( result.next() )
            {
                /*getString()メソッドは、引数に指定されたフィールド名(列)の値をStringとして取得する*/
                String str1 = result.getString( "id" );
                Date str2 = result.getDate( "date" );
                String str3 = result.getString( "name" );
                System.out.println( str1 + ", " + str2 + ", " + str3);
            }

            /*ResultSetオブジェクトを閉じる*/
            result.close();

            /*Statementオブジェクトを閉じる*/
            st.close();

            /*Connectionオブジェクトを閉じる*/
            con.close();
        }
        catch( SQLException e ){

            /*エラーメッセージ出力*/
            System.out.println( "Connection Failed. : " + e.toString() );

            /*例外を投げちゃうぞ*/
            throw new Exception();

        }catch (ClassNotFoundException e){

            /*エラーメッセージ出力*/
            System.out.println("ドライバを読み込めませんでした " + e);
        }
        finally{
            try{
                if( con != null ){ 
                    con.close();
                }
            }
            catch(Exception e){

                /*エラーメッセージ出力*/
                System.out.println( "Exception2! :" + e.toString() );

                /*例外を投げちゃうぞ*/
                throw new Exception();
            }
        }
    }
}
