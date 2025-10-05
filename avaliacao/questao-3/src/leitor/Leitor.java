package leitor;

public class Leitor implements iLeitor {
    public String nome;
    public String email;

    public Leitor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }


    @Override
    public void Atualizar(String topico, String titulo, String conteudo) {
        System.out.println("Nova notícia chegou no email " + this.email + " sobre " + conteudo + " titulo: " + titulo);
    }
}
