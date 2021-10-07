package MAPA;

import java.util.ArrayList;
import java.util.Scanner;

public class AppProdutos {
	
	private Produtos produtosLista[] = new Produtos[5];
	private int posicao = 0;

	public static void main(String[] args) {
		
		AppProdutos aplicacao = new AppProdutos();
		aplicacao.tituloMenu();
		aplicacao.menuPrincipal();
	}
	
	private void menuPrincipal() {
		int opcao = 0;
		do {
			opcao = opcaoMenuPrincipal();
			switch (opcao) {
				case 1:
					menuCadastrarProduto();
					break;
				case 2:
					menuMovimentacao();
					break;
				case 3:
					menuReajuste();
					break;
				case 4:
					menuRelatorios();
					break;
				case 0:
					System.out.println("Finalizando...");
					break;
				default:
					System.out.println("Opcao Invalida\n");
					break;
			}
		}while (opcao != 0);
	}
	
	private void menuCadastrarProduto() {
		int opcao;
		do {
			System.out.println("1 - INCLUSAO\n" +
					"2 - ALTERACAO\n" +
					"3 - CONSULTA\n" +
					"4 - EXCLUSAO\n" +
					"0 - RETORNAR\n");
			opcao = getEscolhaMenu();
			switch (opcao) {
				case 1:
					inclusaoProduto();
					break;
				case 2:
					alterarProduto();
					break;
				case 3:
					consultaProduto();
					break;
				case 4:
					exclusaoProduto();
					break;
				case 0:
					System.out.println("Retornando ao menu principal...\n");
					break;
				default:
					System.out.println("Opcao Invalida");
					break;
			}
		}while (opcao != 0);
	}

	private int opcaoMenuPrincipal() {
		int opcao;
		System.out.println("---MENU-PRINCIPAL---\n" +
				"1 - CADASTRAR-PRODUTO\n" +
				"2 - MOVIMENTACAO\n" +
				"3 - REAJUSTE DE PRECO\n" +
				"4 - RELATORIOS\n" +
				"0 - FINALIZAR\n" +
				"OPCAO : ");
		opcao = getEscolhaMenu();
		return opcao;
	}
	
	private void menuMovimentacao() {
		int opcao;
		do {
			System.out.println("1 - ENTRADA\n" +
					"2 - SAIDA\n" +
					"0 - RETORNAR\n");
			opcao = getEscolhaMenu();
			switch (opcao) {
				case 1:
					entradaMovimentacao();
					break;
				case 2:
					saidaMovimentacao();
					break;
				case 0:
					System.out.println("Retornando ao menu principal...\n");
			}
		}while (opcao != 0);
	}
	
	private void menuReajuste() {
		System.out.println("Estou no menu reajuste\n");
	}
	
	private void menuRelatorios() {
		this.tituloMenu();
        System.out.println("-------RELATÓRIO-------");
        for (int i = 0; i < posicao; i++) {
            System.out.println("\n");
            System.out.println("Produto: \n" +
                    "CÓDIGO: " + i + "\n" +
                    produtosLista[i]);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.println("Pressione qualquer tecla + ENTER para continuar...");
        scanner.next();
	}
	
	private void inclusaoProduto() {
		String choice;
		do {
			this.tituloMenu();
			System.out.println("INCLUSAO-DE-PRODUTOS");
			Produtos produtos = setDadosProdutos();
			choice = confirmaOperacao();
			if(choice.equalsIgnoreCase("S")) {
				produtosLista[posicao] = produtos;
				posicao++;
			}
			choice = getRepetirOperacao();
		}while (choice.equalsIgnoreCase("S"));
	}
	
	private void alterarProduto() {
		String choice;
		do {
			Scanner scanner = new Scanner(System.in);
			this.tituloMenu();
			System.out.println("ALTERACAO-DE-PRODUTOS");
			System.out.println("Digite o nome do produto que deseja alterar:");
			String nomeSearch = scanner.nextLine();
			boolean controle = true;
			for(int i = 0; i < posicao; i++) {
				if(nomeSearch.equalsIgnoreCase(produtosLista[i].getNome())) {
					controle = false;
					System.out.println("Produto Localizado\n");
					Produtos produtos = setDadosProdutos();
					choice = confirmaOperacao();
					if(choice.equalsIgnoreCase("S")) {
						produtosLista[i] = produtos;
					}
					break;
				}
			}
			mensagemConsultaNaoLocalizada(controle);
			choice = getRepetirOperacao();
			
		}while (choice.equalsIgnoreCase("S"));
	}
	
	private void consultaProduto() {
		
		String choice;
		do {
			Scanner scanner = new Scanner(System.in);
			this.tituloMenu();
			System.out.println("CONSULTA-DE-PRODUTOS");
			System.out.println("Informe o nome do produto a pesquisar:");
			String nomeSearch = scanner.nextLine();
			boolean controle = true;
			for(int i = 0; i < posicao; i++) {
				if(nomeSearch.equalsIgnoreCase(produtosLista[i].getNome())) {
					controle = false;
					System.out.println(produtosLista[i].toString());
					break;
				}
			}
			mensagemConsultaNaoLocalizada(controle);
			choice = getRepetirOperacao();
		}while (choice.equalsIgnoreCase("S"));
	}
	
	
	private void exclusaoProduto() {
		
		String choice;
		do {
			
			Scanner scanner = new Scanner(System.in);
			this.tituloMenu();
			System.out.println("EXCLUSAO-DE-PRODUTOS");
			System.out.println("Digite o nome do produto a excluir:");
			String nomeSearch = scanner.nextLine();
			boolean controle = true;
			ArrayList<Produtos> arrayList = new ArrayList();
			arrayList.add(new Produtos());
			for(int i = 0; i < posicao; i++) {
				scanner = new Scanner(System.in);
				Produtos produtos = arrayList.get(i);
				if(nomeSearch.equalsIgnoreCase(produtosLista[i].getNome())) {
					controle = false;
					System.out.println(produtosLista[i].toString());
					System.out.println("CONFIRMA EXCLUSAO? | S/N");
					choice = scanner.next();
					if(choice.equalsIgnoreCase("S")) {
						for(int j = i; j < posicao; j++ ) {
							produtosLista[j] = produtosLista[j + 1];
							posicao--;
						}
					}
					break;
				}
			}
			mensagemConsultaNaoLocalizada(controle);
			choice = getRepetirOperacao();
		}while (choice.equalsIgnoreCase("S"));
	}
	
	private void entradaMovimentacao() {
		String choice;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ENTRADA-DE-PRODUTOS");
            System.out.println("Digite o nome do produto:");
            String nomeProduto = scanner.nextLine();
            Produtos produtosMovimentacao;
            boolean controle=true;
            for (int i = 0; i < posicao; i++) {
                if (nomeProduto.equalsIgnoreCase(produtosLista[i].getNome())) {
                    controle = false;
                    produtosMovimentacao = produtosLista[i];
                    System.out.println("QTDE ATUAL : " + produtosMovimentacao.getQuantidadeEmEstoque());
                    System.out.println("QTDE ENTRADA : ");
                    int quantidadeEntrada = scanner.nextInt();
                    System.out.println("QTDE FINAL : " + (produtosMovimentacao.getQuantidadeEmEstoque() + quantidadeEntrada));
                    choice = confirmaOperacao();
                    if (choice.equalsIgnoreCase("S")) {
                        produtosMovimentacao.setAdicionaQuantidade(quantidadeEntrada);
                        produtosLista[i] = produtosMovimentacao;
                    }
                    break;
                }
            }
            mensagemConsultaNaoLocalizada(controle);

            choice = getRepetirOperacao();

        } while (choice.equalsIgnoreCase("S"));
	}
	
	private void saidaMovimentacao() {
		String choice;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("SAIDA-DE-PRODUTOS");
            System.out.println("Digite o nome do produto:");
            String nomeProduto = scanner.nextLine();

            boolean controle = true;
            for (int i = 0; i < posicao; i++) {
                if (nomeProduto.equalsIgnoreCase(produtosLista[i].getNome())) {
                    controle = false;
                    Produtos produtosMovimentacao = produtosLista[i];
                    System.out.println("QTDE ATUAL : " + produtosMovimentacao.getQuantidadeEmEstoque());
                    System.out.println("QTDE SAÍDA : ");
                    int quantidadeSaida = scanner.nextInt();
                    System.out.println("QTDE FINAL : " + (produtosMovimentacao.getQuantidadeEmEstoque() - quantidadeSaida));
                    if (produtosMovimentacao.getQuantidadeEmEstoque() < quantidadeSaida) {
                        System.out.println("Valor maior que o estoque, operacao nao realizada!!\n");
                        break;
                    }
                    choice = confirmaOperacao();
                    if (choice.equalsIgnoreCase("S")) {
                        produtosMovimentacao.setSubtraiQuantidade(quantidadeSaida);
                        produtosLista[i] = produtosMovimentacao;
                    }
                    break;
                }
            }
            mensagemConsultaNaoLocalizada(controle);
            choice = getRepetirOperacao();

        } while (choice.equalsIgnoreCase("S"));
	}
	
	private Produtos setDadosProdutos() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome do produto: ");
		String nome = scanner.nextLine();
		System.out.println("Digite o preço do produto: ");
		scanner = new Scanner(System.in);
		int preco = scanner.nextInt();
		System.out.println("Digite a unidade de medida: ");
		scanner = new Scanner(System.in);
		String unidade = scanner.nextLine();
		System.out.println("Digite a quantidade em estoque: ");
		int quantidade = scanner.nextInt();
		
		Produtos produtos = new Produtos();
		produtos.setNome(nome);
		produtos.setPrecoUnitario(preco);
		produtos.setUnidade(unidade);
		produtos.setQuantidadeEmEstoque(quantidade);
		return produtos;
	}
	
	private String getRepetirOperacao() {
		Scanner scanner = new Scanner(System.in);
		String choice;
		System.out.println("REPETIR OPERACAO? | S/N");
		choice = scanner.next();
		return choice;
	}
	
	private String confirmaOperacao() {
		Scanner scanner = new Scanner(System.in);
		String choice;
		System.out.println("CONFIRMA OPERACAO? | S/N");
		choice = scanner.next();
		return choice;
	}
	
	private int getEscolhaMenu() {
		Scanner scanner = new Scanner(System.in);
		return Integer.parseInt(scanner.next());
	}
	
	private void tituloMenu() {
		System.out.println("--------ESTOQUE--------"); 
	}
	
	private void mensagemConsultaNaoLocalizada(boolean controle) {
		if(controle) {
			System.out.println("Produto não localizado!!\n");
		}
	}
	
}
