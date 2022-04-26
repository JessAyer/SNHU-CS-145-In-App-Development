public class Monkey extends RescueAnimal {

    // Instance variable
    private String species;
    private String tailLength;
    private String monkeyHeight;
    private String bodyLength;
  
    // Constructor
    public Monkey(String name, String species, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry, 
	String tailLenght, String height, String bodyLength) {
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);

    }


	// Accessor Method
    public String getSpecies() {
        return species;
    }
    public String getTailLength() {
    	return tailLength;
    }
    public String getMonkeyHeight() {
    	return monkeyHeight;
    }
    public String getBodyLength() {
    	return bodyLength;
    }

    
    // Mutator Method
    public void setSpecies(String MonkeySpecies) {
        species = MonkeySpecies;
    }
    public void setTailLength(String tail) {
		tailLength = tail;		
	}
	public void setHeight(String height) {
		monkeyHeight = height;
		
	}
	public void setBodyLength(String length) {
		bodyLength = length;
	}

}
