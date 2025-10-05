package SistemaLogistico;

public class CalculadoraTarifa {
    public void Calcular(iFabricaModalidade fabricaModalidade,Double tarifa, Remessa remessa){

        iModalidade modalidade = fabricaModalidade.fabricar(tarifa,remessa);

        modalidade.calcularTarifa();

    }
}
