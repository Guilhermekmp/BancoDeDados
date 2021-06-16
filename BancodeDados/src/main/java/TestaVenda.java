
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TestaVenda {
	public static void testaInsert() {

		Venda venda = new Venda();
		venda.setId(1);
		venda.setNumeroDeSerieArma(1);
		venda.setIdUsuario(1);
		venda.setNotaFiscal(123456);
		venda.setDataVenda(new Date());

		/* agora criar um objeto DAO para chamar o método
		de inserção da base de dados */
		VendaDAO venDAO = null;

		//criação do objeto DAO

		try {

			venDAO = new VendaDAO();
			} catch (SQLException e) {
				e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					}
		venDAO.adicionarVenda(venda);
		} //fim do método testaInsert()
	
	public static void testaUpdate() {

		Venda venda = new Venda();
		venda.setNumeroDeSerieArma(1);
		venda.setNotaFiscal(654321);
		VendaDAO venDAO = null;
		
		try {
			
			venDAO = new VendaDAO();
			
		} catch (SQLException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
		e.printStackTrace(); 
		} //fim do catch

		venDAO.updateVenda(venda);

		} //fim do método testaUpdate()
	
	public static void testaDelete() {

		Venda venda = new Venda();
		venda.setIdUsuario(1);
		VendaDAO venDAO = null;
		
		try {
			venDAO = new VendaDAO();
			
		} catch (SQLException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		venDAO.deleteVenda(venda);
		}//fim do método
	
	public static void testaSelectTodos() {
		
		VendaDAO venDAO = null;
		
		try {
			venDAO = new VendaDAO();

		} catch (SQLException e) {

		e.printStackTrace();

		} catch (ClassNotFoundException e) {

		e.printStackTrace();

		}
		List<Venda> listaResultado = venDAO.selectTodos();

		for(Venda v:listaResultado) {

		System.out.println("id: " + v.getId() + " numeroDeSerieArma: " + v.getNumeroDeSerieArma() + " idUsuario: " + v.getIdUsuario() + " notaFiscal: " + v.getNotaFiscal() + " dataVenda: " + v.getDataVenda());

		}
		//fim do for

		} //fim do método testaSelectTodos()
	
}
