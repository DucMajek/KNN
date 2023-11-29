import java.util.*;

public class KNN {

    public static void knnAlgorithm(List<IrisType> irisTestList, List<IrisType> irisTrainList, int k, boolean information) {
        String answer = "";
        double correctAnswer = 0;


        for (IrisType iris_test : irisTestList) {

            List<Distance> distanceList = new ArrayList<>();

            for (IrisType iris_train : irisTrainList)
                distanceList.add(new Distance(iris_test, iris_train, getDistanceBetweenNodes(iris_test, iris_train)));

            Collections.sort(distanceList);


            double correctVectors = 0;
            List<String> list = new ArrayList<>();
            Set<String> set = new HashSet<>();


            for (int i = 0; i < k; i++) {
                list.add(distanceList.get(i).getIrisTrain().getIrisName());
                set.add((distanceList.get(i)).getIrisTrain().getIrisName());

                if (distanceList.get(i).getIrisTrain().getIrisName().equals(iris_test.getIrisName()))
                    correctVectors++;

            }
            int max = 0;


            for (String s : set) {
                int count = 0;
                for (String t : list) {
                    if (s.equals(t)) {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                    answer = s;
                }
            }


            if (answer.equals(iris_test.getIrisName()))
                correctAnswer++;

            System.out.println("K: " + k);
            System.out.println("KNN: " + answer);

            if (information) {
                double outputVectors = (correctVectors / k) * 100;
                String finalOutput = String.format("Trafność wektorów: %.2f%%", outputVectors);

                System.out.println(finalOutput);
                System.out.println("Poprawna odpowiedz: " + iris_test.getIrisName());
            }
            System.out.println(" ");

        }


        if (information) {
            int consoleWidth = 80;
            double accuracy = (correctAnswer / irisTestList.size()) * 100;
            String output = String.format("Accuracy: %.2f%%", accuracy);

            int padding = (consoleWidth - output.length()) / 2;

            for (int i = 0; i < padding; i++) {
                System.out.print("\t");
            }
            System.out.println(output);
        }

    }

    public static double getDistanceBetweenNodes(IrisType iris1, IrisType iris2) {
        double distance = 0;

        for (int i = 0; i < iris1.getIrisVectors().size(); i++) {
            distance += Math.pow(iris1.getIrisVectors().get(i) - iris2.getIrisVectors().get(i), 2);
        }

        return distance;
    }
}
