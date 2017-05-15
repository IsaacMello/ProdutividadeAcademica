package ProdutividadeAcademica;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void print_projects(ArrayList<Projeto> p) {
		for (int i = 0; i < p.size(); i++)
			System.out.println(i + " " + p.get(i).getTitulo());
	}

	public static int professor_project(ArrayList<String> p, ArrayList<Professor> pr) {
		int x = 0;
		for (int i = 0; i < p.size(); i++) {
			if (pr.contains(p.get(i))) {
				System.out.println(p.get(i));
				x = 1;
			}
		}
		if (x == 1)
			return 1;
		else
			return 0;
	}

	public static void new_colab(ArrayList aluno, ArrayList prof) {
		Scanner teclado = extracted();
		System.out.println("1- Add um professor.\n2- Add um aluno");
		int x = teclado.nextInt();
		switch (x) {
		case 1:
			Professor novo = new Professor();
			novo.adcionarProfessor();
			prof.add(novo);
			break;
		case 2:
			Aluno novoAluno = new Aluno();
			novoAluno.adcionarAluno();
			aluno.add(novoAluno);
			break;
		}
	}

	public static void project(ArrayList<Projeto> p, ArrayList<Professor> pr, ArrayList<Aluno> a) {
		Scanner teclado = extracted();
		System.out.println("1 para criar novo projeto\n2 para editar projeto existente");
		int x = teclado.nextInt();
		switch (x) {
		case 1:
			new_project(p);
			break;
		case 2:
			edit_project(p, pr, a);
			break;
		}
	}

	public static void edit_project(ArrayList<Projeto> p, ArrayList<Professor> pr, ArrayList<Aluno> a) {
		Scanner teclado = extracted();
		System.out.println("1 Alocar participante\n2 Adicionar publicação\n3 adicionar orientação");
		int x = teclado.nextInt();
		switch (x) {
		case 1:
			print_projects(p);

			System.out.println("Informe o projeto que deseja alocar alunos");
			int k = teclado.nextInt();
			if (p.get(k).atual == 1) {
				System.out.println("1 para associar um professor\n2 para associar um aluno");
				int esc = teclado.nextInt();
				int i;
				switch (esc) {
				case 1:
					System.out.println("Professores:");
					for (i = 0; i < pr.size(); i++)
						System.out.println(i + " " + pr.get(i).nome);
					int y = 1;
					while (y != 0) {
						System.out.println("Informe o id do professor desejado ou -1 para sair");
						int id = teclado.nextInt();
						if (id == -1)
							break;
						else if (id >= i)
							System.out.println("Id invalido");
						else {
							p.get(k).adcionarProf(pr.get(id).nome); // projeto(k)
																// recebe o
																// professor(id)
							p.get(k).profNoProjeto = 1;
							break;
						}

					}
					break;
				case 2:
					System.out.println("Alunos:");
					for (i = 0; i < a.size(); i++)
						System.out.println(i + " " + a.get(i).nome);
					int y1 = 1;
					while (y1 != 0) {
						System.out.println("Informe o id do aluno desejado ou -1 para sair");
						int id = teclado.nextInt();
						if (id == -1)
							break;
						else if (id >= i)
							System.out.println("Id invalido");
						else if (a.get(id).p_andamento >= 2)
							System.out.println("Aluno já colabora com o maximo de projetos");
						else {
							p.get(k).adcionarProf(a.get(id).nome); // projeto(k)
																// recebe o
																// professor(id)
							a.get(id).p_andamento += 1;
							break;
						}

					}
					break;
				}

			} else
				System.out.println("Não é possível adicionar colaboradores a esse projeto");
			break;
		case 2:
			New_publication(p, a, pr);
			break;
		case 3:
			New_orientation(p, pr);
		}
	}

	public static void New_orientation(ArrayList<Projeto> p, ArrayList<Professor> pr) {
		Scanner teclado = extracted();
		print_projects(p);
		System.out.println("Informe o id do projeto para o qual deseja fazer uma orientação");
		int np = teclado.nextInt();
		teclado.nextLine();
		int x;
		x = professor_project(p.get(np).participantes, pr);
		if (x == 1) {
			System.out.println("Informe o nome do professor que publicará orientação");
			String prof = teclado.nextLine();
			if (p.get(np).participantes.contains(prof) == true && pr.contains(prof) == true) {
				public_and_orient novo = new public_and_orient();
				novo.nome = prof;
				novo.choice = 1;
				System.out.println("Orientação");
				novo.text = teclado.nextLine();
				p.get(np).listim.add(novo);
			} else
				System.out.println("Nome inválido");
		} else {
			System.out.println("Não existe professores associados ao projeto");
			return;
		}
	}

	public static void New_publication(ArrayList<Projeto> p, ArrayList<Aluno> a, ArrayList<Professor> pr) {
		Scanner teclado = extracted();
		print_projects(p);
		System.out.println("Informe o id do projeto para o qual deseja fazer uma publicação:");
		int np = teclado.nextInt();
		teclado.nextLine();
		for (int i = 0; i < p.get(np).participantes.size(); i++)
			System.out.println(p.get(np).participantes.get(i));
		System.out.println("Informe o nome de quem fará a publicação");
		String partic = teclado.nextLine();
		if (p.get(np).participantes.contains(partic) == true) {
			public_and_orient novo = new public_and_orient();
			novo.nome = partic;
			novo.choice = 0;
			System.out.println("Publicação:");
			novo.text = teclado.nextLine();
			p.get(np).listim.add(novo);
		} else {
			System.out.println("Nome inválido");
		}
	}

	public static void new_project(ArrayList<Projeto> p) {
		
		@SuppressWarnings("rawtypes")
		Projeto novo = new Projeto();
		
		System.out.println("Titulo do projeto: ");
		novo.setTitulo(extracted().nextLine());
		
		System.out.println("Informe dia, mes e ano do inicio do projeto: ");
		novo.setDia(extracted().nextInt());
		novo.setMes(extracted().nextInt());
		novo.setAno(extracted().nextInt());
		
		System.out.println("Informe dia, mes e ano do fim do projeto: ");
		novo.setDiafim(extracted().nextInt());
		novo.setMesfim(extracted().nextInt());
		novo.setAnofim(extracted().nextInt());
		extracted().nextLine();
		
		System.out.println("Informe agencia financiadora: ");
		novo.setAgencia(extracted().nextLine());
		
		System.out.println("Informe valor financiado: ");
		novo.setValorf(extracted().nextDouble());
		novo.setAtual(1);
		
		System.out.println("Projeto criado com sucesso.\n Status: Em elaboração.");
		p.add(novo);
		// adcparticipantes();
	}

	private static Scanner extracted() {
		return new Scanner(System.in);
	}

	@SuppressWarnings({ "static-access", "unchecked", "unchecked" })
	public static void alterar_status(@SuppressWarnings("rawtypes") ArrayList<Projeto> p) {
		Scanner teclado = extracted();
		print_projects(p);
		System.out.println("Informe o ID do projeto que terá o status modificado");
		int x = teclado.nextInt();
		if (p.get(x) == null) {
			System.out.println("Projeto inválido");
		} else if (p.get(x).atual == 1) {
			if (p.get(x).profNoProjeto == 1) {
				p.get(x).atual = 2;
				System.out.println("Status alterado para 'Em andamento' ");
			} else
				System.out.println("Não há professor colaborando com o projeto");
		} else if (p.get(x).atual == 2) {
			if (p.get(x).listim.isEmpty()) {
				System.out.println("Não há publicações associadas ao projeto");
			} else {
				p.get(x).atual = 3;
				System.out.println("Projeto concluido");
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Aluno> aluno = new ArrayList<Aluno>();
		@SuppressWarnings("rawtypes")
		ArrayList<Projeto> projetos = new ArrayList<Projeto>();
		ArrayList<Professor> prof = new ArrayList<Professor>();

		boolean x = true;
		Scanner teclado = extracted();
		while (x) {
			System.out.println("1 - Encerrar");
			System.out.println("2 - Editar um projeto");
			System.out.println("3 - Adicionar um colaborador");
			System.out.println("4 - Alterar o status");
			int chave = teclado.nextInt();
			switch (chave) {
			case 1:
				x = false;
				break;
			case 2:
				project(projetos, prof, aluno);
				break;
			case 3:
				new_colab(aluno, prof);
				break;
			case 4:

				break;
			}
		}
		for (int i = 0; i < prof.size(); i++) {
			System.out.println(prof.get(i).nome);
		}
	}

}
