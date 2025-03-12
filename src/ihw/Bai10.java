package ihw;

import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        class StudentManager {
            private Student[] students;
            private int studentCount;
            private Scanner sc;

            public StudentManager() {
                this.students = new Student[100];
                this.studentCount = 0;
                this.sc = new Scanner(System.in);
            }

            public void displayAllStudents() {
                if (studentCount == 0) {
                    System.out.println("Danh sách sinh viên trống.");
                } else {
                    System.out.println("=============Hiển thị sinh viên=============");
                    for (int i = 0; i < studentCount; i++) {
                        students[i].displayData();
                    }
                }
            }

            public void addStudent() {
                System.out.println("Nhập số sinh viên cần nhập thông tin: ");
                int numberOfStudents = Integer.parseInt(sc.nextLine());

                for (int i = 0; i < numberOfStudents; i++) {
                    System.out.println("Nhập thông tin cho sinh viên thứ " + (i + 1) + ":");
                    Student student = new Student();
                    student.inputData();
                    students[studentCount++] = student;
                    System.out.println("Thêm sinh viên thành công!");
                }
            }


            public void updateStudent() {
                System.out.print("Nhập mã sinh viên cần sửa: ");
                int id = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < studentCount; i++) {
                    if (students[i].getStd_id() == id) {
                        System.out.println("Nhập thông tin mới cho sinh viên: " + id);

                        while (true) {
                            System.out.println("\nChọn thông tin cần cập nhật:");
                            System.out.println("1. Tên sinh viên");
                            System.out.println("2. Tuổi");
                            System.out.println("3. Giới tính");
                            System.out.println("4. Số điện thoại");
                            System.out.println("5. Email");
                            System.out.println("6. Địa chỉ");
                            System.out.println("7. Thoát");
                            System.out.print("Nhập lựa chọn: ");

                            int choice = sc.nextInt();
                            sc.nextLine(); // Xử lý trôi lệnh

                            switch (choice) {
                                case 1:
                                    System.out.print("Nhập tên mới: ");
                                    students[i].setStd_name(sc.nextLine());
                                    break;
                                case 2:
                                    System.out.print("Nhập tuổi mới: ");
                                    students[i].setStd_age(Integer.parseInt(sc.nextLine()));
                                    break;
                                case 3:
                                    System.out.print("Nhập giới tính mới (Nam/Nữ/Khác): ");
                                    String genderInput = sc.nextLine().toLowerCase();

                                    switch (genderInput) {
                                        case "nam":
                                            students[i].setStd_gender(Gender.MALE);
                                            break;
                                        case "nữ":
                                            students[i].setStd_gender(Gender.FEMALE);
                                            break;
                                        case "khác":
                                            students[i].setStd_gender(Gender.OTHER);
                                            break;
                                        default:
                                            System.out.println("Giới tính không hợp lệ! Mặc định đặt thành 'Khác'.");
                                            students[i].setStd_gender(Gender.OTHER);
                                            break;
                                    }
                                    break;

                                case 4:
                                    System.out.print("Nhập số điện thoại mới: ");
                                    students[i].setStd_phoneNumber(sc.nextLine());
                                    break;
                                case 5:
                                    System.out.print("Nhập địa chỉ mới: ");
                                    students[i].setStd_address(sc.nextLine());
                                    break;
                                case 6:
                                    System.out.println("Cập nhật thông tin hoàn tất.");
                                    return;
                                default:
                                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                                    break;
                            }
                            System.out.println("Cập nhật thành công!\n");
                        }
                    }
                }
                System.out.println("Không tìm thấy sinh viên có mã: " + id);
            }


            public void deleteStudent() {
                System.out.print("Nhập mã sinh viên cần xóa: ");
                int id = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < studentCount; i++) {
                    if (students[i].getStd_id() == id) {
                        for (int j = i; j < studentCount - 1; j++) {
                            students[j] = students[j + 1];
                        }
                        students[--studentCount] = null;
                        System.out.println("Xóa sinh viên thành công!");
                        return;
                    }
                }
                System.out.println("Không tìm thấy sinh viên có mã: " + id);
            }
        }
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("----- MENU -----");
            System.out.println("1. Hiển thị danh sách tất cả sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa thông tin sinh viên dựa vào mã sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Xử lý trôi lệnh

            switch (choice) {
                case 1:
                    manager.displayAllStudents();
                    break;
                case 2:
                    manager.addStudent();
                    break;
                case 3:
                    manager.updateStudent();
                    break;
                case 4:
                    manager.deleteStudent();
                    break;
                case 5:
                    System.out.println("Chương trình kết thúc.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                    break;
            }
        }
    }
}
