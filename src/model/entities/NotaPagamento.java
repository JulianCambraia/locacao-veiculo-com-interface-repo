package model.entities;

public class NotaPagamento {

	private Double pagamentoBasico;
	private Double taxaAluguel;

	public NotaPagamento() {
		super();
	}

	public NotaPagamento(Double pagamentoBasico, Double taxaAluguel) {
		super();
		this.pagamentoBasico = pagamentoBasico;
		this.taxaAluguel = taxaAluguel;
	}

	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public Double getTaxaAluguel() {
		return taxaAluguel;
	}

	public void setTaxaAluguel(Double taxaAluguel) {
		this.taxaAluguel = taxaAluguel;
	}

	public Double getPagamentoTotal() {
		return getPagamentoBasico() + getTaxaAluguel();
	}
}