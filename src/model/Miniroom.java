package model;

import java.util.ArrayList; 

/**
*Miniroom class
*/
public class Miniroom{

	/**
	*Date lease
	*/
	private String dateLease;
	
	/**
	*Price lease.
	*/
	private double priceLease; 
	
	//Relationship with company and university.
	
	/**
	*Company lesse.
	*/
	private Company lesse;
	
	/**
	*University lesseP.
	*/
	private University lesseP;
	
	//Server's list.

	ArrayList<Server> servers; 
	
	//Relationship enum StateMode
	/**
	*StateMode mode.
	*/
	private StateMode mode;
	
	//Relationship enum State
	
	/**
	*State stateRoom.
	*/
	private State stateRoom; 
	
	//Relationship with pictureWindow
	
	/**
	*PictureWindow window.
	*/
	
	private PictureWindow window;
	
	private Server serversP;
	
	/**
	*Constructor method 
	*@param dateLease String
	*@param priceLease double
	*@param name String
	*@param nit String 
	*@param mode StateMode
	*@param stateRoom State 
	*@param window PictureWindow
	*/
	
	public Miniroom(String dateLease, double priceLease, String name, String nit, StateMode mode, State stateRoom, PictureWindow window){
		
		this.dateLease = dateLease;
		this.priceLease = priceLease;
		//this.name = name;
		//this.nit = nit;
		lesse = new Company(name,nit); 
		this.mode = mode;
		this.stateRoom = stateRoom; 
		this.window = window;
		
		servers = new ArrayList<Server> ();
	}
	
	/**
	*Constructor method 
	*@param dateLease String
	*@param priceLease double
	*@param name String
	*@param nit String
	*@param projectCode String
	*@param mode StateMode
	*@param stateRoom State 
	*@param window PictureWindow
	*/
	
	public Miniroom(String dateLease, double priceLease, String name, String nit, String projectCode, StateMode mode, State stateRoom, PictureWindow window){
		
		this.dateLease = dateLease;
		this.priceLease = priceLease;
		lesseP = new University(name,nit,projectCode); 
		this.mode = mode;
		this.stateRoom = stateRoom; 
		this.window = window;
		servers = new ArrayList<Server> ();
	}
	
	/**
	*addServer Method, with this we can add servers objects
	*@param quantityCacheMemory double
	*@param numProcessor int 
	*@param quantityRamMemory double
	*@param numDisk int 
	*@param processors Processor[]
	*@param diskCapacity double
	*/
	public void addServer(double quantityCacheMemory, int numProcessor, double quantityRamMemory, int numDisk,Processor[] processors,double diskCapacity){
		
		serversP = new Server(quantityCacheMemory,numProcessor,quantityRamMemory,numDisk,processors,diskCapacity);
		
		servers.add(serversP);
	}
	
	//Métodos get y set
	
	public String getDateLease(){
		return dateLease;
	}
	public void setDateLease(String dateLease){
		this.dateLease = dateLease;
	}
	
	public double getPriceLease(){
		return priceLease;
	}
	public void setPriceLease(double priceLease){
		this.priceLease=priceLease;
	}
	
	public Company getLesse(){
		return lesse;
	}
	
	public void setLesse(Company lesse){
		this.lesse = lesse;
	}
	
	public University getLesseP(){
		return lesseP;
	}
	
	public void setLesseP(University lesseP){
		this.lesseP = lesseP;
	}
	
	public StateMode getMode(){
		return mode;
	}
	
	public void setMode(StateMode mode){
		this.mode = mode;
	}
	
	public State getStateRoom(){
		return stateRoom;
	}
	
	public void setStateRoom(State stateRoom){
		this.stateRoom = stateRoom;
	}
	
	public PictureWindow getWindow(){
		return window;
	}
	public void window(PictureWindow window){
		this.window = window;
	}
	
}