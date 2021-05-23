package entidades;

public class produtoImportado extends Produto {
	
private Double taxaDaAlfandega;
	
	public produtoImportado() {
		super();
	}

	public produtoImportado(String nome, Double preco, Double taxaDaAlfandega) {
		super(nome, preco);
		this.taxaDaAlfandega = taxaDaAlfandega;
	}
	
	public Double precoTotal() {
		return super.getPreco() + taxaDaAlfandega;
	}
	
	public Double getTaxaDaAlfandega() {
		return taxaDaAlfandega;
	}

	public void setTaxaDaAlfandega(Double taxaDaAlfandega) {
		this.taxaDaAlfandega = taxaDaAlfandega;
	}

	@Override
	public String etiquetaDePreco() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getNome() + " $ " + String.format("%.2f", super.getPreco()) + " Taxa da alfandega: $ " + String.format("%.2f", taxaDaAlfandega));
		return sb.toString();
	}

}
