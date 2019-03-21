package solar;

import java.util.Iterator;

public class LinkList implements java.lang.Iterable{
    private Node first;//�����ͷ
    private Node last;//�����β
    private int size;//������
    
    public LinkList() {	
    }
    
    public LinkList(Object obj) {
	add(obj);
    }
    
    public int size() {
	return size;
    }
    
    public void add(Object obj) {//׷�ӵ������β��
	Node n=new Node(obj);
	if(first==null) {
	    first=n;
	    last=n;	    
	}else {
	    last.setNext(n);//�����һ��node��ָ���µ�node;
	    n.setPre(last);//���µ�node��preָ��last;
	    last=n;	    
	}
	size++;
    }
    
    public void addFirst(Object obj) {//��Ӷ���ͷ��
	Node n=new Node(obj);
	if(first==null) {
	    first=n;
	    last=n;
	}else {
	    n.setNext(first);//���µ�node����һ��ָ���һ��;
	    first.setPre(n);//����һ��node����һ��ָ���µ�node;
	    first=n;
	}
	size++;
    }
    
    private void rangeCheck(int index) {
	if(index<0) {
	    try {
		throw new Exception("�����±겻��ȷ");
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	if(index>=size) {
	    throw new IndexOutOfBoundsException("��������±��Ѿ�Խ��");
	}
    }
    
    public Object get(int index) {
	Node temp=getNode(index);
	return temp.getObj();
    }
    
    public void addLast(Object obj) {
	this.add(obj);
    }
    
    public Object remove() {//�Ƴ�ͷ�ڵ�
	if(size>0) {
	    Object temp=first;
	    first.getNext().setPre(null);
	    first=first.getNext();
	    return temp;
	}
	return null;	
    }
    
    private Node getNode(int index) {//��ȡָ���ڵ�
	rangeCheck(index);
	Node temp=first;
	while(true) {
	    if(index-->0) {
		temp=temp.getNext();
	    }else {
		break;
	    }
	}
	return temp;
    }
    
    public Object remove(int index) {//�Ƴ�ָ������
	rangeCheck(index);
	Node temp=getNode(index);
	if(size==1) {//���ֻ��һ���ڵ�������
	    first=null;
	    last=null;
	    size--;
	    return temp.getObj();
	}
	
	if(temp.hasPre()) {//����ǰ�ڵ�
	    temp.getPre().setNext(temp.getNext());	    
	}else {//������ǰ�ڵ�
	    first=temp.getNext();
	}
	if(temp.hasNext()) {
	    temp.getNext().setPre(temp.getPre());
	}else {
	    last=temp.getPre();
	}
	size--;
	return temp.getObj();
    }
       
    @Override
    public Iterator iterator() {

	return new Iterator() {

	    private int cur=0;//��ǰ����
	    private int lastRet=-1;//�ոձ�����Ķ���
	    @Override
	    public boolean hasNext() {
		return cur!=size;
	    }

	    @Override
	    public Object next() {
		
		if(cur>=size) {
		    try {
			throw new Exception();
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
		Object temp=get(cur);
		lastRet=cur++;
		return temp;		
	    }
	    
	    public void remove() {
		if(lastRet==-1) {
		    try {
			throw new Exception("�������ѱ�ɾ��");
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
		LinkList.this.remove(lastRet);
		lastRet=-1;
	    }
	};
    }
    public static void main(String[] args) {
	LinkList l=new LinkList();
	l.add(1);
	l.add(4);
	l.add(7);
	l.add(2);
	for(Object t:l) {
	   System.out.println(t);
	}
	

    }
}






























