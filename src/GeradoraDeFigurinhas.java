
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;


import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

	void cria(  InputStream inputStream , String nomeArquivo ) throws Exception{
		// leitura da imagem 
		// --InputStream inputStream = new FileInputStream("entrada/filme");
		// --InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMzE5MDM1NDktY2I0OC00YWI5LTk2NzUtYjczNDczOWQxYjM0XkEyXkFqcGdeQXVyMTQxNzMzNDI@.jpg").openStream();
		 BufferedImage ImagemOriginal = ImageIO.read(inputStream);
		
	   // cria  nova imagem em memória com trasparencia e com tamanho novo  
		 
		int largura = ImagemOriginal.getWidth();
		int altura  = ImagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem  = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
	  // copiar a imagem original pra nova imagem (em memória)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics(); 
		graphics.drawImage(ImagemOriginal,0,0,null); 
		
	// configurar a fonte 
		 var  fonte = new Font(Font.SANS_SERIF,Font.BOLD , 64);
		graphics.setFont(fonte);
		graphics.setColor(Color.red);
		
	// escrever uma frase na nova imagem 
		graphics.drawString("TOPZERA",100 , novaAltura - 100);
		
  // escrever a nova imagem em um arquivo 
		ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo));
	}
	
}
