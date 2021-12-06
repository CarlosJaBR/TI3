package model;

/**
*University Class.
*/

public class University extends Company{

	/**
	*It's project code.
	*/
	private String projectCode;
	
	
	/**
	*Constructor method of University Class
	*@param name String.
	*@param nit String.
	*@param projectCode String.
	*/
	public University(String name, String nit, String projectCode){
		super(name,nit);
		this.projectCode = projectCode;
	}
	
	//Métodos get y set
	
	public String getProjectCode(){
		return projectCode;
	}
	
	public void setProjectCode(String projectCode){
		this.projectCode = projectCode;
	}
	
	/**
	*toString Method, It's method show the information about a university object.
	@return out String, It's has the information. 
	*/
	public String toString(){
		String out = ""; 
		
		out += super.toString() + "\n";
		out += "Project code: " + projectCode + "\n";
		
		return out;
	}
	
	
}