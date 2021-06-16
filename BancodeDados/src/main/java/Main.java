import java.sql.Connection;
import java.sql.SQLException;

import connection.ConexaoBanco;
import dominio.TestaMetodosUsuarioDao;

public class Main {

  public static void main(String[] args) {

    try{
      Connection con = ConexaoBanco.criarConexao();
    }catch (ClassNotFoundException e){
      e.printStackTrace();
    }catch (SQLException e){
      e.printStackTrace();
    }
    
    TestaMetodosUsuarioDao.testaInsert();
    TestaMetodosUsuarioDao.testaUpdate();
    TestaMetodosUsuarioDao.testaDelete();
    TestaMetodosUsuarioDao.testaSelectTodos();
    
  }
}
