package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    /**
     * Construtor da classe Item.
     * 
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
    }

    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
		return produto;
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
		return valorUnitario;
    }

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

    /**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
		return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item) o;
		return quantidade == item.quantidade &&
				produto.equals(item.produto) &&
				valorUnitario.equals(item.valorUnitario);
	}

	@Override
	public int hashCode() {
		return Objects.hash(produto, valorUnitario, quantidade);
	}
}
