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
@Entity(name = "admi_files_bck")
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
	@Column(name = "run_id")
	private long runId;

	@Column(name = "creat_date")
	private String creatDate;

	@Column(name = "creat_time")
	private String creatTime;

	@Column(name = "obj_count")
	private String objCount;

	@Column(name = "file_size")
	private String fileSize;

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

	@Column(name = "crep")
	private String crep;

	@Column(name = "arch_docid")
	private String archDocId;

	@Column(name = "deleting")
	private String deleting;
}
