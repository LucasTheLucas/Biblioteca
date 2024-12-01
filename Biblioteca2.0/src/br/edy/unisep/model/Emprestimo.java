package br.edy.unisep.model;

public class Emprestimo {

    private int livro;
    private int usuario;

    public Emprestimo() {}

    public Emprestimo(int livro, int usuario)
    {
        this.livro = livro;
        this.usuario = usuario;
    }

    public int getLivro() {
        return livro;
    }

    public void setLivro(int livro) {
        this.livro = livro;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
}
