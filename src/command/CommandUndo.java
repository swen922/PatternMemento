package command;

import editor.Editor;

public class CommandUndo extends Command {

    private Editor.Snapshot snapshot;

    public CommandUndo(Editor editor, Editor.Snapshot snapshot) {
        super(editor);
        this.snapshot = snapshot;
    }

    @Override
    public void execute() {
        editor.undo(this.snapshot);
    }
}
