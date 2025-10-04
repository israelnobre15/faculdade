package SistemaLogistico;

public abstract class ABCModalidade {

    public Double tarifa;

    public ABCModalidade(Double tarifa){
        this.tarifa = tarifa;
    }



    public abstract void calcularTarifa(Remessa remessa);
}
