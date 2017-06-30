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

@WebServlet("/diretores")
public class ServletListaDiretores extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conexao = Conexao.getConexao();

        ArrayList<Pessoa> diretores = new PessoaDAO(conexao).listarDiretores();
        String tipoPessoa = "Diretores";

        req.setAttribute("pessoas", diretores);
        req.setAttribute("tipoPessoa", tipoPessoa);

        RequestDispatcher rd = req.getRequestDispatcher("/listaPessoas.jsp");
        rd.forward(req, resp);
    }
}
