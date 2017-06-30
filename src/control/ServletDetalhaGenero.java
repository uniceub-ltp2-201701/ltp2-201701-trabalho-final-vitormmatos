package control;

import dao.Conexao;
import dao.FilmeDAO;
import dao.GeneroDAO;
import dao.GeneroFilmeDAO;
import model.Filme;
import model.Genero;
import model.GeneroFilme;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet("/genero")
public class ServletDetalhaGenero extends HttpServlet{

    public ServletDetalhaGenero() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conexao = Conexao.getConexao();

        int id = Integer.parseInt(req.getParameter("id"));

        ArrayList<Filme> filmes = new FilmeDAO(conexao).listarFilmesGenero(id);
        Genero genero = new GeneroDAO(conexao).selecionaGenero(id);

        req.setAttribute("filmes", filmes);
        req.setAttribute("genero", genero);

        RequestDispatcher rd = req.getRequestDispatcher("/detalhaGenero.jsp");
        rd.forward(req, resp);
    }
}
