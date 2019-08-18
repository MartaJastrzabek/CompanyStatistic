import java.io.*;

public class CompanyTest {
    private static final String INPUT_FILE_NAME = "employees.csv";
    private static final String OUTPUT_FILE_NAME = "company statistic.txt";

    public static void main(String[] args) {

        File file = new File(INPUT_FILE_NAME);
        File outputFile = new File(OUTPUT_FILE_NAME);
        int countLineNumber = 0;
        Employee[] employees;

        try {
            countLineNumber = getLineNumber(INPUT_FILE_NAME);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        employees = readFile(file, countLineNumber);



        CompanyStatistics statistics = new CompanyStatistics(employees);
        writeFile(outputFile, statistics);


    }

    private static void writeFile(File outputFile, CompanyStatistics statistics) {
        try {
            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(statistics.toString());
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Employee[] readFile(File file, int counter) {
        Employee[] employees = new Employee[counter];
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            int i = 0;
            while ((line = br.readLine()) != null){
                String[] employee = line.split(";");
                employees[i] = new Employee(employee[0], employee[1], employee[2], employee[3].toUpperCase(), Integer.parseInt(employee[4]));
                i++;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }

    private static int getLineNumber(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int lines = 0;
        while (reader.readLine() != null)
            lines++;
        reader.close();
        return lines;
    }

}
