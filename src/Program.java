import command.*;
import editor.Editor;

import java.util.*;

public class Program {

    private int idEditors = 10;

    private Map<Integer, Editor> editors = new HashMap<>();
    private Map<Integer, LinkedList<Editor.Snapshot>> snapshotsUndo = new HashMap<>();
    private Map<Integer, LinkedList<Editor.Snapshot>> snapshotsRedo = new HashMap<>();



    public void addEditor(Editor editor) {
        idEditors++;
        editors.put(idEditors, editor);
        snapshotsUndo.put(idEditors, new LinkedList());
        snapshotsRedo.put(idEditors, new LinkedList());
        System.out.println("added editor with id-" + idEditors);
    }

    // Метод для пользователя, чтобы получить доступ ко всем эдиторам
    public List<Integer> getAllIds() {
        List<Integer> result = new ArrayList<>();
        result.addAll(editors.keySet());
        return result;
    }

    public void type(String text, int id) {
        if (editors.get(id) != null) {
            editors.get(id).type(text);
        }
    }


    /** Тута пошли как бы кнопки в программе */

    public void copy(int id) {
        Editor ed = editors.get(id);
        if (ed != null) {
            Command command = new CommandCopy(ed);
            command.execute();
            String clip = editors.get(id).getClipboard();
            for (Editor e : editors.values()) {
                e.setClipboard(clip);
            }
        }
    }


    public void cut(int id) {
        Editor ed = editors.get(id);
        if (ed != null) {
            snapshotsUndo.get(id).addLast(ed.createSnapshot());
            Command command = new CommandCut(ed);
            command.execute();
            String clip = editors.get(id).getClipboard();
            for (Editor e : editors.values()) {
                e.setClipboard(clip);
            }
        }
    }

    public void paste(int id) {
        Editor ed = editors.get(id);
        if (ed != null) {
            snapshotsUndo.get(id).addLast(ed.createSnapshot());
            Command command = new CommandPaste(ed);
            command.execute();
        }
    }

    public void undo(int id) {
        Editor ed = editors.get(id);
        if (ed != null) {
            Editor.Snapshot snapshot = snapshotsUndo.get(id).pollLast();
            Command command = new CommandUndo(ed, snapshot);
            command.execute();
            snapshotsRedo.get(id).addLast(snapshot);
        }
    }

    public void redo(int id) {
        Editor ed = editors.get(id);
        if (ed != null) {
            Editor.Snapshot snapshot = snapshotsRedo.get(id).pollLast();
            Command command = new CommandRedo(ed, snapshot);
            command.execute();
            snapshotsUndo.get(id).addLast(snapshot);
        }
    }

    public void print(int id) {
        Editor ed = editors.get(id);
        if (ed != null) {
            System.out.print("Editor id-" + id + " prints: ");
            ed.print();
        }
    }







}
