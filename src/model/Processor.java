package model;

/**
*Processor class
*/
public class Processor{
	
	/**
	*mark MarkProcessor
	*/
	private MarkProcessor mark;
	
	/**
	*Constructor method Processor class
	*@param mark MarkProcessor
	*/
	public Processor(MarkProcessor mark){
		this.mark = mark;
	}
	
	//Métodos get y set 
	public MarkProcessor getMark(){
		return mark;
	}
	
	public void setMark(MarkProcessor mark){
		this.mark= mark;
	}
}