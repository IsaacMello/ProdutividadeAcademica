package ProdutividadeAcademica;

import java.util.Scanner;


public class Professor extends Aluno {
	String ocupacao;
	
	
	void adcionarProfessor()
	{
		System.out.println("Nome do professor: ");
		this.nome = extracted().nextLine();
		
		System.out.println("Email do professor: ");
		this.email = extracted().nextLine();
		this.tipo = 1;
		System.out.println("Informe a disciplina ministrada pelo professor:");
		this.ocupacao = extracted().nextLine();
	}


	private Scanner extracted() {
		return new Scanner(System.in);
	}
}
