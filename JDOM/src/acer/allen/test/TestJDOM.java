package acer.allen.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * ����JDOM
 * 
 * @author acer
 *
 */
public class TestJDOM {

	public static void main(String[] args) throws IOException, JDOMException {
		// ����·��
		String path = "./users.xml";

		/*
		 * // �����ļ����� File file = new File(path);
		 * 
		 * if (!file.exists()) { System.err.println("�ļ������ڣ�");
		 * 
		 * // ���ô���XML���� createXML(path);
		 * 
		 * System.out.println("�ļ������ɹ�!"); } else { file.delete();
		 * 
		 * // ���ô���XML���� createXML(path);
		 * 
		 * System.out.println("�ļ������ɹ�!"); }
		 */

		// ����XML
		parseXML(path);

		// �޸�XML
		update(path);
	}

	/**
	 * ����XML
	 * 
	 * @param path
	 * @throws IOException
	 */
	static void createXML(String path) throws IOException {

		// ���ڵ�
		Element root = new Element("users");

		// �ӽڵ�
		Element user1 = new Element("user");
		Element user2 = new Element("user");

		// children's son
		Element name1 = new Element("name");

		Element age1 = new Element("age");

		Element gender1 = new Element("gender");

		Element name2 = new Element("name");

		Element age2 = new Element("age");

		Element gender2 = new Element("gender");

		// ��������
		Attribute att1 = new Attribute("id", "1");
		user1.setAttribute(att1);

		// ����ı�����
		name1.addContent("С��");
		age1.setText("19");
		gender1.setText("male");

		// ����ı�����
		name2.addContent("С��");
		age2.setText("18");
		gender2.setText("female");

		// ����������ϵ

		user1.addContent(name1);
		user1.addContent(age1);
		user1.addContent(gender1);

		// ������Ԫ�� addContent
		user2.addContent(name2);
		user2.addContent(age2);
		user2.addContent(gender2);

		root.addContent(user1);
		root.addContent(user2);

		// ���ݸ��ڵ㴴���ĵ�����
		Document document = new Document(root);

		// ��ʽ��
		Format format = Format.getPrettyFormat();
		// ���ñ����ʽ
		format.setEncoding("utf-8");

		// д��ʹ��XMLOutputter ���ڴ��е��ļ���д����������
		XMLOutputter outputter = new XMLOutputter(format);

		// �ļ�д��
		FileOutputStream fos = new FileOutputStream(new File(path));

		// ִ��д������
		outputter.output(document, fos);

	}

	/**
	 * ��ȡ���ڵ�
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 * @throws JDOMException
	 */
	static Element getRootElement(String path) throws JDOMException, IOException {
		// ��ȡӲ�̵�XML�ĵ�
		InputStream is = new FileInputStream(path);

		// ��ȡXML�ļ�������
		SAXBuilder sax = new SAXBuilder();

		// ��������������ת��Ϊ�ĵ�����
		Document document = sax.build(is);

		// ��ȡ�ĵ�����ĸ��ڵ�
		Element root = document.getRootElement();

		return root;

	}

	/**
	 * ����XML
	 * 
	 * @param path
	 * @throws IOException
	 * @throws JDOMException
	 */
	static void parseXML(String path) throws JDOMException, IOException {

		// �õ����ڵ�
		Element root = getRootElement(path);

		// ���ݸ��ڵ�õ��ӽڵ�
		Element user1 = root.getChild("user");

		Element name = user1.getChild("name");

		Element age = user1.getChild("age");

		Element gender = user1.getChild("gender");

		// �����ӽڵ�õ��ӽڵ��Ԫ��ֵ
		System.out.println("name=" + name.getText());
		System.out.println("age=" + age.getText());
		System.out.println("gender=" + gender.getText());

		// �õ�����
		System.out.println("id=" + user1.getAttribute("id").getValue());
		System.out.println("id=" + user1.getAttributeValue("id"));
		System.out.println("name=" + user1.getChildText("name"));

		// ��ӡ���е��ӽڵ�
		List<Element> elements = root.getChildren();

		// �������
		for (Element element : elements) {
			System.out.println("--------------------");
			System.out.println(element);
		}
	}

	/**
	 * �޸�
	 * 
	 * @param path
	 * @throws IOException
	 * @throws JDOMException
	 */
	static void update(String path) throws JDOMException, IOException {

		// ��ȡӲ�̵�XML�ĵ�
		InputStream is = new FileInputStream(path);

		// ��ȡXML�ļ�������
		SAXBuilder sax = new SAXBuilder();

		// ��������������ת��Ϊ�ĵ�����
		Document document = sax.build(is);

		// ��ȡ�ĵ�����ĸ��ڵ�
		Element root = document.getRootElement();

		// ���user����
		Element user = root.getChild("user");

		// �޸�����
		Element age = user.getChild("age");
		age.setText("100");

		// ���һ���ӽڵ�
		Element nickName = new Element("nickName").setText("Mars");
		user.addContent(nickName);

		// ɾ���ӽڵ�
		user.removeChild("name");

		// �޸�����
		user.setAttribute("id", "3");

		// �������
		user.setAttribute("clazz", "12");

		// ɾ������
		user.removeAttribute("id");

		// ��ʽ��
		Format format = Format.getPrettyFormat();
		// ���ñ����ʽ
		format.setEncoding("utf-8");

		// д��ʹ��XMLOutputter ���ڴ��е��ļ���д����������
		XMLOutputter outputter = new XMLOutputter(format);

		// �ļ�д��
		FileOutputStream fos = new FileOutputStream(new File(path));

		// ִ��д������
		outputter.output(document, fos);
	}

}
