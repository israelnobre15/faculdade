import SistemaLogistico.*;
// O padrão utilizado nesta atividade é o padrão factory, pois temos uma abstração relacionada
// as possíveis formas de transporte, onde temos uma semelhança entre o método calcular tarifa
// fazendo com que pudessemos ter uma fabrica retornando um tipo abstrato de calculadora de tarifa
// Foi utilizado abstract class ao invés de interface para o ABCModalidade, para que pudessemos implementar
// um único construtor, mantendo as regras do original.

public class Main {
    public static void main(String[] args) {
        Remessa remessa = new Remessa(12.5,14.2,23.0);
        ABCModalidade tarifaAerea = new FabricaAereo().fabricar(12.4);
        tarifaAerea.calcularTarifa(remessa);

        ABCModalidade tarifaTerrestre = new FabricaTerrestre().fabricar(12.4);
        tarifaTerrestre.calcularTarifa(remessa);

        ABCModalidade tarifaMaritimo = new FabricaMaritimo().fabricar(12.4);
        tarifaMaritimo.calcularTarifa(remessa);

    }
}