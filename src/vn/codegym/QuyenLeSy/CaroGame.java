package vn.codegym.QuyenLeSy;

import java.util.Scanner;
import static java.lang.Character.isLetter;


public class CaroGame {

    char[][] charlocal;

    public static void main(String[] args) {
        CaroGame caroGame = new CaroGame();

        Scanner scanner = new Scanner(System.in);
        int i, j, x, y;
        char previous = 'x';

        System.out.println("Nhập vào kích thước bàn ca-rô");
        System.out.print("Số dòng: ");
        i = scanner.nextInt();
        System.out.print("Số cột: ");
        j = scanner.nextInt();

        boolean checklocal = false;
         caroGame.charlocal = new char[i][j];


        while (true) {
            do {
                System.out.print("Nhập vào tọa độ x: ");
                x = scanner.nextInt();
                System.out.print("Nhập vào tọa độ y: ");
                y = scanner.nextInt();


                if (x > i || y > j) {
                    System.out.println("Tọa độ lớn hơn kích thước bàn chơi!");
                    checklocal = true;
                } else if (isLetter(caroGame.charlocal[x - 1][y - 1])) {
                    System.out.println("Vị trí đã được ghi!");
                    checklocal = isLetter(caroGame.charlocal[x - 1][y - 1]);
                } else {
                    caroGame.charlocal[x - 1][y - 1] = previous;
                    playing(caroGame, i, j, x, y);
                    previous = previous == 'x' ? 'o' : 'x';
                }
            } while (checklocal == true);
        }
    }


    public static void playing(CaroGame caroGame, int i, int j, int x, int y){
        for (int row = 1; row <= i; row++)
        {
            if (row == 1){
                for (int col = 1; col <= j; col++)
                {
                    if (col == 1)
                        System.out.print("-----");
                    else
                        System.out.print("----");

                    if(col == j)
                        System.out.print("\n");
                }
            }

            boolean check = false;

            for (int col = 1; col <= j; col++)
            {
                if(isLetter(caroGame.charlocal[row-1][col-1]))
                    check = true;
                else
                    check =false;

                if(col == 1 && check)
                    System.out.print("| "+caroGame.charlocal[row-1][col-1]+" |");
                if(col == 1 && !check)
                    System.out.print("|   |");
                if(col != 1 && check)
                    System.out.print(" "+caroGame.charlocal[row-1][col-1]+" |");
                if(col != 1 && !check)
                    System.out.print("   |");

                if(col == j)
                    System.out.print("\n");
            }
            for (int col = 1; col <= j; col++)
            {
                if (col == 1)
                    System.out.print("-----");
                else
                    System.out.print("----");

                if(col == j)
                    System.out.print("\n");
            }
        }
    }

}
