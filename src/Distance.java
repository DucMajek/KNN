public class Distance implements Comparable<Distance> {

    private final IrisType irisTest;
    private final IrisType irisTrain;
    private final double distance;

    public Distance(IrisType irisTest, IrisType irisTrain, double distance) {
        this.irisTest = irisTest;
        this.irisTrain = irisTrain;
        this.distance = distance;
    }

    public IrisType getIrisTrain() {
        return irisTrain;
    }


    @Override
    public int compareTo(Distance secondDistance) {
        return Double.compare(this.distance, secondDistance.distance);
    }
}
