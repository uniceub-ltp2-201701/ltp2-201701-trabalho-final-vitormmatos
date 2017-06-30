package dao;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.util.ArrayList;

        import model.Pessoa;

public class PessoaDAO{

    private Connection conexao;

    public PessoaDAO(Connection conexao){
        this.conexao = conexao;
    }

    public Pessoa selecionaPessoa(int id){

        Pessoa pessoa = new Pessoa();

        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexao.prepareStatement("SELECT idPessoa, nome, dataNasc, sexo, fotoLink, descricao FROM pessoa WHERE idPessoa = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            rs.next();
            pessoa.setIdPessoa(rs.getInt("idPessoa"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setDataNascimento(rs.getDate("dataNasc"));
            pessoa.setSexo(rs.getInt("sexo"));
            pessoa.setFotoLink(rs.getString("fotoLink"));
            pessoa.setDescricao(rs.getString("descricao"));

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pessoa;
    }

    //Metodo que retorna um modelo de acordo com a marca
    public ArrayList<Pessoa> listarPessoas(){
        //Criar objeto de retorno
        //Criar objetos de acesso a BD

        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexao.prepareStatement("SELECT idPessoa, nome, dataNasc, sexo, fotoLink, descricao FROM pessoa");
            rs = ps.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDataNascimento(rs.getDate("dataNasc"));
                pessoa.setSexo(rs.getInt("sexo"));
                pessoa.setFotoLink(rs.getString("fotoLink"));
                pessoa.setDescricao(rs.getString("descricao"));
                listaPessoas.add(pessoa);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaPessoas;
    }

    public ArrayList<Pessoa> listarAtores(){
        //Criar objeto de retorno
        //Criar objetos de acesso a BD

        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexao.prepareStatement("SELECT DISTINCT p.idPessoa, p.nome, p.dataNasc, p.sexo, p.fotoLink, p.descricao FROM pessoa AS p, ator_filme AS a WHERE p.idPessoa = a.idPessoa");
            rs = ps.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDataNascimento(rs.getDate("dataNasc"));
                pessoa.setSexo(rs.getInt("sexo"));
                pessoa.setFotoLink(rs.getString("fotoLink"));
                pessoa.setDescricao(rs.getString("descricao"));
                listaPessoas.add(pessoa);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaPessoas;
    }

    //Metodo que retorna um modelo de acordo com a marca
    public ArrayList<Pessoa> listarDiretores(){
        //Criar objeto de retorno
        //Criar objetos de acesso a BD

        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexao.prepareStatement("SELECT DISTINCT p.idPessoa, p.nome, p.dataNasc, p.sexo, p.fotoLink, p.descricao FROM pessoa AS p, diretor_filme AS d WHERE p.idPessoa = d.idPessoa");
            rs = ps.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDataNascimento(rs.getDate("dataNasc"));
                pessoa.setSexo(rs.getInt("sexo"));
                pessoa.setFotoLink(rs.getString("fotoLink"));
                pessoa.setDescricao(rs.getString("descricao"));
                listaPessoas.add(pessoa);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaPessoas;
    }

    public ArrayList<Pessoa> listarRoteiristas(){
        //Criar objeto de retorno
        //Criar objetos de acesso a BD

        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexao.prepareStatement("SELECT DISTINCT p.idPessoa, p.nome, p.dataNasc, p.sexo, p.fotoLink, p.descricao FROM pessoa AS p, roteirista_filme AS r WHERE p.idPessoa = r.idPessoa");
            rs = ps.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDataNascimento(rs.getDate("dataNasc"));
                pessoa.setSexo(rs.getInt("sexo"));
                pessoa.setFotoLink(rs.getString("fotoLink"));
                pessoa.setDescricao(rs.getString("descricao"));
                listaPessoas.add(pessoa);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaPessoas;
    }


    public ArrayList<Pessoa> listarDiretoresFilme(int idFilme){
        //Criar objeto de retorno
        //Criar objetos de acesso a BD

        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexao.prepareStatement("SELECT p.idPessoa, p.nome, p.dataNasc, p.sexo, p.fotoLink, p.descricao FROM pessoa AS p, diretor_filme AS d WHERE p.idPessoa = d.idPessoa and d.idFilme = ?");
            ps.setInt(1, idFilme);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDataNascimento(rs.getDate("dataNasc"));
                pessoa.setSexo(rs.getInt("sexo"));
                pessoa.setFotoLink(rs.getString("fotoLink"));
                pessoa.setDescricao(rs.getString("descricao"));
                listaPessoas.add(pessoa);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaPessoas;
    }

    public ArrayList<Pessoa> listarRoteiristasFilme(int idFilme){
        //Criar objeto de retorno
        //Criar objetos de acesso a BD

        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexao.prepareStatement("SELECT p.idPessoa, p.nome, p.dataNasc, p.sexo, p.fotoLink, p.descricao FROM pessoa AS p, roteirista_filme AS r WHERE p.idPessoa = r.idPessoa and r.idFilme = ?");
            ps.setInt(1, idFilme);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDataNascimento(rs.getDate("dataNasc"));
                pessoa.setSexo(rs.getInt("sexo"));
                pessoa.setFotoLink(rs.getString("fotoLink"));
                pessoa.setDescricao(rs.getString("descricao"));
                listaPessoas.add(pessoa);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaPessoas;
    }
}