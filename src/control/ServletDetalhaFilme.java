package control;

import dao.*;
import model.Filme;
import model.Genero;
import model.Personagem;
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
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(value = "/filme")
public class ServletDetalhaFilme extends HttpServlet{

    public ServletDetalhaFilme() {super();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AtomicReference<Connection> conexao = new AtomicReference<>(Conexao.getConexao());

        int id = Integer.parseInt(req.getParameter("id"));

        ArrayList<Personagem> personagens = new PersonagemDAO(conexao.get()).listaPersonagensFilme(id);
        Filme filme = new FilmeDAO(conexao.get()).selecionaFilme(id);
        ArrayList<Pessoa> diretores = new PessoaDAO(conexao.get()).listarDiretoresFilme(id);
        ArrayList<Pessoa> roteiristas = new PessoaDAO(conexao.get()).listarRoteiristasFilme(id);
        ArrayList<Pessoa> atores = new ArrayList<>();
        ArrayList<Genero> generos = new GeneroDAO(conexao.get()).listaGenerosFilme(id);

        for (Personagem personagem : personagens) {
            atores.add(new PessoaDAO(Conexao.getConexao()).selecionaPessoa(personagem.getIdPessoa()));
        }

        req.setAttribute("personagens", personagens);
        req.setAttribute("filme", filme);
        req.setAttribute("atores", atores);
        req.setAttribute("diretores", diretores);
        req.setAttribute("generos", generos);
        req.setAttribute("roteiristas", roteiristas);

        RequestDispatcher rd = req.getRequestDispatcher("/detalhaFilme.jsp");
        rd.forward(req, resp);
    }
}

