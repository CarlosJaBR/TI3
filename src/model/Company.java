package model; 

/**
*Company class
*/
public class Company{

	/**
	*Company name.
	*/
	private String name;
	
	/**
	*Company nit
	*/
	private String nit;
	
	/**
	*Constructor method of Company Class
	*@param name String.
	*@param nit String.
	*/
	public Company(String name, String nit){
		this.name = name;
		this.nit = nit; 
	}
	
	//Métodos get y set
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getNit(){
		return nit;
	}
	
	public void setNit(String nit){
		this.nit = nit;
	}
	
	/**
	*toString Method, It's method show the information about a company object.
	@return out String, It's has the information. 
	*/
	public String toString(){
		String out = ""; 
		
		out += "***Lessee data***\n";
		out += "Name: " + name + "\n";
		out += "Nit: " + nit + "\n";
		
		return out;
	}
	
}