import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver{
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    
    // Instance variables (if needed)

    public static void main(String[] args) {

    	initializeDogList();					//Initialize List for Dogs and Monkeys
	    initializeMonkeyList();
	    
	    Scanner scnr = new Scanner(System.in); 	// scanner class object
	    char option;
	    
	    do 										// loop until user exits application
	    {
	        displayMenu();
	        option = scnr.next().charAt(0);
	        if (option == '1') { 				// intakeNewDog method is called
	        	intakeNewDog();
	        }
	        
	        else if (option == '2') { 			// intakeNewMonkey method is called
	            intakeNewMonkey();
	        }
	        
	        else if (option == '3') { 			// reserveAnimal method is called
	            reserveAnimal();
	        }
	        
	        else if (option == '4') { 			// printAnimals method is called to print the dog list
	        	printAnimals(option);
	        }
	        
	        else if (option == '5') { 			// printAnimals method is called to print the monkey list
	            printAnimals(option);
	        }
	        
	        else if (option == '6') { 			// printAnimals method is called to print all available animals
	            printAnimals(option);
	        }
	        
	        else if (option == 'q') { 			// exit message prints and application stops running
	            System.out.print("You have exited the application.");
	            break;
	        }
	        
	        else { 								// in the event of an invalid input, tells user and prompts for a new input
	            System.out.print("You have entered an invalid input. Please enter a valid input.");
	        }
	    }
	    while (option != 'q');
	}

												// This method prints the menu options
	public static void displayMenu() {
	    System.out.println("\n\n");
	    System.out.println("\t\t\t\tRescue Animal System Menu");
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

    											// Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    											// Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Guenter", "Capuchin", "male", "1", "80", "08-03-1999",
    			"United States", "in service", false, "United States", "16", "36", "32");
    	monkeyList.add(monkey1);
    }


    											// intakeNewDog method sets data for all attributes
    											// based on user's inputs
    public static void intakeNewDog() {
    	try {
	    	Scanner scanner = new Scanner (System.in);
	    	System.out.println("\tIntake New Dog");
	    	System.out.println("What is the dog's name?");
	    	String name = scanner.nextLine();
	    	
	        for(Dog dog: dogList) {  			//validates that dog is not already checked in
	            if(dog.getName().equalsIgnoreCase(name)) {
	                System.out.println("\n\nThis dog is already in our system\n\n");
	                return; 					//returns to menu
	            }
	        }
	        while (name == "") {				//validates that user enters dog identifier
	        	System.out.println("Name must be at least one character long.");
	        	System.out.println("What is the dog's name?");
	        	name = scanner.nextLine();
	        }
	        System.out.println("What is the dog's breed?"); 
	        String breed = scanner.nextLine();
	        System.out.println("What is the dog's gender?");
	        String gender = scanner.nextLine();
	        System.out.println("What is the dog's age?");
	        String age = scanner.nextLine();
	        System.out.println("What is the dog's weight?");
	        String weight = scanner.nextLine();
	        System.out.println("What is the dog's acquisition date?");
	        String acquisitionDate = scanner.nextLine();
	        System.out.println("What is the dog's acquisition country?");
	        String acquisitionCountry = scanner.nextLine();
	        System.out.println("What is the dog's training status?");
	        String trainingStatus = scanner.nextLine();
	        System.out.println("Is this dog reserved? (Please enter True or False)");
	        boolean reserved = scanner.nextBoolean();
	        scanner.nextLine();
	        System.out.println("Which country is the dog in service?");
	        String inServiceCountry = scanner.nextLine();
	        
	        									// Assign users attributes to dog object and adds object to dog ArrayList
			Dog dog4 = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
	        dogList.add(dog4);
	        System.out.println("Your entry has been added to the Dog List."); 
        }catch (InputMismatchException e) {
        	System.out.println("Must answer True or False");
        	return;
        	}
        }
    
        										// intakeNewMonkey method
    	public static void intakeNewMonkey() {
    		try {
	    		Scanner scanner = new Scanner(System.in);
	            System.out.println("\tIntake New Monkey");
	    		System.out.println("What is the monkey's name?");
	            String name = scanner.nextLine();
	            								// validate the input to make sure the monkey doesn't already exist
	            for (Monkey monkey: monkeyList) {
	                if (monkey.getName().equalsIgnoreCase(name)) {
	                    System.out.println("\nThis monkey is already in our system\n\n");
	                    return;
	               }
	            }
	            								//validates that user enters monkey identifier
	            while (name == "") {
	            	System.out.println("Name must be at least one character long.");
	            	System.out.println("What is the monkey's name?");
	            	name = scanner.nextLine();
	            } 
	            
	            System.out.println("What is the monkey's species?");
	            String species = scanner.nextLine();
	            								// validate the species type is allowed
	            while(!(species.equalsIgnoreCase("Capuchin"))&& !(species.equalsIgnoreCase("Guenon"))&&!(species.equalsIgnoreCase("Macaque"))
	            		&&!(species.equalsIgnoreCase("Marmoset"))&&!(species.equalsIgnoreCase("Squirrel Monkey"))&&!(species.equalsIgnoreCase("Tamarin"))){
	            	System.out.println("Please enter one of the following: Capuchin, Guenon, Macaque, Marmoset, Squirrel Monkey, or Tamarin");
	            	System.out.println("What is the monkey's species?");
	            	species = scanner.nextLine();
	            }
	            System.out.println("What is the monkey's gender?");
	            String gender = scanner.nextLine();
	            System.out.println("What is the monkey's age?");
	            String age = scanner.nextLine();
	            System.out.println("What is the monkey's weight?");
	            String weight = scanner.nextLine();
	            System.out.println("What is the monkey's acquisition date?");
	            String acquisitionDate = scanner.nextLine();
	            System.out.println("What is the monkey's acquisition country?");
	            String acquisitionCountry = scanner.nextLine();
	            System.out.println("What is the monkey's training status?");
	            String trainingStatus = scanner.nextLine();
	            System.out.println("Is this monkey reserved? (Please enter True or False)");
	            boolean reserved = scanner.nextBoolean();
	            scanner.nextLine();
	            System.out.println("Which country is the monkey in service?");
	            String inServiceCountry = scanner.nextLine();
	            System.out.println("What is the tail length?");
	            String tailLength = scanner.nextLine();
	            System.out.println("What is the height?");
	            String height = scanner.nextLine();
	            System.out.println("What is the body length?");
	            String bodyLength = scanner.nextLine();
	            								// Instantiate and add the new monkey to the appropriate list
	            Monkey monkey2 = new Monkey(name, species, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength);
	            monkeyList.add(monkey2);
	            System.out.println("Your entry has been added to the Monkey List.");
	            return;
			}catch(InputMismatchException e) {
				System.out.println("Invalid input format");
				return;
			}
    	}

        										// Complete reserveAnimal method
    											// Find the animal by animal type and in service country
        public static void reserveAnimal() {
        	System.out.println("\tReserve an animal");
        	Scanner scanner = new Scanner(System.in);
            System.out.println("Which animal type would you like to reserve?: ");
            String animalType = scanner.nextLine();
            if (animalType.equalsIgnoreCase("Monkey")) {
                System.out.println("Enter the monkey's country of service: ");
                String country = scanner.nextLine();
                for (Monkey monkey: monkeyList) {
                    if (monkey.getInServiceLocation().equalsIgnoreCase(country)) {
                    	if(monkey.getReserved()== true) {
                    		System.out.println("This Monkey is currently reserved.");
                    		System.out.println("Please pick another.");
                    		return;
                    	}
                    	else {
                            monkey.setReserved(true);
                            System.out.println("This monkey is now reserved.");
                            return;
                    	}
                    }
                    else {
                    	System.out.println("This monkey is not on file.");
                    	System.out.println("Please try another name.");
                    	return;
                    }
                }
            }

        if (animalType.equalsIgnoreCase("Dog")) {
            System.out.println("Enter the Dog's country of Acquisition: ");
            String country = scanner.nextLine();
            for(Dog dog: dogList) {  			//validates that dog is not already checked in
            	if(dog.getInServiceLocation().equalsIgnoreCase(country)) {
                	if(dog.getReserved()== true) {
                		System.out.println("This Dog is currently reserved.");
                		System.out.println("Please pick another.");
                		return;
                		}
                	else {
                        dog.setReserved(true);
                        System.out.println("This dog is now reserved.");
                        return;
                		}
            		}
                }
            }
        }


        										// The printAnimals() method has three different outputs
        										// based on the listType parameter
        										// 4 - prints the list of dogs
        										// 5 - prints the list of monkeys
        										// 6 - prints a combined list of all animals that are
        										// fully trained ("in service") but not reserved 
        
        										// printAnimals method
	public static void printAnimals(char ListType) {

		char option = ListType;
	    if (option == '4') {
	    System.out.println("\tDog List");
	        if (dogList.size() > 0) {			// Include the animal name, status, acquisition country and if the animal is reserved.
	        	for (Dog dog: dogList) {
	        		System.out.println("Name: " + dog.getName() + "\tStatus: "+dog.getTrainingStatus()
	        		+ "\tAcquisition Country: "+dog.getAcquisitionLocation()+ "\tReserved: "+dog.getReserved());
	        	}
	        }
	        else {
	           System.out.println("\nThere are no dogs to list.");
	        }
	    	
	    }
	    else if (option == '5') {
	    	System.out.println("\t Monkey List");
	    	if (monkeyList.size() > 0) {
	    		for (Monkey monkey: monkeyList) {// Include the animal name, status, acquisition country and if the animal is reserved.
	        		System.out.println("Name: " + monkey.getName() + "\tStatus: "+monkey.getTrainingStatus()
	        		+ "\tAcquisition Country: "+monkey.getAcquisitionLocation()+ "\tReserved: "+monkey.getReserved());
	    		}
	    	}
	        else {
	           System.out.println("\nThere are no monkeys to list.");
	        }
	    }
	    
	    else if (option == '6') {				//List name and country of all animals available
	    	System.out.println("\tAll animals that are both in service and available:");
	    	for (Dog dog: dogList) {			
	            if (dog.getTrainingStatus().equals("in service") && dog.getReserved()==false) {
	                System.out.println("Name: "+dog.getName()+"\tCountry: "+dog.getInServiceLocation());
	            }
	        }
	    	for (Monkey monkey: monkeyList) {
	            if (monkey.getTrainingStatus().equals("in service") && monkey.getReserved()==false) {
	                System.out.println("Name: "+monkey.getName()+"\tCountry: "+monkey.getInServiceLocation());
	            }
	        }
	    }
	
	}
}


