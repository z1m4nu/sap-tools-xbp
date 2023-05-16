package org.crossroad.sap.tools.data;

import java.io.Serializable;

public class JobStep implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String program;
	private String variant;
	private String stepUser;
	private String language;
	private int rank;

	/**
	 * @return the program
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * @param program the program to set
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	/**
	 * @return the variant
	 */
	public String getVariant() {
		return variant;
	}

	/**
	 * @param variant the variant to set
	 */
	public void setVariant(String variant) {
		this.variant = variant;
	}

	/**
	 * @return the stepUser
	 */
	public String getStepUser() {
		return stepUser;
	}

	/**
	 * @param stepUser the stepUser to set
	 */
	public void setStepUser(String stepUser) {
		this.stepUser = stepUser;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

}
