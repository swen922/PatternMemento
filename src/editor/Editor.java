package editor;

import command.Command;

import java.util.LinkedList;

public class Editor {

    private String editText = "";
    private String clipboard = "";
    //private LinkedList<Command> undoList = new LinkedList<>();
    //private LinkedList<Command> redoList = new LinkedList<>();


    public void type(String text) {
        editText = editText + text;
    }

    public String getEditText() {
        return editText;
    }

    public void setEditText(String editText) {
        this.editText = editText;
    }

    public String getClipboard() {
        return clipboard;
    }

    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }

    public void undo(Snapshot snapshot) {
        editText = snapshot.backupText;
    }

    public void redo(Snapshot snapshot) {
        editText = snapshot.backupText;
    }

    public Snapshot createSnapshot() {
        return new Snapshot(editText);
    }

    public void print() {

        System.out.println(editText);
    }


    /**  Это и есть Memento, который запоминает состояние, но никому не сообщает о нем */
    public class Snapshot {

        private String backupText = "";

        public Snapshot(String undoText) {
            this.backupText = undoText;
        }
    }



}
