package com.fof.audio;


import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {

    private Sequencer sequencer;

    public AudioPlayer(File file) {
        this.sequencer = getSequencer(file);
        sequencer.start();
        sequencer.setLoopCount(10);
    }

    public void stop() {
        this.sequencer.stop();
    }

    public Sequencer getSequencer(File file) {
        Sequencer sequencer = null;

        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

        try {
            Sequence sequence = MidiSystem.getSequence(file);

            sequencer.setSequence(sequence);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sequencer;
    }

}
