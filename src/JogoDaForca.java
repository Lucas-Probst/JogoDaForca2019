import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
	public static void main(String[] args) {
		
		int cont=0, cont2=0, i, palavraN=0, tamanho=0;
		long tempo, mins, segs;
		char[] palavra, letrasAcerto, letrasErro;
		String linha;
		
		palavra = new char[1];
		palavra[0]='.';
		
		try{

			BufferedReader br = new BufferedReader(new FileReader("Palavras.txt"));

			while(br.ready()){
					br.readLine();
					cont=cont+1;
			}
			br.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		while(palavraN==0) {
			palavraN = new Random().nextInt(cont);
		}
		System.out.println(palavraN);
		cont=0;
		
		try{

			BufferedReader br = new BufferedReader(new FileReader("Palavras.txt"));

			while(br.ready()){
				linha = br.readLine();
				cont=cont+1;
				
				if(cont==palavraN) {
					tamanho = linha.length();
					palavra = new char[linha.length()];
					for(i=0;i<linha.length();i++) {
						palavra[i] = linha.charAt(i);
						System.out.print(" "+palavra[i]);
					}
				}
			}
			br.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		
		boolean play=true;
		char letra='.';
		boolean acerto=true;
		char[] alfabetoMA = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		char[] alfabetoMI = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		letrasAcerto = new char[tamanho];
		letrasErro = new char[6];
		
		Stack pilhaAcerto = new Stack();
		Stack pilhaErro = new Stack();
		Boneco boneco = new Boneco();
		
		pilhaAcerto.create(tamanho);
		pilhaErro.create(6);
		
		Scanner teclado = new Scanner(System.in);
		
		long tempoInicial = System.currentTimeMillis();
		
		while(play) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n _________________________");
			System.out.println("|QUANTIDADE DE ACERTOS: "+pilhaAcerto.size()+" |");
			System.out.println("|-------------------------|");
			System.out.println("| QUANTIDADE DE ERROS: "+pilhaErro.size()+"  |");
			System.out.print("| ");
			if(pilhaErro.isEmpty()) {
			}else {
				pilhaErro.print();
			}
			for(i=0;i<6-pilhaErro.size();i++) {
				System.out.print("  ");
			}
			System.out.println("            |");
			System.out.println("|_________________________|");
			
			if(pilhaErro.size()==0) {
				boneco.Mostrar();
			}else if(pilhaErro.size()==1) {
				boneco.MostrarUmErro();
			}else if(pilhaErro.size()==2) {
				boneco.MostrarDoisErros();
			}else if(pilhaErro.size()==3) {
				boneco.MostrarTresErros();
			}else if(pilhaErro.size()==4) {
				boneco.MostrarQuatroErros();
			}else if(pilhaErro.size()==5) {
				boneco.MostrarCincoErros();
			}else if(pilhaErro.size()==6) {
				boneco.MostrarSeisErros();
				System.out.println("\n	==VOCÊ PERDEU==");
				break;
			}
			
			cont=0;
			
			for(i=0;i<tamanho;i++) {
				if(palavra[i]==letrasAcerto[i]) {
					System.out.print(" "+palavra[i]);
					cont=cont+1;
				}else {
					System.out.print(" _");
				}
			}
			
			if(cont==letrasAcerto.length) {
				System.out.println("\n	==VOCÊ VENCEU==");
				break;
			}
			
			System.out.print("\n\nDigite uma Letra: ");
			letra = teclado.next().charAt(0);
			
			for(i=0;i<alfabetoMI.length;i++) {
				if(letra==alfabetoMI[i]) {
					letra=alfabetoMA[i];
				}
			}
			
			acerto=false;
			for(i=0;i<tamanho;i++) {
				if(palavra[i]==letra) {
					
					letrasAcerto[i]=letra;
					pilhaAcerto.push(letra);
					acerto=true;
					
				}
			}
			
			if(acerto==false) {
				pilhaErro.push(letra);
				for(i=0;i<6;i++) {
					if(pilhaErro.getTop()==letrasErro[i]) {
						pilhaErro.pop();
						break;
					}else if(i==5) {
						letrasErro[cont2]=letra;
						cont2=cont2+1;
					}
				}
			}
		}
		
		teclado.close();
		
		long tempoFinal = System.currentTimeMillis();
		
		tempo = (tempoFinal-tempoInicial)/1000;
		
		if(tempo/60>=1) {
			mins = tempo/60;
		}else {
			mins = 0;
		}
		
		for(i=1;i<=mins;i++) {
			tempo = tempo-60;
		}
		
		segs = tempo;
		
		System.out.println("\nTempo transcorrido do jogo: "+mins+":"+segs);
		
		System.out.print("\nPilha Acerto ");
		pilhaAcerto.print();
		System.out.print("\nPilha Erro ");
		pilhaErro.print();
		
		
	}
}
