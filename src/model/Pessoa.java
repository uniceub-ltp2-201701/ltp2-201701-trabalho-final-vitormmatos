package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Pessoa {

   private int idPessoa;
   private String nome;
   private Calendar dataNascimento = new GregorianCalendar();
   private int sexo;
   private String fotoLink;
   private String descricao;

    public Pessoa(){}

    public Pessoa(int idPessoa, String nome, Calendar dataNasc, int sexo, String fotoLink, String descricao) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.dataNascimento = dataNasc;
        this.sexo = sexo;
        this.fotoLink = fotoLink;
        this.descricao = descricao;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){ this.nome = nome; }

    public Calendar getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(Date data) {
        this.dataNascimento.setTime(data);
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getFotoLink() { return fotoLink; }

    public void setFotoLink(String fotoLink) { this.fotoLink = fotoLink; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
