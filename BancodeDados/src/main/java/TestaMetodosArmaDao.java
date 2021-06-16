import java.sql.SQLException;

import java.util.List;

public class TestaMetodosArmaDao {
	
	public static void testaDelete() {
			Arma arma = new Arma();
			arma.setNumeroDeSerie(1);
			
			ArmaDao dao = null;
			
			try {
				dao = new ArmaDao();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			dao.deletaArma(arma);
			
	}
	
	public static void testaInsert() {
		Arma arma1 = new Arma();
		arma1.setNumeroDeSerie(1);
		arma1.setNome("Awm G22");
		arma1.setMarca("Accuracy International");
		arma1.setModelo("Sniper");
		arma1.setValor(55000);
		
		ArmaDao armadao = null;
		
		try {
			armadao = new ArmaDao();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		armadao.adicionarArma(arma1);
	}
	
	public static void testaUpdate() {
		Arma armaUpdate = new Arma();
		armaUpdate.setNumeroDeSerie(1);
		armaUpdate.setValor(52000);
		
		ArmaDao armadao = null;
		
		try {
			armadao = new ArmaDao();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		armadao.updateArma(armaUpdate);
		
	}
	
	public static void testaSelectTodos() {
		ArmaDao armadao = null;
		
		try {
			armadao = new ArmaDao();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		List<Arma> listaResultado = armadao.selectArmas();
		
		
		for (Arma arma : listaResultado) {
			System.out.println("Número de série: "+ arma.getNumeroDeSerie()+
					" Nome: "+ arma.getNome()+
					" Marca: "+ arma.getMarca()+
					" Modelo: "+ arma.getModelo()+
					" Valor: "+ arma.getValor());
		}
	}
}
