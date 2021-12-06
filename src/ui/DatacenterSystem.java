package ui;

import java.util.Scanner;
import model.*; 
/**
*DatacenterSystem class
*/
public class DatacenterSystem{

	/**
	*Scanner sc 
	*/
	private Scanner sc; 
	/**
	*Building bl
	*/
	private Building bl;
	
	/**
	*Constructor method DatacenterSystem
	*/
	public DatacenterSystem(){
		
		sc = new Scanner(System.in);
		bl = new Building();
		
	}
	
	/**
	*Main method, principal in this project
	*@param args String[]
	*/
	public static void main(String[] args){
		
		DatacenterSystem dt = new DatacenterSystem();
		
		//Crear en este espacio el método que inicializa los cuartos
		
		int option = 0; 
		System.out.println("Welcome to Datacenter - Universidad Icesi\n");
		
		dt.initializeMiniRoom();
		do{
			option = dt.optionMenu();
			dt.menu(option);
		}while(option!=0);
		
	}
	
	/**
	*optionMenu method, it can show and give option menu and return the option for other method.
	*@return option int, option menu.
	*/
	public int optionMenu(){
		int option = 0; 
		
		System.out.println("\nMenu option\n\n"+
						"(1) Mini room list\n"+
						"(2) Rent mini room\n"+
						"(3) Cancel rent a mini room\n"+
						"(4) Cancel rent all mini rooms\n"+
						"(5) Building map\n"+
						"(6) Turn on mini rooms\n"+
						"(7) Turn off mini rooms \n"+
						"(0) Close program\n"
		);
		
		option = sc.nextInt();
		
		return option;
	}
	
	/**
	*menu method, it can execute the option ingressed for user.
	*@param option int, the option. 
	*/
	public void menu(int option){
		
		switch(option){
		case 0:
			System.out.println("Bye bye");
			break; 
		case 1:
			System.out.println(bl.listMiniRoomFree());
			break; 
		case 2:
			rentRoom();
			break; 
		case 3:
			cancelRentMiniroom();
			break; 
		case 4:
			cancelRentAllMinirooms();
			break; 
		case 5:
			controlerOptionMap();
			break; 
		case 6:
			turnOnAllRooms();
			break; 
		case 7:
			turnOffMiniroom();
			break; 
		}
	}
	
	/**
	*InitializeMiniRoom method, it can initialize the mini rooms of building 
	*/
	public void initializeMiniRoom(){
		String dateLease = "N/A"; 
		double priceLease = 0; 
		String name = "N/A";
		String nit = "N/A"; 
		StateMode mode = StateMode.OFF;
		State stateRoom = State.FREE; 
		PictureWindow window = PictureWindow.NO; 
		
		bl.addMiniroom(dateLease,priceLease,name,nit,mode,stateRoom,window);
		
	}
	
	/**
	*rentRoom method, it can take control about rent function. 
	*/
	public void rentRoom(){
		
		int day;
		int month; 
		int year;
		String name="";
		String date = ""; 
		String nit = ""; 
		String projectCode = ""; 
		StateMode mode = StateMode.ON;
		State stateRoom = State.TAKEN;
		int row = 0; 
		int column = 0;
		int condition = 0; 
		int quantityS = 0; 
		
		System.out.println("Mini rooms free");
		System.out.println(bl.miniroomsFree());
		
		System.out.println("Enter the location if mini room");
		
		System.out.println("Hall number");
		
		do{
			row = sc.nextInt();
			if(row>=1&&row<=8){
				condition =-1;
			}
			
		}while(condition!=-1);
		
		condition = 0; 
		
		System.out.println("Room number");
		do{
			column = sc.nextInt();
			if(column>=1&&column<=50){
				condition =-1;
			}
			
		}while(condition!=-1);
		
		condition = 0;
		
		System.out.println("***Rent date***");
		
		System.out.println("Day");
		day = sc.nextInt();
		
		System.out.println("Month");
		month = sc.nextInt();
		
		System.out.println("Year");
		year = sc.nextInt();
		
		date = day + " / " +  month + " / " + year; 
		
		
		int option=0;
		
		System.out.println("Who do you rent the mini room?");
		System.out.println("(1) - Company\n"+
						   "(2) - Investigation project\n"
		);
		do{
			option = sc.nextInt();
		}while(option<1);
		
		
		sc.nextLine();
		
		switch(option){
			
		case 1:
			System.out.println("Company name");
			name = sc.nextLine();
			
			System.out.println("Company nit");
			nit = sc.nextLine();
			
			bl.editMiniroomCompany(row-1,column-1,date,mode,stateRoom,name,nit);
			
			System.out.println("Mini room rented successfully");
			break;
		case 2:
			name = "UNIVERSIDAD ICESI";
			nit = "1.125.234.245";
			System.out.println("Project code");
			projectCode = sc.nextLine();
			
			bl.editMiniroomUniversity(row-1,column-1,date,mode,stateRoom,name,nit,projectCode);
			break;
		}
		System.out.println("Quantity servers");
		quantityS = sc.nextInt();
		
		for(int i = 0; i<quantityS;i++){
			
			System.out.println("\nServer #" + (1+i)+"\n");
			registerServer(row,column);
		}
		
		bl.editPriceRent(row, column);
		
		System.out.println("Rent price $"+ bl.finalPriceRoom(row,column));
		//registerServer(row,column);
		
	}
	/**
	*addServer method, it can add servers to mini room 
	*@param row int
	*@param column int 
	*/
	public void registerServer(int row,int column){
		
		double quantityCacheMemory = 0; 
		int numProcessor = -1; 
		double quantityRamMemory = 0;
		int numDisk = -1; 
		double diskCapacity = 0.0; 
		Processor[] processors; 
		
		System.out.println("Quantity cache memory");
		quantityCacheMemory = sc.nextDouble();
		
		System.out.println("Quantity ram memory");
		quantityRamMemory = sc.nextDouble();
		
		System.out.println("Processors number");
		numProcessor = sc.nextInt();
		
		System.out.println("\n***Processors data***\n");
		processors = arrayProcessors(numProcessor);
		
		System.out.println("\n***Disks data***\n"); 
		
		System.out.println("Disks number");
		numDisk = sc.nextInt();
		
		System.out.println("Disks capacity");
		
		diskCapacity = sc.nextDouble();
		
		bl.addServer(row,column,quantityCacheMemory,numProcessor,quantityRamMemory,numDisk,processors,diskCapacity);
		
	}
	
	/**
	*arrayProcessors method, this method full a array of proccesor
	*@param numProcessor int
	*@return array Processor[]
	*/
	public Processor[] arrayProcessors(int numProcessor){
		
		Processor[] array = new Processor[numProcessor];
		
		int option = 0; 
		MarkProcessor mark = null; 
		
		for(int i = 0; i < numProcessor; i++){
			
			System.out.println("Processor mark "+ (1+i));
			System.out.println("(1) - INTEL\n"+
							   "(2) - AMD\n"
			);
			option = sc.nextInt();
			
			switch(option){
			case 1:
				mark = MarkProcessor.INTEL;
				break;
			case 2: 
				mark = MarkProcessor.AMD;
				break;
			}
			
			array[i] = new Processor(mark);
		}	
		return array; 
	}

	/**
	*turnOnAllRooms method, it can to change the state of mini room On-Off
	*/	
	public void turnOnAllRooms(){
		
		StateMode mode = StateMode.ON;
		
		bl.changeStateMinirooms(mode);
		
		System.out.println("\n***Mini rooms turn on with successful***\n");
	}
	
	/**
	*turnOffMiniroom method, it can controler the option for turn off the mini rooms.
	*/
	public void turnOffMiniroom(){
		
		String option; 
		int column=0; 
		int condition=0;
		int row = 0; 
		
		System.out.println("Menu for turn off\n"+
						   "(L)- First mini rooms of all halls - mini rooms in the first hall \n"+
						   "(Z)- Mini rooms in the firts and last hall - Mini rooms in reverse diagonal\n"+
						   "(H)- Mini rooms located in odd-numbered hall\n"+
						   "(O)- Mini rooms located in the window\n"+
						   "(M)- Column option\n"+
						   "(P)- Hall option\n"
		);
		sc.nextLine();
		
		
		option = sc.nextLine();
		
		switch(option.toUpperCase()){
		
		case "L":
			bl.turnOffL();
			System.out.println("***Turn off with successful***\n");
			System.out.println(bl.mapSings());
			break; 
		case "Z":
			bl.turnOffZ();
			System.out.println("***Turn off with successful***\n");
			System.out.println(bl.mapSings());
			break; 
		case "H":
			bl.turnOffH();
			System.out.println("***Turn off with successful***\n");
			System.out.println(bl.mapSings());
			break; 
		case "O":
			bl.turnOffO();
			System.out.println("***Turn off with successful***\n");
			System.out.println(bl.mapSings());
			break; 
		case "M":
			
			System.out.println("Enter the column\n");
			do{
				column = sc.nextInt();
				if(column>=1&&column<=50){
					condition =-1;
				}
			}while(condition!=-1);
			bl.turnOffM(column-1);
			System.out.println("***Turn off with successful***\n");
			System.out.println(bl.mapSings());
			break; 
		case "P":
		
			System.out.println("Enter the hall\n");
			do{
				row = sc.nextInt();
				if(row>=1&&row<=8){
					condition =-1;
				}
			}while(condition!=-1);
			bl.turnOffP(row-1);
			System.out.println("***Turn off with successful***\n");
			System.out.println(bl.mapSings());
			break; 
		default:
			System.out.println("Wrong option");
			break; 
		}	
	}
	/**
	*controlerOptionMap method, it can controler the option of map. 
	*/
	public void controlerOptionMap(){
		
		int option; 
		
		System.out.println("Option show map\n"+
						   "(1) - List-Map state\n"+
						   "(2) - Map with signs\n" 
		);
		
		sc.nextLine();
		
		option = sc.nextInt();
		
		switch(option){
		
		case 1:
			System.out.println(bl.buildingMap());
			break;
		case 2:
			System.out.println("Indications\n"+
							"X --> Mini room Off\n"+
							"O --> Mini room On\n"
			);
			System.out.println(bl.mapSings());
			break; 
		default:
			System.out.println("Wrong option");
			break;
		}
	}
	/**
	*cancelRentMiniroom method, it can cancel the rent service for a mini room
	*/
	public void cancelRentMiniroom(){
		
		int row = 0; 
		int column = 0; 
		
		System.out.println("***Mini rooms rent***\n\n");
		
		if(bl.miniroomsTaken().equals("")){
			
			System.out.println("There are not leased mini rooms");
		}
		else{
			
			System.out.println(bl.miniroomsTaken());
		
			System.out.println("\n");
		
			System.out.println("Enter the hall");
			row = sc.nextInt();
		
			System.out.println("Enter the column");
			column = sc.nextInt(); 
		
			System.out.println(bl.informationServer(row-1,column-1));
		
			bl.deleteServer(row-1,column-1);
		
			String dateLease = "N/A"; 
			double priceLease = 0; 
			String name = "N/A";
			String nit = "N/A"; 
			StateMode mode = StateMode.OFF;
			State stateRoom = State.FREE; 
			PictureWindow window = PictureWindow.NO; 
		
			bl.initialsValues(row-1,column-1,dateLease,priceLease,name,nit,mode,stateRoom,window);
		
			System.out.println("Rent service canceled with successful");
		}	
	}
	/**
	*cancelRentAllMinirooms method, this method canceled the rent service all mini rooms
	*/
	public void cancelRentAllMinirooms(){
		
		if(bl.infoServers().equals("")){
			
			System.out.println("There are not leased mini rooms");
		}
		else{
			System.out.println(bl.infoServers());
			
			bl.deleteAllServers();
			bl.deleteAllMinirooms();
			initializeMiniRoom();
			
			System.out.println("Rent service canceled with successful");
		}
		
	}
}