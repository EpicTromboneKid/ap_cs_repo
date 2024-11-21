/**
   Analyzes a lipogram, and provides tools for making and verifying said lipogram.

   @author  Chaaruhaas Kandregula
   @version 10/18/2024

   @author Period - 3
   @author Assignment - JMCh10 Lipogrammer

   @author Sources - None
 */
public class LipogramAnalyzer
{
    private String text;

    /**
       Constructor: Initializes the text field 
       @param text String to analyze
     */
    public LipogramAnalyzer(String text)
    {
        this.text = text;
    }

    /**
       Returns a text string with all characters equal to letter 
       replaced with '#'. Do not change the 'text' field itself...

       @param letter character to replace
       @return text string with all characters equal to letter 
                    replaced with '#'
     */
    public String mark(char letter)
    {
        String out = text;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == letter) {
                out = out.substring(0, i) + '#' + out.substring(i+1);
            }
        }

        return out; 
    }


    /**
       Returns a String that concatenates all "offending"
       words from text that contain letter; the words are
       separated by '\n' characters; the returned string
       does not contain duplicate words: each word occurs
       only once; there are no punctuation or whitespace
       characters in the returned string.
  
       @param letter character to find in text
       @return String containing all words with letter
     */
    public String allWordsWith(char letter)
    {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == letter && (alreadyCounted(result, extractWord(i)) == false)) {
                result = result + extractWord(i) + '\n';
            }
        }

        return result;
    }

	// made public for test purposes
    /**
       Returns the word that contains character at pos
       excluding any punctuation or whitespace OR returns
       the word that begins with the character at pos

       @param pos location of a letter in text
       @return word that contains character at pos
     */
    public String extractWord(int pos)
    {
        int first, last, i;
        i = pos;
        while (text.charAt(i) != ' ' &&
                text.charAt(i) != ' ' &&
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
                text.charAt(i) != '.' &&
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
               i < text.length()-1){
            i++;
        }
        if (i == text.length()){
            last = text.length()-1;
        } else {
            last = i;
        }

        return removePunctuation(text.substring(first, last+1)); // !!!Fix this
    }

    private boolean alreadyCounted(String offending, String check){
        boolean out = false;
        int startingIndex = 0;
        String word = "";
        for (int i = 0; i < offending.length(); i++){
            if (offending.charAt(i) == '\n'){
                word = offending.substring(startingIndex, i);
                if (word.equals(check)){
                    out = true;
                    break;
                }
                startingIndex = i+1;
            }
        }
        return out;
    }

    private String removePunctuation(String word){
        int i = 0;
        while (i < word.length()) {
            if (word.charAt(i) == ' ' ||
                word.charAt(i) == '!' ||
                word.charAt(i) == '@' ||
                word.charAt(i) == '#' ||
                word.charAt(i) == '$' ||
                word.charAt(i) == '%' ||
                word.charAt(i) == '^' ||
                word.charAt(i) == '&' ||
                word.charAt(i) == '*' ||
                word.charAt(i) == '(' ||
                word.charAt(i) == ')' ||
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
                word.charAt(i) == ',') {
                    word = word.substring(0, i) + word.substring(i+1);
                    i--;
                }
                i++;
            }
        

        return word;
    }
}

