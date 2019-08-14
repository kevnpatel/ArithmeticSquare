package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String [][] table = new String[3][3];
        String [] temp;
        String[][] tempTable = new String[3][3];
        boolean flipped = false;

        for (int i = 0; i < 3; i++){

            temp = s.nextLine().split(" ", 3);

            for (int j = 0; j < 3; j++){

                table[i][j] = temp[j];

            }
        }

        System.out.println();


        while (table[0][0].charAt(0) == 'X' || table[0][1].charAt(0) == 'X' || table[0][2].charAt(0) == 'X' ||
                table[1][0].charAt(0) == 'X' || table[1][1].charAt(0) == 'X' || table[1][2].charAt(0) == 'X' ||
                table[2][0].charAt(0) == 'X' || table[2][1].charAt(0) == 'X' || table[2][2].charAt(0) == 'X') {

            for (int i = 0; i < 3; i++) {

                if (table[i][0].charAt(0) == 'X' || table[i][1].charAt(0) == 'X' || table[i][2].charAt(0) == 'X') {

                    if (table[i][0].charAt(0) == 'X' & table[i][1].charAt(0) == 'X' & table[i][2].charAt(0) == 'X') {


                    } else {

                        // first case

                        if (table[i][0].charAt(0) != 'X' & table[i][1].charAt(0) != 'X' & table[i][2].charAt(0) == 'X') {

                            table[i][2] = Integer.toString(((Integer.parseInt(table[i][1]) - Integer.parseInt(table[i][0]))
                                    + Integer.parseInt(table[i][1])));

                        } else if (table[i][0].charAt(0) != 'X' & table[i][1].charAt(0) == 'X' & table[i][2].charAt(0) != 'X') {

                            table[i][1] = Integer.toString((Integer.parseInt(table[i][0]) +
                                    Integer.parseInt(table[i][2])) / 2);

                        } else if (table[i][0].charAt(0) == 'X' & table[i][1].charAt(0) != 'X' & table[i][2].charAt(0) != 'X') {

                            table[i][0] = Integer.toString((Integer.parseInt(table[i][1]) - (Integer.parseInt(table[i][2])
                                    - Integer.parseInt(table[i][1]))));

                        } else {

                            if (table[i][0].charAt(0) != 'X') {

                                table[i][1] = table[i][0];
                                table[i][2] = table[i][0];

                            } else if (table[i][1].charAt(0) != 'X') {

                                table[i][0] = table[i][1];
                                table[i][2] = table[i][1];

                            } else if (table[i][2].charAt(0) != 'X') {

                                table[i][0] = table[i][2];
                                table[i][1] = table[i][2];
                            }


                        }


                    }

                }
            }

            // If there are still x's in the table, rotate it and try again

            if (flipped == false){

                flipped = true;

                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){

                        tempTable[i][j] = table[i][j];
                    }
                }

                for (int i = 0; i < 3; i++){

                    for (int j = 0; j < 3; j++){
                        table[2 - j][i] = tempTable[i][j];

                    }
                }

            }else{

                flipped = false;


                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){

                        tempTable[i][j] = table[i][j];
                    }
                }

                for (int i = 0; i < 3; i++){

                    for (int j = 0; j < 3; j++){
                        table[i][j] = tempTable[2 - j ][i];

                    }
                }

            }
        }

        if (flipped == true){

            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){

                    tempTable[i][j] = table[i][j];
                }
            }

            for (int i = 0; i < 3; i++){

                for (int j = 0; j < 3; j++){
                    table[i][j] = tempTable[2 - j ][i];

                }
            }
        }

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.print(table[i][j] + " ");

            }

            System.out.println();
        }
    }
}
