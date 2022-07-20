import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;



public class App {

	public static void main(String[] args) throws Exception { 
		
		
		
		
		
		// Fazer uma  conexão HTTP  e buscar os top 250 filmes  
		
		String url = "https://imdb-api.com/en/API/top250Movies/%s".formatted(System.getenv("key_api")) ;

		URI endereco = URI.create(url);
		var client =  HttpClient.newHttpClient(); 
		 
		var request =  HttpRequest.newBuilder(endereco).GET().build(); 
		
		HttpResponse<String> response = client.send(request,BodyHandlers.ofString());
		
		String body = response.body();
		
		//System.out.println(body);
		 
	   //  extrair só dados que interessam (Titulo , poster , Classificação)
		     
		JsonParser parser =  new JsonParser();
		List<Map<String,String>>listaDeFilmes =  parser.parse(body); 
		
	   
	  //  exibir e manipular os dados
		
		for (Map<String,String> filme :listaDeFilmes ){
			String UrlImagem = filme.get("image");
			String titulo = filme.get("title");
			InputStream inputStream =  new URL( UrlImagem).openStream(); 
			
			String nomeArquivo = titulo + ".png";
			
		var geradora = new GeradoraDeFigurinhas();
		geradora.cria(inputStream, nomeArquivo); 
	
		System.out.println(filme.get("title"));
		System.out.println();
		

	}
		}
	}


