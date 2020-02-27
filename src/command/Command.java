package command;

import com.sun.istack.internal.NotNull;
import editor.Editor;

public abstract class Command {

    protected Editor editor;

    public Command(@NotNull Editor editor) {
        this.editor = editor;
    }

    public abstract void execute();


}
