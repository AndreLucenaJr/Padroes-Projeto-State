package state;

public class PedidoConfirmado extends PedidoEstado {

    private PedidoConfirmado() {}
    private static PedidoConfirmado instance = new PedidoConfirmado();

    public static PedidoConfirmado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Confirmado";
    }

    @Override
    public boolean preparar(Pedido pedido) {
        pedido.setEstado(PedidoPreparando.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoCancelado.getInstance());
        return true;
    }
}
