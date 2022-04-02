package de.timedin.jUtils.methods;

import java.util.List;

@SuppressWarnings("unused")
public class Misc {
    private Object getNextObjectInList(Object object, List<?> list) {
        int nextIndex = 1;
        for (Object items : list) {
            if (object.equals(items)) {
                if (nextIndex >= list.size()) {
                    return null;
                }
                return list.get(nextIndex);
            }
            nextIndex++;
        }
        return null;
    }
}
