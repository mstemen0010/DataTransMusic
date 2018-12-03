/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms.code2music;

import java.util.Stack;


/**
 *
 * @author mstemen@gmail.com
 */
public class Progression extends Stack<MusicKey> {

    /**
     * @return the progMinor
     */
    public int getProgMinor() {
        return progMinor;
    }

    /**
     * @return the progMajor
     */
    public int getProgMajor() {
        return progMajor;
    }

    /**
     * @return the progSteps
     */
    public int getProgSteps() {
        return progSteps;
    }

    /**
     * @return the progNotes
     */
    public int getProgNotes() {
        return progNotes;
    }

    public void advanceMinor() {

    }

    public void advanceMajor() {
        focus++;
    }

    public void addNote(Note noteToAdd) { // convenence method to build a progression note by note
        this.progNotes++;
        MusicKey currKey = this.get(focus);

    }

    public void addStep(MusicKey newStep) {

    }

    public Note getNextNote() {
        MusicKey mKey = this.get(focus);
        Note noteInFocus = mKey.elementAt(index);
        if (mKey != null) {
            if (index < mKey.size()) { /// check to see if the "slot" of the Note that has focus is in range
                noteInFocus = mKey.elementAt(index);
                if (noteInFocus != null) {
                    // advance the index 
                    index++;
                }
            } else {
                // we are at the end of the MusicKey that has focus, move focus, reset index
                focus++;
                index = 0;
                if (focus < this.size()) {
                    MusicKey tKey = this.get(focus); // see if there is another Key to grab
                    if (tKey != null) {
                        // return the first note in this MusicKey
                        noteInFocus = tKey.elementAt(index);
                        if (noteInFocus == null) { // this shouldn't happen.. just a a safety for now
                            // go back to the beginning of the whole progression 
                            focus = 0;
                            index = 0;
                            // grab that first Note
                            tKey = this.get(focus);
                            if (tKey != null) {
                                noteInFocus = tKey.elementAt(index);
                            } else { // something is horribly wrong with progression, so bail... 
                                
                            }

                        }

                    }
                }

            }
        }

        return noteInFocus;
    }

    private int focus = -1; // the current element of the Stack of MusicKey that we hold
    private int index = -1;// the current part (Note) of a MusicKey where that key is in focus--the "address" 
    // of the note is found at the cross of the focus and index

    private int progMinor = -1; // state of the current note in the curent key that has "focus"
    private int progMajor = -1; // state of the current progression (which key is in "Focus")
    private int progSteps = -1; // the number of keys in this progression
    private int progNotes = -1; // the total number of notes in the progression
    private int maxStep = -1;
    private int maxNotes = -1;

}
