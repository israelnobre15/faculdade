package Grafica;

public interface iDocumentoPrototype {
    public iDocumentoPrototype clone();
    public void modificar(String nomeCliente,String corPrimaria, String corSecundaria, String fonte);

}
