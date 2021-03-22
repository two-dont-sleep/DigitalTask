import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        var scanner = new Scanner(System.in);
        var importedString = scanner.nextLine();

        var resultString = unpack(importedString);
        System.out.println("Resulted string: " + resultString);
    }

    public static String unpack (String importedString) {
        //returns result in case no inner substrings are found
        if (!importedString.contains("[")) {
            System.out.println("repeat: " + importedString);
            return importedString;
        }


        var stringLen = importedString.length();
        var resultString = "";
        var numberOfRepeats = "";
        var endIndex  = -1;

        for (int i = 0; i < stringLen; i++) {

            var ch = importedString.charAt(i);


            //skip the part between []
            if (i <= endIndex)
                continue;

            if (Character.isDigit(ch)) {

                numberOfRepeats += ch;
                System.out.println("Got to 32 line, numberOfR =" + numberOfRepeats);
                var nextChar = importedString.charAt(i + 1);


                if (!Character.isDigit(nextChar)) {
                    endIndex = findIndexOfBracket(i+1, importedString);
                    System.out.println("Got to 36 line, endIndex " + endIndex);
                    System.out.println("Got to 37 line, numberOfR =" + numberOfRepeats + ", i = " + i);

                    resultString += unpack(importedString.substring(i + 2, endIndex)).
                            repeat(Integer.parseInt(numberOfRepeats));
                    numberOfRepeats = "";
                }
            } else {
                System.out.println("check");
                resultString += ch;
            }
        }

        return resultString;
    }


    //returns the index of closing bracket, that matches the particular opening bracket
    public static int findIndexOfBracket(int i, String importedString) {

        var numberOfOpeningBrackets = 1;
        var numberOfClosingBrackets = 0;
        int index = i + 1;

        while (numberOfOpeningBrackets != numberOfClosingBrackets ) {
            if (importedString.charAt(index) == '[')
                numberOfOpeningBrackets++;
            if (importedString.charAt(index) == ']')
                numberOfClosingBrackets++;
            index++;
        }

        return index-1;
    }

}



