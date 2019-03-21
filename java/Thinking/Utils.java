package Thinking;

import java.util.Arrays;

/**
 * �Զ���һ��������  ʵ�ַ�������
 * @author 26368
 * @param <T>
 *��С��������	
 *
 *��ʹ�ø÷���ʱ��Ҫ  ����T�̳���Comparable�ӿ�  ������дcompareTo����
 *
 *Ҳ������������  ���Խ�����ת������
 */
public class Utils<T> {
    private Utils() {}
    public static <T extends Comparable>void sort(T t[]){
	boolean sorted=true;
	for(int i=0;i<t.length-1;i++) {
	    for(int j=0;j<t.length-i-1;j++) {		
		if(0<((Comparable<T>)t[j]).compareTo(t[j+1])) {
		    T temp=t[j];
		    t[j]=t[j+1];
		    t[j+1]=temp;
		    sorted=false;
		}
	    }
	    if(sorted) {
		break;
	    }
	}
    }
    public static void main(String[] args) {
	String s[]= {"das","dawq","daw","fsa","dfg"};
	Utils.sort(s);
	System.out.println(Arrays.toString(s));
    }
}
