package com.amigoscode;


import java.util.Random;
import java.util.Scanner;

public class Main {


            public static void main(String[] args) {
                    Scanner scanner = new Scanner(System.in);
                    Random random = new Random();
                    boolean playAgain = false;

                    do {

                        System.out.print("Choose difficulty level (easy, medium, hard): ");
                        String difficulty = scanner.nextLine().trim().toLowerCase();
                        int maxAttempts = 0;


                        if (difficulty.equals("easy")) {
                            maxAttempts = 10;
                        }
                        else if (difficulty.equals("medium")) {
                            maxAttempts = 7;
                        }
                        else if (difficulty.equals("hard")) {
                            maxAttempts = 5;
                        } else {
                            System.out.println("Invalid difficulty level. Please try again.");
                            continue;
                        }

                        int numberToGuess = random.nextInt(100) + 1;
                        int attemptsLeft = maxAttempts;

                        System.out.println("I have selected a number between 1 and 100. You have " + maxAttempts + " attempts to guess it.");


                        while (attemptsLeft > 0) {
                            System.out.print("Enter your guess: ");
                            int guess = getGuess(scanner);


                            if (guess < 1 || guess > 100) {
                                System.out.println("Please enter a number between 1 and 100.");
                                continue; // Skip to the next iteration
                            }


                            if (guess < numberToGuess) {
                                System.out.println("Too low! Try again.");
                            } else if (guess > numberToGuess) {
                                System.out.println("Too high! Try again.");
                            } else {
                                System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly!");
                                break;
                            }

                            attemptsLeft--;
                            System.out.println("You have " + attemptsLeft + " attempts left.");
                        }

                        if (attemptsLeft == 0) {
                            System.out.println("Sorry, you've run out of attempts! The number was " + numberToGuess + ".");
                        }


                        System.out.print("Do you want to play again? (yes/no): ");
                        String response = scanner.nextLine().trim().toLowerCase();
                        playAgain = response.equals("yes");

                    } while (playAgain);

                    System.out.println("Thank you for playing! Goodbye!");
                    scanner.close();
                }


                private static int getGuess(Scanner scanner) {
                    try {
                        return Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        return -1;
                    }


            }
        }