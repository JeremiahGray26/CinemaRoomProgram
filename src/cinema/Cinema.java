package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int rows = 0;
        int seats = 0;
        int totalSeats = 0;
        int rowNumber = 0;
        int seatNumber = 0;
        int ticketsPurchased = 0;


        System.out.println("Enter the number of rows:");
        rows = input.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = input.nextInt();
        totalSeats = rows * seats;
        String[][] diagram = new String[rows][seats + 1];

        for (int i = 0; i < diagram.length; i++) {
            for (int j = 0; j < diagram[0].length; j++) {
                diagram[i][j] = "S";
            }
        }

        System.out.println();


        chooseAction1(diagram, seats, rows, rowNumber, seatNumber, totalSeats);


    }

        //method that prints Cinema based on user input
        public static void printCinema(String[][]diagram,int cols){
            int counter = 1;
            System.out.println();
            System.out.println("Cinema:");
            System.out.print(" ");

            for (int i = 1; i <= cols; i++) {
                System.out.print(" " + i);
            }

            System.out.println();

            for (int i = 0; i < diagram.length; i++) {
                for (int j = 0; j < diagram[0].length; j++) {
                    diagram[i][0] = Integer.toString(counter);
                    System.out.print(diagram[i][j] + " ");
                }
                counter++;
                System.out.println();
            }
            System.out.println();
        }


        public static void markSeat(int rowNumber, int seatNumber, int totalSeats, int rows, String[][] diagram) {
            Scanner input = new Scanner(System.in);
            int ticketPrice = 0;

            System.out.println();
            System.out.println("Enter a row number:");
            rowNumber = input.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber = input.nextInt();

            diagram[rowNumber - 1][seatNumber] = "B";

            if (rowNumber <= rows / 2 || totalSeats <= 60) {
                ticketPrice = 10;
            } else if (rowNumber >= Math.ceil(rows / 2)) {
                ticketPrice = 8;
            }
            System.out.println("Ticket price: $" + ticketPrice);
            System.out.println();
            //ticketsPurchase++;
        }

        public static void printAgain(String[][]diagram, int cols) {
            System.out.println();
            System.out.println("Cinema:");
            System.out.print(" ");

            for (int i = 1; i <= cols; i++) {
                System.out.print(" " + i);
            }

            System.out.println();

            for (int i = 0; i < diagram.length; i++) {
                for (int j = 0; j < diagram[0].length; j++) {
                    System.out.print(diagram[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        public static void chooseAction1(String[][]diagram, int seats, int rows, int rowNumber, int seatNumber,
        int totalSeats) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printCinema(diagram, seats);
                    chooseAction1(diagram, seats, rows, rowNumber, seatNumber, totalSeats);
                    break;
                case 2:
                    markSeat(rowNumber, seatNumber, totalSeats, rows, diagram);
                    chooseAction1(diagram, seats, rows, rowNumber, seatNumber, totalSeats);
                    break;
                case 0:
                    return;
            }
        }

    }
