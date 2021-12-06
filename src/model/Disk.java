package model;

/**
*Disk Class
*/
public class Disk{
	
	/**
	*Disk capacity
	*/
	private double diskCapacity;
	
	/**
	*Constructor method of Disk Class
	*@param diskCapacity Double. 
	*/
	public Disk(double diskCapacity){
		this.diskCapacity = diskCapacity;
	}
	
	public double getDiskCapacity(){
		return diskCapacity;
	}
	
	public void setDiskCapacity(double diskCapacity){
		this.diskCapacity = diskCapacity;
	}
}