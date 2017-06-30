package control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.FilmeDAO;
import dao.GeneroDAO;
import dao.GeneroFilmeDAO;
import model.Filme;
import model.Genero;
import model.GeneroFilme;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(value = "/index.jsp")
public class ServletFilmes extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletFilmes() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conexao = Conexao.getConexao();

        ArrayList<Filme> filmes = new FilmeDAO(conexao).listarFilmes();
        ArrayList<Genero> generos = new GeneroDAO(conexao).listaGeneros();
        ArrayList<GeneroFilme>  generosFilmes = new GeneroFilmeDAO(conexao).listarGenerosFilmes();

        req.setAttribute("filmes", filmes);
        req.setAttribute("generos", generos);
        req.setAttribute("generosFilmes", generosFilmes);

        RequestDispatcher rd = req.getRequestDispatcher("/filmes.jsp");
        rd.forward(req, resp);
    }

}