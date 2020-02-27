import editor.Editor;

import java.util.List;

/** Снимок, также известен как: Хранитель, Memento */

public class App {

    public static void main(String[] args) {
        Program program = new Program();
        program.addEditor(new Editor());
        program.addEditor(new Editor());
        program.addEditor(new Editor());

        List<Integer> edits = program.getAllIds();

        System.out.println("");

        program.type("Some text here in first editor", edits.get(0));
        program.print(edits.get(0));

        System.out.println("");

        program.type("Second screen is wider", edits.get(1));
        program.print(edits.get(1));

        System.out.println("");

        program.copy(edits.get(0));
        program.paste(edits.get(2));
        program.type(" and this is Third editor", edits.get(2));
        program.print(edits.get(2));

        program.print(114);

        System.out.println("");

        program.cut(edits.get(0));
        program.copy(edits.get(1));
        program.paste(edits.get(0));
        program.print(edits.get(0));
        program.undo(edits.get(0));
        program.print(edits.get(0));
        program.undo(edits.get(0));
        program.print(edits.get(0));



    }
}
