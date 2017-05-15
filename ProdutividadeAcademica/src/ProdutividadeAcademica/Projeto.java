package ProdutividadeAcademica;

import java.util.ArrayList;

@SuppressWarnings("hiding")

public class Projeto<public_and_orient> {
	
	public static int profNoProjeto;
	
	int dia, mes, ano, diafim, mesfim, anofim, atual = 0;	
	String agencia, objetivo, descricao, titulo;
	double valorf;
	public int getDia() {
		return dia;
	}


	public void setDia(int dia) {
		this.dia = dia;
	}


	public int getMes() {
		return mes;
	}


	public void setMes(int mes) {
		this.mes = mes;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public int getDiafim() {
		return diafim;
	}


	public void setDiafim(int diafim) {
		this.diafim = diafim;
	}


	public int getMesfim() {
		return mesfim;
	}


	public void setMesfim(int mesfim) {
		this.mesfim = mesfim;
	}


	public int getAnofim() {
		return anofim;
	}


	public void setAnofim(int anofim) {
		this.anofim = anofim;
	}


	public int getAtual() {
		return atual;
	}


	public void setAtual(int atual) {
		this.atual = atual;
	}


	public String getAgencia() {
		return agencia;
	}


	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}


	public String getObjetivo() {
		return objetivo;
	}


	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getValorf() {
		return valorf;
	}


	public void setValorf(double valorf) {
		this.valorf = valorf;
	}


	public ArrayList<String> getParticipantes() {
		return participantes;
	}


	public void setParticipantes(ArrayList<String> participantes) {
		this.participantes = participantes;
	}


	public ArrayList<public_and_orient> getListim() {
		return listim;
	}


	public void setListim(ArrayList<public_and_orient> listim) {
		this.listim = listim;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	ArrayList <String> participantes = new ArrayList<String>();
	short i = 0;		//ativo
	ArrayList <public_and_orient> listim = new ArrayList<public_and_orient>();
	

	public void adcionarProf(String nome) {
		this.participantes.add(nome);
	}


	public int getTitulo() {
		// TODO Auto-generated method stub
		return 0;
	}


	

	
	
}
