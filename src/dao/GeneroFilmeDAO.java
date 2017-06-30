package dao;

import model.GeneroFilme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GeneroFilmeDAO {

    private Connection conexao;

    public GeneroFilmeDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public ArrayList<GeneroFilme> listarGenerosFilmes(){

        ArrayList<GeneroFilme> listaGenerosFilmes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexao.prepareStatement("SELECT idFilme, idGenero FROM genero_filme");
            rs = ps.executeQuery();

            while (rs.next()) {
                GeneroFilme generoFilme = new GeneroFilme();
                generoFilme.setIdFilme(rs.getInt("idFilme"));
                generoFilme.setIdGenero(rs.getInt("idGenero"));
                listaGenerosFilmes.add(generoFilme);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaGenerosFilmes;
    }
}
