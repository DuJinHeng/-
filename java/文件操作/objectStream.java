
package Thinking;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class objectStream{
    public static void main(String[] args) {
	//���ô�ӡ��  д���ļ���
	/**PrintStream ps=null;
	try {
	    ps=new PrintStream(new BufferedOutputStream(
		    new FileOutputStream(new File("C:\\Users\\26368\\Videos\\Captures\\wo.txt"))));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	ps.println("woaini");
	ps.close();
	*/
	
	//�����ô�ӡ��  ��ȡ�ļ��е�����
	/**InputStream is=null;
	try {
	    is=new BufferedInputStream(new FileInputStream(new File("C:\\Users\\26368\\Videos\\Captures\\wo.txt")));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	Scanner s=new Scanner(is);
	System.out.println(s.nextLine());
	System.out.println(s.nextLine());
	s.close();
	*/
	
	//������̨����ַ�  д���ļ���
	/**Scanner s=new Scanner(System.in);
	PrintStream ps=null;
	try {
	    ps=new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("C:/Users/26368/Videos/Captures/wo.txt"))));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}	
	ps.print(s.nextLine());
	ps.close();
	s.close();
	*/
	
	//����Ĭ�Ϻ����޸������λ��
	//PrintStream(OutputStream,bool)�ڶ�������  �Ƿ��Զ�ˢ�µ��ļ�
	/**try {
	    System.setOut(new PrintStream(new BufferedOutputStream(new 
	    	FileOutputStream(new File("C:/Users/26368/Videos/Captures/wo.txt"))),true));//
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	System.out.print("woshi ");*/
	//�Ļؿ���̨
	//System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out))));
	
	//ģ��Scanner ��ȡ����̨����������
	BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
	String buf=null;
	try {
	    buf=br.readLine();
	} catch (IOException e) {
	    e.printStackTrace();
	}finally {
	    if(br!=null) {
		try {
		    br.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	System.out.println(buf);
    }
}
