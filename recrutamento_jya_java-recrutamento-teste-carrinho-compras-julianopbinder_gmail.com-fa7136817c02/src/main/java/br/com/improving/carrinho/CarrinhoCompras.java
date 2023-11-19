package br.com.improving.carrinho;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

	private Set<Item> itens;

	public CarrinhoCompras() {
		this.itens = new HashSet<>();
	}

	/**
     * Permite a adição de um novo item no carrinho de compras.
     *
     * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
     * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {

		if (produto == null || valorUnitario == null || quantidade <= 0) {
			throw new IllegalArgumentException("Parâmetros inválidos para adicionarItem: produto, valorUnitario ou quantidade inválidos");
		}
		Item novoItem = new Item(produto, valorUnitario, quantidade);

		if (itens.contains(novoItem)) {
			for (Item item : itens) {
				if (item.equals(novoItem)) {
					item.setQuantidade(item.getQuantidade() + quantidade);
					if (!item.getValorUnitario().equals(valorUnitario)) {
						item.setValorUnitario(valorUnitario);
					}
					return;
				}
			}
		}
		itens.add(novoItem);
    }

    /**
     * Permite a remoção do item que representa este produto do carrinho de compras.
     *
     * @param produto
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(Produto produto) {
		return itens.removeIf(item -> item.getProduto().equals(produto));
	}

    /**
     * Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na 
     * coleção, em que zero representa o primeiro item.
     *
     * @param posicaoItem
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(int posicaoItem) {
		List<Item> itemList = new ArrayList<>(itens);
		if (posicaoItem >= 0 && posicaoItem < itemList.size()) {
			itemList.remove(posicaoItem);
			itens = new HashSet<>(itemList);
			return true;
		}
		return false;
	}

    /**
     * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
     * de todos os itens que compõem o carrinho.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
		return itens.stream()
				.map(Item::getValorTotal)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Retorna a lista de itens do carrinho de compras.
     *
     * @return itens
     */
    public Collection<Item> getItens() {
		return new HashSet<>(itens);
    }
}