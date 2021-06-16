package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

  private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

  private static final String USER = "postgres";

  private static final String PASSWORD = "postgres";

  public static Connection criarConexao() throws ClassNotFoundException, SQLException{
    Class.forName("org.postgresql.Driver");

    Connection conection = DriverManager.getConnection(URL,USER,PASSWORD);

    if(conection != null){
      System.out.println(" Conexão Efetuada com sucesso");
    }
    return conection;
  }
}
