package  command;

import model.ListaDeCompras;
import model.PersistenciaJson;

public class SalvarEmArquivoJsonCommand implements Command {
    private ListaDeCompras model;

    public SalvarEmArquivoJsonCommand(ListaDeCompras model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.setEstrategiaPersistencia(new PersistenciaJson());
        model.salvar("lista_compras.json");
    }
}
