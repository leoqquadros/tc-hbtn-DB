package java_jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionSQLite {

    public static void main(String[] args) {
        initConnection();
    }


    public static void initConnection() {
        Connection conexao = null;
        try {
            String url = "jdbc:sqlite:sqlite_database_2022.db";

            conexao = DriverManager.getConnection(url);

            System.out.println("Conexão com o SQlite foi estabelecida.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }
}