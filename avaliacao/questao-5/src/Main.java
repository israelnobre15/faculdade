import Grafica.*;

/*
 O padrão de projeto escolhido para esta atividade foi o prototype pois o mesmo permite a criação de
 um modelo podendo ser clonado para outros objetos sem que o original seja alterado e permitindo que o clone
 modifique a si mesmo, gerando assim flexibilidade com relação as opções dos documentos.
*/

public class Main {
    public static void main(String[] args) {
        Curriculo modelo_1 = new Curriculo("roberval","Azul","amarelo","Arial 12");

        System.out.println("Modelo 1 básico");
        System.out.println(modelo_1.toString());

        Curriculo curriculo_roberval_2 = (Curriculo) modelo_1.clone();
        curriculo_roberval_2.modificar("roberval","Azul","vermelho","Merlo 45");

        System.out.println("Modelo modificado");
        System.out.println(curriculo_roberval_2.toString());

        System.out.println("Modelo original após a modificação da cópia");
        System.out.println(modelo_1.toString());

    }
}