package br.com.cristianomoraiscruz.pontodetaxi.model;

public class Ponto {

    private int numPonto;
    private int telefone1;
    private int telefone2;
    private String endereco;
    private String email;
    private String site;

    public int getNumPonto() {
        return numPonto;
    }

    public void setNumPonto(int numPonto) {
        this.numPonto = numPonto;
    }

    public int getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(int telefone1) {
        this.telefone1 = telefone1;
    }

    public int getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(int telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
