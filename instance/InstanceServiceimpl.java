package instance;

public class InstanceServiceimpl implements  InstanceService{
    private static InstanceServiceimpl instance = new InstanceServiceimpl();

    private InstanceRepository instanceRepository;

    private InstanceServiceimpl(){
        this.instanceRepository = InstanceRepository.getInstance();
    }


    public static InstanceServiceimpl getInstance() {
        return instance;
    }
}
