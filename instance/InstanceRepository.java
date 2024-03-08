package instance;

public class InstanceRepository {
    private static InstanceRepository instance = new InstanceRepository();

    private InstanceRepository(){}


    public static InstanceRepository getInstance() {
        return instance;
    }
}
