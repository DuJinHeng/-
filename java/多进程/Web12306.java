package Thinking;
/**
 * ������io���ģʽ
 * ʹ�þ�̬����ʵ�ֶ��߳�
 * �ô�:���ⵥ�̳еľ�����  
 * 	���ڹ�����Դ
 * @author 26368
 *
 */
	
public class Web12306 implements Runnable{
    private int ticket=50;
    @Override
    public void run() {
	while(ticket>0) {
	    System.out.println(Thread.currentThread().getName()+"����"+ticket--);
	}
    }
    
    public static void main(String[] args) {//��thread��Ϊ��������ͬ������߳�
	Runnable web=new Web12306();
	Thread t1=new Thread(web,"��ţ1");
	Thread t2=new Thread(web,"��ţ2");
	Thread t3=new Thread(web,"��ţ3");
	Thread t4=new Thread(web,"��ţ4");
	t1.start();
	t2.start();
	t3.start();
	t4.start();
    }
}
