package command;

import editor.Editor;

public class CommandRedo extends Command {

    private Editor.Snapshot snapshot;

    public CommandRedo(Editor editor, Editor.Snapshot snapshot) {
        super(editor);
        this.snapshot = snapshot;
    }

    @Override
    public void execute() {
        editor.redo(this.snapshot);
    }
}
