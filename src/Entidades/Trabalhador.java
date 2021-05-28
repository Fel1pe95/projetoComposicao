package Entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Entidades.enums.Worklevel;

public class Trabalhador {

	private String nome;
	private Worklevel nivel;
	private double salarioBase;
	private Departamento departamento;
	private List<Contratos> contratos = new ArrayList<>();

	public Trabalhador() {

	}

	public Trabalhador(String nome, Worklevel nivel, double salarioBase, Departamento departamento) {

		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Worklevel getNivel() {
		return nivel;
	}

	public void setNivel(Worklevel nivel) {
		this.nivel = nivel;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Contratos> getContratos() {
		return contratos;
	}

	public void addContrato(Contratos contrato) {

		contratos.add(contrato);
	}

	public void removeContrato(Contratos contrato) {
		contratos.remove(contrato);
	}

	public double totalDoMes(int ano, int mes) {

		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (Contratos c : contratos) {

			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);

			if (ano == c_ano && mes == c_mes) {

				soma += c.valorTotalDeHoras();
			}

		}
		return soma;

	}

}
