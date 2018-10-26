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
	 * �õ�һ��dom��
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	static Document getDocument(String file) throws Exception {

		// ��xml--ת��document�ĵ���

		// 1.������������������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// 2.��������������
		DocumentBuilder builder = factory.newDocumentBuilder();

		// �����õ�dom��
		Document document = builder.parse(file);
		return document;
	}

	static void parse(Document document) {

		// �������ƻ��dom������ͬԪ�صļ���
		NodeList rootList = document.getElementsByTagName("book");
		for (int i = 0; i < rootList.getLength(); i++) {
			Node node = rootList.item(i);// �õ���book
			NodeList nl = node.getChildNodes();// book�е�����Ԫ��
			for (int j = 0; j < nl.getLength(); j++) {
				Node n = nl.item(j);
				String nodeName = n.getNodeName();// �ڵ������
				String content = n.getTextContent();// �ڵ������
				if ("title".equals(nodeName)) {
					// Ŀ�����ų�#text
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
		// �ҵ����ڵ�
		Node root = document.getElementsByTagName("books").item(0);
		// ��1����dom�������book
		Element book = document.createElement("book");
		// ��2����book�ӵ�root��
		root.appendChild(book);

		Element title = document.createElement("title");
		title.setTextContent("���Ϲ㲻��������");
		book.appendChild(title);// ��title�ŵ�book�ڵ���

		Element author = document.createElement("author");
		author.setTextContent("��֪��");
		book.appendChild(author);

		Element price = document.createElement("price");
		price.setTextContent(String.valueOf(90.8));
		book.appendChild(price);
		// ������һ������ķ���
		save(document);

	}

	public static void save(Document document) throws TransformerException {
		// ��dom�������xml �ļ�
		// ��1������ת������������
		TransformerFactory factory = TransformerFactory.newInstance();
		// ��2������ת��������
		Transformer former = factory.newTransformer();
		// ����ת���ĸ�ʽ
		former.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		former.setOutputProperty(OutputKeys.INDENT, "yes");
		// ��3��ת���Ķ�����dom,
		DOMSource scoure = new DOMSource(document);
		// ��4��ת��������ȥ���ļ���ת����Ŀ �ص������ļ����϶����漰�����ĸ���
		StreamResult result = new StreamResult("books.xml");
		// ��5����ʼת
		former.transform(scoure, result);
		System.out.println("ת���ɹ�");
	}

	public static void update(Document document) throws TransformerException {
		// �������ƻ��dom������ͬԪ�صļ���
		NodeList rootList = document.getElementsByTagName("book");
		for (int i = 0; i < rootList.getLength(); i++) {
			Node node = rootList.item(i); // �õ���book
			NodeList nl = node.getChildNodes();// book�е�����
			for (int j = 0; j < nl.getLength(); j++) {
				Node n = nl.item(j);
				String nodeName = n.getNodeName(); // �ڵ������
				String content = n.getTextContent();// ��ռ������
				if ("title".equals(nodeName) && "С����".equals(content)) { // /Ŀ
																			// �����ų�#text
					n.setTextContent("k��ѽ,!");// ���¸�ֵ
				}
			}
		}
		save(document);
	}

	public static void delete(Document document) throws TransformerException {
		// �������ƻ��dom������ͬԪ�صļ���
		NodeList rootList = document.getElementsByTagName("book");
		for (int i = 0; i < rootList.getLength(); i++) {
			Node node = rootList.item(i); // �õ���book
			NodeList nl = node.getChildNodes();// book�е�����
			for (int j = 0; j < nl.getLength(); j++) {
				Node n = nl.item(j); // ֹǰ n -->title,author,price
				String nodeName = n.getNodeName(); // �ڵ������
				String content = n.getTextContent();// ��ռ������
				if ("title".equals(nodeName) && "k��ѽ,!".equals(content)) { // /Ŀ
					// node��book ,node.getparentNode��books
					node.getParentNode().removeChild(node); // �����ų�#text
				}
			}
		}
		// ����
		save(document);
	}
}