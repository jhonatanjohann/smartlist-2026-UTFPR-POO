package command;

import model.ListaDeCompras;
import view.ListaDeComprasView;

public class FiltrarPorQuantidadeMinimaCommand implements Command{
    private ListaDeCompras model;
    private ListaDeComprasView view;

    public FiltrarPorQuantidadeMinimaCommand(ListaDeCompras model, ListaDeComprasView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void execute() {
        int quantidadeMinima = view.lerQuantidadeMinima();
        System.out.println(model.filtrarPorQuantidadeMinima(quantidadeMinima).toString());
    }
}
