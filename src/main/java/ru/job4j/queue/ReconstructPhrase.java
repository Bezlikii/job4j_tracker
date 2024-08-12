package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder resultString = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            Character element = evenElements.pollFirst();
            if (i % 2 == 0) {
                resultString.append(element);
            }
        }
        return resultString.toString();
    }

    private String getDescendingElements() {
        StringBuilder resultString = new StringBuilder();
        while (!descendingElements.isEmpty()) {
            resultString.append(descendingElements.pollLast());
        }
        return resultString.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}

