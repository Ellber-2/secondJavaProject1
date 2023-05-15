package org.testing;

import java.util.Scanner;

            public class Main {
                public static void main(String[] args) {

                    Scanner scanner = new Scanner(System.in);
                    boolean validInput = false;
                    WebsiteTesting WebsiteTesting = new WebsiteTesting ();

                    while (!validInput) {
                        System.out.println("Press 1:.. 2:.. 3:.. 4:.. 5:.. 6:.. 7:..");
                        String userInput = scanner.next();



                        switch(userInput) {
                            case "1":
                                //verify.assertDownloadCertificate();
                                validInput=true;
                                break;
                            case "2":
                                System.out.println("Task 2 performed");
                                validInput=true;
                                break;
                            case "3":
                                System.out.println("Task 3 performed");
                                validInput=true;
                                break;
                            case "4":
                                System.out.println("Task 4 performed");
                                validInput=true;
                                break;
                            case "5":
                                System.out.println("Task 5 performed");
                                validInput=true;
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                    }
                }




            }








