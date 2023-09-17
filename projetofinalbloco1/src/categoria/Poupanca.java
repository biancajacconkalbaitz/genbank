package categoria;

import contagenbank.ContaGen;

public class Poupanca extends ContaGen {
	private int aniversario;

	public Poupanca(int num, int agencia, int categoria, String nometitular, float saldo, int aniversario2, int aniversario) {
		super(num, agencia, categoria, nometitular, saldo);
		this.aniversario = aniversario;
		
		}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Aniversário da conta: "+this.aniversario);
		
	}

}