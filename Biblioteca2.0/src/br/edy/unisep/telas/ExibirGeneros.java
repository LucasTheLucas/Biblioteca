package br.edy.unisep.telas;

import br.edy.unisep.model.Genero;
import br.edy.unisep.model.Usuario;

import javax.swing.*;
import java.util.List;

public class ExibirGeneros {
    public void exibirGeneros(List<Genero> generos)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Exibir Generos");
        frame.setSize(500,500);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int i = 0; i < generos.size(); i++)
        {
            JLabel label = new JLabel((i+1) + " - " + generos.get(i).getGenero());
            panel.add(label);
        }
        frame.add(panel);

        frame.setVisible(true);
    }
}
