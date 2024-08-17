package Day17of45;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;

            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            int gaps = last - index - 1;

            if (last == words.length || gaps == 0) {
                for (int i = index + 1; i < last; i++) {
                    builder.append(" ").append(words[i]);
                }
                while (builder.length() < maxWidth) {
                    builder.append(" ");
                }
            } else {
                int spaces = (maxWidth - totalChars) / gaps;
                int extraSpaces = (maxWidth - totalChars) % gaps;

                for (int i = index + 1; i < last; i++) {
                    for (int s = 0; s <= spaces + (i - index <= extraSpaces ? 1 : 0); s++) {
                        builder.append(" ");
                    }
                    builder.append(words[i]);
                }
            }

            result.add(builder.toString());
            index = last;
        }

        return result;
    }
}

