public class PokemonBox {

	// CONSTANT VARIABLES
	public static final int DEFAULT_CAPACITY = 10;

	// INSTANCE VARIABLES
	private Pokemon[] caught;
	private int numCaught;

	// CONSTRUCTORS
	public PokemonBox(Pokemon[] caught) {
		if(caught == null || caught.length == 0) {
			System.out.println("ERROR: Invalid Pokemon array provided to PokemonBox. Exiting program.");
			System.exit(0);
		}
		this.numCaught = caught.length;
		this.caught = this.deepCopyArray(caught, this.numCaught*2);
	}

	public PokemonBox() {
		this.caught = new Pokemon[DEFAULT_CAPACITY];
		this.numCaught = 0;
	}

	// ACCESSOR/GETTER METHODS
	//returns -1 if not found
	public int getLocation(String pokemonName) {
		int location = -1, count = 0;
		//loop until we reach end of array or we find item
		while(count < this.numCaught && location == -1) {
			if(this.caught[count].getName().equalsIgnoreCase(pokemonName)) {
				//found pokemon!
				location = count;
			} else {
				//didnt find pokemon, setup for next loop
				count++;
			}
		}
		return location;
	}

	public Pokemon getPokemon(int location) {
		return this.caught[location];
	}

	public int getNumCaught() {
		return this.numCaught;
	}

	public boolean isEmpty() {
		return this.numCaught == 0;
	}

	public boolean hasPokemon(String pokemonName) {
		return this.getLocation(pokemonName) != -1;
	}

	// MUTATOR/SETTER METHODS
	public void add(Pokemon newPoke) {
		//new pokemon,  add to partially filled array
		//but first check if box is full
		if(this.numCaught == this.caught.length) {
			//if full, then grow array *2 and copy contents over
			this.caught = this.deepCopyArray(this.caught, this.numCaught*2);
		}

		//then add new caught pokemon
		this.caught[this.numCaught] = new Pokemon(newPoke);
		this.numCaught++;
	}
	
	// OTHER REQUIRED METHODS
	public String toString() {
		if(this.isEmpty()) {
			return "This box is empty";
		} else {
			String all = "\t01. " + this.caught[0].toRow();
			for(int i = 1; i < this.numCaught; i++) {
				all += String.format("%n\t%02d. %s", i+1, this.caught[i].toRow());
			}

			return String.format("This box has %d Pokemon, which are:%n%s",
				this.numCaught, all);
		}
	}

	private Pokemon[] deepCopyArray(Pokemon[] p, int newLength) {
		Pokemon[] deepCopy = new Pokemon[newLength];
		
		for(int i = 0; i < p.length; i++) {
			deepCopy[i] = new Pokemon(p[i]);
		}

		return deepCopy;
	}
}