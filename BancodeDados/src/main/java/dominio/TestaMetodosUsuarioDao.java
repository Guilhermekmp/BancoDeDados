package dominio;

import java.sql.SQLException;
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
        usuario1.setCpf("222.879.210-10");
        //usuario1.setIdataNascimento("1999-01-01");
        usuario1.setEmail("jhon@gmail.com");
        usuario1.setTelefone("(83) 927823-8830");

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
        usuarioUpdate.setTelefone("(70) 88482-9979");

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
