package TestListReferenceBased;


public class TestListReferenceBased {

    private Node first, last;
    public int size=0;

    public TestListReferenceBased(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }

    public void add(int n, int pos){
    	
        Node newNode = new Node(n, null);
        Node pointer = first;
        if(isEmpty()){
        	first = newNode;
        	size++;
        	return;
        }
        if(pos==0 && !isEmpty()){
        	newNode.setNext(first);
        	first = newNode;
        	size++;
        	return;
        }
        if(pos == size+1 && !isEmpty()){
        	last.setNext(newNode);
        	last = newNode;
        	size++;
        	return;
        }
        
        pos = pos-1;
        for (int i=0; i< size; i++){
            
            if(i == pos){
            	Node tmp = pointer.getNext();
            	pointer.setNext(newNode);
            	newNode.setNext(tmp);
            	break;
            }
            pointer = pointer.getNext();
        }
        size++;
    }

    public int remove(int pos){
        if(pos == 0){
        	Node x = first;
        	first = first.getNext();
        	size--;
        	return x.getItem();
        }
        if(pos == size-1){
        	Node y = last;
        	Node p = first;
        	Node q = first;
        	while(p!=last){
        		q = p;
        		p = p.getNext();
        	}
        	last = q;
        	last.setNext(null);
        	size--;
        	return y.getItem();
        }
        Node pointer = first;
        pos = pos-1;
        Node x = first;
        for(int i=0; i < size; i++){
        	if(i==pos){
        		x = pointer.getNext();
        		Node tmp = pointer.getNext();
        		tmp=tmp.getNext();
        		pointer.setNext(tmp);
        		break;
        	}
        	pointer = pointer.getNext();
        }
        size--;
        return x.getItem();
    }

    public int get(int pos){
        Node c = first;
        int count = 0;
        while(c.getNext()!=null){
        	if(count==pos){
        		return c.getItem();
        	}
        	c = c.getNext();
        	count++;
        }
        return -1111;
    }

    public void removeAll(){
        first = null;
        size = 0;
    }

    public void displayList(){
    	System.out.print(size + " Items in the linked list:");
    	
    	if(first.getNext()==null){
    		System.out.print("" + first.getItem());
    		return;
    	}
        
        Node a = first;
        System.out.println(first.getItem() + " ");
        a = first.getNext();
        while(a.getNext()!=null){
            System.out.print(a.getItem() + " ");
            a = a.getNext();
        }
        System.out.println(a.getItem() + " ");
    }


}
