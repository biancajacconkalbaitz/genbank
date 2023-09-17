package contagenbank;

public abstract class ContaGen {

	private int num;
	private int agencia;
	private int categoria;
	private String nometitular;
	private float saldo;
	public ContaGen(int num, int agencia, int categoria, String nometitular, float saldo) {
		this.num = num;
		this.agencia = agencia;
		this.categoria = categoria;
		this.nometitular = nometitular;
		this.saldo = saldo;
	}
	public int getContaGen() {
		return num;
	}
	public void setContaGen(int conta) {
		this.num = conta;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getNomeTitular() {
		return nometitular;
	}
	public void setNomeTitular(String nometitular) {
		this.nometitular = nometitular;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public boolean sacar(float valor) {
		if(this.getSaldo()>valor) {
			System.out.println("\nSaldo insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo()+valor);
	}
	public void visualizar() {
		String categoria = "";
		
		switch (this.categoria) {
		case 1: categoria = "Conta Corrente";
		break;
		case 2: categoria = "Conta Poupança";
		break;
		
		}
		System.out.println("****************************************************************");
		System.out.println("Dados da conta:");
		System.out.println("****************************************************************");
		System.out.println("Número da conta: "+this.num);
		System.out.println("Número da Agência: "+this.agencia);
		System.out.println("Categoria da conta: "+this.categoria);
		System.out.println("Nome do titular da conta: "+this.nometitular);
		System.out.println("Saldo: "+this.saldo);
		
}
}