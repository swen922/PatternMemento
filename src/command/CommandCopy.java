package command;

import editor.Editor;

public class CommandCopy extends Command {

    public CommandCopy(Editor editor) {
        super(editor);
    }

    @Override
    public void execute() {
        editor.setClipboard(editor.getEditText());
    }

}
