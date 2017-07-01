package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Filme;

public class FilmeDAO{
    //Atributos
    private Connection conexao;

    //Metodo construtor
    public FilmeDAO(Connection conexao){
        this.conexao = conexao;
    }

    public Filme selecionaFilme(int id){
        //Criar objeto de retorno
        //Criar objetos de acesso a BD

        Filme filme = new Filme();

        try {
            try (PreparedStatement ps = conexao.prepareStatement("SELECT idFilme, nome, faixaEtaria, dataLancamento, trailerLink, cartazLink, sinopse FROM filme WHERE idFilme = ?")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    rs.next();
                    filme.setIdFilme(rs.getInt("idFilme"));
                    filme.setNome(rs.getString("nome"));
                    filme.setFaixaEtaria(rs.getInt("faixaEtaria"));
                    filme.setDataLanc(rs.getDate("dataLancamento"));
                    filme.setTrailerLink(rs.getString("trailerLink"));
                    filme.setCartazLink(rs.getString("cartazLink"));
                    filme.setSinopse(rs.getString("sinopse"));
                    rs.close();
                }
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return filme;
    }

    public ArrayList<Filme> listarFilmes(){
        //Criar objeto de retorno
        //Criar objetos de acesso a BD

        ArrayList<Filme> listaFilmes = new ArrayList<>();


        try {
            try (PreparedStatement ps = conexao.prepareStatement("SELECT idFilme, nome, faixaEtaria, dataLancamento, trailerLink, cartazLink, sinopse FROM filme")) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Filme filme = new Filme();
                        filme.setIdFilme(rs.getInt("idFilme"));
                        filme.setNome(rs.getString("nome"));
                        filme.setFaixaEtaria(rs.getInt("faixaEtaria"));
                        filme.setDataLanc(rs.getDate("dataLancamento"));
                        filme.setTrailerLink(rs.getString("trailerLink"));
                        filme.setCartazLink(rs.getString("cartazLink"));
                        filme.setSinopse(rs.getString("sinopse"));
                        listaFilmes.add(filme);
                    }
                    rs.close();
                }
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaFilmes;
    }

    public ArrayList<Filme> listarFilmesGenero(int idGenero){
        //Criar objeto de retorno
        //Criar objetos de acesso a BD

        ArrayList<Filme> filmes = new ArrayList<>();

        try {
            try (PreparedStatement ps = conexao.prepareStatement("SELECT f.idFilme, f.nome, f.dataLancamento, f.faixaEtaria, f.trailerLink, f.cartazLink, f.sinopse FROM catalogo_filmes.genero_filme AS gf, catalogo_filmes.filme AS f WHERE gf.idFilme = f.idFilme AND gf.idGenero = ?")) {
                ps.setInt(1, idGenero);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()){
                        Filme filme = new Filme();
                        filme.setIdFilme(rs.getInt("idFilme"));
                        filme.setNome(rs.getString("nome"));
                        filme.setFaixaEtaria(rs.getInt("faixaEtaria"));
                        filme.setDataLanc(rs.getDate("dataLancamento"));
                        filme.setCartazLink(rs.getString("cartazLink"));
                        filme.setSinopse(rs.getString("sinopse"));
                        filmes.add(filme);
                    }
                    rs.close();
                }
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return filmes;
    }

    public ArrayList<Filme> listarFilmesPessoa(int idPessoa) throws FileNotFoundException {
        //Criar objeto de retorno
        //Criar objetos de acesso a BD

        ArrayList<Filme> filmes = new ArrayList<>();

        try {
            try (PreparedStatement ps = conexao.prepareStatement("SELECT p.idPessoa, f.idFilme, f.nome, f.dataLancamento, f.faixaEtaria, f.trailerLink, f.cartazLink, f.sinopse FROM catalogo_filmes.ator_filme AS a, catalogo_filmes.filme AS f, catalogo_filmes.pessoa AS p WHERE f.idFilme = a.idFilme AND p.idPessoa = a.idPessoa AND p.idPessoa = ?")) {
                ps.setInt(1, idPessoa);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Filme filme = new Filme();
                        filme.setIdFilme(rs.getInt("idFilme"));
                        filme.setNome(rs.getString("nome"));
                        filme.setFaixaEtaria(rs.getInt("faixaEtaria"));
                        filme.setDataLanc(rs.getDate("dataLancamento"));
                        filme.setCartazLink(rs.getString("cartazLink"));
                        filme.setSinopse(rs.getString("sinopse"));
                        filmes.add(filme);
                    }
                    rs.close();
                }
                ps.close();
                if(!filmes.isEmpty()){
                    return filmes;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            try (PreparedStatement ps = conexao.prepareStatement("SELECT p.idPessoa, f.idFilme, f.nome, f.dataLancamento, f.faixaEtaria, f.trailerLink, f.cartazLink, f.sinopse FROM catalogo_filmes.diretor_filme AS d, catalogo_filmes.filme AS f, catalogo_filmes.pessoa AS p WHERE f.idFilme = d.idFilme AND p.idPessoa = d.idPessoa AND p.idPessoa = ?")) {
                ps.setInt(1, idPessoa);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Filme filme = new Filme();
                        filme.setIdFilme(rs.getInt("idFilme"));
                        filme.setNome(rs.getString("nome"));
                        filme.setFaixaEtaria(rs.getInt("faixaEtaria"));
                        filme.setDataLanc(rs.getDate("dataLancamento"));
                        filme.setCartazLink(rs.getString("cartazLink"));
                        filme.setSinopse(rs.getString("sinopse"));
                        filme.setCartazLink(rs.getString("cartazLink"));
                        filme.setSinopse(rs.getString("sinopse"));
                        filmes.add(filme);
                    }
                    rs.close();
                }
                ps.close();
                if(!filmes.isEmpty()){
                    return filmes;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            try (PreparedStatement ps = conexao.prepareStatement("SELECT p.idPessoa, f.idFilme, f.nome, f.dataLancamento, f.faixaEtaria, f.trailerLink, f.cartazLink, f.sinopse FROM catalogo_filmes.roteirista_filme AS r, catalogo_filmes.filme AS f, catalogo_filmes.pessoa AS p WHERE f.idFilme = r.idFilme AND p.idPessoa = r.idPessoa AND p.idPessoa = ?")) {
                ps.setInt(1, idPessoa);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Filme filme = new Filme();
                        filme.setIdFilme(rs.getInt("idFilme"));
                        filme.setNome(rs.getString("nome"));
                        filme.setFaixaEtaria(rs.getInt("faixaEtaria"));
                        filme.setDataLanc(rs.getDate("dataLancamento"));
                        filme.setCartazLink(rs.getString("cartazLink"));
                        filme.setSinopse(rs.getString("sinopse"));
                        filme.setCartazLink(rs.getString("cartazLink"));
                        filme.setSinopse(rs.getString("sinopse"));
                        filmes.add(filme);
                    }
                    rs.close();
                }
                ps.close();
                if(!filmes.isEmpty()){
                    return filmes;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}