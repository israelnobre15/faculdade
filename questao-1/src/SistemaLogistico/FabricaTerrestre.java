package SistemaLogistico;

public class FabricaTerrestre implements iFabricaModalidade {
    @Override
    public ABCModalidade fabricar(Double tarifa) {
        return new Terrestre(tarifa);
    }
}
