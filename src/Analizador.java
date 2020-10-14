import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class Analizador {
	String[] entrada;
	Stack<String> st;

	public Analizador(String entrada) {
		this.entrada = entrada.split("");
		this.st = new Stack<String>();
		this.st.push("┴"); //elemento inicial de la pila
		
		balanceado();
	}
	
	public void balanceado() {
		boolean isBalanced = true;
		int i = 0;
		while(isBalanced && i<entrada.length) {
			if(isLeft(this.entrada[i])) {
				this.st.push(this.entrada[i]);
			}else {
				if(type(this.entrada[i]) == type(st.peek())) {
					st.pop();
				}else {
					isBalanced = false;
				}
			}
			i++;
		}
		
		if(isBalanced) {
			System.out.println("Balanceado");
		}else {
			System.out.println("Desvalanceado");
		}
	}
	
	public boolean isLeft(String sim) {
		boolean side = false;
		switch (sim) {
		case "{":
			side = true;
			break; 
		case "[":  
			side = true;
			break; 
		case "(":  
			side = true;
			break;
		case "}":
			side = false;
			break; 
		case "]": 
			side = false;
			break; 
		case ")":  
			side = false;
			break;
		default:
			break;
		}
		
		return side;
	}
	
	public int type(String sim) {
		int type = 0;
		switch (sim) {
		case "{":
			type = 1;
			break;
		case "}":
			type = 1;
			break;
		case "(":
			type = 2;
			break;
		case ")":
			type = 2;
			break;
		case "[":
			type = 3;
			break;
		case "]":
			type = 3;
			break;
		default:
			break;
		}
		return type;
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
		Analizador a = new Analizador(s);
	}

}
