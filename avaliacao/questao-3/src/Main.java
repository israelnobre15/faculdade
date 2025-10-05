import leitor.*;

/*
O padrão de projeto escolhido para esta atividade foi o Observer, pois com o mesmo, conseguimos
informar uma classe que é observadora quando ouve "mudança" ou um comportamento foi acionado na classe observada
com isso, conseguimos fazer a administração de forma dinamica de quais pessoa recebem determinadas noticias de determinados topicos
com base em sesus interesses, também criando tópicos de forma dinamica sem gerar uma depencia de existence entre classes.
*/


public class Main {
    public static void main(String[] args) {

        Noticiario jornal_globo = new Noticiario();

        Leitor leitor1 = new Leitor("Cleber da silva","cleber_da_silva@gmail.com");
        Leitor leitor2 = new Leitor("Maria petrolina de souza","maria1234@gmail.com");
        Leitor leitor3 = new Leitor("Robertor pereira rocha","robertinho_da_galera@gmail.com");

        jornal_globo.mostrarTopicos();

        jornal_globo.seInscreverNoticia("tecnologia",leitor1);
        jornal_globo.seInscreverNoticia("tecnologia",leitor2);

        jornal_globo.publicarNoticias("tecnologia","Como se dar bem no mercado de t.i","Para se dar bem no mercado de t.i você precisa de indicação");

        jornal_globo.seInscreverNoticia("esportes",leitor3);

        jornal_globo.publicarNoticias("esportes","Qual foi o resultado do jogo do corinthias", "O jogo do corintias nesta ultima fase de grupos contra o palmeiras foi de 1x0 para o corintias");


    }
}