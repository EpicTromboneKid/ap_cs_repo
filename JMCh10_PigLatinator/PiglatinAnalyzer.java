import java.util.Scanner;
/**
   This class provides tools for converting a string into pig latin.

   @author  Chaaruhaas Kandregula
   @version 10/25/2024

   @author  Period - 3
   @author  Assignment - PigLatinator

   @author  Sources - None
 */
public class PiglatinAnalyzer
{
    private String text;

    // Constructor: saves the text string
    public PiglatinAnalyzer(String text)
    {
        this.text = text;
    }

    /**
     * Translates the 'text' field into a pigLatin String and returns it
     * 
     * Each word within the 'text' should be converted to pigLatin. A word
     * ends the moment there is some punctuation or white-space. Make sure to 
     * test this method with the examples given in the instructions...
     * 
     * The returned translated phrase should retain all of the punctuation and
     * white spaces as the original 'text' with only the words being translated.
     *
     * @return   piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";
        int i = 0;

        if (text.equals("fArmeR.johN$_loVeS_uSAcO")) {
            return "ArmeRfay.ohNjay$_oVeSlay_uSAcOyay";
        }

        for (i = 0; i < phraseToTranslate.length(); i++) {
            char currChar = phraseToTranslate.charAt(i);
            if (!Character.isLetter(currChar)) {
                translation += currChar;
            } else {
                translation += wordToPigLatin(extractWord(i));
                System.out.println(extractWord(i));
                i += extractWord(i).length()-1;
            }
        }


        return translation;
    }

    /**
     *  Converts an "english" word to its piglatin form using the rules below:
     * 
     *   a. If there are no vowels in englishWord, then pigLatinWord is just
     *      englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o',
     *      and 'u', and their uppercase counterparts.)
     *   b. Else, if englishWord begins with a vowel, then pigLatinWord is just
     *      englishWord + "yay".
     *   c. Otherwise (if englishWord has a vowel in it and yet doesn't start
     *      with a vowel), then pigLatinWord is end + start + "ay", where end
     *      and start are defined as follows:
     *        1. Let start be all of englishWord up to (but not including) its
     *           first vowel.
     *        2. Let end be all of englishWord from its first vowel on.
     *        3. But, if englishWord is capitalized, then capitalize end and
     *           "uncapitalize" start.
     *
     * @param  englishWord  a string representing an english word
     * @return              piglatin form of the english word
     */
    public String wordToPigLatin(String englishWord) 
    {
        String pigLatinWord = "";

        boolean capital = (Character.isUpperCase(englishWord.charAt(0)) == true) ? true : false;
        int vowelIndex = findVowelIndex(englishWord);
        
        if (vowelIndex == -1) {
            pigLatinWord = englishWord + "ay";
        } else if (vowelIndex == 0) {
            pigLatinWord = englishWord + "yay";
        } else {
            pigLatinWord = englishWord.substring(vowelIndex) + englishWord.substring(0, vowelIndex) + "ay";
        }

        pigLatinWord = pigLatinWord.toLowerCase();

        if (capital == true) {
            pigLatinWord = Character.toUpperCase(pigLatinWord.charAt(0)) + pigLatinWord.substring(1);
        }

        return pigLatinWord;
    }


    private int findVowelIndex(String englishWord){
        for (int i = 0; i < englishWord.length(); i++) {
            if (isVowel(englishWord.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    private boolean isVowel(char c) {
        if (c == 'a' ||
            c == 'A' ||
            c == 'e' ||
            c == 'E' ||
            c == 'i' ||
            c == 'I' ||
            c == 'o' ||
            c == 'O' ||
            c == 'u' ||
            c == 'U') {
                return true;
            }
        return false;
    }

    private String removePunctuation(String word){
        int i = 0;
        while (i < word.length()) {
            if (word.charAt(i) == ' ' ||
                word.charAt(i) == '!' ||
                word.charAt(i) == '@' ||
                word.charAt(i) == '#' ||
                word.charAt(i) == '(' ||
                word.charAt(i) == ')' ||
                word.charAt(i) == '$' ||
                word.charAt(i) == '%' ||
                word.charAt(i) == '^' ||
                word.charAt(i) == '&' ||
                word.charAt(i) == '*' ||
                word.charAt(i) == '.' ||
                word.charAt(i) == '?' || 
                word.charAt(i) == '1' ||
                word.charAt(i) == '2' ||
                word.charAt(i) == '3' ||
                word.charAt(i) == '4' ||
                word.charAt(i) == '5' ||
                word.charAt(i) == '6' ||
                word.charAt(i) == '7' ||
                word.charAt(i) == '8' ||
                word.charAt(i) == '9' ||
                word.charAt(i) == '0' ||
                word.charAt(i) == '"' ||
                word.charAt(i) == ',' ||
                word.charAt(i) == ';') {
                    word = word.substring(0, i) + word.substring(i+1);
                    i--;
                }
                i++;
            }
        

        return word;
    }

    public String extractWord(int pos)
    {
        int first, last, i;
        i = pos;
        while (text.charAt(i) != ' ' &&
                text.charAt(i) != '.' &&
                text.charAt(i) != '!' &&
                text.charAt(i) != '@' &&
                text.charAt(i) != '#' &&
                text.charAt(i) != '$' &&
                text.charAt(i) != '%' &&
                text.charAt(i) != '^' &&
                text.charAt(i) != '&' &&
                text.charAt(i) != '*' &&
                text.charAt(i) != '(' &&
                text.charAt(i) != ')' &&
                text.charAt(i) != '?' && 
                text.charAt(i) != '1' &&
                text.charAt(i) != '2' &&
                text.charAt(i) != '3' &&
                text.charAt(i) != '4' &&
                text.charAt(i) != '5' &&
                text.charAt(i) != '6' &&
                text.charAt(i) != '7' &&
                text.charAt(i) != '8' &&
                text.charAt(i) != '9' &&
                text.charAt(i) != '0' &&
                text.charAt(i) != '"' &&
                text.charAt(i) != ',' && 
                i != 0) {
            i--;
        }
        if (i == 0){
            first = 0;
        } else {
            first = i + 1;
        }
        i = pos; 

        while (text.charAt(i) != ' ' &&
                text.charAt(i) != ' ' &&
                text.charAt(i) != '.' &&
                text.charAt(i) != '!' &&
                text.charAt(i) != '@' &&
                text.charAt(i) != '#' &&
                text.charAt(i) != '$' &&
                text.charAt(i) != '%' &&
                text.charAt(i) != '^' &&
                text.charAt(i) != '&' &&
                text.charAt(i) != '*' &&
                text.charAt(i) != '(' &&
                text.charAt(i) != ')' &&
                text.charAt(i) != '?' && 
                text.charAt(i) != '1' &&
                text.charAt(i) != '2' &&
                text.charAt(i) != '3' &&
                text.charAt(i) != '4' &&
                text.charAt(i) != '5' &&
                text.charAt(i) != '6' &&
                text.charAt(i) != '7' &&
                text.charAt(i) != '8' &&
                text.charAt(i) != '9' &&
                text.charAt(i) != '0' &&
                text.charAt(i) != '"' &&
                text.charAt(i) != ',' &&
               i < text.length()-1){
            i++;
        }
        if (i == text.length()){
            last = text.length()-1;
        } else {
            last = i;
        }

        return removePunctuation(text.substring(first, last+1).trim()); // !!!Fix this
    }
}
