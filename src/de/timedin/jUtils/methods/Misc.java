package de.timedin.jUtils.methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("unused")
public class Misc {
    public static Object getNextObjectInList(Object currentObject, List<?> list) throws NullPointerException {
        int nextIndex = 1;
        if (!list.contains(currentObject)) {
            throw new NullPointerException("Given value not found in list.");
        }
        for (Object items : list) {
            if (currentObject.equals(items)) {
                if (nextIndex >= list.size()) {
                    throw new NullPointerException("Given value is last value in list.");
                }
                return list.get(nextIndex);
            }
            nextIndex++;
        }
        throw new NullPointerException("Unknown Exception.");
    }

    public static String getNextStringInList(String currentString, List<String> list) {
        return (String) getNextObjectInList(currentString, list);
    }

    public static Integer getNextIntegerInList(Integer currentInteger, List<Integer> list) {
        return (Integer) getNextObjectInList(currentInteger, list);
    }

    public static Character getNextCharInList(Character currentCharacter, List<Character> list) {
        return (Character) getNextObjectInList(currentCharacter, list);
    }

    public static Float getNextFloatInList(Float currentFloat, List<Float> list) {
        return (Float) getNextObjectInList(currentFloat, list);
    }

    public static Double getNextDoubleInList(Double currentDouble, List<Double> list) {
        return (Double) getNextObjectInList(currentDouble, list);
    }

    public static boolean getNextBooleanInList(Boolean currentBoolean, List<Boolean> list) throws NullPointerException {
        return (Boolean) getNextObjectInList(currentBoolean, list);
    }

    public static ArrayList<?> getNextArrayListInList(List<?> currentArrayList, List<ArrayList<?>> list) {
        return (ArrayList<?>) getNextObjectInList(currentArrayList, list);
    }

    public static HashMap<?, ?> getNextHashMapInList(HashMap<?, ?> currentHashMap, List<HashMap<?, ?>> list) {
        return (HashMap<?, ?>) getNextObjectInList(currentHashMap, list);
    }
}
