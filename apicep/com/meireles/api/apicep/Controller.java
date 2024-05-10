package com.meireles.api.apicep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

//@Controller
public class Controller {
	private Model model;
	
	//Classe para consultar o cep e retornar o arquivo JSON
	public String configurarApi(String cep) {
		String json = "";
		try {
			URL url = new URL("http://viacep.com.br/ws/"+cep+"/json");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder result = new StringBuilder();
			
			while((json = rd.readLine()) != null) {
				result.append(json);				
			}
			rd.close();
			json = result.toString();
		} catch (MalformedURLException e) {
			System.out.println("CEP Não Encontrado!");
		} catch (IOException e) {
			System.out.println("Tempo de espera atingido!");
		}
		
		return json;
		
	}

	//Classe para pegar os dados do arquivo JSON e armazenar no ArrayList
	public void manipularJson(String json) {
		try {
			JSONObject jsonObject = new JSONObject(json);
			List<String> cep = new ArrayList<>();
			cep.add(jsonObject.getString("cep"));
			cep.add(jsonObject.getString("logradouro"));
			cep.add(jsonObject.getString("complemento"));
			cep.add(jsonObject.getString("bairro"));
			cep.add(jsonObject.getString("localidade"));
			cep.add(jsonObject.getString("uf"));
			model.setCep(cep.get(0));
			model.setLogradouro(cep.get(1));
			model.setComplemento(cep.get(2));
			model.setBairro(cep.get(3));
			model.setLocalidade(cep.get(4));
			model.setUf(cep.get(5));
		} catch (JSONException e) {
			System.out.println("Arquivo JSON Não Encontrado!");
		}
		
	}	
	
	
	//Classe principal 
	public Controller(String cep, Model model) {
		this.model = model;
		manipularJson(configurarApi(cep));
		
	}
}
