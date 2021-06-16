import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoBanco;

public class VendaDAO {
	private Connection con;
	
	public VendaDAO() throws SQLException, ClassNotFoundException {
	con = ConexaoBanco.criarConexao(); //fazendo a conex�o
	}
	
	public void adicionarVenda(Venda venda) {
		String sql = "INSERT INTO Venda VALUES (?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, venda.getId());
			preparador.setInt(2, venda.getNumeroDeSerieArma());
			preparador.setInt(3, venda.getIdUsuario());
			preparador.setInt(4, venda.getNotaFiscal());
			preparador.setDate(5, new java.sql.Date(venda.getDataVenda().getTime()));
			preparador.execute();
			preparador.close();
			System.out.println("Inser��o realizada com sucesso!");
			
		} catch (Exception e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}
	public void updateVenda(Venda venda) {
		String sql = "UPDATE Venda SET notaFiscal = ? WHERE numeroDeSerieArma = ?";
		try {
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setInt(1, venda.getNotaFiscal());
		preparador.setInt(2, venda.getNumeroDeSerieArma());
		preparador.execute();
		preparador.close();
		System.out.println("Altera��o realizada!");
		} catch (SQLException e) {
		System.out.println("Erro - "+ e.getMessage());
		}//fecha o catch }
	}
	public void deleteVenda(Venda venda) {

		String sql = "DELETE FROM Venda WHERE id = ?";
		try {
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setInt(1, venda.getIdUsuario());
		preparador.execute();
		preparador.close();
		System.out.println("Dele��o realizada!");
		
		} catch (SQLException e) {
			
		System.out.println("Erro - "+ e.getMessage());
		}//fim do catch
		} //fim do delete(...)
	
	public List<Venda> selectTodos(){

		String sql = "SELECT * FROM Venda";
		List<Venda> lista = new ArrayList<Venda>();
		
		try {
		PreparedStatement preparador = con.prepareStatement(sql);
		ResultSet resultados = preparador.executeQuery();
		
		while (resultados.next()) {
			Venda venda2 = new Venda();
			venda2.setId(resultados.getInt("id"));
			venda2.setNumeroDeSerieArma(resultados.getInt("numeroDeSerieArma"));
			venda2.setIdUsuario(resultados.getInt("idUsuario"));
			venda2.setNotaFiscal(resultados.getInt("notaFiscal"));
			venda2.setDataVenda(resultados.getDate("dataVenda"));
			lista.add(venda2);
			} //fim do while
		
			} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
			}
			return lista; //retornando a lista com todos os dados
			} //fim do m�todo selectTodos()
	
}
