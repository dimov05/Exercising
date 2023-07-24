package academy.customLinkedList;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<String> cLList = new CustomLinkedList<>();
        cLList.add("Test 1");
        cLList.add("Test 2");
        cLList.add("Test 3");
        System.out.println(cLList + "  -- Added 3 elements");
        cLList.removeAtIndex(1);
        System.out.println(cLList + "  -- Removed element at index 1");
        cLList.add("Test 4");
        cLList.add("Test 1");
        System.out.println(cLList + "  -- Added 2 more elements");
        cLList.remove("Test 1");
        System.out.println(cLList + "  -- Removed first found element by given element");
//        System.out.println(cLList.get(1) + "  -- Get element at index 1");
        CustomLinkedList<String> cLListToAdd = new CustomLinkedList<>();
        cLListToAdd.add("Test 5");
        cLListToAdd.add("Test 4");
        cLListToAdd.add("Test 7");
        cLList.addAll(cLListToAdd);
        System.out.println(cLList + "  -- Added 3 elements by add all");
//        System.out.println(cLList.get(3) + "  -- get Element by index 3(Test 5)");
//        System.out.println(cLList.getSize() + "  -- return size of list(should be 6)");
//        System.out.println(cLList.indexOf("Test 7") + "  -- return index of element(Test 7 -> index = 5 )");
//        System.out.println(cLList.lastIndexOf("Test 4") + "  -- returns last index of Element(Test 4 -> index = 4)");
//        System.out.println(cLList.contains("Test 4") + " -- Checks if list contains element (true)");
//        System.out.println(cLList.contains("Test 23") + " -- Checks if list contains element (false)");
//        System.out.println(cLList.containsAll(cLListToAdd) + "  -- checks if list containsAll elements from other list (true)");
        cLListToAdd.add("Test 231231");
//        System.out.println(cLList.containsAll(cLListToAdd) + "  -- checks if list containsAll elements from other list (false)");
        System.out.println(cLList.getSize() + "  -- prints size(should be 6)");
        cLList.clear();
        System.out.println(cLList.getSize() + "  -- prints size after .clear(should be 0)");
        System.out.println(cLList.isEmpty() + "  -- checks if isEmpty (true)");
        cLList.addAll(cLListToAdd);
        System.out.println(cLList.isEmpty() + "  -- checks if isEmpty (false)");

    }
}
