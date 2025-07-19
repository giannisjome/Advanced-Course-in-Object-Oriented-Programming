// Base class for generating random values
class RandomGenerator {
    // Returns a random Object – can be Integer, String, or Object
    Object generate() {
        var random = new java.util.Random();
        return switch (random.nextInt(4)) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> "three";
            default -> new Object();
        };
    }
}

// Subclass that is supposed to generate only Integers
class RandomIntegerGenerator extends RandomGenerator {

    
    // - This method tries to override 'generate()', but its return type is 'Integer' instead of 'Object'.
    // - Java method overriding requires the return type to be the same or a covariant type.
    // - 'Integer' is not considered a covariant return of 'Object' in this context.
    // - Because the original method returns Object, this is treated as a NEW method, not an override.
    @Override
    Integer generate() {
        return new java.util.Random().nextInt(64);
    }
}
