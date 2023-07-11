/**
 * 
 */
package org.crossroad.idm.app.config;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.crossroad.idm.app.config.SAPEndpoints.SAPEndpoint;
import org.crossroad.idm.app.ws.LogHttpHeaderClientInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.Assert;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.ws.transport.http.HttpComponentsMessageSender.RemoveSoapHeadersInterceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * @author e.soden
 *
 */
@Configuration
@Slf4j
public class WSConfiguration {

	@Bean("ws.pool")
	public Map<String, WebServiceTemplate> createTemplate(SAPEndpoints endpoints,
			@Qualifier(value = "jaxb2.marshaller") Jaxb2Marshaller marshaller) {
		log.debug("Creating ws.pool...");

		Map<String, WebServiceTemplate> pool = new LinkedHashMap<>();

		for (Entry<String, SAPEndpoint> entry : endpoints.getEndpoints().entrySet()) {

			try {
				WebServiceTemplate template = new WebServiceTemplate();
				template.setMarshaller(marshaller);
				template.setUnmarshaller(marshaller);
				if (StringUtils.hasText(entry.getValue().getUsername())) {
					Assert.notNull(entry.getValue().getPassword(), "When username is specified password cannot be null");
					template.setMessageSender(httpComponentsMessageSender(entry.getValue().getUsername(), entry.getValue().getPassword()));
				}
				template.setDefaultUri(entry.getValue().getEndpoint());
				ClientInterceptor[] interceptors = new ClientInterceptor[] { new LogHttpHeaderClientInterceptor() };
				template.setInterceptors(interceptors);
				pool.put(entry.getKey(), template);
			} catch (Exception e) {
				log.error(String.format("Unable to create webservice template for '%s'", entry.getKey()), e);
			}

		}

		return pool;
	}

	private HttpComponentsMessageSender httpComponentsMessageSender(String userName, String password) throws Exception {
		HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
		httpComponentsMessageSender.setHttpClient(httpClient(userName, password));
		return httpComponentsMessageSender;
	}

	private HttpClient httpClient(String username, String password) throws Exception {
		List<Header> headers = new ArrayList<>();
		BasicHeader authHeader = new BasicHeader("Authorization",
				"Basic " + base64authUserPassword(username, password));
		headers.add(authHeader);
		RequestDefaultHeaders reqHeader = new RequestDefaultHeaders(headers);
		return HttpClientBuilder.create().addInterceptorFirst(new RemoveSoapHeadersInterceptor())
				.addInterceptorLast(reqHeader).build();
	}

	private String base64authUserPassword(String username, String password) {
		String userpassword = username + ":" + password;
		String encodedAuthorization = new String(Base64Utils.encode(userpassword.getBytes()));
		return encodedAuthorization;
	}
}
