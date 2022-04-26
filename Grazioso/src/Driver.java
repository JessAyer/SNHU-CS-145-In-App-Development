/*
 * -----------------------------------------
 * Author: Jessica Ayer
 * Rescue Animal Java Code
 * SNHU CS 145: In Application Development
 * 08/11/2021
 * -----------------------------------------
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	static Scanner scnr = new Scanner(System.in);
	// Array lists for Dogs and Monkeys
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    // menu
    private static char menuSelection;
    static int d = 3;
    static int m = 2;
    
    public static void main(String[] args) {
    	initializeDogList();
        initializeMonkeyList();
        displayMenu();
        menuSelection = (scnr.nextLine().toLowerCase().charAt(0));
        
        //loop that displays the menu and accepts the users input
        while(menuSelection != 'q') {
        	
        	while (menuSelection != '1' && menuSelection != '2' && menuSelection !='3' && menuSelection !='4' && menuSelection != '5'
        			&& menuSelection != '6' && menuSelection != 'q') {
        		System.out.println("Invalid selection");
        		menuSelection = scnr.nextLine().toLowerCase().charAt(0);  		
        	}
        	// Dog intake menu option
        	if(menuSelection == '1') {
        		System.out.println("Dog intake: ");
        		intakeNewDog(scnr);
        		
        		displayMenu();
                menuSelection = (scnr.nextLine().toLowerCase().charAt(0));
        	}
        	// monkey intake menu option
        	if(menuSelection == '2') {
        		System.out.println("Monkey intake: ");
        		intakeNewMonkey(scnr);
        		
        		displayMenu();
                menuSelection = (scnr.nextLine().toLowerCase().charAt(0));
        	}
        	// reserve animal menu option
        	if(menuSelection == '3') {
        		System.out.println("Reserving animal:");
        		reserveAnimal(scnr);
        		
        		displayMenu();
                menuSelection = (scnr.nextLine().toLowerCase().charAt(0));
        	}
        	//print dogs menu option
        	if(menuSelection == '4') {
        		printAnimals();
        		
        		displayMenu();
                menuSelection = (scnr.nextLine().toLowerCase().charAt(0));
    
        	}
        	// print monkeys menu option
        	if(menuSelection == '5') {
        		printAnimals();
        		
        		displayMenu();
                menuSelection = (scnr.nextLine().toLowerCase().charAt(0));
        	}
        	// print all available animals menu option
        	if(menuSelection == '6') {
        		System.out.println();
        		printAnimals();
        		
        		displayMenu();
                menuSelection = (scnr.nextLine().toLowerCase().charAt(0));
        	}
        	// quit menu option
        	if (menuSelection == 'q') {
        		System.out.println("Goodbye");
            	break;	
            }	
        }
    }
 
    /*
 	 * ---------------------------------------
 	 *               MAIN MENU
 	 * ---------------------------------------
     */
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\t--Rescue Animal System Menu--");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }
    
    /*
     * ---------------------------------------
     *               TEST INPUT
     * ---------------------------------------
     */
    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");
        Dog dog4 = new Dog("Izzy", "Mastiff", "female", "2", "125", "03-25-2019", "United States", "in service", false, "United States");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
    }

    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Bob", "Capuchin", "male", "2", "15", "03-21-2020", "United States", "intake", true, "United States", "3", "16" ,"8");
    	Monkey monkey2 = new Monkey("George", "Guenon", "male", "5", "10", "09-15-2019", "United States", "intake", false, "United States", "7", "17" ,"9");
    	Monkey monkey3 = new Monkey("Betsy", "Macaque", "female", "7", "21", "07-08-2018", "United States", "in service", false, "United States", "9", "24" ,"12"); 

    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    	monkeyList.add(monkey3);
    }

    /*
     * ---------------------------------------
     *             Menu Methods
     * ---------------------------------------
     */
    //intakeNewDog method
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scnr.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }          
        }
        // gets dogs information
        System.out.println("Enter dog's breed:");
    	String animalType = scnr.nextLine();
    	System.out.println("Enter gender:");
    	String gender = scnr.nextLine();
    	System.out.println("Enter age:");
    	String age = scnr.nextLine();
    	System.out.println("Enter weight:");
    	String weight = scnr.nextLine();
    	System.out.println("Enter acquistion date:");
    	String acquisitionDate = scnr.nextLine();
    	System.out.println("Enter acquisition Country:");
    	String acquisitionCountry = scnr.nextLine();
    	System.out.println("Enter training Status:");
    	String trainingStatus = scnr.nextLine();
    	boolean reserved = false;
    	System.out.println("What is the dog's in service country?");
    	String inServiceCountry = scnr.nextLine();
    	
    	Dog newDog = new Dog(name, animalType, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
    	// adds dog to array
    	dogList.add(newDog);
    	System.out.println("Dog Added");
    	// notes array length to iterate through
    	++d;
    }
  
        //intakeNewMonkey method
        public static void intakeNewMonkey(Scanner scanner) {
        	String [] monkeySpecies = {"Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrell Monkey", "Tamarin"};
        	String species;
        	System.out.println("What is the Monkey's name?");
            String name = scnr.nextLine();
            for(Monkey monkey: monkeyList) {
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
                }
            }
            //validate that species is acceptable
            System.out.println("Enter monkey's Species:");
            System.out.println("(Capuchin, Guenon, Macaque, Marmoset, Squirrell Monkey, or Tamarin)");
            species = scnr.nextLine();
            if (!Arrays.asList(monkeySpecies).contains(species)){
            	System.out.println("Invalid species");
            	return; 	
            }
            // gets monkeys information
            else {
            	String animalType = species;
            	System.out.println("Enter gender:");
            	String gender = scnr.nextLine();
            	System.out.println("Enter age:");
            	String age = scnr.nextLine();
            	System.out.println("Enter weight:");
            	String weight = scnr.nextLine();
            	System.out.println("Enter acquistion date:");
            	String acquisitionDate = scnr.nextLine();
            	System.out.println("Enter acquisition Country:");
            	String acquisitionCountry = scnr.nextLine();
            	System.out.println("Enter training Status:");
            	String trainingStatus = scnr.nextLine();
            	boolean reserved = false;
            	System.out.println("What is the monkey's in service country?");
            	String inServiceCountry = scnr.nextLine();
            	System.out.println("Enter tail length:");
            	String tailLength = scnr.nextLine();
            	System.out.println("Enter height:");
            	String height = scnr.nextLine();
            	System.out.println("Enter body length:");
            	String bodyLength = scnr.nextLine();
            
        	
            	Monkey newMonkey = new Monkey(name, animalType, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry, tailLength,
            			height, bodyLength);
            	// adds monkeys to array
            	monkeyList.add(newMonkey);
            	System.out.println("Monkey added");
            	// notes length of monkey array to iterate through
            	++m;
            }
        }

        //reserveAnimal method
        public static void reserveAnimal(Scanner scanner) {
        	String reserveInput;
        	String dogReserve = "1";
        	String monkeyReserve = "2";
        	String menuReturn = "3";
        	String countryInput;
        	int i = 1;
        	String animalSelection = "none";
        	boolean reservationStatus = false;
        	boolean noDogs = true;
        	boolean noMonkeys = true;
        	
        	// sub menu to specify animal type
        	System.out.println("[1] Reserve dog");
        	System.out.println("[2] Reserve monkey");
        	System.out.println("[3] Return to menu");
        	reserveInput = scnr.nextLine();

        	//reserve dog
        	if (reserveInput.equalsIgnoreCase(dogReserve)) {
        		System.out.println("Reserving dog");
        		
        		//get country
        		System.out.println("Enter Service Country:");
        		countryInput = scnr.nextLine();  
        		for (Dog dog: dogList) {
        			if (dog.getReserved() == (reservationStatus)) {			
        				if (dog.getInServiceLocation().equalsIgnoreCase(countryInput)) {
        					noDogs = false;
        					System.out.println(i + ": " + dog.getName() + ": "  + dog.getBreed());
        					++i;
        				}
        			}
        		}
        		
        		//get dog name
        		if (noDogs != true) {
        			System.out.println("\nChoose a dog (Enter name): ");
        			animalSelection = scnr.nextLine();
        			for (Dog dog: dogList) {
        				if (dog.getName().equalsIgnoreCase(animalSelection)) {
        					dog.setReserved(true); 
        					System.out.println(dog.getName() + " is now reserved");
        				}
        			}
        		}
        		// no dogs meet requested criteria
        		else {
        			System.out.println("No dogs available");
        		}
        	}
 
        	//reserve monkey
        	if (reserveInput.equalsIgnoreCase(monkeyReserve)) {
        		System.out.println("Reserving Monkey");
        		
        		// get country
        		System.out.println("Enter Service Country:");
        		countryInput = scnr.nextLine();
        		for (Monkey monkey: monkeyList) {
        			if (monkey.getReserved() == (reservationStatus)) {
        				if (monkey.getInServiceLocation().equalsIgnoreCase(countryInput)) {
        					noMonkeys = false;
        					System.out.println(i + ": " + monkey.getName() + ": "  + monkey.getSpecies());
        					++i;
        				}
        			}		
        		}
        		
        		//get monkey name
        		if (noMonkeys != true) {
        			System.out.println("\nChoose a monkey (Enter name): ");
        			animalSelection = scnr.nextLine();
        			for (Monkey monkey: monkeyList) {
        				if (monkey.getName().equalsIgnoreCase(animalSelection)) {
        					monkey.setReserved(true); 
        					System.out.println(monkey.getName() + " is now reserved");		
        				}
        			}
        		}
        		// no monkeys meet requested criteria
        		else {
        			System.out.println("No monkeys available");
        		}
        	}
        	//return to main menu
        	if(reserveInput.equalsIgnoreCase(menuReturn)) {
        		return;
        	}
        	//return to animal reserve menu
        }
        
        // printAnimals method
        public static void printAnimals() {
        	String trainingStatus = "in service";
        	
        	// dog - prints the list of dogs
        	if (menuSelection == '4') {
        		System.out.println("\n\t--All dogs--");
        		System.out.println();
        		for(Dog dog: dogList) {
        			System.out.println(dog.getName() + ":\nTraining status: " + dog.getTrainingStatus() + ", Acquisistion country: " 
        								+ dog.getAcquisitionLocation() + ", reserved: " + dog.getReserved() + "\n");
        		}
        		System.out.print("-----\n");
        	}
        	
    		// monkey - prints the list of monkeys
        	if (menuSelection == '5') {
        		System.out.println("\n\t--All monkeys--");
        		System.out.println();
        		for (Monkey monkey: monkeyList){
        			System.out.println(monkey.getName()+ ":\nTraining Status: " + monkey.getTrainingStatus() + ", Acqusistion country: " 
							+ monkey.getAcquisitionLocation() + ", Reserved: " + monkey.getReserved() + "\n");
        			System.out.println();
        		}
        		System.out.print("-----\n");
        	}
        	
            // available - prints a combined list of all animals that are
            // fully trained ("in service") but not reserved 
        	if (menuSelection == '6') {
        		System.out.println("\n\t--Available dogs--");
        		for (Dog dog: dogList) {
        			if (dog.getReserved() == false) {
        				if (dog.getTrainingStatus().equalsIgnoreCase(trainingStatus)) {
        					System.out.println(dog.getName() + ":\nIn service country: " 
        							+ dog.getInServiceLocation());
        					System.out.println();
        				}
        			}
        		}
        		
        		System.out.println("\n\n\t--Available Monkeys--");
        		for (Monkey monkey: monkeyList) {
        			if(monkey.getReserved() == false) {
        				if (monkey.getTrainingStatus().equalsIgnoreCase(trainingStatus)) {
        					System.out.println(monkey.getName()+ ":\nIn service country: " 
        							+ monkey.getInServiceLocation());
        					System.out.println();
        				}
        			}
        		}
        	}
        }
        
        // menu constructors
		public static char getMenuSelection() {
			return menuSelection;
		}
	
		public static void setMenuSelection(char menuSelection) {
			Driver.menuSelection = menuSelection;
		}
}
		
		
