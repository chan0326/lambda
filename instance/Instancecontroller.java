package instance;

public class Instancecontroller {
    private static Instancecontroller instance = new Instancecontroller();

    private InstanceServiceimpl instanceServiceimpl;

    private Instancecontroller(){

        this.instanceServiceimpl = InstanceServiceimpl.getInstance();
    }


    public static Instancecontroller getInstance() {
        return instance;
    }

}
