import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập kích thước của ma trận vuông (n x n)
        System.out.print("Nhập kích thước n của ma trận vuông: ");
        int n = scanner.nextInt();

        // 2. Kiểm tra điều kiện hợp lệ của n
        if (n <= 0) {
            System.out.println("Ma trận không hợp lệ");
            scanner.close();
            return;
        }

        // 3. Khởi tạo và nhập giá trị cho ma trận
        int[][] matrix = new int[n][n];
        System.out.println("Nhập các phần tử cho ma trận (theo từng hàng):");
        for (int i = 0; i < n; i++) {
            System.out.print("Hàng " + (i + 1) + ": ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 4. Xoay ma trận 90 độ theo chiều kim đồng hồ
        // Bước 4.1: Chuyển vị ma trận (hoán đổi hàng và cột)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Bước 4.2: Đảo ngược thứ tự các cột của ma trận chuyển vị
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

        // 5. In kết quả ma trận sau khi xoay 90 độ
        System.out.println("Ma trận sau khi xoay 90 độ theo chiều kim đồng hồ:");
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + (j < n - 1 ? "," : ""));
            }
            System.out.print("]" + (i < n - 1 ? "," : ""));
        }
        System.out.println("]");

        scanner.close();
    }
}