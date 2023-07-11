/**
 * 
 */
package org.crossroad.idm.app.config;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.Marshaller;

import org.crossroad.sap.wsdl.idm.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import lombok.extern.slf4j.Slf4j;

/**
 * @author e.soden
 *
 */
@Configuration
@Slf4j
public class IDMConfiguration {

	@Bean(name = "xml.objectmapper")
	public ObjectMapper createIDOCMapper() {
		log.debug("Loading xml.objectmapper...");
	

		ObjectMapper mapper = new ObjectMapper();
		// if ONLY using JAXB annotations:
		mapper.registerModule(new JaxbAnnotationModule());
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper;
	}

	@Bean(name = "jaxb2.marshaller")
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("org.crossroad.sap.wsdl.idm");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		map.put(Marshaller.JAXB_ENCODING, "UTF-8");
		map.put(Marshaller.JAXB_FRAGMENT, true);
		marshaller.setMarshallerProperties(map);

		return marshaller;
	}

	@Bean(name = "idm.objectfactory")
	public ObjectFactory factory() {
		return new ObjectFactory();
	}
}
