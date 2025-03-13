package bt;

import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        class BookManager {
            private Book[] bookList;
            private int bookCount;
            private Scanner scanner;

            public BookManager() {
                this.bookList = new Book[100];
                this.bookCount = 0;
                this.scanner = new Scanner(System.in);

            }

            public void displayBookList() {
                if (bookCount == 0) {
                    System.out.println("Danh sách sách trống.");
                    return;
                }
                for (int i = 0; i < bookCount; i++) {
                    bookList[i].displayData();
                }
            }

            public void addNewBook() {
                System.out.println("Nhập số sách cần thêm: ");
                int numberOfBook = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < numberOfBook; i++) {
                    System.out.println("Nhập thông tin cho sách thứ " + (i + 1) + ": ");
                    Book book = new Book();
                    book.inputData();
                    bookList[bookCount++] = book;
                    System.out.println("Sách thứ " + (i + 1) + " đã được thêm.");
                }
            }

            public void calculateProfit() {
                for (int i = 0; i < bookCount; i++) {
                    bookList[i].calInterset();
                }
                System.out.println("Lợi nhuận đã được tính cho tất cả sách.");
            }

            public void updateBook() {
                System.out.print("Nhập mã sách cần cập nhật: ");
                String bookId = scanner.nextLine();

                for (int i = 0; i < bookCount; i++) {
                    if (bookList[i].getBookId().equals(bookId)) {
                        int choice;
                        do {
                            System.out.println("\nChọn thông tin cần cập nhật:");
                            System.out.println("1. Tên sách");
                            System.out.println("2. Tác giả");
                            System.out.println("3. Giá nhập");
                            System.out.println("4. Giá bán");
                            System.out.println("5. Thoát cập nhật");
                            System.out.print("Nhập lựa chọn: ");
                            choice = scanner.nextInt();
                            scanner.nextLine();

                            switch (choice) {
                                case 1:
                                    System.out.print("Nhập tên sách mới: ");
                                    bookList[i].setBookName(scanner.nextLine());
                                    break;
                                case 2:
                                    System.out.print("Nhập tên tác giả mới: ");
                                    bookList[i].setAuthor(scanner.nextLine());
                                    break;
                                case 3:
                                    System.out.print("Nhập giá nhập mới: ");
                                    bookList[i].setImportPrice(scanner.nextDouble());
                                    scanner.nextLine();
                                    break;
                                case 4:
                                    System.out.print("Nhập giá bán mới: ");
                                    bookList[i].setExportPrice(scanner.nextDouble());
                                    scanner.nextLine();
                                    break;
                                case 5:
                                    System.out.println("Thoát cập nhật.");
                                    return;
                                default:
                                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại!");
                            }
                        } while (true);
                    }
                }
                System.out.println("Không tìm thấy sách có mã: " + bookId);
            }

            public void deleteBook() {
                System.out.print("Nhập mã sách cần xóa: ");
                String bookId = scanner.nextLine();
                for (int i = 0; i < bookCount; i++) {
                    if (bookList[i].getBookId().equals(bookId)) {
                        for (int j = i; j < bookCount - 1; j++) {
                            bookList[j] = bookList[j + 1];
                        }
                        bookList[--bookCount] = null;
                        System.out.println("Sách đã được xóa thành công.");
                        return;
                    }
                }
                System.out.println("Không tìm thấy sách cần xóa.");
            }

            public void sortBooksByProfit() {
                for (int i = 1; i < bookCount; i++) {
                    Book key = bookList[i];
                    int j = i - 1;
                    while (j >= 0 && bookList[j].getInterest() > key.getInterest()) {
                        bookList[j + 1] = bookList[j];
                        j--;
                    }
                    bookList[j + 1] = key;
                }
                System.out.println("Sách đã được sắp xếp theo lợi nhuận tăng dần.");
            }

            public void searchByAuthor() {
                System.out.print("Nhập tên tác giả: ");
                String author = scanner.nextLine();
                boolean found = false;
                for (int i = 0; i < bookCount; i++) {
                    if (bookList[i].getAuthor().equalsIgnoreCase(author)) {
                        bookList[i].displayData();
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Không tìm thấy sách của tác giả này.");
                }
            }
            public void searchByExport() {
                System.out.print("Giá từ: ");
                double start = scanner.nextDouble();
                System.out.print("Đến: ");
                double end = scanner.nextDouble();
                scanner.nextLine();
                for (int i = 0; i < bookCount; i++) {
                    if (bookList[i].getExportPrice() >= start && bookList[i].getExportPrice() <= end) {
                        bookList[i].displayData();
                    }
                }
            }

                public void bookStatistics() {
                    System.out.print("Nhập tên tác giả: ");
                    String authorName = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < bookCount; i++) {
                        if (bookList[i].getAuthor().equalsIgnoreCase(authorName)) {
                            bookList[i].displayData();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sách của tác giả: " + authorName);
                    }
                }
        }
        BookManager manager = new BookManager();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\n==========================MENU==========================");
            System.out.println("1. Danh sách sách");
            System.out.println("2. Thêm sách mới");
            System.out.println("3. Tính lợi nhuận sách");
            System.out.println("4. Cập nhật thông tin sách");
            System.out.println("5. Xóa sách");
            System.out.println("6. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("7. Tìm kiếm sách theo tác giả");
            System.out.println("8. Tìm kiếm sách theo khoảng giá (tìm theo khoảng giá bán)");
            System.out.println("9. Thống kê sách theo mỗi tác giả");
            System.out.println("10. Thoát chương trình");
            System.out.print("Chọn một tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Xử lý trôi lệnh
            switch (choice) {
                case 1:
                    manager.displayBookList();
                    break;
                case 2:
                    manager.addNewBook();
                    break;
                case 3:
                    manager.calculateProfit();
                    break;
                case 4:
                    manager.updateBook();
                    break;
                case 5:
                    manager.deleteBook();
                    break;
                case 6:
                    manager.sortBooksByProfit();
                    break;
                case 7:
                    manager.searchByAuthor();
                    break;
                case 8:
                    manager.searchByExport();
                    break;
                case 9:
                    manager.bookStatistics();
                    break;
                case 10:
                    System.out.println("Chương trình kết thúc.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
                    break;
            }
        }
    }
}

