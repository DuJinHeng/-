package Thinking;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ʹ��callable�����߳� ��call������runnable��run�Ա�
 * call�з���ֵ,call�����ӳ��쳣
 * @author 26368
 *  �������ܵ�ģ����ϰ
 */
public class test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
	//�����߳�  �����Ǵ������߳���  Executor-->ִ����
	ExecutorService ser=Executors.newFixedThreadPool(2);
	race rabbit=new race("����",200);
	race tortoise=new race("�ڹ�",400);
	//��ȡ���к�ķ���ֵ  ����future��get��ȡ����ֵ
	Future<Integer> result1=ser.submit(rabbit);
	Future<Integer> result2=ser.submit(tortoise);
	
	Thread.sleep(2000);
	rabbit.setFlag(false);
	tortoise.setFlag(false);
	
	System.out.println("��������"+result1.get()+"�ڹ�����"+result2.get());
	//�ر��߳�  �����Զ��˳�
	ser.shutdownNow();
    }
}

//���ﷺ����ָ�߳����к�ķ���ֵ
class race implements Callable<Integer>{
    private String name;
    private long time ;//ÿ����ʱ��
    private int step=0;
    private boolean flag=true;//��־�Ƿ������
       
    public race(String name, long time) {
	super();
	this.name = name;
	this.time = time;
    }

    @Override
    public Integer call() throws Exception {
	while(flag) {
	    Thread.sleep(time);
	    step++;
	}
	return step;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }
    
}