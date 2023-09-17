package contagencontrole;
	
	import java.util.ArrayList;
import contagenbank.ContaGen;
import contamovimentacao.ContaMovimentacao;
public class ContaGenControle implements ContaMovimentacao {

private ArrayList <ContaGen> listaContas = new ArrayList <ContaGen>();{
			
		
		int num = 0;}

		@Override
		public void procurarPorNumero(int num) {
			var contaGen = buscarNaCollection (num);
			if (contaGen!=null) {
				contaGen.visualizar();
			}else {
				System.out.println("A conta número "+num+"não foi encontrada!");
			}
			
		}

		@Override
		public void listarTodas() {
			for (var contaGen : listaContas) {
				contaGen.visualizar();
			}
			
		}

		@Override
		public void cadastrar(ContaGen contaGen) {
			listaContas.add(contaGen);
			System.out.println("\nA conta número: "+contaGen.getContaGen()+" foi criada com sucesso!");
			
		}

		@Override
		public void atualizar(ContaGen contaGen) {
			var buscaContaGen = buscarNaCollection(contaGen.getContaGen());
			if(buscaContaGen!=null) {
				listaContas.set(listaContas.indexOf(buscaContaGen), contaGen);
				System.out.println("A conta número "+contaGen.getContaGen()+" foi atualizada com sucesso!");
						}else {
							System.out.println("A conta número "+contaGen.getContaGen()+" não foi encontrada!");
						}
			
		}

		@Override
		public void deletar(int num) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void sacar(int num, float valor) {
			var contaGen = buscarNaCollection(num);
			if(contaGen!=null) {
				if(contaGen.sacar(valor)==true) {
					System.out.println("\nO saque na conta número "+num+" foi efetuado com sucesso!");
				}
			}else {
				System.out.println("\nA conta número "+num+" não foi encontrada!");
			}
			
		}

		@Override
		public void depositar(int num, float valor) {
			var contaGen = buscarNaCollection(num);
			if(contaGen!=null) {
				contaGen.depositar(valor);
				System.out.println("\nO depósito na conta: "+num+" foi efetuado com sucesso");
							
			}else {
				System.out.println("\nA conta número: "+num+" não foi encontrada ou a Conta destino não é uma Conta Corrente!");
				
			}
			
		}

		@Override
		public void transferir(int numOrigem, int numDestino, float valor) {
			var contaOrigem = buscarNaCollection(numOrigem);
			var contaDestino = buscarNaCollection(numDestino);
			if(contaOrigem!=null && contaDestino!=null){
				if(contaOrigem.sacar(valor)==true) {
					contaDestino.depositar(valor);
					System.out.println("\nA transferência foi efetuada com sucesso!");
				}
							
			}else 
				System.out.println("\n A conta de origem e/ou destino não foram encontradas!");
			
		}



	public int gerarNum() {
		int num = 0;
		return ++ num;
		
	}
	public ContaGen buscarNaCollection(int num) {
		for (var contaGen: listaContas) {
			if(contaGen.getContaGen()==num) {
				return contaGen;
			}
		}
		return null;
		
	}

	public int retornaTipoint(int num) {
		for(var contaGen : listaContas ) {
			if(contaGen.getContaGen()==num) {
				return contaGen.getCategoria();
				
			}
		}
		return 0;
	}
	public void deleta (int num) {
		var contaGen = buscarNaCollection(num);
		if(listaContas.remove(contaGen)==true) {
			System.out.println("A conta número "+num+" foi deletada com sucesso");
			
			
		}else {
			System.out.println("A conta número "+num+"não foi encontrada!");
		}
	}

	}


