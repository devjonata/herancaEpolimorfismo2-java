package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.produtoImportado;
import entidades.produtoUsado;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Produto> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Informe o numero de produtos: ");
		int num = sc.nextInt();
		
		for (int i=1; i<=num; i++) {
			System.out.println();
			System.out.println("Dados do " + i + "º produto: ");
			System.out.print("Comum, usado, importado (c,u,i): ");
			char tipoDeProtudo = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			Double preco = sc.nextDouble();
			
			if (tipoDeProtudo == 'i') {
				System.out.print("Taxa da alfandega: ");
				Double taxaDaAlfandaga = sc.nextDouble();
				list.add(new produtoImportado(nome, preco, taxaDaAlfandaga));
			} else if (tipoDeProtudo == 'u') {
				System.out.print("Data de fabricação (DD/MM/AAAA) : ");
				String dataDeFabricacao = sc.next();
				list.add(new produtoUsado(nome, preco, sdf.parse(dataDeFabricacao)));
			} else {
				list.add(new Produto(nome, preco));
			}
			
		}
		
		System.out.println();
		System.out.println("Marcadores de preços: ");
		for (Produto p : list) {
			System.out.println(p.etiquetaDePreco());
		}
		
		sc.close();
	}

}
