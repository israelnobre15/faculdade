package noticia;
import leitor.iLeitor;

public interface iNoticia {
    public void inscrever(iLeitor leitor);
    public void desinscrever(iLeitor leitor);
    public void publicarNoticia(String titulo, String conteudo);
}
