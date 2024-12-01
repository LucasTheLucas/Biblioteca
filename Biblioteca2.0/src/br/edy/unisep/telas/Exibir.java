package br.edy.unisep.telas;

import br.edy.unisep.model.Autor;
import br.edy.unisep.model.Genero;
import br.edy.unisep.model.Livro;

import javax.swing.*;
import java.util.List;

public class Exibir {
    public void exibir(List<Livro> livros, List<Autor> autores, List<Genero> generos)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Exibir Livros");
        frame.setSize(500,500);

        JPanel panel = new JPanel();

        for (int i = 0; i < livros.size(); i++)
            {
                String livro = "id: " + (i+1) + " - " +
                        "titulo: " + livros.get(i).getTitulo() + " - " +
                        " genero: " + generos.get(livros.get(i).getGenero()).getGenero() + " - " +
                        " Autor: " + autores.get(livros.get(i).getAutor()).getNome() + " - " +
                        " Disponível: " + (livros.get(i).isDisponivel()? "Sim":"Não");
                JLabel label = new JLabel(livro);
                panel.add(label);
            }

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);
        frame.setVisible(true);
    }
}

