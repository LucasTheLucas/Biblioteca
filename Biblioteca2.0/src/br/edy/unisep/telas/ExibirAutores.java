package br.edy.unisep.telas;

import br.edy.unisep.model.Autor;

import javax.swing.*;
import java.util.List;

public class ExibirAutores {
    public void ExibirAutores(List<Autor> autores)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Exibir Autores");
        frame.setSize(500,500);

        JPanel panel = new JPanel();

        for (int i = 0; i < autores.size(); i++)
        {
            JLabel label = new JLabel((i+1) + " - " + autores.get(i).getNome());
            panel.add(label);
        }
        frame.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frame.setVisible(true);
    }
}
