package ProdutividadeAcademica;

import java.util.Scanner;

public class Aluno {
	String nome, email, projetos;

	int tipo, p_andamento;

	void adcionarAluno() {
		System.out.println("Nome do aluno: ");
		this.nome = extracted().nextLine();
		
		System.out.println("Email do aluno: ");
		this.email = extracted().nextLine();
	}

	private Scanner extracted() {
		return new Scanner(System.in);
	}
}
