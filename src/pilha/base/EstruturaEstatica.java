package pilha.base;
public class EstruturaEstatica <T>
{
	protected T[] Elemento;
	protected int Tamanho;

	public EstruturaEstatica(int capacidade)
	{
		this.Elemento=(T[]) new Object[capacidade];
		this.Tamanho=-1;
		
	}
	public EstruturaEstatica()
	{
		this(12);
	}
	public int Tamanho()
	{
		return this.Tamanho;
	}
	public boolean Adicionar(T elemento)
	{
		this.AumentarCapacidade();
		if(!isFull())
		{
			this.Tamanho++;
			this.Elemento[this.Tamanho]=elemento;
			return true;
		}
		return false;
	}
	public boolean estaVazia()
	{
		return this.Tamanho==-1;
	}
	public boolean Adicionar(int posicao, T elemento)
	{
		if (posicao < 0 || posicao > this.Tamanho)
		{
			throw new IllegalArgumentException("Posição inválida");
		}
		this.AumentarCapacidade();
		for (int i=this.Tamanho-1; i>=posicao; i--){
			this.Elemento[i+1] = this.Elemento[i];
		}
		this.Elemento[posicao] = elemento;
		this.Tamanho++;

		return true;
	}
	public boolean isFull(){
		return this.Tamanho == this.Elemento.length-1;
		
	}
	@SuppressWarnings("unchecked")
	public void AumentarCapacidade()
	{
		if (isFull())
		{
			T[] novoElemento = (T[]) new Object[this.Elemento.length * 2];
			for (int i=0; i<this.Elemento.length; i++)
			{
				novoElemento[i] = this.Elemento[i];
			}
			this.Elemento = novoElemento;
		}
		
	}
	@Override
	public String toString() 
	{
		StringBuilder s = new StringBuilder();
		s.append("[\n");
		s.append("------------------------------\n");
		for (int i=0; i<=this.Tamanho; i++){
			s.append(this.Elemento[i]);
			s.append("------------------------------\n");
		}
		s.append("]");
		
		return s.toString();
	}
}