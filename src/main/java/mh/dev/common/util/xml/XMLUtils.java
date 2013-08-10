package mh.dev.common.util.xml;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;

import mh.dev.common.util.xml.exception.MarshalFailedException;
import mh.dev.common.util.xml.exception.UnmarshalFailedException;

import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;

/**
 * Allows the transformation from an object to various targets and from various sources to an object
 * 
 */
public class XMLUtils {

	private static HashMap<Class<?>, Unmarshaller> unmarshallers = new HashMap<>();
	private static HashMap<Class<?>, Marshaller> marshallers = new HashMap<>();

	/**
	 * Unmarshalls the content of the {@link File} to an object of the type clazz
	 * 
	 * @param file
	 *            source
	 * @param clazz
	 *            type of target object
	 * @return
	 * @throws UnmarshalFailedException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(File file, Class<T> clazz) throws UnmarshalFailedException {
		try {
			return (T) getUnmarshaller(clazz).unmarshal(file);
		} catch (JAXBException e) {
			throw new UnmarshalFailedException(e);
		}
	}

	/**
	 * Unmarshalls the content of the {@link InputSource} to an object of the type clazz
	 * 
	 * @param inputSource
	 *            source
	 * @param clazz
	 *            type of target object
	 * @return
	 * @throws UnmarshalFailedException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(InputSource inputSource, Class<T> clazz) throws UnmarshalFailedException {
		try {
			return (T) getUnmarshaller(clazz).unmarshal(inputSource);
		} catch (JAXBException e) {
			throw new UnmarshalFailedException(e);
		}
	}

	/**
	 * Unmarshalls the content of the {@link InputStream} to an object of the type clazz
	 * 
	 * @param inputStream
	 *            source
	 * @param clazz
	 *            type of target object
	 * @return
	 * @throws UnmarshalFailedException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(InputStream inputStream, Class<T> clazz) throws UnmarshalFailedException {
		try {
			return (T) getUnmarshaller(clazz).unmarshal(inputStream);
		} catch (JAXBException e) {
			throw new UnmarshalFailedException(e);
		}
	}

	/**
	 * Unmarshalls the content of the {@link Node} to an object of the type clazz
	 * 
	 * @param node
	 *            source
	 * @param clazz
	 *            type of target object
	 * @return
	 * @throws UnmarshalFailedException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(Node node, Class<T> clazz) throws UnmarshalFailedException {
		try {
			return (T) getUnmarshaller(clazz).unmarshal(node);
		} catch (JAXBException e) {
			throw new UnmarshalFailedException(e);
		}
	}

	/**
	 * Unmarshalls the content of the {@link Source} to an object of the type clazz
	 * 
	 * @param source
	 *            source
	 * @param clazz
	 *            type of target object
	 * @return
	 * @throws UnmarshalFailedException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(Source source, Class<T> clazz) throws UnmarshalFailedException {
		try {
			return (T) getUnmarshaller(clazz).unmarshal(source);
		} catch (JAXBException e) {
			throw new UnmarshalFailedException(e);
		}
	}

	/**
	 * Unmarshalls the content of the {@link URL} to an object of the type clazz
	 * 
	 * @param url
	 *            source
	 * @param clazz
	 *            type of target object
	 * @return
	 * @throws UnmarshalFailedException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(URL url, Class<T> clazz) throws UnmarshalFailedException {
		try {
			return (T) getUnmarshaller(clazz).unmarshal(url);
		} catch (JAXBException e) {
			throw new UnmarshalFailedException(e);
		}
	}

	/**
	 * Marhalls the object T and returns the generated xml as a string
	 * 
	 * @param t
	 *            object which should be converted
	 * @param clazz
	 *            type of the clazz to convert
	 * @return the object as a xml string
	 * @throws MarshalFailedException
	 */
	public static <T> String marshal(T t, Class<T> clazz) throws MarshalFailedException {
		StringWriter stringWriter = new StringWriter();
		marshal(t, clazz, stringWriter);
		return stringWriter.toString();
	}

	/**
	 * Marhalls the object T and writes the generated xml into the {@link ContentHandler}
	 * 
	 * @param t
	 *            object which should be converted
	 * @param clazz
	 *            type of the clazz to convert
	 * @param contentHandler
	 *            target
	 * @throws MarshalFailedException
	 */
	public static <T> void marshal(T t, Class<T> clazz, ContentHandler contentHandler) throws MarshalFailedException {
		try {
			getMarshaller(clazz).marshal(t, contentHandler);
		} catch (JAXBException e) {
			throw new MarshalFailedException(e);
		}
	}

	/**
	 * Marhalls the object T and writes the generated xml into the {@link File}
	 * 
	 * @param t
	 *            object which should be converted
	 * @param clazz
	 *            type of the clazz to convert
	 * @param file
	 *            target
	 * @throws MarshalFailedException
	 */
	public static <T> void marshal(T t, Class<T> clazz, File file) throws MarshalFailedException {
		try {
			getMarshaller(clazz).marshal(t, file);
		} catch (JAXBException e) {
			throw new MarshalFailedException(e);
		}
	}

	/**
	 * Marhalls the object T and writes the generated xml into the {@link Node}
	 * 
	 * @param t
	 *            object which should be converted
	 * @param clazz
	 *            type of the clazz to convert
	 * @param node
	 *            target
	 * @throws MarshalFailedException
	 */
	public static <T> void marshal(T t, Class<T> clazz, Node node) throws MarshalFailedException {
		try {
			getMarshaller(clazz).marshal(t, node);
		} catch (JAXBException e) {
			throw new MarshalFailedException(e);
		}
	}

	/**
	 * Marhalls the object T and writes the generated xml into the {@link OutputStream}
	 * 
	 * @param t
	 *            object which should be converted
	 * @param clazz
	 *            type of the clazz to convert
	 * @param outputStream
	 *            target
	 * @throws MarshalFailedException
	 */
	public static <T> void marshal(T t, Class<T> clazz, OutputStream outputStream) throws MarshalFailedException {
		try {
			getMarshaller(clazz).marshal(t, outputStream);
		} catch (JAXBException e) {
			throw new MarshalFailedException(e);
		}
	}

	/**
	 * Marhalls the object T and writes the generated xml into the {@link Result}
	 * 
	 * @param t
	 *            object which should be converted
	 * @param clazz
	 *            type of the clazz to convert
	 * @param result
	 *            target
	 * @throws MarshalFailedException
	 */
	public static <T> void marshal(T t, Class<T> clazz, Result result) throws MarshalFailedException {
		try {
			getMarshaller(clazz).marshal(t, result);
		} catch (JAXBException e) {
			throw new MarshalFailedException(e);
		}
	}

	/**
	 * Marhalls the object T and writes the generated xml into the {@link Writer}
	 * 
	 * @param t
	 *            object which should be converted
	 * @param clazz
	 *            type of the clazz to convert
	 * @param writer
	 *            target
	 * @throws MarshalFailedException
	 */
	public static <T> void marshal(T t, Class<T> clazz, Writer writer) throws MarshalFailedException {
		try {
			getMarshaller(clazz).marshal(t, writer);
		} catch (JAXBException e) {
			throw new MarshalFailedException(e);
		}
	}

	/**
	 * Marhalls the object T and writes the generated xml into the {@link XMLEventWriter}
	 * 
	 * @param t
	 *            object which should be converted
	 * @param clazz
	 *            type of the clazz to convert
	 * @param xmlEventWriter
	 *            target
	 * @throws MarshalFailedException
	 */
	public static <T> void marshal(T t, Class<T> clazz, XMLEventWriter xmlEventWriter) throws MarshalFailedException {
		try {
			getMarshaller(clazz).marshal(t, xmlEventWriter);
		} catch (JAXBException e) {
			throw new MarshalFailedException(e);
		}
	}

	/**
	 * Marhalls the object T and writes the generated xml into the {@link XMLStreamWriter}
	 * 
	 * @param t
	 *            object which should be converted
	 * @param clazz
	 *            type of the clazz to convert
	 * @param xmlStreamWriter
	 *            target
	 * @throws MarshalFailedException
	 */
	public static <T> void marshal(T t, Class<T> clazz, XMLStreamWriter xmlStreamWriter) throws MarshalFailedException {
		try {
			getMarshaller(clazz).marshal(t, xmlStreamWriter);
		} catch (JAXBException e) {
			throw new MarshalFailedException(e);
		}
	}

	private static <T> Unmarshaller getUnmarshaller(Class<T> clazz) throws JAXBException {
		Unmarshaller unmarshaller = unmarshallers.get(clazz);
		if (unmarshaller == null)
			unmarshaller = createUnmarshaller(clazz);
		return unmarshaller;
	}

	private static <T> Marshaller getMarshaller(Class<T> clazz) throws JAXBException {
		Marshaller marshaller = marshallers.get(clazz);
		if (marshaller == null)
			marshaller = createMarshaller(clazz);
		return marshaller;
	}

	private static <T> Unmarshaller createUnmarshaller(Class<T> clazz) throws JAXBException {
		Unmarshaller unmarshaller = createJAXBContext(clazz).createUnmarshaller();
		unmarshallers.put(clazz, unmarshaller);
		return unmarshaller;
	}

	private static <T> Marshaller createMarshaller(Class<T> clazz) throws JAXBException {
		Marshaller marshaller = createJAXBContext(clazz).createMarshaller();
		marshallers.put(clazz, marshaller);
		return marshaller;
	}

	private static <T> JAXBContext createJAXBContext(Class<T> clazz) throws JAXBException {
		return JAXBContext.newInstance(clazz);
	}
}
