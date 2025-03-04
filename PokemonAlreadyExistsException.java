public class PokemonAlreadyExistsException extends Exception {

    // Default constructor
    public PokemonAlreadyExistsException() {
        super();
    }

    // Constructor that accepts a message
    public PokemonAlreadyExistsException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public PokemonAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public PokemonAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
