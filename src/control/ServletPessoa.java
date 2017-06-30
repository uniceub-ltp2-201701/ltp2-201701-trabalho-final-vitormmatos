package control;

import dao.Conexao;
import dao.PessoaDAO;
import dao.FilmeDAO;
import dao.PersonagemDAO;
import model.Pessoa;
import model.Filme;
import model.Personagem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(value = "/pessoa")
public class ServletPessoa extends HttpServlet{

    public ServletPessoa() {super();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conexao = Conexao.getConexao();

        int id = Integer.parseInt(req.getParameter("id"));

        Pessoa pessoa = new PessoaDAO(conexao).selecionaPessoa(id);
        ArrayList<Personagem> personagens = new PersonagemDAO(conexao).listarPersonagensAtor(id);
        ArrayList<Filme> filmes = new FilmeDAO(conexao).listarFilmesPessoa(id);

        req.setAttribute("pessoa", pessoa);
        req.setAttribute("filmes", filmes);

        RequestDispatcher rd = req.getRequestDispatcher("/pessoa.jsp");
        rd.forward(req, resp);
    }
}
