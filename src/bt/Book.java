package bt;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Book {
    private String bookId;
    private String bookName;
    private double importPrice;
    private double exportPrice;
    private String title;
    private String author;
    private double interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, double importPrice, double exportPrice, String title, String author, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.author = author;
        this.year = year;
        this.interest = interest;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã sách (Bxxxx): ");
        while (true) {
            String input = scanner.nextLine();
            if (Pattern.matches("^B\\w{4}$", input)) {
                this.bookId = input;
                break;
            } else {
                System.out.print("Mã không hợp lệ. Phải bắt đầu bằng 'B' và có 5 ký tự . Nhập lại: ");
            }
        }

        System.out.print("Nhập tên sách: ");
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty() && input.length() >= 6 && input.length() <= 100) {
                this.bookName = input;
                break;
            } else {
                System.out.print("Tên sách phải từ 6 đến 100 ký tự. Nhập lại: ");
            }
        }

        System.out.print("Nhập giá nhập: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Giá nhập phải là số dương!");
            scanner.next();
        }
        this.importPrice = scanner.nextDouble();
        scanner.nextLine(); // Xử lý trôi lệnh

        System.out.print("Nhập giá bán: ");
        while (true) {
            while (!scanner.hasNextDouble()) {
                System.out.println("Giá bán phải là số!");
                scanner.next();
            }
            this.exportPrice = scanner.nextDouble();
            scanner.nextLine(); // Xử lý trôi lệnh
            if (this.exportPrice >= this.importPrice * 1.1) {
                break;
            } else {
                System.out.print("Giá bán phải cao hơn giá nhập ít nhất 10%. Nhập lại: ");
            }
        }

        System.out.print("Nhập tiêu đề: ");
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                this.title = input;
                break;
            } else {
                System.out.print("Tiêu đề không được để trống. Nhập lại: ");
            }
        }

        System.out.print("Nhập tên tác giả: ");
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                this.author = input;
                break;
            } else {
                System.out.print("Tên tác giả không được để trống. Nhập lại: ");
            }
        }

        System.out.print("Nhập năm phát hành: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Năm phát hành phải là số nguyên!");
            scanner.next();
        }
        this.year = scanner.nextInt();
        while (this.year <= 1970) {
            System.out.print("Năm phát hành phải sau 1970. Nhập lại: ");
            this.year = scanner.nextInt();
        }
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayData() {
        System.out.println("Mã sách: " + getBookId());
        System.out.println("Tên sách: " + getBookName());
        System.out.println("Giá nhập: " + getImportPrice());
        System.out.println("Giá xuất: " + getExportPrice());
        System.out.println("Tiêu đề:" + getTitle());
        System.out.println("Tác giả: " + getAuthor());
        System.out.println("Năm phát hành: " + getYear());
        System.out.println("Thuế: " + getInterest());
        System.out.println("Giá bán: " + (getExportPrice() + (getExportPrice() * getInterest())));
    }

    public void calInterset() {
        this.interest = this.exportPrice - this.importPrice;
    }

}
