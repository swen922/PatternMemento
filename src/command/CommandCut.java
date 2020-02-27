package command;

import editor.Editor;

public class CommandCut extends Command {

    public CommandCut(Editor editor) {
        super(editor);
    }

    @Override
    public void execute() {
        editor.setClipboard(editor.getEditText());
        editor.setEditText("");
    }

}
