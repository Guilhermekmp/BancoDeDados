import connection.ConexaoBanco;
import dominio.TestaMetodosUsuarioDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) {

    try{
      Connection con = ConexaoBanco.criarConexao();
    }catch (ClassNotFoundException e){
      e.printStackTrace();
    }catch (SQLException e){
      e.printStackTrace();
    }

    TestaMetodosUsuarioDao.testaSelectTodos();
  }
}
