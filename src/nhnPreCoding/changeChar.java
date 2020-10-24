package nhnPreCoding;

import java.util.Scanner;

public class changeChar {
    static String[] result;
    static boolean flag;

    private static void solution(int numOfOrder, String[] orderArr) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        result = new String[numOfOrder];
        for (int i = 0; i < numOfOrder; i++) {
            String[] array_word;
            flag = false;
            int number = 0;
            result[i]="";

            array_word = orderArr[i].split("");

            for (int j = 0; j < array_word.length; j++) {
                char checkChar = array_word[j].charAt(0);
                if (checkChar >= 48 && checkChar <= 58) {
                    flag = true;
                    number = Integer.valueOf(array_word[j]);
                }else if (checkChar == '(') {
                    j=changeChar(j+1, array_word, flag, number, i);
                } else if (checkChar == ')') {
                    flag = false;
                }else {
                    result[i] += checkChar;
                }
            }
        }


        for (int i = 0; i < numOfOrder; i++) {
            System.out.println(result[i]);
        }
    }

    public static int changeChar(int startNum, String[] array_word, boolean flag, int number, int charCount) {
        String mulChar = "";
        for(int i=startNum;i<array_word.length;i++) {
            char checkChar = array_word[i].charAt(0);
            if (checkChar >= 48 && checkChar <= 58) {
                flag = true;
                number = Integer.valueOf(array_word[i]);
            } else if (checkChar == '(') {
                i = changeChar(i+1, array_word, flag, number, charCount);
            } else if (checkChar == ')') {
                flag = false;
                for (int k = 0; k < number; k++) {
                    result[charCount] += mulChar;
                }
                return i;
            } else {
                if (flag) {
                    mulChar += checkChar;
                } else {
                    result[charCount] += mulChar;
                }
            }
        }
        return 0;
    }

    private static class InputData {
        int numOfOrder;
        String[] orderArr;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.orderArr = new String[inputData.numOfOrder];
            for (int i = 0; i < inputData.numOfOrder; i++) {
                inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfOrder, inputData.orderArr);
    }
}

