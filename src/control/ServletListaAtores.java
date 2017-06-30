package control;

import dao.Conexao;
import dao.PessoaDAO;
import model.Pessoa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet("/atores")
public class ServletListaAtores extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conexao = Conexao.getConexao();

        ArrayList<Pessoa> atores = new PessoaDAO(conexao).listarAtores();
        String tipoPessoa = "Atores";

        req.setAttribute("pessoas", atores);
        req.setAttribute("tipoPessoa", tipoPessoa);

        RequestDispatcher rd = req.getRequestDispatcher("/listaPessoas.jsp");
        rd.forward(req, resp);
    }
}
