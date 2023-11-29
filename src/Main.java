import java.io.*;
import java.util.*;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        List<IrisType> irisTrainList;
        List<IrisType> irisTestList;
        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj K:");
        while (!scan.hasNextInt()) {
            System.out.println("Nie podałeś liczby, spróbuj ponownie:");
            scan.next();
        }
        int k = scan.nextInt();


        System.out.println("Podaj nazwe pliku treningowego bez .txt");
        String trainName = scan.next();
        File trainFile = new File(trainName + ".txt");

        while (!trainFile.exists()) {
            System.out.println("Plik treningowy nie istnieje, spróbuj ponownie:");
            trainName = scan.next();
            trainFile = new File(trainName + ".txt");
        }


        System.out.println("Podaj nazwe pliku testowego bez .txt");
        String testName = scan.next();
        File testFile = new File(testName + ".txt");
        while (!testFile.exists()) {
            System.out.println("Plik testowy nie istnieje, spróbuj ponownie:");
            testName = scan.next();
            testFile = new File(testName + ".txt");
        }

        irisTrainList = getIrisData(trainName);

        System.out.println("Chcesz podac własne parametry? Wpisz [tak/nie]");
        String option = scan.next();


        boolean yes = true;
        if (option.equals("tak")) {
            while (yes) {
                List<IrisType> irisType = new ArrayList<>();
                List<Double> irisVectors = new ArrayList<>();

                System.out.println("Podaj wektory (przykład 4;3;2;1) [ Pamiętaj o odzieleniu \";\"]");
                String line = scan.next();
                line += ";[Brak typu]";

                String[] tmp = line.split(";");

                for (int i = 0; i < tmp.length - 1; i++)
                    irisVectors.add(Double.parseDouble(tmp[i]));


                irisType.add(new IrisType(irisVectors, tmp[tmp.length - 1]));
                irisTestList = irisType;

                KNN.knnAlgorithm(irisTestList, irisTrainList, k, false);


                System.out.println(" ");
                System.out.println("Czy chcesz zakonczyć wprowadzanie własnych wektorów i przejsc do klasyfikacji k-NN? [tak/nie]");

                String option2 = scan.next();
                if (option2.equals("tak")) {
                    yes = false;
                }

            }

            irisTestList = getIrisData(testName);
            KNN.knnAlgorithm(irisTestList, irisTrainList, k, true);

        } else {
            irisTestList = getIrisData(testName);
            KNN.knnAlgorithm(irisTestList, irisTrainList, k, true);
        }


    }


    public static List<IrisType> getIrisData(String fileName) throws IOException {
        String line;
        String[] tmp;
        List<Double> irisVectors;
        List<IrisType> irisType = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"))) {
            while ((line = br.readLine()) != null) {
                tmp = line.split(";");

                irisVectors = new ArrayList<>();

                for (int i = 0; i < tmp.length - 1; i++)
                    irisVectors.add(Double.parseDouble(tmp[i]));

                irisType.add(new IrisType(irisVectors, tmp[tmp.length - 1]));

            }
        }
        return irisType;

    }
}




