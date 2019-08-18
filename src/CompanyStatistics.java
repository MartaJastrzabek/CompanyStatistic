import java.util.Arrays;

public class CompanyStatistics {
    private Employee[] employees;

    public CompanyStatistics(Employee[] employees) {
        this.employees = employees;
    }

    private double averageSalary(){
        int counter = 0;
        int salarySum = 0;
        for(Employee e : employees){
            salarySum += e.getSalary();
            counter++;
        }
        return salarySum/counter;
    }

    public String getAverageSalary () {
        return "Średnia wypłata: " + averageSalary();
    }

    private int lowestSalary(){
        int lowest = employees[0].getSalary();
        for (Employee e: employees){
            if(e.getSalary() < lowest){
                lowest = e.getSalary();
            }
        }
        return lowest;
    }

    public String getLowestSalary () {
        return "Najniższa wypłata: " + lowestSalary();
    }

    private int highestSalary(){
        int highest = employees[0].getSalary();
        for (Employee e: employees){
            if(e.getSalary() > highest){
                highest = e.getSalary();
            }
        }
        return highest;
    }

    public String getHighestSalary () {
        return "Najwyższa wypłata: " + highestSalary();
    }

    private String[] createDepartamentArray(){
        String[] departaments = new String[3];
        int counter = 0;
        for (Employee e : employees){
            boolean isFound = false;
            for (int i = 0; i < departaments.length; i++){
                if(e.getDepartment().equals(departaments[i])){
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                departaments[counter] = e.getDepartment();
                counter++;
            }
        }
        System.out.println(Arrays.toString(departaments));
        return departaments;
    }

    private int departamentEmployeesNumber(String department){
        int counter = 0;
        for (Employee e : employees){
            if(e.getDepartment().equals(department)){
                counter++;
            }
        }
        return counter;
    }



    private String getDepartamentsEmployeesNumber(){
        String[] departments = createDepartamentArray();
        int[] employeesNumber = new int[departments.length];
        String toPrint = null;

        for(int i = 0; i < departments.length; i++){
            employeesNumber[i] = departamentEmployeesNumber(departments[i]);
            toPrint += "Liczba pracowników w dziale " + departments[i] + ": " + employeesNumber[i] + "\n";
        }

        return toPrint;
    }

    public String toString() {
        return getAverageSalary() + "\n"
                + getLowestSalary() + "\n"
                + getHighestSalary() + "\n"
                + getDepartamentsEmployeesNumber();
    }
}
