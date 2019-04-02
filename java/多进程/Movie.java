package Thinking;

/**
 * ����������ģʽ
 * ����  �̵߳�����
 * @author 26368
 *
 */

//��ʾӰƬ   ��Ҫ������ �ݺ������߿�
public class Movie{
    
    public  String name ;//��Ӱ����
    private boolean flag=true;//true��ʾ�����߿��Բ���  false��ʾ �����߲���
    
    public synchronized void play(String name) {
	if(false==flag) {
	    try {//���flag��false  ������̵߳ȴ�
		this.wait();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	try {
	    Thread.sleep(200);//ģ���������ʱ��
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	this.name=name;
	this.notify();
	flag=false;
    }
    
    public synchronized void watch() {
	if(flag) {
	    try {//���flag��true������̵߳ȴ�
		this.wait();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	try {
	    Thread.sleep(200);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	this.notify();
	flag=true;
    }
    
    public static void main(String[] args) {
	Movie m=new Movie();
	player p=new player(m);
	Watcher w=new Watcher(m);
	Thread t=new Thread(p);
	Thread t1=new Thread(w);
	t.start();
	t1.start();
    }
}
//��ʾ������
class player implements Runnable{

    Movie m;    
    public player(Movie m) {
	super();
	this.m = m;
    }

    @Override
    public void run() {
	for(int i=0;i<20;i++) {
	    m.play("��Ӱ"+i);
	    System.out.println("����������"+m.name);
	}
    }    
}
//������
class Watcher implements Runnable{

    Movie m;
    public Watcher(Movie m) {
	this.m=m;
    }
    @Override
    public void run() {
	for(int i=0;i<20;i++) {
	    m.watch();
	    System.out.println("�����߹ۿ���"+m.name);
	}
    }
    
}