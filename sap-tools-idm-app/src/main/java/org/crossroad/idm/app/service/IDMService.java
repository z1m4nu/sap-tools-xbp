package org.crossroad.idm.app.service;

import java.util.List;
import java.util.Map;

import org.crossroad.sap.data.idm.UserParam;
import org.crossroad.sap.data.idm.UserQuery;
import org.crossroad.sap.wsdl.idm.BAPIUSERDELETE;
import org.crossroad.sap.wsdl.idm.BAPIUSERDELETEResponse;
import org.crossroad.sap.wsdl.idm.BAPIUSEREXISTENCECHECK;
import org.crossroad.sap.wsdl.idm.BAPIUSEREXISTENCECHECKResponse;
import org.crossroad.sap.wsdl.idm.BAPIUSERGETDETAIL;
import org.crossroad.sap.wsdl.idm.BAPIUSERGETDETAILResponse;
import org.crossroad.sap.wsdl.idm.BAPIUSERGETLIST;
import org.crossroad.sap.wsdl.idm.BAPIUSERGETLISTResponse;
import org.crossroad.sap.wsdl.idm.BAPIUSERLOCK;
import org.crossroad.sap.wsdl.idm.BAPIUSERLOCKResponse;
import org.crossroad.sap.wsdl.idm.BAPIUSERUNLOCK;
import org.crossroad.sap.wsdl.idm.BAPIUSERUNLOCKResponse;
import org.crossroad.sap.wsdl.idm.BAPIUSNAME;
import org.crossroad.sap.wsdl.idm.BAPIUSSEXP;
import org.crossroad.sap.wsdl.idm.ObjectFactory;
import org.crossroad.sap.wsdl.idm.TABLEOFBAPIUSNAME;
import org.crossroad.sap.wsdl.idm.TABLEOFBAPIUSSEXP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class IDMService {

	@Autowired
	@Qualifier(value = "idm.objectfactory")
	ObjectFactory factory;

	@Autowired
	@Qualifier(value = "ws.pool")
	Map<String, WebServiceTemplate> templates;


	/**
	 * 
	 * @param id
	 * @param username
	 * @throws Exception
	 * @throws JsonProcessingException
	 */
	public BAPIUSERGETDETAILResponse userDetail(String id, String username) throws Exception {
		BAPIUSERGETDETAIL input = factory.createBAPIUSERGETDETAIL();
		input.setUSERNAME(username);
		input.setRETURN(factory.createTABLEOFBAPIRET2());

		return (BAPIUSERGETDETAILResponse) consume(id, input);
	}
	

	/**
	 * 
	 * @param id
	 * @param username
	 * @return
	 */
	public BAPIUSERLOCKResponse userLock(String id, String username) {
		BAPIUSERLOCK input = factory.createBAPIUSERLOCK();
		input.setUSERNAME(username);
		input.setRETURN(factory.createTABLEOFBAPIRET2());
		return (BAPIUSERLOCKResponse) consume(id, input);
	}

	/**
	 * 
	 * @param id
	 * @param username
	 * @return
	 */
	public BAPIUSERUNLOCKResponse userUnlock(String id, String username) {
		BAPIUSERUNLOCK input = factory.createBAPIUSERUNLOCK();
		input.setUSERNAME(username);
		input.setRETURN(factory.createTABLEOFBAPIRET2());
		return (BAPIUSERUNLOCKResponse) consume(id, input);
	}

	/**
	 * 
	 * @param id
	 * @param username
	 * @return
	 */
	public BAPIUSEREXISTENCECHECKResponse userExist(String id, String username) throws Exception {
		BAPIUSEREXISTENCECHECK input = factory.createBAPIUSEREXISTENCECHECK();
		input.setUSERNAME(username);
		return (BAPIUSEREXISTENCECHECKResponse) consume(id, input);
	}
	/**
	 * 
	 * @param id
	 * @param username
	 * @return
	 */
	public BAPIUSERDELETEResponse deleteUser(String id, String username) {
		BAPIUSERDELETE input = factory.createBAPIUSERDELETE();
		input.setRETURN(factory.createTABLEOFBAPIRET2());
		input.setUSERNAME(username);
		
		return (BAPIUSERDELETEResponse) consume(id, input);
	}
	/**
	 * 
	 * @param id
	 * @param data
	 * @return
	 */
	public BAPIUSERGETLISTResponse search(String id, UserQuery query)
	{
		
		BAPIUSERGETLIST input = factory.createBAPIUSERGETLIST();
		input.setRETURN(factory.createTABLEOFBAPIRET2());
		input.setUSERLIST(factory.createTABLEOFBAPIUSNAME());
		
		if(query.getMaxRow() > 0)
		{
			input.setMAXROWS(query.getMaxRow());
		}
		
		if(query.getWithUserName() != null)
		{
			input.setWITHUSERNAME(query.getWithUserName().asSAPStr());
		}
		
		TABLEOFBAPIUSSEXP table = factory.createTABLEOFBAPIUSSEXP();
		for(UserParam p : query.getSelection())
		{
			BAPIUSSEXP bapi = factory.createBAPIUSSEXP();
			if(StringUtils.hasText(p.getHigh())) {
				bapi.setHIGH(p.getHigh());
			}
			if(StringUtils.hasText(p.getLow())) {
				bapi.setLOW(p.getLow());
			}
			
			if(p.getLogOp() != null)
			{
				bapi.setLOGOP(p.getLogOp().name());
			}
			
			if (p.getOption() != null)
			{
				bapi.setOPTION(p.getOption().name());
			}
			
			if (p.getParameter() != null)
			{
				bapi.setPARAMETER(p.getParameter().name());
			}
			
			table.getItem().add(bapi);
		}
			
		
		
		
		input.setSELECTIONEXP(table);
		
		return (BAPIUSERGETLISTResponse) consume(id, input);
	}

	

	private Object consume(String id, Object input) {
		Assert.isTrue(templates.containsKey(id), String.format("Webservice pool does not contains template for id '%s'", id));
		return templates.get(id).marshalSendAndReceive(input);
	}
}
