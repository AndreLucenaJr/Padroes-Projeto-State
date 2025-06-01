package state;

public class Pedido {
    
    private PedidoEstado estado;
    private String descricao;

    public Pedido() {
        this.estado = PedidoAberto.getInstance();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public boolean confirmar() {
        return estado.confirmar(this);
    }

    public boolean preparar() {
        return estado.preparar(this);
    }

    public boolean entregar() {
        return estado.entregar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public String getEstadoNome() {
        return estado.getEstado();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PedidoEstado getEstado() {
        return estado;
    }
}
