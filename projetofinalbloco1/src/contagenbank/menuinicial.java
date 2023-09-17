package contagenbank;

import estilo.cores;

import java.io.IOException;
import java.util.Scanner;

import categoria.Corrente;
import categoria.Poupanca;
import contagencontrole.ContaGenControle;


public class menuinicial {
	public static void main(String[] args) {
		
		ContaGenControle contaGen = new ContaGenControle();
		int Opcao, num, agencia, categoria, aniversario, numeroDestino = 0;
		String nometitular;
		float saldo, limite, valor = 0;
		System.out.println("\nCriar Conta: ");
		Corrente cc1 = new Corrente(contaGen.gerarNum(),  123,  1,  "Bianca Jaccon", 1000f);
		contaGen.cadastrar(cc1);
		Corrente cc2 = new Corrente(contaGen.gerarNum(), 124, 1, "Eduardo Jaccon",2000f);
		contaGen.cadastrar(cc2);
		Poupanca cp1 = new Poupanca(contaGen.gerarNum(), 125, 2, "Alexandre Jaccon", 4000f, 12, numeroDestino);
		contaGen.cadastrar(cp1);
		Poupanca cp2 = new Poupanca(contaGen.gerarNum(), 125, 2, "Isabella Jaccon", 8000f, 15, numeroDestino);
		contaGen.cadastrar(cp2);
		contaGen.listarTodas();
		
		
		Scanner leia = new Scanner(System.in);
		int opcao;
		 while(true) {
			System.out.println(cores.TEXT_BLUE_BOLD_BRIGHT+cores.ANSI_WHITE_BACKGROUND);
			 System.out.println("***************************************************");
			 System.out.println("                                                   ");
			 System.out.println("**************Gen Bank****************");
			 System.out.println("                                                   ");
			 System.out.println("***************************************************");
			 System.out.println("                                                   ");
			 System.out.println("                1 - Criar conta                    ");
			 System.out.println("                2 - Listar todas as Contas         ");
			 System.out.println("                3 - Buscar conta por Número        ");
			 System.out.println("                4 - Atualizar Dados da Conta       ");
			 System.out.println("                5 - Apagar Conta                   ");
			 System.out.println("                6 - Sacar                          ");
			 System.out.println("                7 - Depositar                      ");
			 System.out.println("                8 - Transferir valores entre Contas");    
			 System.out.println("                9 - Sair                           ");
			 System.out.println("                                                   ");
			 System.out.println("***************************************************");
			 System.out.println("Entre com a opção desejada:                        ");
			 System.out.println("                                                   "+cores.TEXT_RESET);
			 
			 opcao = leia.nextInt();
			 
			 if(opcao==9) {
			 System.out.println(cores.TEXT_BLUE_BOLD_BRIGHT+"\ngGen Bank - Seu banco aliado a tecnologia");
			 leia.close();
			 System.exit(0);
		 }
			 switch(opcao) {
			 case 1:
				 System.out.println(cores.TEXT_BLUE_BOLD_BRIGHT+"Criar Conta\n\n");
				 System.out.println("Digite o número da agência: ");
				 agencia = leia.nextInt();
				 System.out.println("Digite o nome do titular: ");
				 leia.skip("\\R?");
				 nometitular = leia.nextLine();
				 do {
					 System.out.println("Digite o tipo de conta: (1 - CC ou 2 - CP)");
					 categoria = leia.nextInt();					 
				 }while (categoria <=1 && categoria>=2);
				 System.out.println("Digite o valor correspondente ao saldo da conta (R$): ");
				 saldo = leia.nextFloat();
				 switch(categoria) {
				 case 1 :{
					 System.out.println("Digite o limite de crédito (R$): ");
					 limite = leia.nextFloat();
					 contaGen.cadastrar(new Corrente( contaGen.gerarNum(), agencia, categoria, nometitular, saldo, limite, valor));
				 }
				 case 2 :{
					 System.out.println("Digite o dia do aniversário da conta: ");
					 aniversario = leia.nextInt();
					 contaGen.cadastrar(new Poupanca( contaGen.gerarNum(), agencia, categoria, nometitular, saldo, aniversario, aniversario));
					 
				 }
					 
				 }
			    			    	 
				 keyPress();
				 break;
			 case 2:
				 System.out.println(cores.TEXT_BLUE_BOLD_BRIGHT+"Listar todas as Contas\n\n");
				 contaGen.listarTodas();
				 keyPress();
				 break;
			 case 3:
				 System.out.println(cores.TEXT_BLUE_BOLD_BRIGHT+"Consultar dados da Conta - por número\n\n");
				 System.out.println("Digite o número da conta: ");
				 num = leia.nextInt();
				 contaGen.procurarPorNumero(num);
		
				 keyPress();
				 break;
			 case 4:
				 System.out.println(cores.TEXT_BLUE_BOLD_BRIGHT+"Atualizar Dados da Conta\n\n");
                 System.out.println("Digite o número da conta: ");
                 num = leia.nextInt();
                 if(contaGen.buscarNaCollection(num)!=null) {
                 System.out.println("Digite o número da agência: ");
                 agencia = leia.nextInt();
                 System.out.println("Digite o nome do titular: ");
                 leia.skip("\\R?");
                 nometitular = leia.nextLine();
                 
                 System.out.println("Digite o saldo da conta (R$): ");
                 saldo = leia.nextFloat();
                 
                 categoria = contaGen.retornaTipoint(num);
                 switch(categoria) {
				 case 1 :{
					 System.out.println("Digite o limite de crédito (R$): ");
					 limite = leia.nextFloat();
					 contaGen.cadastrar(new Corrente( contaGen.gerarNum(), agencia, categoria, nometitular, saldo, limite, valor));
				 }
				 case 2 :{
					 System.out.println("Digite o dia do aniversário da conta: ");
					 aniversario = leia.nextInt();
					 contaGen.cadastrar(new Poupanca( contaGen.gerarNum(), agencia, categoria, nometitular, saldo, aniversario, opcao));
					 
				 }
				 default :{
					 System.out.println("Tipo de conta inválido!");
				 }
                 }
                 
                 }else {
                	 System.out.println("A conta não foi encontrada!");
                 }
				 keyPress();
				 break;
			 case 5:
				 System.out.println(cores.TEXT_BLUE_BOLD_BRIGHT+"Apagar Conta\n\n");
				 System.out.println("Digite o número da conta: ");
				 num = leia.nextInt();
				 contaGen.deleta(num);
				 keyPress();
				 break;
			 case 6:
				 System.out.println(cores.TEXT_BLUE_BOLD_BRIGHT+"Saque\n\n");
				System.out.println("Digite o número da conta: ");
				num = leia.nextInt();
				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = leia.nextFloat();
				}while (valor<=0);
				contaGen.sacar(num, valor);
				 keyPress();
				 break;
			 case 7:
				 System.out.println(cores.TEXT_BLUE_BOLD_BRIGHT+"Depósito\n\n");
				 System.out.println("Digite o número da conta: ");
					num = leia.nextInt();
					do {
						System.out.println("\nDigite o valor do Depósito (R$): ");
						valor = leia.nextFloat();
					} while (valor<=0);
					contaGen.depositar(num, valor);
				 keyPress();
				 break;
			 case 8:
				 System.out.println(cores.TEXT_BLUE_BOLD_BRIGHT+"Tranferência entre Contas\n\n");
				System.out.println("\nDigite o número da conta origem: ");
				num = leia.nextInt();
				System.out.println("Digite o número da conta destino: ");
				numeroDestino = leia.nextInt();
				do {
					System.out.println("\nDigite o valor da transferência (R$): ");
					valor = leia.nextFloat();
				}while(valor<=0);
				contaGen.transferir(num, numeroDestino, valor);
				 keyPress();
				 break;
				 default:
					 System.out.println(cores.TEXT_RED_BOLD+"\nOpção inválida!\n"+cores.TEXT_RESET);
					 keyPress();
					 break;
			 }
			 

	}

}
	public static void keyPress() {
		try {
			System.out.println(cores.TEXT_RESET+"\n\nPressione a tecla 'Enter' caso deseje continuar...");
			System.in.read();
		} catch(IOException e) {
			System.out.println("Tecla inválida");
			
			
			
		}
	}

}

