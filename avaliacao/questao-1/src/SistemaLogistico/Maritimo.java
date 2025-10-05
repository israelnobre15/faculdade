package SistemaLogistico;

public class Maritimo implements iModalidade {
    Double tarifa;
    Remessa remessa;
    public Maritimo(Double tarifa,Remessa remessa){
        this.tarifa =  tarifa;
        this.remessa = remessa;
    }

    @Override
    public void calcularTarifa() {
        System.out.println("Calculando tarifa");
        System.out.println("Sua tarifa área tem o custo de: "+ this.remessa.volume * this.tarifa);
    }
}
