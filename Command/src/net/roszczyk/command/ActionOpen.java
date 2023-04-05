package net.roszczyk.command;

public class ActionOpen implements ActionListenerCommand {
    private final Document doc;

    public ActionOpen(Document doc) {
        this.doc = doc;
    }

    @Override
    public void execute() {
        doc.open();
    }
}
