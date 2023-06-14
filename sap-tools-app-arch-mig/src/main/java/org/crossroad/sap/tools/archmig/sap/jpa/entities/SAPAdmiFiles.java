/**
 * 
 */
package org.crossroad.sap.tools.archmig.sap.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;

import lombok.Data;

/**
 * @author e.soden
 *
 */
@IdClass(AdmiFileKey.class)
@Entity(name = "admi_files")
@Data
public class SAPAdmiFiles {
	@Id
	@Column(name = "document")
	private String document;

	@Id
	@Column(name = "archiv_key")
	private String archivKey;

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
