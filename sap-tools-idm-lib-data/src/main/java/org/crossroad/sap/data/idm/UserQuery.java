package org.crossroad.sap.data.idm;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserQuery {
	private int maxRow;
	private BAPIBOOLCHAR withUserName;
	private List<UserParam> selection;
 
}
