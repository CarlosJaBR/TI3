package model;

/**
*Server Class.
*/
public class Server{
	
	/**
	*Quantity cache memory.
	*/
	private double quantityCacheMemory;
	/**
	*Number processor.
	*/
	private int numProcessor;
	/**
	*Quantity ram memory.
	*/
	private double quantityRamMemory; 
	/**
	*Number disk
	*/
	private int numDisk;
	/**
	*Processors information.
	*/
	private Processor[] processors;
	/**
	*Disk information.
	*/
	private Disk disks; 
	
	/**
	*Construcor method of Server Class
	*@param quantityCacheMemory double.
	*@param numProcessor int
	*@param quantityRamMemory double.
	*@param numDisk int.
	*@param processors Processor[]
	*@param diskCapacity double
	*/
	public Server(double quantityCacheMemory, int numProcessor, double quantityRamMemory, int numDisk,Processor[] processors,double diskCapacity){
		
		this.quantityCacheMemory = quantityCacheMemory;
		this.numProcessor = numProcessor; 
		this.quantityRamMemory = quantityRamMemory; 
		this.numDisk = numDisk;
		processors = new Processor[numProcessor];
		disks = new Disk(diskCapacity);
		
	}
	//***Métodos get y set***
	public double getQuantityCacheMemory(){
		return quantityCacheMemory;
	}
	
	public void setQuantityCacheMemory(double quantityCacheMemory){
		this.quantityCacheMemory = quantityCacheMemory;
	}
	
	public int getNumProcessor(){
		return numProcessor;
	}
	
	public void setNumProcessor(int numProcessor){
		this.numProcessor = numProcessor;
	}
	
	public double getQuantityRamMemory(){
		return quantityRamMemory;
	}
	
	public void setQuantityRamMemory(double quantityRamMemory){	
		this.quantityRamMemory = quantityRamMemory;
	}
	
	public int getNumDisk(){
		return numDisk;
	}
	
	public void setNumDisk(int numDisk){
		this.numDisk = numDisk;
	}
	
	public Processor[] getProcessors(){
		return processors;
	}
	
	public void setProcessors(Processor[] processors){
		this.processors = processors;
	}
	
	public Disk getDisks(){
		return disks;
	}
	
	public void setDisks(Disk disks){
		this.disks = disks;
	} 
	
}