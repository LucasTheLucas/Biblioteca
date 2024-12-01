package br.edy.unisep.funcoes;

import br.edy.unisep.model.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Funcoes {


    public File verificarSeExiste()
    {
        File pasta = new File("C://Biblioteca 2.0");
        if(!pasta.exists())
        {
            pasta.mkdir();
        }
        return pasta;
    }

    public List<Genero> lerGenero()
    {
        File genero = new File(verificarSeExiste(),"genero.txt");
        List<Genero> generos = new ArrayList<Genero>();
        if(genero.exists())
        {
            try
            {
                FileReader fr = new FileReader(genero);
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while ((linha = br.readLine()) != null)
                {
                    String[] objeto = linha.split(";");
                    Genero toObject = new Genero(objeto[0]);
                    generos.add(toObject);
                }
                br.close();
                fr.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return generos;
    }
    //----------------------------------------------------------------------

    public List<Autor> lerAutor()
    {
        File autor = new File(verificarSeExiste(),"autor.txt");
        List<Autor> autores = new ArrayList<Autor>();
        if(autor.exists())
        {
            try
            {
                FileReader fr = new FileReader(autor);
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while ((linha = br.readLine()) != null)
                {
                    String[] objeto = linha.split(";");
                    Autor toObject = new Autor(objeto[0]);
                    autores.add(toObject);
                }
                br.close();
                fr.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return autores;
    }
    //-------------------------------------------------------------------

    public List<Livro> lerLivro() {
        File livro = new File(verificarSeExiste(), "livro.txt");
        List<Livro> livros = new ArrayList<Livro>();
        if (livro.exists()) {
            try {
                FileReader fr = new FileReader(livro);
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] objeto = linha.split(";");
                    String nomeLivro = objeto[0];
                    int autorId = Integer.parseInt(objeto[1]);
                    int generoId = Integer.parseInt(objeto[2]);

                    int boolBruto = Integer.parseInt(objeto[3]);
                    boolean disponivel = boolBruto == 1? true : false;

                    Livro livroObjeto = new Livro(nomeLivro, autorId, generoId, disponivel);
                    livros.add(livroObjeto);
                }
                    br.close();
                    fr.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return livros;
    }

    //--------------------------------------------------------------------

    public List<Usuario> lerUsuario()
    {
        File usuario = new File(verificarSeExiste(),"usuario.txt");
        List<Usuario> usuarios = new ArrayList<Usuario>();
        if(usuario.exists())
        {
            try
            {
                FileReader fr = new FileReader(usuario);
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while ((linha = br.readLine()) != null)
                {
                    String[] objeto = linha.split(";");
                    Usuario toObject = new Usuario(objeto[0]);
                    usuarios.add(toObject);
                }
                br.close();
                fr.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return usuarios;
    }
    //-------------------------------------------------------------------------

    public List<Emprestimo> lerEmprestimo()
    {
        File emprestimo = new File(verificarSeExiste(),"emprestimo.txt");
        List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        if(emprestimo.exists())
        {
            try
            {
                FileReader fr = new FileReader(emprestimo);
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while ((linha = br.readLine()) != null)
                {
                    String[] objeto = linha.split(";");
                    Emprestimo toObject = new Emprestimo(Integer.parseInt(objeto[0]),Integer.parseInt(objeto[1]));
                    emprestimos.add(toObject);
                }
                br.close();
                fr.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return emprestimos;
    }
    public void AddUsuario(List<Usuario> usuarios)
    {
        String txt = JOptionPane.showInputDialog(null,"Digite o nome do usuario");
        if (txt != null)
        {
            if(!txt.isEmpty())
            {
                usuarios.add(new Usuario(txt));
            }
        }
    }
    public void AddAutor(List<Autor> autores)
    {
        String txt = JOptionPane.showInputDialog(null,"Digite o nome do autor");
        if (txt != null)
        {
            if(!txt.isEmpty())
            {
                autores.add(new Autor(txt));
            }
        }
    }

    public void AddGenero(List<Genero> generos)
    {
        String txt = JOptionPane.showInputDialog(null,"Digite o nome do genero");
        if (txt != null)
        {
            if(!txt.isEmpty())
            {
                generos.add(new Genero(txt));
            }
        }
    }
    public void AddLivro(List<Livro> livros, List<Autor> autores, List<Genero> generos) {
        String nomeLivro = JOptionPane.showInputDialog(null, "Digite o nome do livro:");
        if (nomeLivro == null || nomeLivro.trim().isEmpty()) return;

        String autorIdTexto = JOptionPane.showInputDialog(null, "Digite o índice do autor:");
        if (autorIdTexto == null || autorIdTexto.trim().isEmpty()) return;

        int autorId = Integer.parseInt(autorIdTexto) - 1;
        if (autorId < 0 || autorId >= autores.size()) return;

        String generoIdTexto = JOptionPane.showInputDialog(null, "Digite o índice do gênero:");
        if (generoIdTexto == null || generoIdTexto.trim().isEmpty()) return;

        int generoId = Integer.parseInt(generoIdTexto) - 1;
        if (generoId < 0 || generoId >= generos.size()) return;

        livros.add(new Livro(nomeLivro, autorId, generoId, true));
    }

    public void devolverLivro(List<Livro> livros)
    {
        String txt = JOptionPane.showInputDialog(null,"Digite o index do livro que vai devolver");
        if (txt != null || !txt.trim().isEmpty())
        {
            livros.get(Integer.parseInt(txt)-1).setDisponivel(true);
        };
    }
    public void emprestarLivro(List<Livro> livros, List<Usuario> usuarios)
    {
        String livroIndexStr = JOptionPane.showInputDialog(null, "Digite o índice do livro que deseja emprestar:");
        if (livroIndexStr != null && !livroIndexStr.trim().isEmpty())
        {
            int livroIndex = Integer.parseInt(livroIndexStr) - 1;
            if (livroIndex >= 0 && livroIndex < livros.size())
            {
                Livro livro = livros.get(livroIndex);
                if (livro.isDisponivel())
                {
                    String usuarioIndexStr = JOptionPane.showInputDialog(null, "Digite o índice do usuário:");
                    if (usuarioIndexStr != null && !usuarioIndexStr.trim().isEmpty())
                    {
                        int usuarioIndex = Integer.parseInt(usuarioIndexStr) - 1;
                        if (usuarioIndex >= 0 && usuarioIndex < usuarios.size())
                        {
                            livro.setDisponivel(false);
                        }
                    }
                }
            }
        }

    }
    public void SalvarTudo(List<Livro> livros, List<Usuario> usuarios, List<Autor> autores, List<Genero> generos,List<Emprestimo> emprestimos)
    {
        File pasta = new File("C://Biblioteca 2.0");
        if(!pasta.exists())
        {
            pasta.mkdir();
        }

        File usuarioFile = new File(pasta, "usuario.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usuarioFile))) {
            for (Usuario usuario : usuarios) {
                writer.write(usuario.getNome()+";");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File generoFile = new File(pasta, "genero.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(generoFile))) {
            for (Genero genero : generos) {
                writer.write(genero.getGenero()+";");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File autorFile = new File(pasta, "autor.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(autorFile))) {
            for (Autor autor : autores) {
                writer.write(autor.getNome()+";");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File livroFile = new File(pasta, "livro.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(livroFile))) {
            for (Livro livro : livros) {
                writer.write(livro.getTitulo()+";"+livro.getAutor()+";"+livro.getGenero()+";"+(livro.isDisponivel()? 1:0+";"));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File emprestimoFile = new File(pasta, "emprestimo.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(emprestimoFile))) {
            for (Emprestimo emprestimo : emprestimos) {
                writer.write(emprestimo.getLivro()+";"+emprestimo.getUsuario()+";");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
