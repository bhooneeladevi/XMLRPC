/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soulfulwanderer.xmlrpc;

/**
 *
 * @author BHARGAVA
 */

import java.util.Hashtable;
import helma.xmlrpc.*;
import org.apache.xerces.parsers.SAXParser;
public class JavaServer {

    public JavaServer () {
        // Our handler is a regular Java object. It can have a
        // constructor and member variables in the ordinary fashion.
        // Public methods will be exposed to XML-RPC clients.
    }

    public Hashtable sumAndDifference (int x, int y) {
        Hashtable result = new Hashtable();
        result.put("sum", new Integer(x + y));
        result.put("difference", new Integer(x - y));
        return result;
    }

    public static void main (String [] args) {
        try {
            
            // Invoke me as <http://localhost:8080/RPC2>.
            WebServer server = new WebServer(8081);
            server.addHandler("sample", new JavaServer());

        } catch (Exception exception) {
            System.err.println("JavaServer: " + exception.toString());
        }
    }
}