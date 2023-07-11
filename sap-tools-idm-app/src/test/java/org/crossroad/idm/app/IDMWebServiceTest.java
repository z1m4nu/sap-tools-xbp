/**
 * 
 */
package org.crossroad.idm.app;

import static org.assertj.core.api.Assertions.fail;

import java.util.Map;

import org.crossroad.sap.wsdl.idm.BAPIUSERGETDETAIL;
import org.crossroad.sap.wsdl.idm.BAPIUSERGETDETAILResponse;
import org.crossroad.sap.wsdl.idm.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;

import lombok.extern.slf4j.Slf4j;

/**
 * @author e.soden
 *
 */
@SpringBootTest
@Slf4j
public class IDMWebServiceTest {
	@Autowired
	@Qualifier(value = "jaxb2.marshaller")
	Jaxb2Marshaller marshaller;

	@Autowired
	@Qualifier(value = "idm.objectfactory")
	ObjectFactory factory;

    @Autowired
    @Qualifier(value = "ws.pool")
    Map<String, WebServiceTemplate> templates;
	@Test
	void checkIDMWS() {
		
		try {
		
			
			
			
			
			BAPIUSERGETDETAIL userDetailInput = factory.createBAPIUSERGETDETAIL();
			userDetailInput.setUSERNAME("SODEE");
			userDetailInput.setRETURN(factory.createTABLEOFBAPIRET2());

			BAPIUSERGETDETAILResponse response = (BAPIUSERGETDETAILResponse) templates.get("ecc-dev").marshalSendAndReceive(userDetailInput);
			StringResult source = new StringResult();
			marshaller.marshal(response, source);
			log.debug("Data \n{}\n", source);
		} catch(Exception e)
		{
			fail("Error test IDM WS",e);
		}
	}
	

}
