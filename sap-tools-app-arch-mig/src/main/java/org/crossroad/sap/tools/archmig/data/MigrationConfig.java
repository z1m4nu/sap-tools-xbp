package org.crossroad.sap.tools.archmig.data;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MigrationConfig {
	public static final String KEY_SRC_CREP = "src.crep";
	public static final String KEY_DST_CREP = "dst.crep";
	public static final String KEY_ITEMS_COUNT = "items.count";
	public static final String KEY_RUNID = "run.id";
	private String srcCREP;
	private String dstCREP;
	private long docToMigrate = 0L;

}
