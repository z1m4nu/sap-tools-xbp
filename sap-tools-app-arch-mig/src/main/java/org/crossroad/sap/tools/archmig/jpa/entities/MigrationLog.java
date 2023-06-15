/**
 * 
 */
package org.crossroad.sap.tools.archmig.jpa.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author e.soden
 *
 */
@Entity
@Table(name = "migration_journal")
@Setter
@Getter
public class MigrationLog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "`key`")
	private Long key;
	
	@Column(name = "sid")
	private String sid;
	
	@Column(name = "document")
	private String document;

	@Column(name = "archiv_key")
	private String archivKey;

	@Column(name = "msg")
	private String msg;

	@Column(name = "posted", nullable = false)
	private LocalDateTime posted;
	
	@Column(name = "severity", nullable = false)
	private String severity;
	
	@Column(name = "client")
	private String client;
}
