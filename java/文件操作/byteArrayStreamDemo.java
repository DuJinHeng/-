package Thinking;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * �ڵ���   �����������Ƕ�д�ļ���  ���������ݵĴ���   ���������ݲ�����ʧ
 * �ʺ�С���ݵĴ���
 * ByteArrayOutputStream  ByteArrayOutputStream
 * read(byte[],int off,int len)+close()
 * write(byte[],int off,int len)+toByteArray
 * ��Ҫ�����е��½���������ʹ�ö�̬
 * @author 26368
 *
 */
public class byteArrayStreamDemo {
    public static byte[] getByteFromFile(String srcPath) throws IOException {
	byte[] flush=null;//���Ƿ���ֵ
	ByteArrayOutputStream bos=new ByteArrayOutputStream();
	File src=new File(srcPath);
	InputStream is=new BufferedInputStream(new FileInputStream(src));
	byte[] data=new byte[1024];
	int len=0;
	while(-1!=(len=is.read(data))){
	    bos.write(data, 0, len);
	}
	bos.flush();//������ˢ�µ�bos��
	flush=bos.toByteArray();// �����С��  ��ȡ�Ĵ�С�仯
	is.close();
	bos.close();	
	return flush;
    }
    
    //���ֽ�����д�뵽�ļ���
    public static void toFileFromByteArray(byte[] src,String destPath) throws IOException {
	File dest=new File(destPath);
	InputStream is=new BufferedInputStream(new ByteArrayInputStream(src));
	OutputStream os=new BufferedOutputStream(new FileOutputStream(dest,false));
	byte[] flush =new byte[1024];
	int len=0;
	while(-1!=(len=is.read(flush))) {
	    os.write(flush, 0, len);
	}
	os.flush();
	os.close();
	is.close();	
    }
    
    public static void main(String[] args) {
	String s="woainisda";
	byte[] b=s.getBytes();
	try {
	    toFileFromByteArray(b, "C:\\Users\\26368\\Documents\\Visual Studio 2013\\Դ��\\c++�㷨����.txt");
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
}
