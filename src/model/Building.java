package model;
/**
*Building class
*/
public class Building{
	
	/**
	*Miniroom[][] minirooms.
	*/
	private Miniroom[][] minirooms;
	/**
	*Rows number 
	*/
	private int rows = 8;
	/**
	*Columns number
	*/
	private int columns = 50;
	
	/**
	*double basePrice.
	*/
	private double basePrice = 500000;
	/**
	*Constructor method Building class
	*/
	public Building(){
		
		minirooms = new Miniroom[rows][columns];
	}
	
	//Métodos get y set
	
	public Miniroom[][] getMinirooms(){
		return minirooms;
	}
	
	public void setMinirooms(Miniroom[][] minirooms){
		this.minirooms = minirooms;
	}
	
	
	/**
	*AddMiniroom method, it can add all minirooms with base values.
	*@param dateLease String 
	*@param priceLease String 
	*@param name String 
	*@param nit String 
	*@param mode StateMode
	*@param stateRoom State
	*@param window PictureWindow
	*/
	
	public void addMiniroom(String dateLease, double priceLease,String name, String nit, StateMode mode, State stateRoom,PictureWindow window){
		
		priceLease = basePrice;
		for(int i = 0; i < minirooms.length;i++)
		{
			for(int j = 0; j < minirooms[0].length;j++)
			{
				
				if(i==0 || i==(minirooms.length)-1){
					
					window = PictureWindow.YES;
				}
				else if(j == 0 || j == (minirooms[0].length)-1){
					window = PictureWindow.YES;
				}
				else{
					window = PictureWindow.NO;
				}
				minirooms[i][j] = new Miniroom(dateLease,priceLease,name,nit,mode,stateRoom,window);
				//finalPrice();
			}
		}	
		finalPrice();
	}
	
	/**
	*listMiniRoomFree method, it does a list of mini rooms free.
	*@return out String, list of mini rooms free
	*/
	public String listMiniRoomFree(){
		String out = ""; 
		
		for(int i = 0; i < minirooms.length;i++)
		{
			for(int j = 0; j < minirooms[0].length;j++)
			{
				if(minirooms[i][j].getStateRoom()==State.FREE){
					out += "--------------------\n";
					out += "Hall - N room: " + (1+i) + " - " + (j+1) + "\n";
					out += "Ubication with window: " + minirooms[i][j].getWindow() + "\n"; 
					out += "Price lease: $" + minirooms[i][j].getPriceLease() + "\n"; 
					out += "********************\n";
				}
			}
		}
		return out; 
	}
	
	/**
	*discointWindow method, it can calculate the discoint when the mini room has a window.
	*@return out double, discoint.
	*/
	public double discointWindow(){
		
		double out = 0;
	
		out = -1*(basePrice*0.1);
		//out = (basePrice*0.1);
		return out; 
	}
	/**
	*discointHall method, it can calculate the discoint when the minirooms are in the first o final hall of building.
	*@return out double, discoint
	*/
	public double discointHall(){
		double out = 0; 
		
		out = -1*(basePrice*0.15);
		//out = (basePrice*0.15);
		return out; 
	}
	
	
	/**
	*increaseHall method, it can calculate the increase if the mini room are between 2 and 6 hall.
	*@return out double, increase. 
	*/
	
	public double increaseHall(){
		
		double out = 0;
		
		out = (basePrice*0.25);
		
		return out;
	}
	
	/**
	*finalPrice method, it can edit the price lease a mini room.
	*/
	public void finalPrice(){
		
		double out = 0; 
		double aux = 0; 
		int counter = 0;   
		
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				if(minirooms[i][j].getWindow()==PictureWindow.YES){
					
					aux=discointWindow();
					counter++; 
				}
				else if(i==(minirooms.length)-2&&counter==0){
					
					aux=discointHall();
					counter++;
				}
				else if(i!=0&&i!=(minirooms.length)-2&&counter==0){
					
					aux=increaseHall();
					counter++;
				}
				
				out = basePrice+aux;
				System.out.println();
				minirooms[i][j].setPriceLease(out);
				out = 0;
				aux=0;
				counter=0;
			}
		}
	}
	
	/**
	*buildingMap method, it can does the building map(with the mini rooms ubication and state(ON-OFF))
	*@return out String, has the map.
	*/
	public String buildingMap(){
		String out = ""; 
		
		out+="*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n";
		
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				//out+="\t";
				out+=miniroomData(i,j);
				if(j%4==0){
					out+="\n";
				}
			}
			out+= "\n\n";
			
			out+="**********************Corredor " + (1+i) + "**********************\n";
			out+= "\n";
		}
		
		out+="*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n";
		return out;
	}
	/**
	*miniroomData method, this method can does the list with the information of only a mini room.
	*@param row int, the row of matrix.
	*@param columns int, the column of matrix.
	*@return out String, the information.
	*/
	public String miniroomData(int row,int columns){
		
		String out = ""; 
		
		out+= "\t | Room " + (row+1) + "-" + (columns+1);
		if(minirooms[row][columns].getMode()==StateMode.ON){
			out+= "\tMode: " + minirooms[row][columns].getMode() + "  |";
		}
		else{
			out+= "\tMode: " + minirooms[row][columns].getMode() + " |";
		}
		return out;
	}
	/**
	*editMiniroomCompany method, it can edit a mini room when this going to rent
	*@param row int 
	*@param column int 
	*@param date String 
	*@param mode StateMode
	*@param stateRoom State 
	*@param name String 
	*@param nit String 
	*/
	public void editMiniroomCompany(int row, int column,String date, StateMode mode, State stateRoom, String name, String nit){
		
		minirooms[row][column].setDateLease(date);
		minirooms[row][column].setMode(mode);
		minirooms[row][column].setStateRoom(stateRoom);
		minirooms[row][column].getLesse().setName(name);
		minirooms[row][column].getLesse().setNit(nit);
		//System.out.println(minirooms[row][column].getLesse().toString());
	}
	/**
	*miniroomsFree method, it can does list with all mini rooms in state free
	*@return out String, the list.
	*/
	public String miniroomsFree(){
		
		String out = ""; 
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				if(minirooms[i][j].getStateRoom()==State.FREE){
					
					out+= "\tRoom : " + (i+1) + "-" + (j+1);  
					if(j%8==0){
						out+="\n";
					}
				}
			}
			out+="\n\n";
		}
		return out; 
	}
	/**
	*editMiniroomUniversity method, it can rent a mini room to Universidad Icesi for investigation projects
	*@param row int 
	*@param column int 
	*@param date String 
	*@param mode StateMode
	*@param stateRoom State 
	*@param name String
	*@param nit String 
	*@param projectCode String 
	*/
	public void editMiniroomUniversity(int row,int column,String date,StateMode mode,State stateRoom,String name,String nit,String projectCode){
		double price = minirooms[row][column].getPriceLease();
		
		PictureWindow window = minirooms[row][column].getWindow();
		
		minirooms[row][column] = null; 
		
		minirooms[row][column] = new Miniroom(date,price,name,nit,projectCode,mode,stateRoom,window);
	}
	/**
	*addServer method, it can add server to mini room
	*@param row int  
	*@param column int 
	*@param quantityCacheMemory double 
	*@param numProcessor int 
	*@param quantityRamMemory double 
	*@param numDisk int 
	*@param processors Processor[]
	*@param diskCapacity double
	*/
	public void addServer(int row, int column, double quantityCacheMemory, int numProcessor, double quantityRamMemory, int numDisk,Processor[] processors,double diskCapacity){
		minirooms[row-1][column-1].addServer(quantityCacheMemory,numProcessor,quantityRamMemory,numDisk,processors,diskCapacity);
	}
	
	/**
	*increaseServer method, it can calculate the increase 
	*@param row int 
	*@param column int 
	*@return out double
	*/
	public double increaseServer(int row, int column){
		double out = 0; 
		
		out = (minirooms[row-1][column-1].getPriceLease()*0.15);
		//System.out.println("MONEY " + minirooms[row-1][column-1].getPriceLease());
		return out; 
	}
	/**
	*editPriceRent method, this method can edit the price for a mini room
	*@param row int 
	*@param column int 
	*/
	public void editPriceRent(int row, int column){
		double aux=0;
		double increaseR=0;
		
		if(minirooms[row-1][column-1].servers.size()<4){
			increaseR=increaseServer(row,column);
		}
		else{
			increaseR = 0; 
		}
		aux=minirooms[row-1][column-1].getPriceLease()+increaseR;
		minirooms[row-1][column-1].setPriceLease(aux);		
	}
	/**
	*finalPriceRoom method, it can to get final price rent of mini room 
	*@param row int 
	*@param column int 
	*@return minirooms[row-1][column-1].getPriceLease()
	*/
	public double finalPriceRoom(int row, int column){ 
		return minirooms[row-1][column-1].getPriceLease();
	}
	
	/**
	*changeStateMinirooms method, it can to change the state On-Off all mini rooms
	*@param mode StateMode;
	*/
	public void changeStateMinirooms(StateMode mode){
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				minirooms[i][j].setMode(mode);
			}
		}
	}
	/**
	*mapSings method, it can does a map with signs about the state On-Off of mini rooms 
	*@return out String, the map.
	*/
	public String mapSings(){
		String out = "\n***Map***\n\n"; 
		
		out+="*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n";
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				if(minirooms[i][j].getMode()==StateMode.ON){
					out+=" O";
				}
				if(minirooms[i][j].getMode()==StateMode.OFF){
					//out+="\tX";
					out+=" X";
				}
			}
			out+= "\n\n";
			
			out+="**********************Corredor " + (1+i) + "**********************\n";
			
			out+= "\n";
		}
		out+="*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n";
		return out; 
		
	} 
	
	/**
	*turnOffL method, it can turn off the mini rooms that are in the option L
	*/
	public void turnOffL(){
		
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				if(i==0){
					minirooms[i][j].setMode(StateMode.OFF);
				}
				if(j==0){
					minirooms[i][j].setMode(StateMode.OFF);
				}
			}
		}
	}
	/**
	*turnOffZ method, it can turn off the mini rooms that are in the option Z
	*/
	public void turnOffZ(){
		int counter =0; 
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				if(i==0||i==(minirooms.length)-1){
					minirooms[i][j].setMode(StateMode.OFF);
				}
			}
		}
		
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				if(counter==0){
					if(j==(7*i)+1){
						minirooms[i][j].setMode(StateMode.OFF);
						counter++; 
					}
				}
			}
			counter=0; 
		}
		
	}
	/**
	*turnOffH method, it can turn off the mini rooms that are in the option H
	*/
	public void turnOffH(){
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				if(i%2==0){
					minirooms[i][j].setMode(StateMode.OFF);
				}
			}
		}
	}
	
	/**
	*turnOffO method, it can turn off the mini rooms that are in the option O
	*/
	public void turnOffO(){
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				if(minirooms[i][j].getWindow()==PictureWindow.YES){
					minirooms[i][j].setMode(StateMode.OFF);
				}
			}
		}
	}
	
	/**
	*turnOffM method, it can turn off the mini rooms that are in the option M
	*@param option int, column that user want to turn off
	*/
	public void turnOffM(int option){
		
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				if(j==option){
					minirooms[i][j].setMode(StateMode.OFF);
				}
			}
		}
	}
	
	/**
	*turnOffP method, it can turn off the mini rooms that are in the option PBEKey
	*@param row int, row that user want to turn off
	*/
	public void turnOffP(int row){
		
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				if(i==row){
					minirooms[i][j].setMode(StateMode.OFF);
				}
			}
		}
	}
	/**
	*informationServr method, this method does a list with the information a server of mini room
	*@param row int 
	*@param column int
	*@return out String, list with the information. 
	*/
	public String informationServer(int row, int column){
		
		
		String out = ""; 
		//double capacityDisk = 0.0;
		int lengthArrayDisk = 0; 
		for(int i = 0; i<minirooms[row][column].servers.size();i++){
			
			lengthArrayDisk= minirooms[row][column].servers.get(i).getNumDisk();
			out+= "***Information server " + (1+i) + " ***\n";
			out+= "Disks capacity: " + minirooms[row][column].servers.get(i).getDisks().getDiskCapacity() + "\n"; 
			out+= "Ram memory: " + minirooms[row][column].servers.get(i).getQuantityRamMemory()+"\n";
			out+= "----------------------\n"; 
			//capacityDisk = 0; 
		}
		out += "\n";
		return out; 
	}
	/**
	*deleteServer method, it can delete all server for a mini room
	*@param row int 
	*@param column int 
	*/
	public void deleteServer(int row, int column){
		
		minirooms[row][column].servers.clear(); 
	}
	/**
	*initialsValues method, it can does give up the initials values a mini room
	*@param row int 
	*@param column int 
	*@param dateLease String 
	*@param priceLease String 
	*@param name String 
	*@param nit String 
	*@param mode StateMode
	*@param stateRoom State
	*@param window PictureWindow
	*/
	public void initialsValues(int row, int column,String dateLease, double priceLease,String name, String nit, StateMode mode, State stateRoom,PictureWindow window){
		minirooms[row][column] = null; 
		nextAddMiniroom(row,column,dateLease,priceLease,name,nit,mode,stateRoom,window);
	}
	/**
	*nextAddMiniroom method, this method does initialization process in a mini room
	*@param row int 
	*@param column int 
	*@param dateLease String 
	*@param priceLease String 
	*@param name String 
	*@param nit String 
	*@param mode StateMode
	*@param stateRoom State
	*@param window PictureWindow
	*/
	public void nextAddMiniroom(int row, int column,String dateLease, double priceLease,String name, String nit, StateMode mode, State stateRoom,PictureWindow window){
		
		priceLease = basePrice;
		
		if(row==0 || row==(minirooms.length)-1){
			window = PictureWindow.YES;	
		}
		else if(column == 0 || column == (minirooms[0].length)-1){
			window = PictureWindow.YES;
		}
		else{
			window = PictureWindow.NO;
		}
		
		minirooms[row][column] = new Miniroom(dateLease,priceLease,name,nit,mode,stateRoom,window);
		
		nextFinalPrice(row,column);
	}
	/**
	*nextFinalPrice method, this method calculate the price rent of a mini room 
	*@param row int 
	*@param column int 
	*/
	public void nextFinalPrice(int row, int column){
		
		double out = 0; 
		double aux = 0; 
		int counter = 0;   
		
		if(minirooms[row][column].getWindow()==PictureWindow.YES){
			aux=discointWindow();
			counter++; 
		}
		else if(row==(minirooms.length)-2&&counter==0){
			aux=discointHall();
			counter++;
		}
		else if(row!=0&&row!=(minirooms.length)-2&&counter==0){
			aux=increaseHall();
			counter++;
		}	
		out = basePrice+aux;
		minirooms[row][column].setPriceLease(out);
		out = 0;
		aux=0;
		counter=0;
	}
	/**
	*miniroomsTaken method, this method does a list with all mini room that are in rent 
	*@return out String 
	*/
	public String miniroomsTaken(){
	
		String out = ""; 
		
		for(int i = 0; i < minirooms.length;i++)
		{
			for(int j = 0; j < minirooms[0].length;j++)
			{
				if(minirooms[i][j].getStateRoom()==State.TAKEN){
					out += "\tHall - N room: " + (1+i) + " - " + (j+1);
					if(j%5==0){
					  out+="\n";
					}
				}
			}
		}
		return out; 
	}
	/**
	*deleteAllServers method, it can delete the servers all mini rooms
	*/
	public void deleteAllServers(){
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				if(minirooms[i][j].getStateRoom()==State.TAKEN){
					minirooms[i][j].servers.clear(); 
				}
			}
		}
	}
	/**
	*infoServers method, this method does a list with all servers of building 
	*@return out String 
	*/
	public String infoServers(){
		String out = "";
		int row = 0; 
		int column = 0; 
		int sizeL = 0; 
		int counter = 0;
		
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				if(minirooms[i][j].getStateRoom()==State.TAKEN){
					
					row = 1+i;
					column = 1+j;
					out+="*****\n";
					out+="Information about the servers in room " + row + " - " + column + "\n";
					sizeL= minirooms[i][j].servers.size();
					out+="TAMAÑO SERVER " + sizeL;
					for(int k = 0; k < sizeL;k++){
						counter = 1+k;
						//agregar +1
						out+= "***Information server " + counter + " ***\n";
						out+= "Disks capacity: " + minirooms[i][j].servers.get(k).getDisks().getDiskCapacity() + "\n"; 
						out+= "Ram memory: " + minirooms[i][j].servers.get(k).getQuantityRamMemory()+"\n";
						out+= "----------------------\n"; 
					}
					
					out+="\n";
				}
			}
		}
		return out; 
		
	}
	/**
	*deleteAllMinirooms method, this methos can delete all mini rooms of system
	*/
	public void deleteAllMinirooms(){
		for(int i = 0; i<minirooms.length;i++)
		{
			for(int j = 0; j<minirooms[0].length;j++)
			{
				minirooms[i][j] = null; 
			}
		}
	}
	
}