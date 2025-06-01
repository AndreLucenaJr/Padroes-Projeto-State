package state;

public class PedidoAberto extends PedidoEstado {

    private PedidoAberto() {}
    private static PedidoAberto instance = new PedidoAberto();

    public static PedidoAberto getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Aberto";
    }

    @Override
    public boolean confirmar(Pedido pedido) {
        pedido.setEstado(PedidoConfirmado.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoCancelado.getInstance());
        return true;
    }
}
