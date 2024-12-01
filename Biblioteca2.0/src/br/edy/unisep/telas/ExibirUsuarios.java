package br.edy.unisep.telas;

import br.edy.unisep.model.Usuario;

import javax.swing.*;
import java.util.List;

public class ExibirUsuarios {
    public void exibirUsuarios(List<Usuario> usuarios)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Exibir Usuarios");
        frame.setSize(500,500);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int i = 0; i < usuarios.size(); i++)
        {
            JLabel label = new JLabel((i+1) + " - " + usuarios.get(i).getNome());
            panel.add(label);
        }
        frame.add(panel);

        frame.setVisible(true);
    }
}
