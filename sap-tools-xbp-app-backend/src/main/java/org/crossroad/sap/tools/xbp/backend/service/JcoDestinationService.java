package org.crossroad.sap.tools.xbp.backend.service;

import java.io.FileWriter;
import java.io.StringWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;

import org.crossroad.sap.tools.xbp.backend.jpa.entities.JcoEntity;
import org.crossroad.sap.tools.xbp.backend.jpa.repositories.JcoDestinationRepository;
import org.crossroad.sap.tools.xbp.data.jco.JcoContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JcoDestinationService {

	private static final Logger log = LoggerFactory.getLogger(JcoDestinationService.class);

	@Autowired
	@Qualifier(value = "xbp.objectmapper")
	ObjectMapper mapper;

	@Autowired
	Environment env;

	@Autowired
	JcoDestinationRepository repository;

	public void save(JcoContainer container, boolean isNew) throws JcoServiceException {
		StringWriter writer = null;
		try {
			Date dt = new Date();

			JcoEntity entity = new JcoEntity();
			entity.setName(container.getName());
			entity.setDef(mapper.writeValueAsString(container));

			if (isNew) {
				entity.setCreatime(dt);
			}

			entity.setModtime(dt);

			repository.save(entity);
		} catch (Exception e) {
			throw new JcoServiceException(e);
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (Exception e) {
				log.error("Error while closing writer", e);
			}
		}
	}

	public JcoContainer getJcoInfo(String dest) throws JcoServiceException {
		try {
			JcoEntity entity = repository.getById(dest);

			return mapper.readValue(entity.getDef(), JcoContainer.class);

		} catch (Exception e) {
			throw new JcoServiceException(e);
		}

	}

	public String dump(String dest) throws JcoServiceException {
		FileWriter writer = null;
		try {
			JcoContainer container = getJcoInfo(dest);
			Path path = Paths.get(env.getProperty("jco.destinations.dir", "."),
					String.format("%s.jcoDestination", container.getName()));
			log.debug("Store '{}' to {}", dest, path.toAbsolutePath());
			
			if (!path.getParent().toFile().exists())
			{
				path.getParent().toFile().mkdirs();
			}
			writer = new FileWriter(path.toFile());
			container.asProperties().store(writer, String.format("Jco destination '%s'", container.getName()));
			writer.flush();

			return path.toAbsolutePath().toString();
		} catch (Exception e) {
			throw new JcoServiceException(e);
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e) {
				log.error("Unable to close filewriter", e);
			}
		}
	}

	public JcoContainer delete(String dest) throws JcoServiceException {
		try {
			JcoContainer container = getJcoInfo(dest);
			repository.deleteById(dest);
			return container;
		} catch (Exception e) {
			throw new JcoServiceException(e);
		}

	}

}
