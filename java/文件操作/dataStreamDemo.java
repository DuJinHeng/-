package Thinking;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���������ʵ�ֶ�int,double�Ȼ������͵Ĵ���
 * д���ļ�  ���������ͺ�����
 * ע�� д��˳���  д��˳�� ������ͬ  �������ݿ��ܳ���
 * @author 26368
 *
 */
public class dataStreamDemo{
    public static void read(String srcPath) throws IOException {
	File src=new File(srcPath);
	DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream(src)));
	double x=0;//������
	x=dis.readDouble();
	dis.close();
    }
    
    public static void write(String destPath) throws IOException {
	File dest=new File(destPath);
	DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
	dos.writeDouble(1.2);//д��double   writeXxx д�벻ͬ���͵�����
	dos.writeUTF("wo");//д���ַ���
	dos.flush();
	dos.close();
    }
    
    public static void main(String[] args) {
	
    }
}