package br.com.improving.carrinho;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {

		Produto produto1 = new Produto(1L, "iphone 14 pro max");
		Produto produto2 = new Produto(2L, "Smart TV LG Nanocell 55' 4K");

		CarrinhoComprasFactory carrinhoComprasFactory = new CarrinhoComprasFactory();
		CarrinhoCompras carrinhoCliente1 = carrinhoComprasFactory.criar("Juliano Petrillo Binder");

		carrinhoCliente1.adicionarItem(produto1, new BigDecimal("7599.00"), 2);
		carrinhoCliente1.adicionarItem(produto2, new BigDecimal("2564.05"), 3);

		System.out.println("Itens no Carrinho do Cliente1:");
		carrinhoCliente1.getItens().forEach(item ->
				System.out.println(item.getProduto().getDescricao() +
						" - Quantidade: " + item.getQuantidade() +
						" - Valor Unitário: " + item.getValorUnitario() +
						" - Valor Total: " + item.getValorTotal())
		);

		carrinhoCliente1.removerItem(produto1);

		System.out.println("\nItens no Carrinho do Cliente1 após a remoção:");
		carrinhoCliente1.getItens().forEach(item ->
				System.out.println(item.getProduto().getDescricao() +
						" - Quantidade: " + item.getQuantidade() +
						" - Valor Unitário: " + item.getValorUnitario() +
						" - Valor Total: " + item.getValorTotal())
		);

		System.out.println("\nValor Total do Carrinho do Juliano: " + carrinhoCliente1.getValorTotal());

		System.out.println("\nValor Médio dos Carrinhos: " + carrinhoComprasFactory.getValorTicketMedio());
	}
}