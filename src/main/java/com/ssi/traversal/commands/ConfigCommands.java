package com.ssi.traversal.commands;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

@Component
public class ConfigCommands implements CommandMarker {


    private TraversalType type = TraversalType.BREADTH;
    private boolean showDetail = false;

    @CliAvailabilityIndicator({"set type", "set detail"})
    public boolean isConfigAvailable() {
        //always available
        return true;
    }

    @CliCommand(value = "set type", help = "Configure the traversal type breadth|depth")
    public String setType(
            @CliOption(key = "",
                    mandatory = true,
                    help = "The traversal type to use") final String type) {

        this.type = TraversalType.valueOf(type.toUpperCase());
        return String.format("Using %s first traversal", this.type);
    }

    @CliCommand(value = "set detail", help = "Configure the output detail true|false")
    public String setDetail(
            @CliOption(key = "",
                    mandatory = true,
                    help = "The output detail") final String detail) {

        this.showDetail = Boolean.valueOf(detail);
        return String.format("Using %s detail for outout", getLevel());
    }


    public TraversalType getType() {
        return this.type;
    }

    public boolean getShowDetail() { return this.showDetail; }

    public String getLevel() {
        return (this.showDetail) ? "detailed" : "simple";
    }

    public enum TraversalType {
        BREADTH("breadth"),
        DEPTH("depth");

        private String type;

        private TraversalType(String type){
            this.type = type;
        }

        @Override
        public String toString(){
            return this.type;
        }
    }

}
