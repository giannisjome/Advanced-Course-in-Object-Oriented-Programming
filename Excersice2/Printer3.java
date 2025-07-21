class Printer3 implements Decorator, Printer {
    private final Decorator baseDecorator = new Fancy();

    @Override
    public String decorate(String input) {
        return "--" + baseDecorator.decorate(input) + "--";
    }

    @Override
    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public void run() {
        print(decorate("main"));
    }
}
