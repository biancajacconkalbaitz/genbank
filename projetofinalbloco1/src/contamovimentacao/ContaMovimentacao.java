package contamovimentacao;

import contagenbank.ContaGen;

public interface ContaMovimentacao {

		
		public void procurarPorNumero(int num);
		public void listarTodas();
		public void cadastrar (ContaGen contaGen);
		public void atualizar (ContaGen contaGen);
		public void deletar (int num);


		public void sacar (int num, float valor);
		public void depositar (int num, float valor);
		public void transferir (int numOrigem, int numDestino, float valor);
		
	}


