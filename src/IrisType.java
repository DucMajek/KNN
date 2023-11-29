import java.util.List;

public class IrisType {
    private final List<Double> irisVectors;
    private final String irisName;

    public IrisType(List<Double> irisVectors, String irisName) {
        this.irisVectors = irisVectors;
        this.irisName = irisName;
    }


    public List<Double> getIrisVectors() {
        return irisVectors;
    }

    public String getIrisName() {
        return irisName;
    }

}
