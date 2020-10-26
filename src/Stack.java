
public class Stack {
	
	//estrutura de dados
	private char[] vetor;
	private int top;
	
	//operações
	public void create(int tam) {
		vetor = new char [tam];
		top = -1;
	}
	
	public void push(char a) {
			
		if(isFull()) {
			System.out.println("PILHA CHEIA, não é possível adicionar mais itens");
		}else {
			top = top+1;
			vetor[top] = a;
		}
	}
	
	public void pop() {
			
		if(isEmpty()) {
			System.out.println("PILHA VAZIA, não é possível remover mais itens");
		}else {
			top = top-1;
		}
	}
	
	public int size() {
		return top+1;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public boolean isFull() {
		return size()==vetor.length;
	}
	
	public char getTop() {
		if(isEmpty()) {
			System.out.println("[getTop] Pilha Vazia");
			return '-'; 
		}else {
			return vetor[top];
		}
	}
	
	public void clear() {
		top = -1;
		System.out.println("A Pilha foi Limpa");
	}
	
	public void print() {
		
		if(isEmpty()) {
			System.out.println("Operação inválida. PILHA VAZIA");
		}else {
			for(int i=0;i<=top;i++) {
				System.out.print(vetor[i]+" ");
			}
		}
	}
}
