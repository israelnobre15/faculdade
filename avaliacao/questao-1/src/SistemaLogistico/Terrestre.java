package SistemaLogistico;

public class Terrestre implements iModalidade {

    Double tarifa;
    Remessa remessa;
    public Terrestre(Double tarifa,Remessa remessa) {
        this.tarifa = tarifa;
        this.remessa = remessa;
    }
    @Override
    public void calcularTarifa() {
        System.out.println("Calculando tarifa");
        System.out.println("Sua tarifa área tem o custo de: "+ this.remessa.distancia * this.tarifa);
    }
}
