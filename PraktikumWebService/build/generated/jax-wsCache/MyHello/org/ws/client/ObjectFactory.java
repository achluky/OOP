
package org.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.ws.client package. 
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

    private final static QName _MyDataException_QNAME = new QName("http://myservice.ws.org/", "MyDataException");
    private final static QName _GetDataMahasiswa_QNAME = new QName("http://myservice.ws.org/", "getDataMahasiswa");
    private final static QName _GetDataMahasiswaResponse_QNAME = new QName("http://myservice.ws.org/", "getDataMahasiswaResponse");
    private final static QName _Hello_QNAME = new QName("http://myservice.ws.org/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://myservice.ws.org/", "helloResponse");
    private final static QName _Kali_QNAME = new QName("http://myservice.ws.org/", "kali");
    private final static QName _KaliResponse_QNAME = new QName("http://myservice.ws.org/", "kaliResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MyDataException }
     * 
     */
    public MyDataException createMyDataException() {
        return new MyDataException();
    }

    /**
     * Create an instance of {@link GetDataMahasiswa }
     * 
     */
    public GetDataMahasiswa createGetDataMahasiswa() {
        return new GetDataMahasiswa();
    }

    /**
     * Create an instance of {@link GetDataMahasiswaResponse }
     * 
     */
    public GetDataMahasiswaResponse createGetDataMahasiswaResponse() {
        return new GetDataMahasiswaResponse();
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
     * Create an instance of {@link Kali }
     * 
     */
    public Kali createKali() {
        return new Kali();
    }

    /**
     * Create an instance of {@link KaliResponse }
     * 
     */
    public KaliResponse createKaliResponse() {
        return new KaliResponse();
    }

    /**
     * Create an instance of {@link Mahasiswa }
     * 
     */
    public Mahasiswa createMahasiswa() {
        return new Mahasiswa();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MyDataException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice.ws.org/", name = "MyDataException")
    public JAXBElement<MyDataException> createMyDataException(MyDataException value) {
        return new JAXBElement<MyDataException>(_MyDataException_QNAME, MyDataException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataMahasiswa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice.ws.org/", name = "getDataMahasiswa")
    public JAXBElement<GetDataMahasiswa> createGetDataMahasiswa(GetDataMahasiswa value) {
        return new JAXBElement<GetDataMahasiswa>(_GetDataMahasiswa_QNAME, GetDataMahasiswa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataMahasiswaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice.ws.org/", name = "getDataMahasiswaResponse")
    public JAXBElement<GetDataMahasiswaResponse> createGetDataMahasiswaResponse(GetDataMahasiswaResponse value) {
        return new JAXBElement<GetDataMahasiswaResponse>(_GetDataMahasiswaResponse_QNAME, GetDataMahasiswaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice.ws.org/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice.ws.org/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Kali }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice.ws.org/", name = "kali")
    public JAXBElement<Kali> createKali(Kali value) {
        return new JAXBElement<Kali>(_Kali_QNAME, Kali.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KaliResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice.ws.org/", name = "kaliResponse")
    public JAXBElement<KaliResponse> createKaliResponse(KaliResponse value) {
        return new JAXBElement<KaliResponse>(_KaliResponse_QNAME, KaliResponse.class, null, value);
    }

}
