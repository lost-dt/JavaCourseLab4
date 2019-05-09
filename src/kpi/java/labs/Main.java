package kpi.java.labs;

import java.util.*;

public class Main {

    private static void setRandomNumbers(List<Long> inputArray, int sizeOfArray) {
        Random rand = new Random();
        for(int i = 0; i < sizeOfArray; i++) {
            inputArray.add((long) rand.nextInt(100));
        }

    }

    private static List<Long> createList() {
        int typeOfCollection = 0;
        Scanner in = new Scanner(System.in);
        while (typeOfCollection > 2 || typeOfCollection < 1) {
            System.out.println("Enter type of collection: \n{\n\tLinkedList - 1, \n\tArrayList - 2\n}");
            typeOfCollection = in.nextInt();
        }
        System.out.println("Enter size of array: ");
        int sizeOfArray = in.nextInt();


        List<Long> returnedList = null;
        switch (typeOfCollection) {
            case 1: {
                returnedList = new LinkedList<>();
                break;
            }
            case 2: {
                returnedList = new ArrayList<>(sizeOfArray);
                break;
            }
        }

        setRandomNumbers(returnedList, sizeOfArray);

        return returnedList;

    }

    private static Long findLowestSameNumber(List<Long> inputList) {

        System.out.println("Enter the number to find: ");
        Scanner in = new Scanner(System.in);
        int inputNumber = in.nextInt();
        in.close();

        Long resultLowestNumber = inputList.get(0);

        Iterator<Long> inputListIterator = inputList.iterator();

        while (inputListIterator.hasNext()) {
            Long nextNumber = inputListIterator.next();
            if (Math.abs(nextNumber - inputNumber) < Math.abs(resultLowestNumber - inputNumber)) {
                resultLowestNumber = nextNumber;
            }
        }


        return resultLowestNumber;
    }

    public static void main(String[] args) {

        List<Long> mainList = createList();

        System.out.println("Result array: " + mainList);

        Long lowestNumber = findLowestSameNumber(mainList);
        System.out.println("Result number: " + lowestNumber);

    }

}
