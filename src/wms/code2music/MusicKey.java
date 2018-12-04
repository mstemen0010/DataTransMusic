package wms.code2music;

public class MusicKey extends MusicScale {

    private final boolean isWholeNote = false;
    private final boolean isHalfNote = false;
    private String value;
    private String natValue;
    private int octave;
    private int midiBaseValue; // the midi value based octave 0 (i.e. 21 = A0, 22 = Bb0, etc)
    private int midiNote;
    private int midiEvent;

    int octaveOffSet = 1;

    public Note cvtLetterToNote(char charToCvt) {

        Note note = null;

        //how many notes are in this key?
        int numNotesInKey = this.size();
        // to determine what octave this note is in within this key

        // determine whether char is alphanumeric
        int midiNoteEventNumber = -1;
        if (Character.isAlphabetic(charToCvt)) {
            // get the ascii value
            int ascii = (int) charToCvt;
            if (ascii > 97 && ascii < 122) {

            }
            int noteValueAsAsciiDecimal = (ascii - 97) + 1;

            switch (noteValueAsAsciiDecimal) {
                case 65: // a
                case 97: // A
                    note = this.toNote(charToCvt);
                    break;

                case 66: // b
                case 98: // B
                    note = this.toNote(charToCvt);
                    break;

                case 67: // c
                case 99: // C
                    note = this.toNote(charToCvt);
                    break;

                case 68:  // d
                case 100: // D
                    note = this.toNote(charToCvt);
                    break;

                case 69:  // e
                case 101: // E
                    note = this.toNote(charToCvt);
                    break;

                case 70:  // f
                case 102: // F
                    note = this.toNote(charToCvt);
                    break;
                case 71:  // g
                case 103: // G
                    note = this.toNote(charToCvt);
                    break;

            }

        }

        return note;

    }

    public Note toNote(char charToConvert) {
        String charRange = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        //  D, E, F, G, A, B♭, and C. dm scale
        // C - Eb - F - Gb - G - Bb - C "blues" scale
        String retVal = "#";
        Note retNote = null;

        //  hexTonicScale.add(new Note("C", 1));
        // figure out the note based on the scale and the octave based on how
        // many times it "loops" though the scale to get the relative note
        int charPos = charRange.indexOf(charToConvert);
        int relativeNotePos = charPos % this.size();
        int relativeOctave = charPos / this.size();
        if (relativeNotePos >= 7) {
            relativeNotePos = 0;
        }
        // System.out.println("Relative pos is: " + relativeNotePos );
        // System.out.println("Mod value is: " + relativeNotePos);
        Note noteToSend = super.elementAt(relativeNotePos);
        int newOctave = relativeOctave + octaveOffSet;
        retNote = noteToSend;
        retNote.setOctave(newOctave);
        // retVal = noteToSend.getValue() + ":" + noteToSend.getOctave() + "~";

        //  C E G♯and E♭ G B
        // we are using a hexatonic (8 note) scale... so mod by 8 first
        return retNote;
    }
}
