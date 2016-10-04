package com.ssi.traversal.providers;

import com.ssi.traversal.commands.ConfigCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.expression.spel.ast.Indexer;
import org.springframework.shell.plugin.PromptProvider;
import org.springframework.stereotype.Component;

@Component
@Order(Integer.MIN_VALUE)
public class TraversalPromptProvider implements PromptProvider {

    private final ConfigCommands configCommands;

    @Autowired
    public TraversalPromptProvider(ConfigCommands configCommands) {
        this.configCommands = configCommands;
    }

    @Override
    public String getPrompt() {
        String level = configCommands.getLevel();
        String strategy = configCommands.getType().toString();
        return String.format("%s:%s> ", level, strategy);
    }


    @Override
    public String getProviderName() {
        return configCommands.getType().toString();
    }
}
