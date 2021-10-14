package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contrato;
import entities.Parcelamento;

public class ContratoServices {
	
	private InterPaymenteService paymentService;
	
	public ContratoServices(InterPaymenteService paymentService) {
		this.paymentService = paymentService;
	}
	
	
	public void processamentoContrato(Contrato contrato, int numeroParcela) {
		
		double valorParcela = contrato.getValorLimpo() / numeroParcela;
		
		for(int i = 1; i <= numeroParcela; i++) {
			
			Date data = addData(contrato.getData(), i);
			
			double valorComTaxa1 = valorParcela + paymentService.addTaxa1(valorParcela, i);
			double valorComTaxa2 = valorComTaxa1 + paymentService.addtaxa2(valorComTaxa1);
		
			contrato.addParcelamento(new Parcelamento(data,valorComTaxa2));
		
		}
		
	}

	//método data
	private Date addData(Date data, int mes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.MONTH, mes);
		
		return calendar.getTime();
	}
	
}
