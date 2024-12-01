package br.edy.unisep.view;

import br.edy.unisep.funcoes.Funcoes;
import br.edy.unisep.model.*;
import br.edy.unisep.telas.Exibir;
import br.edy.unisep.telas.ExibirAutores;
import br.edy.unisep.telas.ExibirGeneros;
import br.edy.unisep.telas.ExibirUsuarios;

import javax.swing.*;
import java.util.List;

public class Principal {
    public static void main(String[] args)
    {
        Exibir exibirTela = new Exibir();
        ExibirGeneros exibirGenerosTela = new ExibirGeneros();
        ExibirAutores exibirAutoresTela = new ExibirAutores();
        ExibirUsuarios exibirUsuariosTela = new ExibirUsuarios();
        Funcoes funcoes = new Funcoes();

        List<Autor> autores = funcoes.lerAutor();
        List<Genero> generos = funcoes.lerGenero();
        List<Usuario> usuarios = funcoes.lerUsuario();
        List<Livro> livros = funcoes.lerLivro();
        List<Emprestimo> emprestimos = funcoes.lerEmprestimo();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Biblioteca 2.0");
        frame.setSize(500, 500);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        JPanel panelLivros = new JPanel();
        JLabel tituloLivros = new JLabel("Livros:");
        JButton exibirLivros = new JButton("Exibir Livros");
        exibirLivros.addActionListener(e -> {
            exibirTela.exibir(livros, autores, generos);
        });
        JButton adicionarLivro = new JButton("Adicionar Livro");
        adicionarLivro.addActionListener(e -> {
            funcoes.AddLivro(livros, autores, generos);
        });
        panelLivros.add(tituloLivros);
        panelLivros.add(exibirLivros);
        panelLivros.add(adicionarLivro);

        JPanel panelUsuario = new JPanel();
        JLabel tituloUsuario = new JLabel("Usuários:");
        JButton exibirUsuarios = new JButton("Exibir Usuários");
        exibirUsuarios.addActionListener(e -> {
            exibirUsuariosTela.exibirUsuarios(usuarios);
        });
        JButton adicionarUsuario = new JButton("Adicionar Usuário");
        adicionarUsuario.addActionListener(e -> {
            funcoes.AddUsuario(usuarios);
        });
        panelUsuario.add(tituloUsuario);
        panelUsuario.add(exibirUsuarios);
        panelUsuario.add(adicionarUsuario);

        JPanel panelAutor = new JPanel();
        JLabel tituloAutor = new JLabel("Autores:");
        JButton exibirAutores = new JButton("Exibir Autores");
        exibirAutores.addActionListener(e -> {
            exibirAutoresTela.ExibirAutores(autores);
        });
        JButton adicionarAutor = new JButton("Adicionar Autor");
        adicionarAutor.addActionListener(e -> {
            funcoes.AddAutor(autores);
        });
        panelAutor.add(tituloAutor);
        panelAutor.add(exibirAutores);
        panelAutor.add(adicionarAutor);

        JPanel panelGenero = new JPanel();
        JLabel tituloGenero = new JLabel("Gêneros:");
        JButton exibirGeneros = new JButton("Exibir Gêneros");
        exibirGeneros.addActionListener(e -> {
            exibirGenerosTela.exibirGeneros(generos);
        });
        JButton adicionarGenero = new JButton("Adicionar Gênero");
        adicionarGenero.addActionListener(e -> {
            funcoes.AddGenero(generos);
        });
        panelGenero.add(tituloGenero);
        panelGenero.add(exibirGeneros);
        panelGenero.add(adicionarGenero);

        JPanel panelEmprestimo = new JPanel();
        JLabel tituloEmprestimo = new JLabel("Empréstimo:");
        JButton emprestarLivro = new JButton("Emprestar Livro");
        emprestarLivro.addActionListener(e -> {
            funcoes.emprestarLivro(livros, usuarios);
        });
        JButton devolverLivro = new JButton("Devolver Livro");
        devolverLivro.addActionListener(e -> {
            funcoes.devolverLivro(livros);
        });
        panelEmprestimo.add(tituloEmprestimo);
        panelEmprestimo.add(emprestarLivro);
        panelEmprestimo.add(devolverLivro);

        JButton sair = new JButton("Sair");
        sair.addActionListener(e -> {
            funcoes.SalvarTudo(livros,usuarios,autores,generos,emprestimos);
            System.exit(0);
        });

        painelPrincipal.add(panelLivros);
        painelPrincipal.add(panelUsuario);
        painelPrincipal.add(panelAutor);
        painelPrincipal.add(panelGenero);
        painelPrincipal.add(panelEmprestimo);
        painelPrincipal.add(sair);

        frame.add(painelPrincipal);

        frame.setVisible(true);
    }
}
