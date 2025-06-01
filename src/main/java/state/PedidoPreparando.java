package state;

public class PedidoPreparando extends PedidoEstado {

    private PedidoPreparando() {}
    private static PedidoPreparando instance = new PedidoPreparando();

    public static PedidoPreparando getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Preparando";
    }

    @Override
    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoPronto.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        return false;
    }
}
