import leitor.*;
import noticia.*;

import java.util.HashMap;

public class Noticiario {
    private HashMap<String,Noticia> noticias;

    public Noticiario() {
        this.noticias = new HashMap<>();
        this.inicializarTopicosBase();
    }

    private void inicializarTopicosBase(){
        noticias.put("politica", new Noticia("politica"));
        noticias.put("esportes", new Noticia("esportes"));
        noticias.put("tecnologia", new Noticia("tecnologia"));
    }

    public void seInscreverNoticia(String nomeNoticia, iLeitor leitor){
        iNoticia noticia = noticias.get(nomeNoticia);
        noticia.inscrever(leitor);
    }

    public void desinscreverNoticia(String nomeNoticia, iLeitor leitor){
        iNoticia noticia = noticias.get(nomeNoticia);
        noticia.desinscrever(leitor);
    }

    public void publicarNoticias(String nomeNoticia,String titulo, String conteudo) {

        iNoticia noticia = noticias.get(nomeNoticia);
        noticia.publicarNoticia(titulo,conteudo);

    }

    public void adicionarNovoTema(String nomeNoticia){
        noticias.put(nomeNoticia, new Noticia(nomeNoticia));
        System.out.println("Adicionando novo tema " + nomeNoticia);
    }

    public void mostrarTopicos(){
        System.out.println(noticias);
    }

}
