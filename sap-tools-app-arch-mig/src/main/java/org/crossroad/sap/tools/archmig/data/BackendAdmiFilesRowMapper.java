/**
 * 
 */
package org.crossroad.sap.tools.archmig.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.crossroad.sap.tools.archmig.jpa.entities.BackendAdmiFiles;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author e.soden
 *
 */
public class BackendAdmiFilesRowMapper implements RowMapper<BackendAdmiFiles>{

	@Override
	public BackendAdmiFiles mapRow(ResultSet rs, int rowNum) throws SQLException {
		BackendAdmiFiles data = new BackendAdmiFiles();
		
		data.setDocument(rs.getString("DOCUMENT"));
		data.setArchivKey(rs.getString("ARCHIV_KEY"));
		data.setCreatDate(rs.getString("CREAT_DATE"));
		data.setCreatTime(rs.getString("CREAT_TIME"));
		data.setObjCount(rs.getString("OBJ_COUNT"));
		data.setFileSize(rs.getString("FILE_SIZE"));
		data.setFilename(rs.getString("FILENAME"));
		data.setStatusOpt(rs.getString("STATUS_OPT"));
		data.setStatusFile(rs.getString("STATUS_FIL"));
		data.setComments(rs.getString("COMMENTS"));
		data.setStatusIdx(rs.getString("STATUS_IDX"));
		data.setPathIntern(rs.getString("PATHINTERN"));
		data.setCrep(rs.getString("CREP"));
		data.setOldArchDocId(rs.getString("ARCH_DOCID"));
		data.setDeleting(rs.getString("DELETING"));
		
		return data;
	}


}
