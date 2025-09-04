package Lab_5;
import java.util.ArrayList;

import java.util.Scanner;

public class arrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdvancedArrayListOps ops = new AdvancedArrayListOps();

        int choice;
        do {
            System.out.println("\n--- Advanced ArrayList Operations ---");
            System.out.println("1. Append");
            System.out.println("2. Insert");
            System.out.println("3. Search");
            System.out.println("4. Starts With");
            System.out.println("5. Ascending Sort");
            System.out.println("6. Descending Sort");
            System.out.println("7. Regex Match");
            System.out.println("8. Display");
            System.out.println("9. Remove Duplicate elements");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    String str1 = sc.nextLine();
                    ops.append(str1);
                    System.out.println("Appended successfully!");
                    break;

                case 2:
                    System.out.print("Enter string to insert: ");
                    String str2 = sc.nextLine();
                    System.out.print("Enter index: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    try {
                        ops.insert(str2, index);
                        System.out.println("Inserted successfully!");
                    } catch (Exception e) {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 3:
                    System.out.print("Enter string to search: ");
                    String str3 = sc.nextLine();
                    boolean found = ops.Search(str3);
                    System.out.println(found ? "Found!" : "Not Found!");
                    break;

                case 4:
                    System.out.print("Enter Starting letter: ");
                    String prefix = sc.nextLine();
                    ArrayList<String> startsList = ops.Starts(prefix);
                    System.out.println("Strings starting with '" + prefix + "': " + startsList);
                    break;

                case 5:
                    ops.AscendingSortList();
                    System.out.println("List sorted in Ascending order.");
                    break;

                case 6:
                    ops.DescendingSortList();
                    System.out.println("List sorted in Descending order.");
                    break;

                case 7:
                    System.out.print("Enter regex pattern: ");
                    String regex = sc.nextLine();
                    ArrayList<String> matchedList = ops.match(regex);
                    System.out.println("Matching strings: " + matchedList);
                    break;
                case 8:
                    ops.display();
                    break;
                case 9:
                    ArrayList<String> newlist = ops.RemoveDuplicate();
                    System.out.println("List after removing duplicate elements" + newlist);
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;

                
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 10);

        sc.close();
    }
}
