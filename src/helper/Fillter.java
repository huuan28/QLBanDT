/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

/**
 *
 * @author ADMIN
 */
public class Fillter extends DocumentFilter {

    private JTextField textField;
    private int maxValue;

    public Fillter(JTextField textField, int maxValue) {
        this.textField = textField;
        this.maxValue = maxValue;
    }

    public Fillter() {
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string != null && string.matches("\\d*")) {
            String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + string;
            if (isWithinMaxValue(newText)) {
                super.insertString(fb, offset, string, attr);
            } else {
                adjustToMaxValue(fb);
            }
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text != null && text.matches("\\d*")) {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
            if (isWithinMaxValue(newText)) {
                super.replace(fb, offset, length, text, attrs);
            } else {
                adjustToMaxValue(fb);
            }
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
        String newText = currentText.substring(0, offset) + currentText.substring(offset + length);
        if (isWithinMaxValue(newText)) {
            super.remove(fb, offset, length);
        }
    }

    private boolean isWithinMaxValue(String text) {
        if (text.isEmpty()) {
            return true;
        }
        try {
            int value = Integer.parseInt(text);
            return value <= maxValue;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void adjustToMaxValue(FilterBypass fb) throws BadLocationException {
        fb.remove(0, fb.getDocument().getLength());
        fb.insertString(0, String.valueOf(maxValue), null);
        textField.setText(String.valueOf(maxValue));
    }
}
