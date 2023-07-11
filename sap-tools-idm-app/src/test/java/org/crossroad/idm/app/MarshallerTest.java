/**
 * 
 */
package org.crossroad.idm.app;

import static org.assertj.core.api.Assertions.fail;

import org.crossroad.sap.wsdl.idm.BAPIUSERGETDETAIL;
import org.crossroad.sap.wsdl.idm.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.xml.transform.StringResult;

import lombok.extern.slf4j.Slf4j;

/**
 * @author e.soden
 *
 */
@SpringBootTest
@Slf4j
public class MarshallerTest {
	@Autowired
	@Qualifier(value = "jaxb2.marshaller")
	Jaxb2Marshaller marshaller;

	@Autowired
	@Qualifier(value = "idm.objectfactory")
	ObjectFactory factory;

	@Test
	void checkUserName() {
		try {
			BAPIUSERGETDETAIL data = factory.createBAPIUSERGETDETAIL();
			data.setUSERNAME("SODEE");
			
			StringResult result = new StringResult();
			marshaller.marshal( data, result );
			log.debug("Unmarshaller \n{}\n", result);
			
			
		} catch (Exception e) {
			fail("CheckUsername failed", e);
		}
	}
}
