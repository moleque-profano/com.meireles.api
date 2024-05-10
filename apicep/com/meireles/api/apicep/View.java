package com.meireles.api.apicep;

public class View{
	private Model model;
	
	public String pegarCep(Model model) {
		this.model = model;
		return model.getCep();
		
	}
	
	public String pegarLogradouro(Model model) {
		this.model = model;
		return model.getLogradouro();
		
	}
	
	public String pegarComplemento(Model model) {
		this.model = model;
		return model.getComplemento();
		
	}
	
	public String pegarBairro(Model model) {
		this.model = model;
		return model.getBairro();
		
	}
	
	public String pegarLocalidade(Model model) {
		this.model = model;
		return model.getLocalidade();
		
	}
	
	public String pegarUf(Model model) {
		this.model = model;
		return model.getUf();
		
	}
	
	public String pegarEndereco(Model model) {
		this.model = model;
		String endereco = model.getCep()+"\n"+model.getLogradouro()+"\n"+model.getComplemento()+"\n"+model.getBairro()+"\n"+model.getLocalidade()+"\n"+model.getUf();
		return endereco;
		
	}
	
	//teste CLI
	/*
	public static void main(String[] args) {
		View view = new View();
		Model model = new Model();
		new Controller("24859392", model);
		System.out.println(view.pegarEndereco(model));
	}
	*/
}
