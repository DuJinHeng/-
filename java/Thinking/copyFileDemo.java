package Thinking;

/**
 * һ�� ���绺����  BufferedInPutStream  ��ǿЧ��
 *�ڶ�ȡ�ַ���ʱ������������ʱ  ʹ��ת����
 *Reader= InPutStreamReader(new InputStream(""),"�ַ���")ע��������Լ��ϻ�����
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class copyFileDemo {
    
    public static void copyFile(File src,File dest) throws FileNotFoundException {
	InputStream is=null;
	OutputStream os=null;
	
	if(!src.exists()) {//�ж�Դ�ļ��Ƿ����
	    throw new FileNotFoundException("Դ�ļ�δ�ҵ�");
	}
	
	try {  	    
	    is=new FileInputStream(src);
	    os=new FileOutputStream(dest);
	    byte[] data=new byte[1024];
	    int len=0;
	    while(-1!=(len=is.read(data))) {//ѭ����ȡԴ�ļ�
		os.write(data, 0, len);
	    };
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}finally {
	    if(null!=src) {
		try {
		    is.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	    if(null!=os) {
		try {
		    os.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
    }
    
    public static void copyFile(String srcPath,String destPath) throws IOException {
	File src=new File(srcPath);
	File dest=new File(destPath);
	//����Ŀ���ļ�
	dest.getParentFile().mkdirs();
	dest.createNewFile();
	copyFile(src,dest);
    }
    
    //ʵ���ļ��м��ļ���ȫ����
    public static void copyDir(File src,File dest) throws FileNotFoundException {
	if(!src.exists()) {
	    throw new FileNotFoundException("δ�ҵ�Դ�ļ�"+src.getAbsolutePath());
	}
	if(src.isFile()) {
	    copyFile(src,new File(dest.getPath()+'/'+src.getName()));
	}else {
	    new File(dest.getPath()+'/'+src.getName()).mkdirs();
	    File []fList=src.listFiles();
	    for(File temp:fList) {
		copyDir(temp, new File(dest.getPath()+'/'+src.getName()));
	    }
	}
    }
    
    public static void main(String[] args) {	
	try {
	    copyDir(new File("C:/Users/26368/Videos"), new File("C:\\Users\\26368\\Pictures"));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}	
    }
}

