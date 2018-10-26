package dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test {

	public static void main(String[] args) throws Exception {

		parse(getDocument("books.xml"));
		// add(getDocument("books.xml"));
		// update(getDocument("books.xml"));
		// delete(getDocument("books.xml"));
	}

	/**
	 * 得到一个dom树
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	static Document getDocument(String file) throws Exception {

		// 将xml--转成document文档树

		// 1.创建解析器工厂对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// 2.创建解析器对象
		DocumentBuilder builder = factory.newDocumentBuilder();

		// 解析得到dom树
		Document document = builder.parse(file);
		return document;
	}

	static void parse(Document document) {

		// 根据名称获得dom树中相同元素的集合
		NodeList rootList = document.getElementsByTagName("book");
		for (int i = 0; i < rootList.getLength(); i++) {
			Node node = rootList.item(i);// 得到了book
			NodeList nl = node.getChildNodes();// book中的所有元素
			for (int j = 0; j < nl.getLength(); j++) {
				Node n = nl.item(j);
				String nodeName = n.getNodeName();// 节点的名称
				String content = n.getTextContent();// 节点的内容
				if ("title".equals(nodeName)) {
					// 目的是排除#text
					System.out.println(nodeName + "\t" + content);
				} else if ("author".equals(nodeName)) {
					System.out.println(nodeName + "\t" + content);
				} else if ("price".equals(nodeName)) {
					System.out.println(nodeName + "\t" + content);
				}
			}

		}

	}

	public static void add(Document document) throws TransformerException {
		// 找到根节点
		Node root = document.getElementsByTagName("books").item(0);
		// 【1】在dom点上添加book
		Element book = document.createElement("book");
		// 【2】把book加到root上
		root.appendChild(book);

		Element title = document.createElement("title");
		title.setTextContent("北上广不相信眼泪");
		book.appendChild(title);// 把title放到book节点下

		Element author = document.createElement("author");
		author.setTextContent("不知道");
		book.appendChild(author);

		Element price = document.createElement("price");
		price.setTextContent(String.valueOf(90.8));
		book.appendChild(price);
		// 调用了一个保存的方法
		save(document);

	}

	public static void save(Document document) throws TransformerException {
		// 将dom树保存成xml 文件
		// 【1】创建转换器工厂对象
		TransformerFactory factory = TransformerFactory.newInstance();
		// 【2】创建转换器对象
		Transformer former = factory.newTransformer();
		// 设置转换的格式
		former.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		former.setOutputProperty(OutputKeys.INDENT, "yes");
		// 【3】转换的对象是dom,
		DOMSource scoure = new DOMSource(document);
		// 【4】转换到哪里去，文件，转换的目 地的是是文件，肯定就涉及到流的概念
		StreamResult result = new StreamResult("books.xml");
		// 【5】开始转
		former.transform(scoure, result);
		System.out.println("转换成功");
	}

	public static void update(Document document) throws TransformerException {
		// 根据名称获得dom树中相同元素的集合
		NodeList rootList = document.getElementsByTagName("book");
		for (int i = 0; i < rootList.getLength(); i++) {
			Node node = rootList.item(i); // 得到了book
			NodeList nl = node.getChildNodes();// book中的所有
			for (int j = 0; j < nl.getLength(); j++) {
				Node n = nl.item(j);
				String nodeName = n.getNodeName(); // 节点的名称
				String content = n.getTextContent();// 节占的内容
				if ("title".equals(nodeName) && "小北京".equals(content)) { // /目
																			// 的是排除#text
					n.setTextContent("k哎呀,!");// 重新赋值
				}
			}
		}
		save(document);
	}

	public static void delete(Document document) throws TransformerException {
		// 根据名称获得dom树中相同元素的集合
		NodeList rootList = document.getElementsByTagName("book");
		for (int i = 0; i < rootList.getLength(); i++) {
			Node node = rootList.item(i); // 得到了book
			NodeList nl = node.getChildNodes();// book中的所有
			for (int j = 0; j < nl.getLength(); j++) {
				Node n = nl.item(j); // 止前 n -->title,author,price
				String nodeName = n.getNodeName(); // 节点的名称
				String content = n.getTextContent();// 节占的内容
				if ("title".equals(nodeName) && "k哎呀,!".equals(content)) { // /目
					// node是book ,node.getparentNode是books
					node.getParentNode().removeChild(node); // 的是排除#text
				}
			}
		}
		// 保存
		save(document);
	}
}