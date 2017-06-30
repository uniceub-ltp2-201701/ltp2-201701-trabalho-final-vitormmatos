package dao;

import model.Personagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class PersonagemDAO {

    private Connection conexao;

    public PersonagemDAO(Connection conexao) {
        this.conexao = conexao;
    }


    public ArrayList<Personagem> listaPersonagensFilme(int idFilme) {

        ArrayList<Personagem> listaPersonagens = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexao.prepareStatement("SELECT idPersonagem, nomePersonagem, idPessoa, idFilme FROM ator_filme WHERE idFilme = ?");
            ps.setInt(1, idFilme);
            rs = ps.executeQuery();

            while (rs.next()) {
                Personagem personagem = new Personagem();
                personagem.setIdPersonagem(rs.getInt("idPersonagem"));
                personagem.setNomePersonagem(rs.getString("nomePersonagem"));
                personagem.setIdFilme(rs.getInt("idFilme"));
                personagem.setIdPessoa(rs.getInt("idPessoa"));
                listaPersonagens.add(personagem);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPersonagens;
    }

    public ArrayList<Personagem> listarPersonagensAtor(int idPessoa) {

        ArrayList<Personagem> listaPersonagens = new ArrayList<>();

        try {
            try (PreparedStatement ps = conexao.prepareStatement("SELECT idPersonagem, nomePersonagem, idPessoa, idFilme FROM ator_filme where idPessoa = ?")) {
                ps.setInt(1, idPessoa);
                try (ResultSet rs = ps.executeQuery()) {
                    try {
                        while (rs.next()) {
                            Personagem personagem = new Personagem();
                            personagem.setIdPersonagem(rs.getInt("idPersonagem"));
                            personagem.setNomePersonagem(rs.getString("nomePersonagem"));
                            personagem.setIdFilme(rs.getInt("idFilme"));
                            personagem.setIdPessoa(rs.getInt("idPessoa"));
                            listaPersonagens.add(personagem);
                        }
                        rs.close();
                    } finally {
                        rs.close();
                    }
                }
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaPersonagens;
    }
}
