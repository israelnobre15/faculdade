package SistemaLogistico;

public class FabricaMaritimo implements iFabricaModalidade {
    @Override
    public ABCModalidade fabricar(Double tarifa) {
        return new Maritimo(tarifa);
    }
}
