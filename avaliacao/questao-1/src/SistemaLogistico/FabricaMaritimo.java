package SistemaLogistico;

public class FabricaMaritimo implements iFabricaModalidade {
    @Override
    public iModalidade fabricar(Double tarifa,Remessa remessa) {
        return new Maritimo(tarifa,remessa);
    }
}
