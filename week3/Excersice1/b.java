// Interface that defines the contract for all natural resources
interface NaturalResource {
    // How much of the natural resources are left?
    float amountLeft();

    // Spend x percent
    void spend(float amount);
}

// A class representing a finite resource (Coal)
class Coal implements NaturalResource {
    private float left;

    Coal(float amount) {
        left = amount;
    }

    @Override
    public float amountLeft() {
        return left;
    }

    @Override
    public void spend(float amount) {
        left -= amount; // Valid implementation
    }
}

// A class representing a renewable resource (Hydroelectric)
class Hydroelectric implements NaturalResource {
    private float left = 100;

    @Override
    public float amountLeft() {
        return left;
    }

    // - This method is marked as 'private', but the interface requires it to be public.
    // - It's not overriding the interface method (visibility is too narrow).
    // - Also throws a checked exception 'Exception', but the interface does not declare it.
    // - So this method is not considered a valid implementation of 'spend()' by the compiler.
    private void spend(float amount) throws Exception {
        throw new Exception("Renewable is limitless!");
    }
}
