package services;

public class Paypal implements InterPaymenteService {

	@Override
	public double addTaxa1(double parcelaLimpa, int mes) {
		return parcelaLimpa * mes * 0.01;
	}

	@Override
	public double addtaxa2(double ParcelaComTaxa1) {
		return ParcelaComTaxa1 * 0.02;
	}
	
	

}
