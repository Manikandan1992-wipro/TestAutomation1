package POM.functions;


import static FrameWork.helpers.Helper.*;
import static FrameWork.helpers.ReportHelper.logReportStatus;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

import javax.accessibility.AccessibleRelation;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import FrameWork.helpers.Helper;
import FrameWork.helpers.ReportHelper;
import FrameWork.listeners.PreReq;
import com.relevantcodes.extentreports.LogStatus;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class webserviceHandler {
	public static int randum_key=0;

	public static HashMap<String, String> inputxmlDataMapper(String inputXmlName) {
		HashMap<String, String> hm = new HashMap<String, String>();
		String[] arr = inputXmlName.split(";");


		for (int i = 0; i < arr.length; i++) {
			String key = arr[i].split("=")[0];
			String value = arr[i].split("=")[1];
			hm.put(key, value);

		}
		Set set = hm.entrySet();

		// Get an iterator
		Iterator i = set.iterator();

		// Display elements
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}

		return hm;
	}


	public static void formXMLwithdata(String inputXmlName,String xml_inputdata ) throws ParserConfigurationException, IOException, SAXException, TransformerException {

		String path = System.getProperty("user.dir");
		Random rand = new Random();
		int randum=rand.nextInt(500);
		randum_key=randum;
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		String Templatefile = path + "\\src\\main\\resources\\soapInput\\" + inputXmlName + ".xml";//input file path+file
		File Responsefile = new File(PreReq.XMLRequest + "\\" + inputXmlName+randum + ".xml");

		File file = new File(Templatefile);
		Document doc = dBuilder.parse(file);
		HashMap<String, String> TestData = new HashMap<String, String>();
		TestData = inputxmlDataMapper(xml_inputdata);
		Set set = TestData.entrySet();

		// Get an iterator
		Iterator i = set.iterator();

		// Display elements
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			System.out.print(me.getKey() + ": ");
			String key = me.getKey().toString();
			String value = me.getValue().toString();
			System.out.println(me.getValue());
			doc = SetElementvalue(doc, key, value);
		}
		Source source = new DOMSource(doc);
		//File fil1e = new File(XMLRequest_Path);
		Result result = new StreamResult(Responsefile);
		Transformer xformer = TransformerFactory.newInstance().newTransformer();
		xformer.transform(source, result);

		ReportHelper.forceScreenShotPass = false;
		logReportStatus(LogStatus.PASS, "Request XML is created successfully with input Test data");
		logReportStatus(LogStatus.INFO, "Request XML Data:" + " <a href='.\\XML\\Request_XML\\" + inputXmlName+randum + ".xml'  target=\"_blank\">" + inputXmlName + ".xml</a>");

/*
		File Responsefile = new File(PreReq.XMLResponse + "\\" + response_name + ".xml");


		Responsefile.createNewFile();
		FileOutputStream fileOutputStream = new FileOutputStream(doc);
		soapResponse.writeTo(fileOutputStream);
		fileOutputStream.flush();*/

	}


	public static String getSoapConnectionResponse(String inputXmlName, String soapAction, String endpointUrl) throws ParserConfigurationException, IOException, SAXException, TransformerException, SOAPException {
		String path = System.getProperty("user.dir");
		SOAPMessage message;

		String response_name = soapAction + "_response";
		File report_file1 = new File( PreReq.XMLRequest + "\\" + inputXmlName+randum_key + ".xml");
		if(report_file1.exists())
		{
			 message = readSoapMessage(PreReq.XMLRequest + "\\" + inputXmlName+randum_key + ".xml", soapAction);
			message.writeTo(System.out);

		}else{



		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		String Templatefile = path + "\\src\\main\\resources\\soapInput\\" + inputXmlName + ".xml";//input file path+file
		String XMLRequest_Path = path + "\\src\\main\\resources\\soapInput\\" + inputXmlName+randum_key + ".xml";
		File file = new File(Templatefile);
		Document doc = dBuilder.parse(file);

		Transformer xformer = TransformerFactory.newInstance().newTransformer();
		xformer.transform(new DOMSource(doc), new StreamResult(new File(XMLRequest_Path)));
		/*SOAPMessage message= readSoapMessage(XMLRequest_Path,getdata("SoapAction")*//**name in soup request**//* .toString());*/
		 message = readSoapMessage(XMLRequest_Path, soapAction);
		message.writeTo(System.out);

		FileOutputStream fop = null;
		File file1;
		try {
			file1 = new File(PreReq.XMLRequest + "\\" + inputXmlName+randum_key + ".xml");
			fop = new FileOutputStream(file1);
			if (!file1.exists()) {
				file1.createNewFile();
			}
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			String xmlString = null;
			message.writeTo(bout);
			System.out.println(bout);
			xmlString = bout.toString("UTF-8");
			byte[] contentInBytes = xmlString.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			PreReq.RequestXMLPath = PreReq.XMLRequest + "\\" + inputXmlName+randum_key + ".xml";
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (message == null)
			logReportStatus(LogStatus.FAIL, "XML is not formed with Input Test data");
		else {
			ReportHelper.forceScreenShotPass = false;
			logReportStatus(LogStatus.PASS, "Request XML is created successfully with input Test data");
			logReportStatus(LogStatus.INFO, "Request XML Data:" + " <a href='.\\XML\\Request_XML\\" + inputXmlName+randum_key + ".xml'  target=\"_blank\">" + inputXmlName + ".xml</a>");
		}
		}

//Establish SOAP Connection and send request to End Point URL
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory.createConnection();


		SOAPMessage soapResponse = soapConnection.call(message, endpointUrl);
		Random rand = new Random();
		int randum=rand.nextInt(500);
		String XMLResponse_Path = "";

		File Responsefile = new File(PreReq.XMLResponse + "\\" + response_name+randum+ ".xml");
		XMLResponse_Path = PreReq.XMLResponse + "\\" + response_name+randum + ".xml";

		Responsefile.createNewFile();
		FileOutputStream fileOutputStream = new FileOutputStream(Responsefile);
		soapResponse.writeTo(fileOutputStream);
		fileOutputStream.flush();
		fileOutputStream.close();
		ReportHelper.forceScreenShotPass = false;
		logReportStatus(LogStatus.PASS, inputXmlName+" Response XML is received");
		logReportStatus(LogStatus.INFO, "Response XML Data:<a href='.\\XML\\Response_XML\\" + response_name+randum + ".xml'  target='_blank'>" + response_name + "</a>");

return XMLResponse_Path;

	}
public static void getDatafromResponse(String Action_name,String XMLResponse_Path,String xml_outdata,String outdatacolname) throws ParserConfigurationException, IOException, SAXException {

	DocumentBuilderFactory dbFactory1 = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
	Document doc1 = dBuilder1.parse(new File(XMLResponse_Path));
	doc1.getDocumentElement().normalize();

	//xml_outdata = getData("Xout_nodedata");
	//check for status check
	String val1 = getElementvalue(doc1, "b:IsSucess");
	if(val1.equalsIgnoreCase("true")) {
		ReportHelper.forceScreenShotPass = false;
		logReportStatus(LogStatus.PASS, Action_name+" XML response status is validated Successfully");
		if (xml_outdata == "") {
		} else {

			String[] arr = xml_outdata.split(";");
			String out = "";
			for (String key : arr) {
				String val = getElementvalue(doc1, key);
				out = out + key + "=" + val + ";";
			}
			System.out.println("XML value:::--->" + out);

			try {
				Helper.saveTestData(outdatacolname, out);
				ReportHelper.forceScreenShotPass = false;
				logReportStatus(LogStatus.PASS, "Response XML data elements are captured");

			} catch (Exception e) {
				ReportHelper.forceScreenShotPass = false;
				logReportStatus(LogStatus.FAIL, "XML output is failed");
			}

		}
	}else
	{		ReportHelper.forceScreenShotPass = false;
		logReportStatus(LogStatus.FAIL, Action_name+ " xml response Status is received as failure");
	}



}
/*

	public static void getsoapResponse() {
		try {

			String path = System.getProperty("user.dir");

			String inputXmlName = getData("Input_xml");
			String soapAction = getData("SOAP_ACTION");
			String endpointUrl = getData("SOAP_URL");
			String response_name = soapAction + "_response";
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			String Templatefile = path + "\\src\\main\\resources\\soapInput\\" + inputXmlName + ".xml";//input file path+file
			String XMLRequest_Path = path + "\\src\\main\\resources\\soapInput\\" + inputXmlName + ".xml";
			File file = new File(Templatefile);
			Document doc = dBuilder.parse(file);
			//doc.getDocumentElement().normalize();

			String xml_inputdata = null;
			*/
/*xml_inputdata = getData("XIN_nodedata");
			if (xml_inputdata=="") {
			}else
			{
				HashMap<String, String> TestData = new HashMap<String, String>();
				TestData = inputxmlDataMapper(xml_inputdata);
				Set set = TestData.entrySet();

				// Get an iterator
				Iterator i = set.iterator();

				// Display elements
				while (i.hasNext()) {
					Map.Entry me = (Map.Entry) i.next();
					System.out.print(me.getKey() + ": ");
					String key = me.getKey().toString();
					String value = me.getValue().toString();
					System.out.println(me.getValue());
					doc = SetElementvalue(doc, key, value);
				}
			}*//*


			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.transform(new DOMSource(doc), new StreamResult(new File(XMLRequest_Path)));
*/
/*SOAPMessage message= readSoapMessage(XMLRequest_Path,getdata("SoapAction")*//*
*/
/**name in soup request**//*
*/
/* .toString());*//*

			SOAPMessage message = readSoapMessage(XMLRequest_Path, soapAction);
			message.writeTo(System.out);

			FileOutputStream fop = null;
			File file1;
			try {
				file1 = new File(PreReq.XMLRequest + "\\" + inputXmlName + ".xml");
				fop = new FileOutputStream(file1);
				if (!file1.exists()) {
					file1.createNewFile();
				}
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				String xmlString = null;
				message.writeTo(bout);
				System.out.println(bout);
				xmlString = bout.toString("UTF-8");
				byte[] contentInBytes = xmlString.getBytes();
				fop.write(contentInBytes);
				fop.flush();
				fop.close();
				PreReq.RequestXMLPath = PreReq.XMLRequest + "\\" + inputXmlName + ".xml";
			} catch (IOException e) {
				e.printStackTrace();
			}


			if (message == null)
				logReportStatus(LogStatus.FAIL, "XML is not formed with Input Test data");
			else {
				ReportHelper.forceScreenShotPass = false;
				logReportStatus(LogStatus.PASS, "Request XML is created successfully with input Test data");
				logReportStatus(LogStatus.INFO, "Request XML Data:" + " <a href='.\\XML\\Request_XML\\" + inputXmlName + ".xml'  target=\"_blank\">" + inputXmlName + ".xml</a>");

				//logReportStatus(LogStatus.INFO, "Reformed XML Data:<br><pre><![CDATA["+doctostring(doc)+"]]></pre>");
			}


//Establish SOAP Connection and send request to End Point URL
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			String XMLResponse_Path = "";

			SOAPMessage soapResponse = soapConnection.call(message, endpointUrl);


			File Responsefile = new File(PreReq.XMLResponse + "\\" + response_name + ".xml");
			XMLResponse_Path = PreReq.XMLResponse + "\\" + response_name + ".xml";

			Responsefile.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(Responsefile);
			soapResponse.writeTo(fileOutputStream);
			fileOutputStream.flush();
			fileOutputStream.close();

			System.out.println("Response is captured and resonse file created!!");
			DocumentBuilderFactory dbFactory1 = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
			Document doc1 = dBuilder1.parse(new File(XMLResponse_Path));
			doc1.getDocumentElement().normalize();


			String xml_outdata = null;
			xml_outdata = getData("Xout_nodedata");
			if (xml_outdata == "") {
			} else {

				String[] arr = xml_outdata.split(";");
				String out = "";
				for (String key : arr) {
					String val = getElementvalue(doc1, key);
					out = out + key + "=" + val + ";";
				}
				System.out.println("XML value:::--->" + out);

				try {
					Helper.saveTestData("Xout_nodedata", out);
					ReportHelper.forceScreenShotPass = false;
					logReportStatus(LogStatus.PASS, "Response XML is received and the node elements are captured");
					logReportStatus(LogStatus.INFO, "Response XML Data:<a href='.\\XML\\Response_XML\\" + response_name + ".xml'  target='_blank'>" + response_name + "</a>");
				} catch (Exception e) {
					logReportStatus(LogStatus.FAIL, "XML output is failed");
				}

			}
			ReportHelper.forceScreenShotPass = false;
			logReportStatus(LogStatus.PASS, "Response XML is received and the node elements are captured");
			logReportStatus(LogStatus.INFO, "Response XML Data:<a href='.\\XML\\Response_XML\\" + response_name + ".xml'  target='_blank'>" + response_name + "</a>");

		} catch (Exception e) {
			logReportStatus(LogStatus.FAIL, "XML output is failed");
			e.printStackTrace();
		}
	}
*/

	/*------------------------------------------------------------------------------------------------------
	* Function Name: readSoapMessage
	* Use : Read the soap MSG
	* Designed By: AG
	* Last Modified Date : 15-June-2016
	--------------------------------------------------------------------------------------------------------*/
	public static SOAPMessage readSoapMessage(String filename, String SOAPAction) throws SOAPException, FileNotFoundException {
		SOAPMessage message = MessageFactory.newInstance().createMessage();
		SOAPPart soapPart = message.getSOAPPart();
		soapPart.setContent(new StreamSource(new FileInputStream(filename)));
		MimeHeaders headers = message.getMimeHeaders();
		headers.addHeader("SOAPAction", SOAPAction);
		message.saveChanges();
		return message;
	}

	/*------------------------------------------------------------------------------------------------------
	* Function Name: getvalue
	* Use : fetch tag value from the soap MSG
	* Designed By: AG
	* Last Modified Date : 15-June-2016
	--------------------------------------------------------------------------------------------------------*/
	public static String getElementvalue(Document doc, String TagName) {
		String ReturnValue = "";
		try {
			NodeList nList = doc.getElementsByTagName(TagName);
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					ReturnValue = ReturnValue + eElement.getTextContent();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ReturnValue;
	}
/*---------------------------------------------------------------------------------------------------------

    * Method Name                                             : Setvalue

    * Arguments                                     : Update the tag value with the value in the testdata sheet

    * Use                                                                   : waits till the object exists

    * Designed By                                  : AG

    * Last Modified Date     : 25-Apr-2016

    --------------------------------------------------------------------------------------------------------*/

	public static Document SetElementvalue(Document doc, String key, String val)

	{

		NodeList nList = doc.getElementsByTagName(key);

		for (int temp = 0; temp < nList.getLength(); temp++)

		{

			Node nNode = nList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE)

			{

				nNode.setTextContent(val);

			}

		}

		return doc;

	}

}

