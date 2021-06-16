package dominio;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TestaMetodosUsuarioDao {

    public static void testaDelete() {
        Usuario usuario = new Usuario();
        usuario.setId(1);

        UsuarioDao dao = null;

        try {
            dao = new UsuarioDao();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        dao.deletaUsuario(usuario);

    }

    public static void testaInsert() {
        Usuario usuario1 = new Usuario();
        usuario1.setId(1);
        usuario1.setNome("Jhon");
        usuario1.setCpf("22287921010");
        usuario1.setDataNascimento(new Date());
        usuario1.setEmail("jhon@gmail.com");
        usuario1.setTelefone("839278238830");

        UsuarioDao usuarioDao = null;

        try {
            usuarioDao = new UsuarioDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        usuarioDao.adicionarUsuario(usuario1);
    }

    public static void testaUpdate() {
        Usuario usuarioUpdate = new Usuario();
        usuarioUpdate.setId(1);
        usuarioUpdate.setNome("Jhon Diniz");
        usuarioUpdate.setEmail("jhon.diniz@gmail.com");
        usuarioUpdate.setTelefone("70884829979");

        UsuarioDao usuariodao = null;

        try {
            usuariodao = new UsuarioDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        usuariodao.updateUsuario(usuarioUpdate);

    }

    public static void testaSelectTodos() {
        UsuarioDao usuarioDao = null;

        try {
            usuarioDao = new UsuarioDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        List<Usuario> listaResultado = usuarioDao.selectUsuario();


        for (Usuario usuario : listaResultado) {
            System.out.println("O id é: "+ usuario.getId()+
                    " Nome: "+ usuario.getNome()+
                    " Cpf: "+ usuario.getCpf()+
                    " Data de Nascimento: "+ usuario.getdataNascimento()+
                    " Email: "+ usuario.getEmail() +
                    " Telefone: "+ usuario.getTelefone());

        }
    }
}
