class NamedCow extends Cow
{
    private String name;

    public NamedCow(String name, String sound) {
        super("cow", sound);
        this.name = name;
    }

    public NamedCow(String type, String name, String sound) {
        super(type, sound);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
