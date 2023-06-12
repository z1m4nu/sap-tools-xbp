/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * @author e.soden
 *
 */
@Configuration
public class XBPConfiguration {
	private static final Logger log = LoggerFactory.getLogger(XBPConfiguration.class);

	@Bean(name = "xbp.objectmapper")
	public ObjectMapper createMapper(
			@Value(value = "#{new Boolean('${xbp.mapper.fail-unknown-properties:true}')}") Boolean failUnknown) {
		log.debug("Create xbp.objectmapper...");

		var mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failUnknown);
		mapper.registerModule(new JavaTimeModule());
		

		return mapper;
	}

}
