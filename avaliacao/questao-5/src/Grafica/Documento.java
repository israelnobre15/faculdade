package Grafica;

public abstract class Documento {

    String nomeCliente;
    String corPrimaria;
    String corSecundaria;
    String fonte;
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(nomeCliente + "\n")
        .append(corPrimaria + "\n")
        .append(corSecundaria + "\n")
        .append(fonte + "\n");
        return s.toString();

    }
}
