package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File input = new File("input.txt");
        Scanner scan_ = new Scanner(System.in);
        System.out.println("Enter the desired type:");
        String type = scan_.nextLine();

        File dir = new File("outputs");
        Boolean dir_cr = dir.mkdirs();
        String path = "outputs\\output_" + type + ".txt";
        File output = new File(path);

        try {

            FileWriter myWriter = new FileWriter(path);

            try (Scanner scan = new Scanner(input)) {

                while (scan.hasNextLine()) {
                    String s = scan.nextLine();

                    // Определяем тип
                    String b_type = "Int";
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == '.' && b_type.equals("Int")) {
                            b_type = "Float";
                        }
                        if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != '.') {
                            b_type = "Word";
                        }
                    }
                    if (b_type.equals("Word") && s.length() == 1) {
                        b_type = "Char";
                    }
                    // Тип определен

                    if (b_type.equals(type)) {
                        // Выводим подобранные строки в файл
                        myWriter.write(s + '\n');

                    }
                }

            }
            catch (FileNotFoundException exp) {

                System.out.println("No input file found!");

            }
            myWriter.close();

        } catch (IOException e) {

            System.out.println("Output file exception!");

        }
    }
}
