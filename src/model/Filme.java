package model;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Filme {

    private int idFilme;
    private String nome;
    private int faixaEtaria;
    private Calendar dataLancamento = new GregorianCalendar();
    private String trailerLink;
    private String cartazLink;
    private String sinopse;

    public Filme(){}

    public Filme(Integer idFilme, String nome, Integer faixaEtaria, Calendar dataLanc,
                 String trailerLink, String cartazLink, String sinopse){
        this.idFilme = idFilme;
        this.nome = nome;
        this.faixaEtaria = faixaEtaria;
        this.dataLancamento = dataLanc;
        this.trailerLink = trailerLink;
        this.cartazLink = cartazLink;
        this.sinopse = sinopse;
    }

    public Integer getIdFilme(){
        return this.idFilme;
    }

    public void setIdFilme(Integer idFilme) { this.idFilme = idFilme;}

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getFaixaEtaria(){
        return this.faixaEtaria;
    }

    public void setFaixaEtaria(int faixaEtaria) { this.faixaEtaria = faixaEtaria; }

    public Calendar getDataLanc(){
        return this.dataLancamento;
    }

    public void setDataLanc(Date data){ this.dataLancamento.setTime(data); }

    public String getTrailerLink() { return trailerLink; }

    public void setTrailerLink(String trailerLink) { this.trailerLink = trailerLink; }

    public String getCartazLink() { return cartazLink; }

    public void setCartazLink(String cartazLink) { this.cartazLink = cartazLink; }

    public String getSinopse() { return sinopse; }

    public void setSinopse(String sinopse) { this.sinopse = sinopse; }
}
