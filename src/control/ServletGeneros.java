package control;

import dao.Conexao;
import dao.GeneroDAO;
import model.Genero;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(value = "/generos")
public class ServletGeneros extends HttpServlet{

    public ServletGeneros() {super();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conexao = Conexao.getConexao();
        ArrayList<Genero> generos = new GeneroDAO(conexao).listaGeneros();

        req.setAttribute("generos", generos);

        RequestDispatcher rd = req.getRequestDispatcher("/generos.jsp");
        rd.forward(req, resp);
    }
}
