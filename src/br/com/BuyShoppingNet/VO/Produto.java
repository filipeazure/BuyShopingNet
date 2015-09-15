package br.com.BuyShoppingNet.VO;



public class Produto {
	private String CodProduto;
	private String DataProduto;
	private String NomeProduto;
	private String Medida;
	private String Tipo;

	private int Quantidade;
	private double ValorInicial;

	public Produto() {

	}

	public Produto(String codProduto, String dataProduto, String nomeProduto,
			String medida, String tipo, int quantidade, double valorInicial) {
		super();
	
		CodProduto = codProduto;
		DataProduto = dataProduto;
		NomeProduto = nomeProduto;
		Medida = medida;
		Tipo = tipo;

		Quantidade = quantidade;
		ValorInicial = valorInicial;
	}

	public String getCodProduto() {
		return CodProduto;
	}

	public void setCodProduto(String codProduto) {
		CodProduto = codProduto;
	}

	public String getDataProduto() {
		return DataProduto;
	}

	public void setDataProduto(String dataProduto) {
		DataProduto = dataProduto;
	}

	public String getNomeProduto() {
		return NomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		NomeProduto = nomeProduto;
	}

	public String getMedida() {
		return Medida;
	}

	public void setMedida(String medida) {
		Medida = medida;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}



	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}

	public double getValorInicial() {
		return ValorInicial;
	}

	public void setValorInicial(double valorInicial) {
		ValorInicial = valorInicial;
	}

}
