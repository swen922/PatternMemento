package command;

import editor.Editor;

public class CommandPaste extends Command {

    public CommandPaste(Editor editor) {
        super(editor);
    }

    @Override
    public void execute() {
        editor.setEditText(editor.getClipboard());
    }

}