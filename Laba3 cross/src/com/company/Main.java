package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // 3. Определяем размеры массива
    static final int SIZE_X = 5;
    static final int SIZE_Y = 5;
    static final int WIN_COUNT = 4;

    // 1. Создаем двумерный массив
    static char[][] field = new char[SIZE_Y][SIZE_X];

    // 2. Обозначаем кто будет ходить какими фишками
    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = '0';
    static final char EMPTY_DOT = '.';

    // 8. Создаем сканер
    static Scanner scanner = new Scanner(System.in);
    // 12. Создаем рандом
    static final Random rand = new Random();

    // 4. Заполняем на массив
    private static void initField() {
        for(int i = 0; i < SIZE_Y; i++) {
            for(int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    // 5. Выводим на массив на печать
    private static void printField() {
        //6. украшаем картинку
        System.out.println("-------");
        for(int i = 0; i < SIZE_Y; i++) {
            System.out.print("|");
            for(int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        //6. украшаем картинку
        System.out.println("-------");
    }

    // 7. Метод который устанавливает символ
    private static void setSym(int y, int x, char sym){
        field[y][x] = sym;
    }

    // 9. Ход игрока
    private static void playerStep(int y, int x) {
        // 11. с проверкой

        setSym(y, x, PLAYER_DOT);

    }

    // 13. Ход ПК
    private static void aiStep(int y, int x) {

        int rand_x;
        int rand_y;
        do{
            rand_x = rand.nextInt(2) + x;
            rand_y = rand.nextInt(2) + y;
        } while(!isCellValid(rand_y,rand_x));

        setSym(rand_y, rand_x, AI_DOT);
    }

    // 14. Проверка победы
    private static boolean checkWin(char sym) {

        for (int i = 0; i < SIZE_X; i++){
            int row_summ = 0;
            int col_summ = 0;
            for (int j = 0; j < SIZE_Y; j++){
                if (field[i][j] == sym){
                    row_summ++;
                    if (row_summ == WIN_COUNT){
                        return true;
                    }
                }
                else {
                    row_summ = 0;
                }
                if (field[j][i] == sym){
                    col_summ++;
                    if (col_summ == WIN_COUNT){
                        return true;
                    }
                }
                else {
                    col_summ = 0;
                }
            }
        }

        int diag_summ;
        for (int i = 0; i < SIZE_X; i++){
            diag_summ = 0;
            for (int j = 0; j < SIZE_Y; j++){
                if (j + i < SIZE_X){
                    if (field[j][j+i] == sym){
                        diag_summ++;
                        if (diag_summ == WIN_COUNT){
                            return true;
                        }
                    }
                    else{
                        diag_summ = 0;
                    }
                }
            }
        }

        for (int i = 1; i < SIZE_X; i++){
            diag_summ = 0;
            for (int j = 0; j < SIZE_Y; j++){
                if (j - i >= 0){
                    if (field[j][j-i] == sym){
                        diag_summ++;
                        if (diag_summ == WIN_COUNT){
                            return true;
                        }
                    }
                    else{
                        diag_summ = 0;
                    }
                }
            }
        }

        int inv_diag_summ;
        for (int i = 0; i < SIZE_X; i++){
            inv_diag_summ = 0;
            for (int j = 0; j < SIZE_Y; j++){
                if (SIZE_Y - 1 - j - i >= 0){
                    if (field[j][SIZE_Y - 1 - j - i] == sym){
                        inv_diag_summ++;
                        if (inv_diag_summ == WIN_COUNT){
                            return true;
                        }
                    }
                    else{
                        inv_diag_summ = 0;
                    }
                }
            }
        }

        for (int i = 1; i < SIZE_X; i++){
            inv_diag_summ = 0;
            for (int j = 0; j < SIZE_Y; j++){
                if (SIZE_Y - 1 - j + i < SIZE_X){
                    if (field[j][SIZE_Y - 1 - j + i] == sym){
                        inv_diag_summ++;
                        if (inv_diag_summ == WIN_COUNT){
                            return true;
                        }
                    }
                    else{
                        inv_diag_summ = 0;
                    }
                }
            }
        }
        return false;
    }

    // 16. Проверка полное ли поле? возможно ли ходить?
    private static boolean isFieldFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for(int j = 0; j < SIZE_X; j++) {
                if(field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    // 10. Проверяем возможен ли ход
    private static boolean isCellValid(int y, int x) {
        // если вываливаемся за пределы возвращаем false
        if(x < 0 || y < 0 || x > SIZE_X -1 || y > SIZE_Y - 1) {
            return false;
        }
        // если не путое поле тоже false
        return (field[y][x] == EMPTY_DOT);
    }

    public static void main(String[] args) {
        // 1 - 1 иницируем и выводим на печать
        initField();
        printField();
        // 1 - 1 иницируем и выводим на печать

        // 15 Основной ход программы

        while (true) {
            int x;
            int y;
            do {
                System.out.println("Введите координаты: X Y (1-" + SIZE_X + ")");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } while (!isCellValid(y,x));
            playerStep(y, x);
            printField();
            if(checkWin(PLAYER_DOT)) {
                System.out.println("Player WIN!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW");
                break;
            }

            aiStep(y, x);
            printField();
            if(checkWin(AI_DOT)) {
                System.out.println("Win SkyNet!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW!");
                break;
            }
        }

    }
}
