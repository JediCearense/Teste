package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Parcelamento;
import services.ContratoServices;
import services.Paypal;

public class teste {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Número: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor do contrato:");
		double valor = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valor);
		
		System.out.print("Número de parcelas: ");
		int parcelas = sc.nextInt();
		
		ContratoServices cs = new ContratoServices(new Paypal());
		
		cs.processamentoContrato(contrato, parcelas);
		
		System.out.println();
		System.out.println("Parcelamento:");
		for(Parcelamento parcelamento : contrato.getListParcelamento()) {
			System.out.println(parcelamento);
		}
		

		sc.close();
	}
}
