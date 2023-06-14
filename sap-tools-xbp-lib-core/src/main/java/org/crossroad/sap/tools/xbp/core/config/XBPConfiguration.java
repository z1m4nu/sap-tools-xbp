package org.crossroad.sap.tools.xbp.core.config;

import org.crossroad.sap.tools.jco.JCOCore;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = JCOCore.class)
public class XBPConfiguration {
}
