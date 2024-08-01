package net.coma112.ctemplate.enums.keys;

import net.coma112.ctemplate.CTemplate;
import net.coma112.ctemplate.processor.MessageProcessor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public enum MessageKeys {
    TEST("message.test"),
    LAST_PAGE("message.last-page"),
    FIRST_PAGE("message.first-page"),
    HELP("message.help");

    private final String path;

    MessageKeys(@NotNull String path) {
        this.path = path;
    }

    public String getMessage() {
        return MessageProcessor.process(CTemplate.getInstance().getLanguage().getString(path));
    }

    public List<String> getMessages() {
        return CTemplate.getInstance().getLanguage().getList(path)
                .stream()
                .map(MessageProcessor::process)
                .toList();
    }

}
