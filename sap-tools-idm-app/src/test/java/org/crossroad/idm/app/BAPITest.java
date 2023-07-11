/**
 * 
 */
package org.crossroad.idm.app;

import static org.assertj.core.api.Assertions.fail;

import java.util.LinkedList;
import java.util.List;

import org.crossroad.idm.app.service.IDMService;
import org.crossroad.sap.data.idm.BAPIBOOLCHAR;
import org.crossroad.sap.data.idm.BAPIOPTION;
import org.crossroad.sap.data.idm.USERSEARCHPARAM;
import org.crossroad.sap.data.idm.UserParam;
import org.crossroad.sap.data.idm.UserQuery;
import org.crossroad.sap.wsdl.idm.BAPIUSEREXISTENCECHECKResponse;
import org.crossroad.sap.wsdl.idm.BAPIUSERGETDETAILResponse;
import org.crossroad.sap.wsdl.idm.BAPIUSERGETLISTResponse;
import org.crossroad.sap.wsdl.idm.BAPIUSERLOCK;
import org.crossroad.sap.wsdl.idm.BAPIUSERLOCKResponse;
import org.crossroad.sap.wsdl.idm.BAPIUSERUNLOCKResponse;
import org.crossroad.sap.wsdl.idm.BAPIUSNAME;
import org.crossroad.sap.wsdl.idm.BAPIUSSEXP;
import org.crossroad.sap.wsdl.idm.ObjectFactory;
import org.crossroad.sap.wsdl.idm.TABLEOFBAPIUSNAME;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.xml.transform.StringResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author e.soden
 *
 */
@SpringBootTest
@Slf4j
public class BAPITest {
	@Autowired
	IDMService service;

	@Autowired
	@Qualifier(value = "jaxb2.marshaller")
	Jaxb2Marshaller marshaller;

	@Test
	void userDetail() {
		try {
			BAPIUSERGETDETAILResponse response = service.userDetail("ecc-dev", "SODEE");
			
			StringResult stringResult = new StringResult();
			marshaller.marshal(response, stringResult);			
			log.debug("Data \n{}\n", stringResult);
		} catch (Exception e)
		{
			fail("CheckUsername failed",e);
		}
	}

	@Test
	void userLock() {
		try {
			BAPIUSERLOCKResponse response = service.userLock("ecc-dev", "ALREMOTE");
			StringResult stringResult = new StringResult();
			marshaller.marshal(response, stringResult);			
			log.debug("Data \n{}\n", stringResult);
		} catch (Exception e)
		{
			fail("CheckUsername failed",e);
		}
	}


	@Test
	void userUnlock() {
		try {
			BAPIUSERUNLOCKResponse response = service.userUnlock("ecc-dev", "ALREMOTE");
			StringResult stringResult = new StringResult();
			marshaller.marshal(response, stringResult);			
			log.debug("Data \n{}\n", stringResult);
		} catch (Exception e)
		{
			fail("CheckUsername failed",e);
		}
	}
	
	@Test
	void userExist() {
		try {
			BAPIUSEREXISTENCECHECKResponse response = service.userExist("ecc-dev", "ALREMOTE");
			StringResult stringResult = new StringResult();
			marshaller.marshal(response, stringResult);			
			log.debug("Data \n{}\n", stringResult);
		} catch (Exception e)
		{
			fail("CheckUsername failed",e);
		}
	}
	
	@Test
	void userNotExist() {
		try {
			BAPIUSEREXISTENCECHECKResponse response = service.userExist("ecc-dev", "AL");
			StringResult stringResult = new StringResult();
			marshaller.marshal(response, stringResult);			
			log.debug("Data \n{}\n", stringResult);
		} catch (Exception e)
		{
			fail("CheckUsername failed",e);
		}
	}
	
	@Test
	void userList() {
		try {
			UserQuery query = new UserQuery();
			
			query.setMaxRow(10);
			query.setWithUserName(BAPIBOOLCHAR.TRUE);
			List<UserParam> params = new LinkedList<>();
			UserParam p = new UserParam();
			p.setLow("R*");
			p.setOption(BAPIOPTION.CP);
			p.setParameter(USERSEARCHPARAM.USERNAME);
			
			params.add(p);
			
			query.setSelection(params);
			
			BAPIUSERGETLISTResponse response = service.search("ecc-dev", query);
			StringResult stringResult = new StringResult();
			marshaller.marshal(response, stringResult);			
			log.debug("Data \n{}\n", stringResult);
		} catch (Exception e)
		{
			fail("CheckUsername failed",e);
		}
	}
}
