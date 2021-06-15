import connection.ConexaoBanco;

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
    
   // TestaMetodosDao.testaInsert();
   // TestaMetodosDao.testaDelete();
   // TestaMetodosDao.testaUpdate();
    TestaMetodosDao.testaSelectTodos();
    
  }
}
