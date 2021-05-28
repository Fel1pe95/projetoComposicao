package Entidades;

import java.util.Date;

public class Contratos {

	private double valorPorHora;
	private int duracao;
	private Date data;

	public Contratos() {

	}

	public Contratos(double valorPorHora, int duracao, Date data) {
		this.valorPorHora = valorPorHora;
		this.duracao = duracao;
		this.data = data;
	}

	public double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int horas) {
		this.duracao = horas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double valorTotalDeHoras() {

		return valorPorHora * duracao;
		
		

	}

}
