package pilha.pilha;

import Base.EstruturaEstatica;

public class Pilha <T> extends EstruturaEstatica <T> implements Cloneable
{

	public Pilha()
	{
		super();
	}
	
	public Pilha(int capacidade){
		super(capacidade);
	}
	
	public void Empilhar(T elemento)
	{
		super.Adicionar(elemento);
	}
	
	public T Topo()
	{
		
		if (this.estaVazia())
		{
			return null;
		} 
		
		return this.Elemento[this.Tamanho];
	}
	
	public T Desempilhar(){
		
		if (this.estaVazia())
		{
			return null;
		}
		return this.Elemento[this.Tamanho--];
	}
}




