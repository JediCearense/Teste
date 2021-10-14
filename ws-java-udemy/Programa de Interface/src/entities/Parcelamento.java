package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcelamento {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dataParcela;
	private double valorComTaxa;
	
	public Parcelamento(Date dataParcela, double valorComTaxa) {
		super();
		this.dataParcela = dataParcela;
		this.valorComTaxa = valorComTaxa;
	}
	public Date getDataParcela() {
		return dataParcela;
	}
	public void setDataParcela(Date dataParcela) {
		this.dataParcela = dataParcela;
	}
	 public double getValorComTaxa() {
		return valorComTaxa;
	}
	public void setValorComTaxa(double valorComTaxa) {
		this.valorComTaxa = valorComTaxa;
	}
	
	public String toString() {
		return String.format("%s - %.2f",sdf.format(dataParcela), valorComTaxa);
	}
	
	

}
