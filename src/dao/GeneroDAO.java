package dao;

import model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GeneroDAO {

    private Connection conexao;

    public GeneroDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public Genero selecionaGenero(int idGenero){

        Genero genero = new Genero();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexao.prepareStatement("SELECT idGenero, nome FROM genero WHERE idGenero=?");
            ps.setInt(1, idGenero);
            rs = ps.executeQuery();

            rs.next();
            genero.setIdGenero(rs.getInt("idGenero"));
            genero.setNome(rs.getString("nome"));

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return genero;
    }

    public ArrayList<Genero> listaGeneros(){

        ArrayList<Genero> listaGeneros = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexao.prepareStatement("SELECT idGenero, nome FROM genero");
            rs = ps.executeQuery();

            while (rs.next()) {
                Genero genero = new Genero();
                genero.setIdGenero(rs.getInt("idGenero"));
                genero.setNome(rs.getString("nome"));
                listaGeneros.add(genero);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaGeneros;
    }

    public ArrayList<Genero> listaGenerosFilme(int idFilme){

        ArrayList<Genero> listaGeneros = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexao.prepareStatement("SELECT g.idGenero, g.nome FROM genero_filme as gf, genero as g where g.idGenero = gf.idGenero and gf.idFilme = ?");
            ps.setInt(1, idFilme);
            rs = ps.executeQuery();

            while (rs.next()) {
                Genero genero = new Genero();
                genero.setIdGenero(rs.getInt("idGenero"));
                genero.setNome(rs.getString("nome"));
                listaGeneros.add(genero);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaGeneros;
    }
}
