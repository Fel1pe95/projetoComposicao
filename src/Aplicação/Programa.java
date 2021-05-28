package Aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entidades.Contratos;
import Entidades.Departamento;
import Entidades.Trabalhador;
import Entidades.enums.Worklevel;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Departamento: ");
		String departamentoTrabalhador = sc.next();

		System.out.println("Dados do funcionario: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.next();
		System.out.print("Nivel do trabalhador: ");
		String nivelTrabalhador = sc.next();
		System.out.print("Salario base: ");
		double salarioBase = sc.nextDouble();

		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, Worklevel.valueOf(nivelTrabalhador), salarioBase,
				new Departamento(departamentoTrabalhador));

		System.out.print("Numero de contratos do trabalhador: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Data do contrato #" + (i + 1) + ": ");
			System.out.print("Data: ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração: ");
			int duracao = sc.nextInt();
			Contratos contratos = new Contratos(valorPorHora, duracao, dataContrato);
			
			trabalhador.addContrato(contratos);
			
			

		}

		System.out.println("Mes e ano para calcular o total(MM/YYYY): ");
		String mesEano = sc.next();
		int mes = Integer.parseInt(mesEano.substring(0, 2));
		int ano = Integer.parseInt(mesEano.substring(3));

		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Total em " + mesEano + ": " + String.format("%.2f", trabalhador.totalDoMes(ano, mes)));

		
		sc.close();
	}

}
