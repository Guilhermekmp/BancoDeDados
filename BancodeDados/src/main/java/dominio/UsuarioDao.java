package dominio;


import connection.ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private Connection con;

    public UsuarioDao()throws SQLException, ClassNotFoundException{
        con = ConexaoBanco.criarConexao();
    }

    public void adicionarUsuario(Usuario usuario){
        String sql = "INSERT INTO Usuario(id,nome,cpf,idade,email,telefone)";

        try{
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, usuario.getId());
            preparador.setString(2, usuario.getNome());
            preparador.setString(3, usuario.getCpf());
            preparador.setDate(4, new java.sql.Date( usuario.getdataNascimento().getTime()));
            preparador.setString(5, usuario.getEmail());
            preparador.setString(5, usuario.getTelefone());
            preparador.execute();
            preparador.close();
            System.out.println("Inserção realizada!");
        } catch (Exception e){
            System.out.println("ERRO - "+e.getMessage());

        }

    }

    public void updateUsuario(Usuario usuario) {
        String sql = "UPDATE Usuario SET nome = ? SET email = ? WHERE id = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, usuario.getNome());
            preparador.setString(2, usuario.getEmail());
            preparador.setString(3, usuario.getTelefone());
            preparador.setInt(4, usuario.getId());
            preparador.execute();
            preparador.close();
            System.out.println("Atualização realizada!");
        }catch(SQLException e) {
            System.out.println("ERRO - "+e.getMessage());
        }
    }

    public void deletaUsuario(Usuario usuario) {
        String sql = "DELETE FROM Usuario WHERE id = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, usuario.getId());
            preparador.execute();
            preparador.close();
            System.out.println("Deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("ERRO - "+e.getMessage());
        }
    }

    public List<Usuario> selectUsuario(){
        String sql = "SELECT * FROM Usuario";

        List<Usuario> lista = new ArrayList<Usuario>();

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            ResultSet resultados = preparador.executeQuery();

            while(resultados.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultados.getInt("id"));
                usuario.setNome(resultados.getString("nome"));
                usuario.setCpf(resultados.getString("cpf"));
                //usuario.getdataNascimento(resultados.getDate(1999-01-01));
                usuario.setEmail(resultados.getString("email"));
                usuario.setTelefone(resultados.getString("telefone"));

                lista.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("ERRO - "+e.getMessage());
        }

        return lista;

    }
}
