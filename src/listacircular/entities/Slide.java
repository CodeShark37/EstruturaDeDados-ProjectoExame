package listacircular.entities;

public class Slide {
    private int id;
    private DoublyCircularLinkedList<Noticia> list;
    private int currentSlideIndex;
    private Node<Noticia> currentNode;

    public Slide(){
        this.list = new DoublyCircularLinkedList<>();
        this.currentSlideIndex = 0;
    }
    public Slide(int id, DoublyCircularLinkedList<Noticia> list) {
        this.id = id;
        this.list = list;
        this.currentSlideIndex = 0;
        this.currentNode = null;
    }
    public void addSlide(Noticia node){
        list.addLast(node);
    }
    public void addSlideFirst(Noticia node){
        list.addFirst(node);
    }
    public void nextSlide(){
        currentSlideIndex = (currentSlideIndex) % this.size();
        currentNode = list.getNode(currentSlideIndex);
        showSlide();
        currentSlideIndex++;
        currentNode = currentNode.getNext();
    }
    public void prevSlide(){
        currentSlideIndex = (currentSlideIndex) % this.size();
        currentNode = list.getNode(currentSlideIndex).getPrev();
        showSlide();
        currentSlideIndex--;
        currentNode = currentNode.getPrev();
    }
    public void stopSlide(){
        this.currentSlideIndex=0;
    }
    private void showSlide(){
        System.out.println("+---------------------------------------+");
        System.out.println("| ("+(currentSlideIndex+1)+"/"+list.size()+")"+" :"+currentNode.getValue().getTitulo()+"   |");
        System.out.println("+---------------------------------------+");
        System.out.println("|"+currentNode.getValue().getInfo()+"");
        System.out.println("+----------------------------------------+");
    }
    public boolean isEmpty(){
        return (!(list.size()>0));
    }
    public int size(){
        return list.size();
    }
    public void removeSlide(Noticia node){
        list.remove(node);
    }
    public void removeLastSlide(){
        list.removeLast();
    }
    public void removeFirstSlide(){
        list.removeFirst();
    }
    public Noticia getSlide(int index){
        return list.getNode(index).getValue();
    }
    public void clearSlide(){
        list.clear();
    }
    public int getCurrentSlideIndex() {
        return currentSlideIndex;
    }
}