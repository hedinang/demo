package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class SequenceService {
    public String split(String sequence, int quantityOfBite) {
        int count = 0;
        String splitSequence = "";
        for (char c : sequence.toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) {
                count += 2;
            } else {
                count += 1;
            }

            if (count == quantityOfBite) {
                splitSequence += c;
                break;
            }
            if (count > quantityOfBite) {
                break;
            }
            splitSequence += c;
        }
        return splitSequence;
    }

    public void recur(String sequence, int i) {
        if (i != sequence.length() - 1) {
            recur(sequence, i + 1);
        }
        System.out.println(sequence.charAt(i));
    }

}
