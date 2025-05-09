import java.util.Scanner;
public class date {
    public int day;
    public int month;
    public int year;

 
    public void displayDate() {
        System.out.println("Date: " + day + "/" + month + "/" + year);
    }
    public void setDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter day: ");
        this.day = scanner.nextInt();    
        System.out.print("Enter month: ");
        this.month = scanner.nextInt();
        System.out.print("Enter year: ");
        this.year = scanner.nextInt();
    
    }
}