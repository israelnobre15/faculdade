package Grafica;

import javax.print.Doc;

public class Curriculo extends Documento implements iDocumentoPrototype{

    public Curriculo(String nomeCliente, String corPrimaria, String corSecundaria, String fonte) {
        this.nomeCliente = nomeCliente;
        this.corPrimaria = corPrimaria;
        this.corSecundaria = corSecundaria;
        this.fonte = fonte;
    }

    public Curriculo(Curriculo curriculo) {
        this.nomeCliente = curriculo.nomeCliente;
        this.corPrimaria = curriculo.corPrimaria;
        this.corSecundaria = curriculo.corSecundaria;
        this.fonte = curriculo.fonte;
    }

    @Override
    public iDocumentoPrototype clone() {
        return new Curriculo(this);
    }

    @Override
    public void modificar(String nomeCliente, String corPrimaria, String corSecundaria, String fonte) {
        this.nomeCliente = nomeCliente;
        this.corPrimaria = corPrimaria;
        this.corSecundaria = corSecundaria;
        this.fonte = fonte;
    }
}
