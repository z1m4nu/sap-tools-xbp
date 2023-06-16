/**
 * 
 */
package org.crossroad.sap.tools.archmig.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.Setter;

/**
 * @author e.soden
 *
 */
@Entity(name = "migration_data")
@IdClass(BackendAdmiFileKey.class)
@Setter
@Getter
public class BackendAdmiFiles {
	@Id
	@Column(name = "document")
	private String document;

	@Id
	@Column(name = "archiv_key")
	private String archivKey;

	@Id
	@Column(name = "sid")
	private String sid;
	
	@Id
	@Column(name = "run_id")
	private long runId;

	@Column(name = "creat_date", nullable = false)
	private String creatDate;

	@Column(name = "creat_time")
	private String creatTime;

	@Column(name = "obj_count")
	private Integer objCount;

	@Column(name = "file_size")
	private Double fileSize;

	@Column(name = "filename")
	private String filename;

	@Column(name = "status_opt")
	private String statusOpt;

	@Column(name = "status_fil")
	private String statusFile;

	@Column(name = "comments")
	private String comments;

	@Column(name = "status_idx")
	private String statusIdx;

	@Column(name = "pathintern")
	private String pathIntern;

	@Column(name = "old_crep")
	private String oldCrep;

	@Column(name = "new_crep")
	private String newCrep;

	@Column(name = "old_arch_docid")
	private String oldArchDocId;

	@Column(name = "new_arch_docid")
	private String newArchDocId;

	@Column(name = "deleting")
	private String deleting;
	
	@Column(name = "status_op")
	private String statusOp;
	

	@Column(name = "client")
	private String client;
	
}
