package Thinking;
/**
 * RandomAccessFile����ϰ  ��������˼��
 * @author 26368
 *
 */

import java.util.List;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class SplitFile {
    
    //�ļ�����
    private File file=null;
    //�ָ�Ŀ���
    private long size=-1;
    //�ָ��С
    private long blockSize=-1;
    //�ָ������ 
    private List<String> blockName=null;
    //�ļ���С
    private long fileLength;
    
    //Ĭ�Ϸָ���С;
    public SplitFile(String filePath) {
	this(new File(filePath),1024);
    }
    public SplitFile(File f) {
	this(f,1024);	
    }
    public SplitFile(String filePath,long blockSize) {
	this(new File(filePath),blockSize);
    }
    public SplitFile(File f,long blockSize)  {
	blockName=new ArrayList<String>();
	this.file=f;
	this.blockSize=blockSize;
	init();	
    }
    
    //��ʼ����Ա
    private void init()  {
	//�ж��ļ��Ƿ�ϸ�
	if(!file.exists()||file.isDirectory()) {
	    try {
		throw new IOException("�ļ�δ�ҵ�");
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}	
	//�жϷָ��С�Ƿ�Ϸ�
	if(blockSize<=0) {
	    throw new IllegalArgumentException("����ָ��С���Ϸ�");
	}
	//�����ļ���С
	fileLength=file.length();
	if(blockSize>fileLength) {
	    blockSize=fileLength;
	    size=1;
	}
	//����ָ�Ŀ���  ע��������Ҫ����1.0  ���ӵĻ� ������ʵ�ʲ�ͬ
	size=(long) Math.ceil(fileLength*1.0/blockSize);
	//���ָ��ļ������ļ���;
	initFileName();
    }
    //���ָ��ļ������ļ���;
    private void initFileName() {
	String fileName=file.getName();
	int index=fileName.indexOf('.');
	for(int i=0;i<size;i++) {
	    //Դ�ļ���+part +i+�ļ�����
	    blockName.add(fileName.substring(0, index)+"Part"+i+fileName.substring(index));
	}
    }
    //�ָ��ļ�
    public void split(String dest) {
	//�иʼλ��
	long beginPos=0;
	//�и�Ĵ�С
	long actualBlockSize=blockSize;
	//����Ŀ���ļ���
	(new File(dest)).mkdirs();
	for(int i=0;i<size;i++) {
	    //�и�  ���һ������
	    if(size-1==i) {
		actualBlockSize=fileLength-beginPos;
	    }
	    saveSplitFile(new File(dest+'/'+blockName.get(i)), beginPos, actualBlockSize);
	    beginPos+=actualBlockSize;
	}
    }
    //����ָ����ļ�
    private void saveSplitFile(File dest,long beginPos,long length) {
	//Դ�ļ���ȡ��
	RandomAccessFile raf=null;
	//����ļ�д����
	OutputStream os=null;
	byte[] flush=new byte[1024];
	try {
	    dest.createNewFile();
	    os=new BufferedOutputStream(new FileOutputStream(dest));
	    //��ȡԴ�ļ�������
	    raf=new RandomAccessFile(file, "r");
	    //��λ��ʼ��ȡ�ĵط�
	    raf.seek(beginPos);
	    while(true) {
		if(1024<length) {
		    raf.readFully(flush);
		    length-=1024;
		    os.write(flush, 0, 1024);
		    continue;
		}
		raf.readFully(flush,0,(int)length);
		os.write(flush,0,(int)length);
		break;
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}finally{
	    if(null!=raf) {
		try {
		    raf.close();
		    os.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	
	
    };
    
    
    public static void main(String[] args) {
	SplitFile sf=new SplitFile("C:\\Users\\26368\\Desktop\\java�ʼ�.txt",2048);
	sf.split("C:\\Users\\26368\\Videos\\1");
    }
}








