package gestaotransporte;

import java.util.List;

public class Viagem {
    private static int contadorId = 1;
    private int id;
    private String descricao;
    private String cidadeOrigem;
    private String cidadeDestino;
    private List<Produto> produtos;
    private Motorista motorista;
    private Cliente cliente;
    private String status;

    public Viagem(String descricao, String cidadeOrigem, String cidadeDestino, List<Produto> produtos, Motorista motorista, Cliente cliente) {
        this.id = contadorId++;
        this.descricao = descricao;
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.produtos = produtos;
        this.motorista = motorista;
        this.cliente = cliente;
        this.status = "Iniciada";
        motorista.setOcupado(true);
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public void finalizar() {
        this.status = "Finalizada";
        motorista.setOcupado(false);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Descrição: " + descricao + ", Origem: " + cidadeOrigem +
                ", Destino: " + cidadeDestino + ", Status: " + status +
                ", Motorista: " + motorista.getNome() + ", Cliente: " + cliente.getNome();
    }
}
