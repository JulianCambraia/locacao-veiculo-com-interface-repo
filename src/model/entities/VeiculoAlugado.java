package model.entities;

import java.util.Date;

public class VeiculoAlugado {
	private Date inicioLocacao;
	private Date fimLocacao;
	private Veiculo veiculo;
	private NotaPagamento notaPagamento;

	public VeiculoAlugado() {
		super();
	}
	
	

	public VeiculoAlugado(Date inicioLocacao, Date fimLocacao, Veiculo veiculo) {
		super();
		this.inicioLocacao = inicioLocacao;
		this.fimLocacao = fimLocacao;
		this.veiculo = veiculo;
	}



	public Date getInicioLocacao() {
		return inicioLocacao;
	}

	public void setInicioLocacao(Date inicioLocacao) {
		this.inicioLocacao = inicioLocacao;
	}

	public Date getFimLocacao() {
		return fimLocacao;
	}

	public void setFimLocacao(Date fimLocacao) {
		this.fimLocacao = fimLocacao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public NotaPagamento getNotaPagamento() {
		return notaPagamento;
	}

	public void setNotaPagamento(NotaPagamento notaPagamento) {
		this.notaPagamento = notaPagamento;
	}

}
