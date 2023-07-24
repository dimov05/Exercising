package academy.customList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        CustomList<String> cList = new CustomList<>();
        LinkedList<String> ll = new LinkedList<>();
        cList.add("Test 1");
        cList.add("Test 2");
        cList.add("Test 3");
        System.out.println(cList + "  -- Added 3 elements");
        cList.remove(1);
        System.out.println(cList + "  -- Removed element at index 1");
        cList.add("Test 4");
        cList.add("Test 1");
//        System.out.println(cList + "  -- Added 2 more elements");
        cList.remove("Test 1");
//        System.out.println(cList + "  -- Removed all elements by given element");
//        System.out.println(cList.get(1) + "  -- Get element at index 1");
        CustomList<String> cListToAdd = new CustomList<>();
        cList.add("Test 5");
        cList.add("Test 4");
        cList.add("Test 7");
        cList.addAll(cListToAdd);
//        System.out.println(cList + "  -- Added 3 elements by add all");
//        System.out.println(cList.get(3) + "  -- get Element by index 3(Test 4)");
//        System.out.println(cList.getSize() + "  -- return size of list");
//        System.out.println(cList.indexOf("Test 5") + "  -- return index of element(Test 5)");

//        System.out.println(cList.lastIndexOf("Test 4") + "  -- returns last index of Element");
//        System.out.println(cList.contains("Test 4") + " -- Checks if list contains element (true)");
//        System.out.println(cList.contains("Test 23") + " -- Checks if list contains element (false)");
//        System.out.println(cList.containsAll(cListToAdd) + "  -- checks if list containsAll elements from other list (true)");
        cListToAdd.add("Test 231231");
//        System.out.println(cList.containsAll(cListToAdd) + "  -- checks if list containsAll elements from other list (false)");
//        System.out.println(cList.getSize() + "  -- prints size");
//        cList.clear();
//        System.out.println(cList.getSize() + "  -- prints size after .clear");
//        System.out.println(cList.isEmpty() + "  -- checks if isEmpty (true)");
        cList.addAll(cListToAdd);
//        System.out.println(cList.isEmpty() + "  -- checks if isEmpty (false)");
        System.out.println(cList);
        cList.addByIndex(3,"TEST ADD BY INDEX");
        System.out.println(cList);
    }
}
