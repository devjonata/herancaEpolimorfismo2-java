package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class produtoUsado extends Produto {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dataDeFabricacao;
	
	public produtoUsado() {
		super();
	}

	public produtoUsado(String nome, Double preco, Date dataDeFabricacao) {
		super(nome, preco);
		this.dataDeFabricacao = dataDeFabricacao;
	}

	public Date getDataDeFabricacao() {
		return dataDeFabricacao;
	}

	public void setDataDeFabricacao(Date dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}

	@Override
	public String etiquetaDePreco() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getNome() + " ( usado ) $ " + String.format("%.2f", super.getPreco()) + " ( Data de fabricação: " + sdf.format(dataDeFabricacao) + ")");
		
		return sb.toString();
	}
	
}
