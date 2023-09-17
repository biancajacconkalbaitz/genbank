package categoria;

import contagenbank.ContaGen;

public class Corrente extends ContaGen {
    public Corrente(int num, int agencia, int categoria, String nometitular, float saldo) {
		super(num, agencia, categoria, nometitular, saldo);

	}
	private float limite;
	public Corrente(int num, int agencia, int categoria, String nometitular, float saldo, float limite, float limite2) {
		super(num, agencia, categoria, nometitular, saldo);
		this.limite = limite;
		
	}         
	public float getLimite() {
		return limite;
	}
	public void setLimite(float limite) {
		this.limite = limite;
	}
	@Override
	
	public boolean sacar(float valor) {
		if(this.getSaldo()>valor) {
			System.out.println("\nSaldo insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite de Crédito: "+this.limite);
	}
}