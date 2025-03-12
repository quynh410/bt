package ihw;

import java.util.Scanner;
import java.util.regex.Pattern;

enum Gender {
    MALE, FEMALE, OTHER;
}

public class Student {
    private int std_id;
    private String std_name;
    private int std_age;
    private Gender std_gender;
    private String std_address;
    private String std_phoneNumber;

    public Student() {
    }

    public Student(int id, String name, int age, Gender gender, String address, String phoneNumber) {
        this.std_id = id;
        this.std_name = name;
        this.std_age = age;
        this.std_gender = gender;
        this.std_address = address;
        this.std_phoneNumber = phoneNumber;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã sinh viên: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Mã sinh viên phải là số nguyên!");
            scanner.next();
        }
        this.std_id = scanner.nextInt();
        scanner.nextLine(); // Xử lý trôi lệnh

        System.out.print("Nhập tên Sinh viên: ");
        this.std_name = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Tuổi phải là số nguyên!");
            scanner.next();
        }
        this.std_age = scanner.nextInt();
        scanner.nextLine(); // Xử lý trôi lệnh

        System.out.print("Nhập giới tính (MALE/FEMALE/OTHER): ");
        while (true) {
            String genderInput = scanner.nextLine().toUpperCase();

            switch (genderInput) {
                case "MALE":
                    this.std_gender = Gender.MALE;
                    break;
                case "FEMALE":
                    this.std_gender = Gender.FEMALE;
                    break;
                case "OTHER":
                    this.std_gender = Gender.OTHER;
                    break;
                default:
                    System.out.print("Giới tính không hợp lệ. Nhập lại (MALE/FEMALE/OTHER): ");
                    continue;
            }
            break;
        }

        System.out.print("Nhập địa chỉ: ");
        this.std_address = scanner.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String phoneRegex = "(091|092|098|035)\\d{7}";
        do {
            this.std_phoneNumber = scanner.nextLine();
            if (Pattern.matches(phoneRegex, this.std_phoneNumber)) {
                break;
            } else {
                System.out.println("Định dạng số điện thoại không đúng, vui lòng nhập lại");
            }
        } while (true);

    }

    public void displayData() {
        System.out.println("Mã Sinh Viên: " + std_id);
        System.out.println("Tên Sinh viên: " + std_name);
        System.out.println("Tuổi: " + std_age);
        System.out.println("Giới tính: " + (this.std_gender == Gender.MALE ? "Nam" : (this.std_gender == Gender.FEMALE ? "Nữ" : "Khác")));
        System.out.println("Địa chỉ: " + std_address);
        System.out.println("Số điện thoại: " + std_phoneNumber);
        System.out.println("---------------------------------");
    }

    // Getter và Setter

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public int getStd_age() {
        return std_age;
    }

    public void setStd_age(int std_age) {
        this.std_age = std_age;
    }

    public Gender getStd_gender() {
        return std_gender;
    }

    public void setStd_gender(Gender std_gender) {
        this.std_gender = std_gender;
    }

    public String getStd_address() {
        return std_address;
    }

    public void setStd_address(String std_address) {
        this.std_address = std_address;
    }

    public String getStd_phoneNumber() {
        return std_phoneNumber;
    }

    public void setStd_phoneNumber(String std_phoneNumber) {
        this.std_phoneNumber = std_phoneNumber;
    }
}
