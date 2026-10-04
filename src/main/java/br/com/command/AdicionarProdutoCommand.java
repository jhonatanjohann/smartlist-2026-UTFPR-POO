package command;

import model.ListaDeCompras;
import model.Produto;
import view.ListaDeComprasView;

public class AdicionarProdutoCommand implements Command {
    private ListaDeCompras model;
    private ListaDeComprasView view;

    public AdicionarProdutoCommand(ListaDeCompras model, ListaDeComprasView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void execute() {
        // Código trazido da classe Controller
        String nome = view.lerNomeProduto();
        int quantidade = view.lerQuantidade();
        double preco = view.lerPreco();
        model.adicionarProduto(new Produto(nome, quantidade, preco));
        view.exibirMensagem("Produto adicionado com sucesso!");
    }
}