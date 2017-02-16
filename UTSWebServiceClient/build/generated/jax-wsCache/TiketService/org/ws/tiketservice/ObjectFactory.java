
package org.ws.tiketservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.ws.tiketservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetDataAllTiket_QNAME = new QName("http://tiketService.ws.org/", "getDataAllTiket");
    private final static QName _GetDataAllTiketResponse_QNAME = new QName("http://tiketService.ws.org/", "getDataAllTiketResponse");
    private final static QName _GetDataTiket_QNAME = new QName("http://tiketService.ws.org/", "getDataTiket");
    private final static QName _GetDataTiketResponse_QNAME = new QName("http://tiketService.ws.org/", "getDataTiketResponse");
    private final static QName _Hello_QNAME = new QName("http://tiketService.ws.org/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://tiketService.ws.org/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.ws.tiketservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDataAllTiket }
     * 
     */
    public GetDataAllTiket createGetDataAllTiket() {
        return new GetDataAllTiket();
    }

    /**
     * Create an instance of {@link GetDataAllTiketResponse }
     * 
     */
    public GetDataAllTiketResponse createGetDataAllTiketResponse() {
        return new GetDataAllTiketResponse();
    }

    /**
     * Create an instance of {@link GetDataTiket }
     * 
     */
    public GetDataTiket createGetDataTiket() {
        return new GetDataTiket();
    }

    /**
     * Create an instance of {@link GetDataTiketResponse }
     * 
     */
    public GetDataTiketResponse createGetDataTiketResponse() {
        return new GetDataTiketResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Tiket }
     * 
     */
    public Tiket createTiket() {
        return new Tiket();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataAllTiket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tiketService.ws.org/", name = "getDataAllTiket")
    public JAXBElement<GetDataAllTiket> createGetDataAllTiket(GetDataAllTiket value) {
        return new JAXBElement<GetDataAllTiket>(_GetDataAllTiket_QNAME, GetDataAllTiket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataAllTiketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tiketService.ws.org/", name = "getDataAllTiketResponse")
    public JAXBElement<GetDataAllTiketResponse> createGetDataAllTiketResponse(GetDataAllTiketResponse value) {
        return new JAXBElement<GetDataAllTiketResponse>(_GetDataAllTiketResponse_QNAME, GetDataAllTiketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataTiket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tiketService.ws.org/", name = "getDataTiket")
    public JAXBElement<GetDataTiket> createGetDataTiket(GetDataTiket value) {
        return new JAXBElement<GetDataTiket>(_GetDataTiket_QNAME, GetDataTiket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataTiketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tiketService.ws.org/", name = "getDataTiketResponse")
    public JAXBElement<GetDataTiketResponse> createGetDataTiketResponse(GetDataTiketResponse value) {
        return new JAXBElement<GetDataTiketResponse>(_GetDataTiketResponse_QNAME, GetDataTiketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tiketService.ws.org/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tiketService.ws.org/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}
