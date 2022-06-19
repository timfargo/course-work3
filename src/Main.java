public class Main {
    private static final Employee[] EMPLOYEES = new Employee[10];

    public static void main(String[] args) {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            EMPLOYEES[i] = generateEmployee(i + 1, (int) (1 + (5 - 1 + 1) * Math.random()));
        }
        printAllEmployees();
        double totalSalaries = totalSalaries();
        System.out.println("Сумма ЗП всех сотрудников за месяц" + totalSalaries);
        Employee employeeWithMinSalary = findEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной ЗП" + employeeWithMinSalary);
        Employee employeeWithMaxSalary = findEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной ЗП:" + employeeWithMaxSalary);
        double averageSalary = averageSalary();
        System.out.printf("Средняя ЗП всех сотрудников за месяц", averageSalary);
    }

    private static double averageSalary() {
        return totalSalaries() / EMPLOYEES.length;
    }

    private static Employee findEmployeeWithMinSalary() {
        double minSalary = 56_800;
        int index = -1;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i].getSalary() < minSalary) {
                minSalary = EMPLOYEES[i].getSalary();
                index = i;
            }
        }
        if (index != -1) {
            return EMPLOYEES[index];
        } else {
            return null;
        }
    }

    private static Employee findEmployeeWithMaxSalary() {
        double maxSalary = 160_500;
        int index = -1;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i].getSalary() > maxSalary) {
                maxSalary = EMPLOYEES[i].getSalary();
                index = i;
            }
        }
        if (index != -1) {
            return EMPLOYEES[index];
        } else {
            return null;
        }
    }

    private static double totalSalaries() {
        double sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }


    private static void printFullNameEmployees() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getSurname() + "" + employee.getName() + "" + employee.getPatronymic());
        }
    }

    private static void printAllEmployees() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static Employee generateEmployee(int i, int department) {
        int start = 56_800;
        int end = 160_500;
        return new Employee(
                "Name" + i,
                "Surname" + i,
                "Patronymic" + i,
                start + (end - start) * Math.random(),
                department
        );

    }
}