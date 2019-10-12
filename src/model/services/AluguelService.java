package model.services;

import model.entities.NotaPagamento;
import model.entities.VeiculoAlugado;

public class AluguelService {

	private Double precoPorDia;
	private Double precoPorHora;
	private TaxaService taxaService;
	private VeiculoAlugado veiculoAlugado;

	public AluguelService() {
		super();
	}

	public AluguelService(Double precoPorDia, Double precoPorHora, TaxaService brasilService) {
		super();
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.taxaService = brasilService;
	}

	/**
	 * Responsável em processar/calcular e gerar a Nota de pagamento
	 * 
	 * @param veiculoAlugado
	 */
	public void processarFatura(VeiculoAlugado veiculoAlugado) {
		long instanteEmprestimo = veiculoAlugado.getInicioLocacao().getTime();
		long instanteDevolucao = veiculoAlugado.getFimLocacao().getTime();
		double horas = (double) (instanteDevolucao - instanteEmprestimo) / 1000 / 60 / 60;
		double pagamentoBasico = 0.00;
		if (horas <= 12) {
			pagamentoBasico = Math.ceil(horas) * precoPorHora;
		} else {
			pagamentoBasico = Math.ceil(horas / 24) * precoPorDia;

		}
		double taxa = taxaService.taxa(pagamentoBasico);
		veiculoAlugado.setNotaPagamento(new NotaPagamento(pagamentoBasico, taxa));
	}

}
