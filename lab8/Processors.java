import java.util.List;
import java.util.stream.Collectors;

public class FilterProcessor {
    @DataProcessor
    public List<String> filterShortWords(List<String> data) {
        return data.stream()
                .filter(s -> s != null && s.trim().length() > 3)
                .collect(Collectors.toList());
    }
}

public class TransformProcessor {
    @DataProcessor
    public List<String> toUpperCase(List<String> data) {
        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}

public class PrefixProcessor {
    @DataProcessor
    public List<String> addPrefix(List<String> data) {
        return data.stream()
                .map(s -> "[PROCESSED] " + s)
                .collect(Collectors.toList());
    }
}