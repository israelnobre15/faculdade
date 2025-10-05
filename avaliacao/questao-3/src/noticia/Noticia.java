package noticia;

import leitor.iLeitor;

import java.util.ArrayList;

public class Noticia implements iNoticia {

    public String nome;
    public ArrayList<iLeitor> leitores;

    public Noticia(String nome){
        this.nome = nome;
        this.leitores = new ArrayList<>();

    }

    @Override
    public void inscrever(iLeitor leitor){
        if (!leitores.contains(leitor)) {
            leitores.add(leitor);
            System.out.println(leitor + " inscrito no tópico "+ this.nome);
        }

    }

    @Override
    public void desinscrever(iLeitor leitor) {
        if  (leitores.contains(leitor)) {
            leitores.remove(leitor);

            System.out.println(leitor + "removido do tópico "+ this.nome);
        }
    }
    @Override
    public void publicarNoticia(String titulo, String conteudo) {
        for (iLeitor leitor : leitores) {
            System.out.println("Publicando notícia " + titulo + "sobre " + this.nome);
            leitor.Atualizar(this.nome,titulo,conteudo);
        }
    }
}
