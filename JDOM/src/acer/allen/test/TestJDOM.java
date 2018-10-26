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
 * 测试JDOM
 * 
 * @author acer
 *
 */
public class TestJDOM {

	public static void main(String[] args) throws IOException, JDOMException {
		// 创建路径
		String path = "./users.xml";

		/*
		 * // 创建文件对象 File file = new File(path);
		 * 
		 * if (!file.exists()) { System.err.println("文件不存在！");
		 * 
		 * // 调用创建XML方法 createXML(path);
		 * 
		 * System.out.println("文件创建成功!"); } else { file.delete();
		 * 
		 * // 调用创建XML方法 createXML(path);
		 * 
		 * System.out.println("文件创建成功!"); }
		 */

		// 解析XML
		parseXML(path);

		// 修改XML
		update(path);
	}

	/**
	 * 创建XML
	 * 
	 * @param path
	 * @throws IOException
	 */
	static void createXML(String path) throws IOException {

		// 根节点
		Element root = new Element("users");

		// 子节点
		Element user1 = new Element("user");
		Element user2 = new Element("user");

		// children's son
		Element name1 = new Element("name");

		Element age1 = new Element("age");

		Element gender1 = new Element("gender");

		Element name2 = new Element("name");

		Element age2 = new Element("age");

		Element gender2 = new Element("gender");

		// 设置属性
		Attribute att1 = new Attribute("id", "1");
		user1.setAttribute(att1);

		// 添加文本内容
		name1.addContent("小刚");
		age1.setText("19");
		gender1.setText("male");

		// 添加文本内容
		name2.addContent("小明");
		age2.setText("18");
		gender2.setText("female");

		// 创建关联关系

		user1.addContent(name1);
		user1.addContent(age1);
		user1.addContent(gender1);

		// 创建子元素 addContent
		user2.addContent(name2);
		user2.addContent(age2);
		user2.addContent(gender2);

		root.addContent(user1);
		root.addContent(user2);

		// 根据根节点创建文档对象
		Document document = new Document(root);

		// 格式化
		Format format = Format.getPrettyFormat();
		// 设置编码格式
		format.setEncoding("utf-8");

		// 写出使用XMLOutputter 将内存中的文件，写出到磁盘中
		XMLOutputter outputter = new XMLOutputter(format);

		// 文件写出
		FileOutputStream fos = new FileOutputStream(new File(path));

		// 执行写出操作
		outputter.output(document, fos);

	}

	/**
	 * 获取根节点
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 * @throws JDOMException
	 */
	static Element getRootElement(String path) throws JDOMException, IOException {
		// 获取硬盘的XML文档
		InputStream is = new FileInputStream(path);

		// 获取XML文件解析器
		SAXBuilder sax = new SAXBuilder();

		// 解析器将输入流转换为文档对象
		Document document = sax.build(is);

		// 获取文档对象的根节点
		Element root = document.getRootElement();

		return root;

	}

	/**
	 * 解析XML
	 * 
	 * @param path
	 * @throws IOException
	 * @throws JDOMException
	 */
	static void parseXML(String path) throws JDOMException, IOException {

		// 得到根节点
		Element root = getRootElement(path);

		// 根据根节点得到子节点
		Element user1 = root.getChild("user");

		Element name = user1.getChild("name");

		Element age = user1.getChild("age");

		Element gender = user1.getChild("gender");

		// 根据子节点得到子节点的元素值
		System.out.println("name=" + name.getText());
		System.out.println("age=" + age.getText());
		System.out.println("gender=" + gender.getText());

		// 得到属性
		System.out.println("id=" + user1.getAttribute("id").getValue());
		System.out.println("id=" + user1.getAttributeValue("id"));
		System.out.println("name=" + user1.getChildText("name"));

		// 打印所有的子节点
		List<Element> elements = root.getChildren();

		// 遍历输出
		for (Element element : elements) {
			System.out.println("--------------------");
			System.out.println(element);
		}
	}

	/**
	 * 修改
	 * 
	 * @param path
	 * @throws IOException
	 * @throws JDOMException
	 */
	static void update(String path) throws JDOMException, IOException {

		// 获取硬盘的XML文档
		InputStream is = new FileInputStream(path);

		// 获取XML文件解析器
		SAXBuilder sax = new SAXBuilder();

		// 解析器将输入流转换为文档对象
		Document document = sax.build(is);

		// 获取文档对象的根节点
		Element root = document.getRootElement();

		// 获得user对象
		Element user = root.getChild("user");

		// 修改内容
		Element age = user.getChild("age");
		age.setText("100");

		// 添加一个子节点
		Element nickName = new Element("nickName").setText("Mars");
		user.addContent(nickName);

		// 删除子节点
		user.removeChild("name");

		// 修改属性
		user.setAttribute("id", "3");

		// 添加属性
		user.setAttribute("clazz", "12");

		// 删除属性
		user.removeAttribute("id");

		// 格式化
		Format format = Format.getPrettyFormat();
		// 设置编码格式
		format.setEncoding("utf-8");

		// 写出使用XMLOutputter 将内存中的文件，写出到磁盘中
		XMLOutputter outputter = new XMLOutputter(format);

		// 文件写出
		FileOutputStream fos = new FileOutputStream(new File(path));

		// 执行写出操作
		outputter.output(document, fos);
	}

}
