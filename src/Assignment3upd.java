import java.util.Arrays;
import java.util.Scanner;

public class Assignment3upd {

    public static void print_array(int[] array) { // Using a method for printing array elements because we are going to print arrays several times.

        for (int i = 0; i < array.length; i++) {

            System.out.println("Index " + i + " : " + array[i]);
        }
    }

    public static void print_multiarray(int[][] array, int line, int column) { //Method for printing multiple arrays.

        for (int i = 0; i < line; i++) {

            for (int j = 0; j < column; j++) {

                System.out.print(array[i][j] + "\t" + "\t");
            }
            System.out.println(""); //We write that to go to the bottom line
        }
    }

    public static int[] sort_array(int[] array) { // Using a method for sorting array elements because we might sort arrays several times. And also for question 1.

        Arrays.sort(array);

        return array;
    }

    public static int[] remove_duplicate(int[] array) { //Question 1:

        sort_array(array); //We sort our array first as we will check the consecutive elements to see if the elements are duplicates.

        int[] temporary = new int[array.length];

        int k = 0; //This integer to filling our temporary array
        int x = 0; //This integer to find the number of elements of our resulting array after eliminating duplicate elements


        for (int i = 0; i < array.length - 1; i++) {

            int j = i + 1; //This integer to check consecutive elements.

            if (array[i] != array[j]) { //That means there is no duplicate for index "i".

                temporary[k] = array[i];

                k++;
                j++;
            }
            x++;
        }

        temporary[k] = array[array.length - 1]; //Here we add the last element of our array because we could not check it at the top lines.

        int[] whitelist = new int[array.length - (x - k)]; //Here we create a new array for the correct number of elements. Because if we don't do this, the return array will contain zeros as much as the copy elements.

        for (int i = 0; i < array.length - (x - k); i++) {

            whitelist[i] = temporary[i];
        }

        return whitelist;
    }

    public static void elements_frequency(int[] array) { //Question 2

        for (int i = 0; i < array.length; i++) {

            int counter = 0; //This integer will count the frequency of elements.

            for (int j = 0; j < array.length; j++) {

                if (array[j] == array[i]) {

                    counter++;

                    if (counter > 1) { //That means the frequency of the element of index "i" will be more than one.

                        array[j] = ' '; /*Here we are converting a copy of our element into something else (which is not likely to be in this array so I used a character).
                         Because at the end of our method our array shouldn't have the same number of elements hence, we will eliminate the 'something else' (char) in our array.*/
                    }
                }
            }

            if (array[i] != ' ') { //We are eliminating the 'something else'

                System.out.println("Frequency of " + array[i] + " is: " + counter);
            }
        }
    }

    public static int[][] input_3x3matrix() { //With this method we can take a 3x3 matrix from user. And we are going to use that for question 3.

        Scanner scanner = new Scanner(System.in);


        System.out.println("Please enter a 3x3 matrix (start with first line): ");


        int[][] matrix = new int[3][3];

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    public static int determinant_matrix(int[][] array) { //Question 3

        //Here we can use simple math to calculate the determinant because in this method we are going to calculate the determinant of only 3x3 matrix.
        int dtr = array[0][0] * array[1][1] * array[2][2] + array[0][1] * array[1][2] * array[2][0] + array[0][2] * array[1][0] * array[2][1];
        int dtr1 = array[2][0] * array[1][1] * array[0][2] + array[2][1] * array[1][2] * array[0][0] + array[2][2] * array[1][0] * array[0][1];

        int result = (dtr) - (dtr1);

        return result;
    }

    public static int[][] input_matrix(int line, int column) {  // Using a method for taking matrix elements from user. I don't use this method for question 3's input because we already know the line and column number for question 3's input.
        Scanner input = new Scanner(System.in);

        int[][] matrix = new int[line][column];

        System.out.println("Please enter your matrix (start with first line) : ");

        for (int i = 0; i < line; i++) {

            for (int j = 0; j < column; j++) {

                matrix[i][j] = input.nextInt();

            }
        }

        return matrix;
    }

    public static int[][] multiply_matrix(int [][] array1,int line1, int column1, int[][] array2, int line2, int column2){ //Question 4

        int[][] multiply = new int[line1][column2];

        for (int i= 0; i < line1; i++)
        {
            for (int j = 0; j < column2; j++)
            {
                for (int k  = 0; k < line2; k++)
                {
                    multiply[i][j] += array1[i][k]*array2[k][j];
                }
            }
        }

        return multiply;
    }


    public static void main(String[] args){

        int [] a = {80, 12, 30, 50, 50, 25, 57, 25, 17, 42, 30, 25};

        print_array(remove_duplicate(a));// -QUESTION 1-

        //************************************************************************


        int b [] = {80, 12, 30, 50, 50, 25, 57, 25, 17, 42, 30, 25}; // -QUESTION 2- I created a new array that is the same as above because array 'a' returned, as has already been sorted and duplicate elements have been removed in question 1.

        System.out.println("****************************************");

        elements_frequency(b);

        System.out.println("****************************************");

        //************************************************************************


        int [][] matrix = input_3x3matrix(); // -QUESTION 3-

        System.out.println("Your 3x3 matrix: ");

        print_multiarray(matrix,3,3);

        System.out.print("Determinant of your 3x3 matrix = ");

        System.out.println(determinant_matrix(matrix));

        System.out.println("****************************************");

        //************************************************************************


        Scanner input = new Scanner(System.in); //  -QUESTION 4-

        System.out.println("How many lines will your first matrix consist of?"); // We are taking the line and column number as an integer from the user.
        int line1 = input.nextInt();

        System.out.println("How many columns will your first matrix consist of?");
        int column1 = input.nextInt();

        int matrix1[][] = new int[line1][column1]; //First matrix.
        matrix1 = input_matrix(line1,column1);


        System.out.println("How many lines will your second matrix consist of?");
        int line2 = input.nextInt();

        System.out.println("How many columns will your second matrix consist of?");
        int column2 = input.nextInt();

        int matrix2[][] = new int[line2][column2]; //Second matrix.



        if (column1 != line2) { //Checking mechanism to be able to make proper multiplication.
            System.out.println("Matrices are inappropriate for multiplication.");
        }
        else
        {
            matrix2 = input_matrix(line2,column2); // We defined the matrix 2 in here because if matrices are inappropriate for multiplication, matrix 2 does not need to be entered.

            System.out.println("The product of your matrices: ");

            print_multiarray(multiply_matrix(matrix1,line1,column1,matrix2,line2,column2),line1,column2);

        }
    }
}
