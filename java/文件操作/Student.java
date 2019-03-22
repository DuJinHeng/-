
package Thinking;
//������Ҫʹ��Serializable�Ľӿ�   �ýӿ��ǿսӿ�  ��������������л�
public class Student implements java.io.Serializable{
    private int id;
    private String name;
    private int age;
    private transient String descrip;
    public Student(int id, String name, int age, String descrip) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.descrip = descrip;
    }
    public Student() {
	super();
    }
    @Override
    public String toString() {
	return "Student [id=" + id + ", name=" + name + ", age=" + age + ", descrip=" + descrip + "]";
    }
}
