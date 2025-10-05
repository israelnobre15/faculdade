package SistemaVendas;

import java.time.LocalDate;
import java.util.UUID;
import java.util.Random;

public class Pedido {
    public String id;
    public String cliente;
    public Double quantidade;
    public Double preco;
    public LocalDate data;

    public Pedido() {
        this.id = UUID.randomUUID().toString();
        this.cliente = "Cliente" + new Random().nextInt(101);
        this.quantidade = new Random().nextDouble();
        this.preco = new Random().nextInt(40) * this.quantidade;
        this.data = LocalDate.now();
    }

}
