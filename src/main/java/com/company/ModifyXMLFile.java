package com.company;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Oleksandr on 2/9/2016.
 */
public class ModifyXMLFile {

    public static void main(String argv[]) {

        String args[] = argv;
        try {
            String filepath = "d:\\file.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
     /*       docFactory.setValidating(false);
            docFactory.setNamespaceAware(true);
            docFactory.setCoalescing(true);
            docFactory.setIgnoringElementContentWhitespace(true);*/
//            docFactory.
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);
//            DOMConfiguration dcong = doc.getDomConfig();
/*            doc.normalizeDocument();
            doc.normalize();*/
//            removeJunkElements(doc);
//            dcong.setParameter("canonical-form", true);
//            dcong.setParameter("element-content-whitespace", true);
//            dcong.setParameter("validate", true);

//            dcong.setParameter("element-content-whitespace", false);


            Node buildersNode = doc.getElementsByTagName("builders").item(0);


            List<Node> nodesToRemoveList = new LinkedList<>();

            NodeList builderList = buildersNode.getChildNodes();
            System.out.println(builderList.getLength());
            System.out.println(builderList.item(1));
          //  rem(builderList);
            System.out.println(builderList.getLength());
            System.out.println(doc.getElementsByTagName("builders").item(0).getChildNodes().getLength());
/*

            for (int i = 0; i < builderList.getLength(); i++) {
                if (builderList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    nodesToRemoveList.add(buildersNode.getChildNodes().item(i));
                }
            }


            for (Node nodeToRemove : nodesToRemoveList) {
                nodeToRemove.getParentNode().removeChild(nodeToRemove);
            }

            Node node = buildersNode.getChildNodes().item(0);

            builderList = buildersNode.getChildNodes();


            for (int i = 0; i < builderList.getLength(); i++) {
                Node thisNode = builderList.item(i);
                System.out.println(thisNode.getNodeName()+"  ----  "+i);

            }*/





/*


            if (node.getNodeType() == Node.ELEMENT_NODE) {

                System.out.println("yeah");

            }
*/


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

            System.out.println("Done");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }


    private static void rem(NodeList builderList) {
        List<Node> nodesToRemoveList = new LinkedList<>();
        for (int i = 0; i < builderList.getLength(); i++) {
            if (builderList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                nodesToRemoveList.add(builderList.item(i));
            }
        }

        for (Node nodeToRemove : nodesToRemoveList) {
            nodeToRemove.getParentNode().removeChild(nodeToRemove);
        }


        for (int i = 0; i < builderList.getLength(); i++) {
            Node thisNode = builderList.item(i);
            System.out.println(thisNode.getNodeName() + "  ----  " + i);

        }


    }


    private void scr() {


//            DOMConfiguration dcong = doc.getDomConfig();
//            dcong.setParameter("canonical-form", true);


        // Get the root element
        //  Node company = doc.getFirstChild();

        // Get the staff element , it may not working if tag has spaces, or
        // whatever weird characters in front...it's better to use
        // getElementsByTagName() to get it directly.
        // Node staff = company.getFirstChild();

        // Get the staff element by tag name directly
//            NodeList buildSteps = doc.getElementsByTagName("buildStep");
//            Node bNode = buildSteps.item(0);

//        NodeList nodes = doc.getElementsByTagName("builders");
//
//        Node node = nodes.item(0).getFirstChild();


        /*    Text textNode = doc.createTextNode("PRE");
            Element buildStepNode = doc.createElement("buildStep");
            buildStepNode.setAttribute("id","pre");
            Element commandNode = doc.createElement("command");
            commandNode.appendChild(textNode);
*/

/*
            buildStepNode.appendChild(commandNode);
            nodes.item(0).insertBefore(buildStepNode, nodes.item(0).getFirstChild());*/
//            nodes.item(0).insertBefore(buildStepNode, nodes.item(0));
//            nodes.item(0).getParentNode().insertBefore(buildStepNode, nodes.item(0));
//            nodes.item(nodes.getLength()-1).getParentNode().insertBefore(buildStepNode, nodes.item(nodes.getLength()-1).getNextSibling());

        //  nodes = doc.getElementsByTagName("builders");
      /*      textNode = doc.createTextNode("POST");
            buildStepNode = doc.createElement("buildStep");
            buildStepNode.setAttribute("id","POST");
            commandNode = doc.createElement("command");
            commandNode.appendChild(textNode);



            buildStepNode.appendChild(commandNode);
            nodes.item(0).insertBefore(buildStepNode, nodes.item(0).getFirstChild());



*/

/*



            nodes.item(0).insertBefore(buildStepNode, nodes.item(0).getLastChild());

            for (int buildstepIndex = 0; buildstepIndex<buildSteps.getLength();buildstepIndex++){
                Node buildStepNode = buildSteps.item(buildstepIndex);
                for (int j = 0;j<buildStepNode.getChildNodes().getLength();j++){
                 if(buildStepNode.getChildNodes().item(j).getNodeName().equals("command")){
                     Node scriptNode = buildStepNode.getChildNodes().item(j);
                     scriptNode.getAttributes()
                 }
                }


                String elat =  el.getAttribute("asdgf");
                el.setAttribute("id",String.valueOf(i));


            }

            Element el = (Element)staff.item(0);
            el.setAttribute("id","222222222");
            // update staff attribute
//            NamedNodeMap attr = staff.getAttributes();
//            Node nodeAttr = attr.getNamedItem("id");
//            nodeAttr.setTextContent("2");

            // append a new node to staff
            Element age = doc.createElement("age");
            age.appendChild(doc.createTextNode("28"));
            staff.appendChild(age);

            // loop the staff child node
            NodeList list = staff.getChildNodes();

            for (int i = 0; i < list.getLength(); i++) {

                Node node = list.item(i);

                // get the salary element, and update the value
                if ("salary".equals(node.getNodeName())) {
                    node.setTextContent("2000000");
                }

                //remove firstname
                if ("firstname".equals(node.getNodeName())) {
                    staff.removeChild(node);
                }

            }*/

    }


    private static void removeJunkElements(Document doc) {
        //removing empty text nodes like whitespaces, new line symbols etc
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPathExpression xpathExp = null;
        try {
            xpathExp = xpathFactory.newXPath().compile("//text()[normalize-space(.) = '']");
            NodeList emptyTextNodes = (NodeList) xpathExp.evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < emptyTextNodes.getLength(); i++) {
                Node emptyTextNode = emptyTextNodes.item(i);
                emptyTextNode.getParentNode().removeChild(emptyTextNode);
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }


    }

}