JDBC:(Java  DataBase  Connectivity,java���ݿ�����)
   01.ʹ��java�������������ݿ�ļ���
   02.����һ����java���Ա�д����ͽӿ���� ��JDBC API�� ���������ǵ����ݿ⣡
   03.��ͬ�����ݿ⳧���ṩ�˲�ͬ�����ݿ�����
 
JDBC��ODBC

JDBC��
   01.��ȫ��java���Ա�д
   02.���ܸߣ���ƽ̨
   03.���ʲ�ͬ�����ݿ���Ҫ���ز�ͬ��������
   
ODBC��
   01.���ܵͣ�ֻ����windowsϵͳ������
   02.����Ҫ���ز�ͬ��������
 
   
���õ�JDBC API:

1.Driver  ��ȡ���ݿ��������
     com.mysql.jdbc.Driver              mysql����
     oracle.jdbc.driver.OracleDriver    oracle����
     
2.Connection �ӿ�  ������ָ�������ݿ⽨������
     DriverManager.getConnection(url,userName,password)��������
  
  url:�������ݿ�ĵ�ַ
       jdbc:mysql://localhost:3306/easybuy
       jdbc:oracle:thin:@localhost:5512:easybuy
  userName:�û���
  password:����   
   
 �������ݿ����Ҫ�أ�
   01.������
   02.�������ݿ�ĵ�ַ
   03.�û���
   04.����   
   
   
  jdbc:mysql://localhost:  3306/   easybuy  ? useUnicode=true&characterEncoding=utf8
    Э��     ��Э��      ��������     �˿ں�    ���ݿ�����   ?  ������=����ֵ
   
3.Statement ִ��������д��sql��䣨�������ݿ�ȥִ�У�
  PreparedStatement  
       01.sqlԤ���빦��
       02.��ֹsqlע��

	01.select * from  student;  //��ѯstudent���е���������   
	û�в���
	
	
	02.select * from  student  where  studentName="С��"  //  ��ѯstudentName="С��"��ѧ������ 
	�в���
	   
	   С��
	   01.ʹ�û������
	   02.С�����ֵ �̶��� 
	   03.���ֵ������д��������
	   
	   
	select  * from  user  where  userName=xxx and password=xxx
	 
4.ResultSet ���صĽ����
     
     user���е��ֶ�
        1         2                   3                  4
     id��int��   userName��varchar�� password��varchar��   birthday��datetime��
 
  ���⣿
   01.�ֶε�����һ����
   02.��ô����ֶ����ͣ�
   
   ��ȡ������� ÿһ��ָ�����ֶΣ�
   
    01. rs.getInt(int  columnIndex)    �����ֶ��±��ȡ  
          rs.getInt(1)  
           �ֶ��±������Ǵ������ʱ�� �����Ѿ������ˣ�
    02. rs.getInt(String columnName)       
          rs.getInt("id")  
     
	   
JDBC�������ݿ�Ĳ���
 01.�������ݿ�����                      Class.forName(������ȫ����)       
 02.�������� ��Ҫ��Ҫ��              Connection con=DriverManager.getConnection(url,userName,password)
 03.��дsql��ִ��                       PreparedStatement ����Statement
 04.��������                             ResultSet(��ѯ)  int(��ɾ��)
 05.�ͷ���Դ                                 �ȿ��ĺ��




JdbcDemo���ڵ����⣺
  01.������ɾ�Ĵ��� ���� sql���֮�⣬���������ظ���JDBC API,�ͷ���Դ��
  02.sql������еĲ�����Ӧ���ڷ����Ĳ����б��У���Ϊ��Щ��������ǰ���û����ݹ�����
     ���˵�û�������10��������������һ������ô����Ӧ��ʹ��JavaBean��
  03.sql����ִ����ʹ�õ�Statement,����ȫ�����ܵ�
             ����sqlע��   
             û�ж�sql������Ԥ����
     ����loginUser()�е�password д��  aaa'or'1'='1 Ҳ���Ե�¼��
     
     
            
  







	   
   
   
   
   