package state;

public class PedidoPronto extends PedidoEstado {

    private PedidoPronto() {}
    private static PedidoPronto instance = new PedidoPronto();

    public static PedidoPronto getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Pronto";
    }

    @Override
    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoEntregue.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        return false;
    }
}
