import javax.swing.*;

class Simulation {
    public static void main(String args[]) {
        JFrame f = new JFrame();
        int employeeNumber = 1;
        int payRanges[] = {299, 399, 499, 599, 699, 799, 899, 999, 1000};
        int TotalclassificationLabels[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean shouldContinue = false;
        String classificationLabels[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

        System.out.println("------TRYING SIMULATION------");

        do {
            double employeeGross = Integer.parseInt(JOptionPane.showInputDialog(f, "Employee " + employeeNumber + " Gross:"));
            if (employeeGross <= 100000 && employeeGross >= 0) {
                double bonus = (9.0 / 100) * employeeGross;
                double total = bonus + 200.0;
                System.out.println("Employee #" + employeeNumber);
                System.out.println("Week Gross " + employeeNumber + ": " + String.format("%.2f", employeeGross));
                System.out.println("Week Bonus " + employeeNumber + ": " + String.format("%.2f", bonus));
                System.out.println("Week Total " + employeeNumber + ": " + String.format("%.2f", total));
                for (int i = 0; i < payRanges.length; i++) {
                    if (i == 0) {
                        if (total < payRanges[i]) {
                            TotalclassificationLabels[i]++;
                            System.out.println("Classification " + employeeNumber + ": " + classificationLabels[i]);
                        }
                    } else {
                        if (total <= payRanges[i] && total > payRanges[i - 1]) {
                            TotalclassificationLabels[i]++;
                            System.out.println("Classification " + employeeNumber + ": " + classificationLabels[i]);
                        }
                        if (i == payRanges.length - 1 && total > payRanges[i]) {
                            TotalclassificationLabels[i]++;
                            System.out.println("Classification " + employeeNumber + ": " + classificationLabels[i]);
                        }
                    }
                }
                System.out.println("--------");
            } else {
                System.out.println("------SIMULATION FAIL------");
                System.exit(0);
            }
            employeeNumber++;
            String checkIfContinue = JOptionPane.showInputDialog(f, "Enter Another Employee? \n [0] : yes \n [1] : no").toLowerCase();
            switch (checkIfContinue) {
                case "yes":
                    shouldContinue = true;
                    break;
                case "no":
                    shouldContinue = false;
                    for (int i = 0; i < TotalclassificationLabels.length; i++) {
                        System.out.println("There are " + TotalclassificationLabels[i] + " Employees in class " + classificationLabels[i]);
                    }
                    System.out.println("------SIMULATION SUCCESSFUL------");
                    break;
                default:
                    shouldContinue = false;
                    System.out.println("------SIMULATION FAIL------");
                    break;
            }
        } while (shouldContinue);
        System.exit(0);
    }
}