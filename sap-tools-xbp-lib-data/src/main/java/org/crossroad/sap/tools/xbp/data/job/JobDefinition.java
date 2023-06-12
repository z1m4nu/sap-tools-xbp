package org.crossroad.sap.tools.xbp.data.job;

import java.util.LinkedList;
import java.util.List;

import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMJOB;
import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMJOBLOG;
import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMRECIP;
import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMSPOOLID;
import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMSTEP;

import lombok.Data;

@Data
public class JobDefinition {

	private BAPIXMJOB job;
	private BAPIXMJOBLOG jobLogAttr;
	private BAPIXMRECIP recipient;
	private List<BAPIXMSTEP> steps = new LinkedList<>();
	private List<BAPIXMSPOOLID> spools = new LinkedList<>();
}
