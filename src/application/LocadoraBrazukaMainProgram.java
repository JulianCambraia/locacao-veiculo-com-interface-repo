package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Veiculo;
import model.entities.VeiculoAlugado;
import model.services.AluguelService;
import model.services.TaxaBrasilService;

public class LocadoraBrazukaMainProgram {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		System.out.println("Entre com os dados do veículo a ser alugado:");
		System.out.print("Modelo:");
		String pModelo = sc.nextLine();
		System.out.print("Início locação: (dd/MM/yyyy HH:ss)");
		Date pInicio = sdf.parse(sc.nextLine());
		System.out.print("Término locação: (dd/MM/yyyy HH:ss)");
		Date pTermino = sdf.parse(sc.nextLine());

		VeiculoAlugado veiculoAlugado = new VeiculoAlugado(pInicio, pTermino, new Veiculo(pModelo));
		System.out.println("Entre com o preço por hora: ");
		double precoPorHora = sc.nextDouble();
		System.out.println("Entre com o preço por Dia: ");
		double precoPorDia = sc.nextDouble();

		AluguelService aluguelService = new AluguelService(precoPorDia, precoPorHora, new TaxaBrasilService());
		aluguelService.processarFatura(veiculoAlugado);

		System.out.println("Fatura:");
		System.out.println(
				"Pagamento básico: " + String.format("%.2f", veiculoAlugado.getNotaPagamento().getPagamentoBasico()));
		System.out.println("Taxa: " + String.format("%.2f", veiculoAlugado.getNotaPagamento().getTaxaAluguel()));
		System.out.println(
				"Pagamento total: " + String.format("%.2f", veiculoAlugado.getNotaPagamento().getPagamentoTotal()));

		sc.close();

	}

}
