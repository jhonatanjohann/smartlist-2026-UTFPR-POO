import controller.ListaDeComprasController;
import model.ListaDeCompras;
import view.ListaDeComprasView;

public class Main {
    public static void main(String[] args) {
        ListaDeCompras model = ListaDeCompras.getInstancia();
        ListaDeComprasView view = new ListaDeComprasView();
        ListaDeComprasController controller = new ListaDeComprasController(model, view);

        controller.iniciar();
    }
}
