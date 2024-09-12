package de.kamiql.util;

import de.kamiql.Main;

public class Messages {

    public Messages() {

    }

    public String getMessage(String path) {
        return Main.getPrefix() + Main.getMessageConfig().getString(path);
    }

}
