package state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
    }

    @Test
    public void deveConfirmarPedidoAberto() {
        pedido.setEstado(PedidoAberto.getInstance());
        assertTrue(pedido.confirmar());
        assertEquals(PedidoConfirmado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDevePrepararPedidoAberto() {
        pedido.setEstado(PedidoAberto.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void deveCancelarPedidoAberto() {
        pedido.setEstado(PedidoAberto.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void devePrepararPedidoConfirmado() {
        pedido.setEstado(PedidoConfirmado.getInstance());
        assertTrue(pedido.preparar());
        assertEquals(PedidoPreparando.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveCancelarPedidoPreparando() {
        pedido.setEstado(PedidoPreparando.getInstance());
        assertFalse(pedido.cancelar());
    }

    @Test
    public void deveEntregarPedidoPronto() {
        pedido.setEstado(PedidoPronto.getInstance());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveFazerNadaAposPedidoEntregue() {
        pedido.setEstado(PedidoEntregue.getInstance());
        assertFalse(pedido.confirmar());
        assertFalse(pedido.preparar());
        assertFalse(pedido.entregar());
        assertFalse(pedido.cancelar());
    }
}
