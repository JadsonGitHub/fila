// Classe para uma Fila de qualquer tipo (Queue)
public class Fila <T>
{    // Classe para um nó da fila
    private static class Node <T>
    {
        private final T data;    // Dado armazenado no nó
        private Node <T> next;   // Referência para o próximo nó
        // Construtor para inicializar o nó com o dado fornecido
        public Node (T data)
        {
            this.data = data;
            this.next = null;
        }
    }
    private Node <T> front; // Representa o início da fila (primeiro elemento)
    private Node <T> rear;  // Representa o final da fila (último elemento)
    private int size;       // Armazena o número de elementos na fila
    // Construtor para fila vazia
    public Fila ()
    {
        this.front = null; // Início vazio
        this.rear = null;  // Final vazio
        this.size = 0;     // Tamanho inicial é zero
    }
    // Método para verificar se a fila está vazia
    public boolean isEmpty ()
    {
        return size == 0; // Retorna true se o tamanho for 0
    }  // Método para obter o tamanho atual da fila
    public void printSize ()
    {
        System.out.println("Tamanho: " + size); // Tamanho da fila
    }  // Método para adicionar (enFileirar) um elemento ao final da fila
    public void enQueue (T element)
    {   // Cria um novo nó com o elemento fornecido
        Node <T> newNode = new Node <> (element);
        // Se houver um elemento no final da fila, conecta o novo nó ao final
        if (rear != null)
        {
            rear.next = newNode;
        }  // Atualiza o final da fila para o novo nó
        rear = newNode;
        // Se a fila estava vazia, atualiza o início para o novo nó também
        if (front == null)
        {
            front = rear;
        }   // Incrementa o tamanho da fila
        size ++;
    }   // Método para remover (desenFileirar) um elemento do início da fila
    public T deQueue ()
    {
        // Verifica se a fila está vazia antes de remover
        if (isEmpty())
        {
            throw new IllegalStateException ("Fila vazia");
        }   // Obtém o dado do primeiro elemento
        T data = front.data;
            // Atualiza o início da fila para o próximo nó
        front = front.next;
            // Se o início ficou vazio, o final também deve ser atualizado para null
        if (front == null)
        {
            rear = null;
        }   // Decrementa o tamanho da fila
        size --;
            // Retorna o elemento removido
        return data;
    }
    // Método para visualizar o elemento no início da fila
    public void printFirst()
    {
        // Verifica se a fila está vazia antes de acessar o início
        if (isEmpty())
        {
            throw new IllegalStateException ("Fila vazia");
        }   // Retorna o dado do primeiro elemento
        System.out.println("Primeiro elemento: " + front.data);
    }   // Método para exibir todos os elementos da fila
    public void printQueue()
    {
        // Verifica se a fila está vazia antes de exibir
        if (isEmpty())
        {
            System.out.println("Fila vazia!");
            return;
        }   // Percorre todos os nós da fila e imprime os dados
        Node <T> current = front;
        System.out.print("Fila: ");
        while (current != null)
        {
            System.out.print(current.data + " "); // Exibe o dado de cada nó
            current = current.next;               // Avança para o próximo nó
        }
        System.out.println();
    }   // Método para testar a Fila
    public static void main(String[] args)
    {   // Cria uma fila de inteiros
        Fila <Integer> fila = new Fila <> ();

        System.out.println();
        System.out.println("** Fila de inteiros criada **");
        fila.printQueue(); // Fila atual
        fila.printSize();  // Tamanho atual

        System.out.println();
        System.out.println("** Adicionando de elementos **");
        fila.enQueue(00);
        fila.enQueue(10);
        fila.enQueue(20);
        fila.enQueue(30);
        fila.enQueue(40);
        fila.enQueue(50);
        fila.enQueue(60);
        fila.enQueue(70);
        fila.enQueue(80);
        fila.enQueue(90);        
        fila.printQueue(); // Fila atual
        fila.printSize();  // Tamanho atual

        System.out.println();
        System.out.println("** Ver primeiro elemento **");
        fila.printFirst();
        fila.printQueue(); // Fila atual
        fila.printSize();  // Tamanho atual

        // Remove o primeiro elemento
        System.out.println();
        System.out.println("** Fila anda **");
        fila.deQueue();
        fila.printQueue(); // Fila atual
        fila.printSize();  // Tamanho atual
    }
}