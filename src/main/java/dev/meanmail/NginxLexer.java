// Generated by JFlex 1.9.1 http://jflex.de/  (tweaked for IntelliJ platform)
// source: Nginx.flex

package dev.meanmail;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static dev.meanmail.psi.Types.*;


public class NginxLexer implements FlexLexer {

    /**
     * This character denotes the end of file
     */
    public static final int YYEOF = -1;
    /**
     * lexical states
     */
    public static final int YYINITIAL = 0;
    public static final int STRING_STATE = 2;
    public static final int DQSTRING_STATE = 4;
    public static final int INCLUDE_STATE = 6;
    public static final int LUA_BLOCK_STATE = 8;
    public static final int LUA_STATE = 10;
    /**
     * initial size of the lookahead buffer
     */
    private static final int ZZ_BUFFERSIZE = 16384;
    /**
     * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
     * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
     * at the beginning of a line
     * l is of the form l = 2*k, k a non negative integer
     */
    private static final int[] ZZ_LEXSTATE = {
            0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5
    };
    private static final String ZZ_CMAP_TOP_PACKED_0 =
            "\1\0\25\u0100\1\u0200\11\u0100\1\u0300\17\u0100\1\u0400\247\u0100" +
                    "\10\u0500\u1020\u0100";
    /**
     * Top-level table for translating characters to character classes
     */
    private static final int[] ZZ_CMAP_TOP = zzUnpackcmap_top();
    private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
            "\11\0\1\1\1\2\2\3\1\2\22\0\1\1\1\0" +
                    "\1\4\1\5\3\0\1\6\10\0\12\7\1\0\1\10" +
                    "\5\0\32\11\1\0\1\12\2\0\1\13\1\0\1\14" +
                    "\1\15\1\16\1\17\1\20\3\11\1\21\1\11\1\22" +
                    "\1\23\1\11\1\24\1\25\2\11\1\26\1\27\1\30" +
                    "\1\31\1\11\1\32\1\11\1\33\1\11\1\34\1\35" +
                    "\1\36\7\0\1\3\32\0\1\1\u01df\0\1\1\177\0" +
                    "\13\1\35\0\2\3\5\0\1\1\57\0\1\1\240\0" +
                    "\1\1\377\0\u0100\37";
    /**
     * Second-level tables for translating characters to character classes
     */
    private static final int[] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();
    private static final String ZZ_ACTION_PACKED_0 =
            "\6\0\1\1\1\2\1\3\1\1\1\4\1\5\5\6" +
                    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\13" +
                    "\1\16\1\17\1\20\1\21\1\22\1\23\1\0\2\24" +
                    "\4\6\2\0\1\24\22\6\1\25\42\6\1\26\2\6" +
                    "\1\27\1\30";
    /**
     * Translates DFA states to action switch labels.
     */
    private static final int[] ZZ_ACTION = zzUnpackAction();
    private static final String ZZ_ROWMAP_PACKED_0 =
            "\0\0\0\40\0\100\0\140\0\200\0\240\0\300\0\340" +
                    "\0\u0100\0\u0120\0\u0100\0\u0100\0\u0140\0\u0160\0\u0180\0\u01a0" +
                    "\0\u01c0\0\300\0\300\0\u01e0\0\u0100\0\u0200\0\u0220\0\u0100" +
                    "\0\u0240\0\u0260\0\u0100\0\u0100\0\u0100\0\u0280\0\u0100\0\u02a0" +
                    "\0\u0100\0\u0120\0\u02c0\0\u02e0\0\u0300\0\u0320\0\u0200\0\u0240" +
                    "\0\u02a0\0\u0340\0\u0360\0\u0380\0\u03a0\0\u03c0\0\u03e0\0\u0400" +
                    "\0\u0420\0\u0440\0\u0460\0\u0480\0\u04a0\0\u04c0\0\u04e0\0\u0500" +
                    "\0\u0520\0\u0540\0\u0560\0\u0140\0\u0580\0\u05a0\0\u05c0\0\u05e0" +
                    "\0\u0600\0\u0620\0\u0640\0\u0660\0\u0680\0\u06a0\0\u06c0\0\u06e0" +
                    "\0\u0700\0\u0720\0\u0740\0\u0760\0\u0780\0\u07a0\0\u07c0\0\u07e0" +
                    "\0\u0800\0\u0820\0\u0840\0\u0860\0\u0880\0\u08a0\0\u08c0\0\u08e0" +
                    "\0\u0900\0\u0920\0\u0940\0\u0960\0\u0980\0\u09a0\0\u0140\0\u09c0" +
                    "\0\u09e0\0\u0140\0\u0140";
    /**
     * Translates a state to a row index in the transition table
     */
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();
    private static final String ZZ_TRANS_PACKED_0 =
            "\1\7\3\10\1\11\1\12\1\13\1\7\1\14\1\15" +
                    "\1\7\1\15\1\16\1\15\1\17\2\15\1\20\4\15" +
                    "\1\21\5\15\1\22\1\7\1\23\1\7\6\24\1\25" +
                    "\3\24\1\26\25\24\4\27\1\30\5\27\1\31\25\27" +
                    "\1\32\3\10\4\32\1\33\27\32\1\34\3\10\30\34" +
                    "\1\35\3\34\36\36\1\37\1\36\1\7\4\0\1\7" +
                    "\1\0\1\7\1\0\27\7\1\0\3\10\74\0\1\12" +
                    "\1\40\1\41\1\0\1\40\1\12\1\40\1\12\1\40" +
                    "\24\12\1\42\1\12\2\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\21\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\3\15\1\43\15\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\12\15" +
                    "\1\44\6\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\11\15\1\45\7\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\5\15\1\46\13\15" +
                    "\4\7\6\24\1\0\3\24\1\47\27\24\2\0\33\24" +
                    "\1\0\4\27\1\0\5\27\1\50\27\27\2\0\33\27" +
                    "\1\0\1\32\3\0\4\32\1\0\27\32\36\36\1\0" +
                    "\1\36\2\40\1\41\1\0\31\40\1\51\1\40\1\0" +
                    "\1\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\3\15\1\52\15\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\11\15\1\53\7\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\3\15\1\54" +
                    "\15\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\17\15\1\55\1\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\5\15\1\56\13\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\15\15" +
                    "\1\57\3\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\10\15\1\60\10\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\13\15\1\61\5\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\14\15\1\62\4\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\5\15\1\63\13\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\16\15\1\64" +
                    "\2\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\6\15\1\65\12\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\14\15\1\66\4\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\11\15" +
                    "\1\67\7\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\4\15\1\70\14\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\15\15\1\71\3\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\1\72\20\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\15\15\1\73\3\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\5\15\1\74\13\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\5\15\1\75\13\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\2\15\1\76\16\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\1\77\20\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\1\100\20\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\20\15\1\101\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\2\15\1\102\16\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\2\15" +
                    "\1\103\16\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\1\104\20\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\20\15\1\105\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\20\15\1\106" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\10\15\1\107\10\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\1\110\20\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\1\111\20\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\16\15" +
                    "\1\112\2\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\10\15\1\113\10\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\10\15\1\114\10\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\1\15\1\115\17\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\16\15\1\116\2\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\16\15\1\117" +
                    "\2\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\1\120\20\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\1\15\1\121\17\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\1\15\1\122" +
                    "\17\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\2\15\1\123\16\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\1\124\20\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\1\125\20\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\10\15\1\126\10\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\2\15\1\127\16\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\2\15\1\130" +
                    "\16\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\12\15\1\131\6\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\10\15\1\132\10\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\10\15" +
                    "\1\133\10\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\3\15\1\134\15\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\12\15\1\135\6\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\12\15\1\136\6\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\7\15\1\137\11\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\3\15\1\140" +
                    "\15\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\3\15\1\141\15\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\7\15\1\142\11\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\7\15" +
                    "\1\143\11\15\4\7";
    /**
     * The transition table of the DFA
     */
    private static final int[] ZZ_TRANS = zzUnpacktrans();
    /* error codes */
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    /* error messages for the codes above */
    private static final String[] ZZ_ERROR_MSG = {
            "Unknown internal scanner error",
            "Error: could not match input",
            "Error: pushback value was too large"
    };
    private static final String ZZ_ATTRIBUTE_PACKED_0 =
            "\6\0\2\1\1\11\1\1\2\11\10\1\1\11\2\1" +
                    "\1\11\2\1\3\11\1\1\1\11\1\0\1\11\5\1" +
                    "\2\0\73\1";
    /**
     * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
     */
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();
    /**
     * Number of characters from the last newline up to the start of the matched text.
     */
    @SuppressWarnings("unused")
    protected int yycolumn;
    Deque<Integer> stack = new ArrayDeque<Integer>();
    /**
     * the input device
     */
    private final java.io.Reader zzReader;
    /**
     * the current state of the DFA
     */
    private int zzState;
    /**
     * the current lexical state
     */
    private int zzLexicalState = YYINITIAL;
    /**
     * this buffer contains the current text to be matched and is
     * the source of the yytext() string
     */
    private CharSequence zzBuffer = "";
    /**
     * the textposition at the last accepting state
     */
    private int zzMarkedPos;
    /**
     * the current text position in the buffer
     */
    private int zzCurrentPos;
    /**
     * startRead marks the beginning of the yytext() string in the buffer
     */
    private int zzStartRead;
    /**
     * endRead marks the last character in the buffer, that has been read
     * from input
     */
    private int zzEndRead;
    /**
     * zzAtBOL == true <=> the scanner is currently at the beginning of a line
     */
    private boolean zzAtBOL = true;
    /**
     * zzAtEOF == true <=> the scanner is at the EOF
     */
    private boolean zzAtEOF;
    /**
     * denotes if the user-EOF-code has already been executed
     */
    private boolean zzEOFDone;
    /**
     * Number of newlines encountered up to the start of the matched text.
     */
    @SuppressWarnings("unused")
    private int yyline;
    /**
     * Number of characters up to the start of the matched text.
     */
    @SuppressWarnings("unused")
    private long yychar;
    /* user code: */
    public NginxLexer() {
        this(null);
    }

    /**
     * Creates a new scanner
     *
     * @param in the java.io.Reader to read input from.
     */
    public NginxLexer(java.io.Reader in) {
        this.zzReader = in;
    }

    private static int[] zzUnpackcmap_top() {
        int[] result = new int[4352];
        int offset = 0;
        offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackcmap_top(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    private static int[] zzUnpackcmap_blocks() {
        int[] result = new int[1536];
        int offset = 0;
        offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackcmap_blocks(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    private static int[] zzUnpackAction() {
        int[] result = new int[99];
        int offset = 0;
        offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAction(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    private static int[] zzUnpackRowMap() {
        int[] result = new int[99];
        int offset = 0;
        offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackRowMap(String packed, int offset, int[] result) {
        int i = 0;  /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length() - 1;
        while (i < l) {
            int high = packed.charAt(i++) << 16;
            result[j++] = high | packed.charAt(i++);
        }
        return j;
    }

    private static int[] zzUnpacktrans() {
        int[] result = new int[2560];
        int offset = 0;
        offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpacktrans(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            value--;
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    private static int[] zzUnpackAttribute() {
        int[] result = new int[99];
        int offset = 0;
        offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAttribute(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    /**
     * Translates raw input code points to DFA table row
     */
    private static int zzCMap(int input) {
        int offset = input & 255;
        return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
    }

    public final void yypush(int newState) {
        yybegin(newState);
        stack.push(newState);
    }

    public final int yypop() {
        if (stack.size() == 0) {
            yyinitial();
            return YYINITIAL;
        }

        int state = stack.pop();

        if (stack.peek() == null) {
            yyinitial();
        } else {
            yybegin(stack.peek());
        }

        return state;
    }

    public final void yyinitial() {
        stack.clear();
        yypush(YYINITIAL);
    }

    /**
     * Returns the maximum size of the scanner buffer, which limits the size of tokens.
     */
    private int zzMaxBufferLen() {
        return Integer.MAX_VALUE;
    }

    /**
     * Whether the scanner buffer can grow to accommodate a larger token.
     */
    private boolean zzCanGrow() {
        return true;
    }

    public final int getTokenStart() {
        return zzStartRead;
    }

    public final int getTokenEnd() {
        return getTokenStart() + yylength();
    }

    public void reset(CharSequence buffer, int start, int end, int initialState) {
        zzBuffer = buffer;
        zzCurrentPos = zzMarkedPos = zzStartRead = start;
        zzAtEOF = false;
        zzAtBOL = true;
        zzEndRead = end;
        yybegin(initialState);
    }

    /**
     * Refills the input buffer.
     *
     * @return <code>false</code>, iff there was new input.
     * @throws java.io.IOException if any I/O-Error occurs
     */
    private boolean zzRefill() throws java.io.IOException {
        return true;
    }


    /**
     * Returns the current lexical state.
     */
    public final int yystate() {
        return zzLexicalState;
    }


    /**
     * Enters a new lexical state
     *
     * @param newState the new lexical state
     */
    public final void yybegin(int newState) {
        zzLexicalState = newState;
    }


    /**
     * Returns the text matched by the current regular expression.
     */
    public final CharSequence yytext() {
        return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
    }


    /**
     * Returns the character at position <tt>pos</tt> from the
     * matched text.
     * <p>
     * It is equivalent to yytext().charAt(pos), but faster
     *
     * @param pos the position of the character to fetch.
     *            A value from 0 to yylength()-1.
     * @return the character at position pos
     */
    public final char yycharat(int pos) {
        return zzBuffer.charAt(zzStartRead + pos);
    }


    /**
     * Returns the length of the matched text region.
     */
    public final int yylength() {
        return zzMarkedPos - zzStartRead;
    }


    /**
     * Reports an error that occurred while scanning.
     * <p>
     * In a wellformed scanner (no or only correct usage of
     * yypushback(int) and a match-all fallback rule) this method
     * will only be called with things that "Can't Possibly Happen".
     * If this method is called, something is seriously wrong
     * (e.g. a JFlex bug producing a faulty scanner etc.).
     * <p>
     * Usual syntax/scanner level error handling should be done
     * in error fallback rules.
     *
     * @param errorCode the code of the errormessage to display
     */
    private void zzScanError(int errorCode) {
        String message;
        try {
            message = ZZ_ERROR_MSG[errorCode];
        } catch (ArrayIndexOutOfBoundsException e) {
            message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
        }

        throw new Error(message);
    }


    /**
     * Pushes the specified amount of characters back into the input stream.
     * <p>
     * They will be read again by then next call of the scanning method
     *
     * @param number the number of characters to be read again.
     *               This number must not be greater than yylength()!
     */
    public void yypushback(int number) {
        if (number > yylength())
            zzScanError(ZZ_PUSHBACK_2BIG);

        zzMarkedPos -= number;
    }


    /**
     * Contains user EOF-code, which will be executed exactly once,
     * when the end of file is reached
     */
    private void zzDoEOF() {
        if (!zzEOFDone) {
            zzEOFDone = true;

        }
    }


    /**
     * Resumes scanning until the next regular expression is matched,
     * the end of input is encountered or an I/O-Error occurs.
     *
     * @return the next token
     * @throws java.io.IOException if any I/O-Error occurs
     */
    public IElementType advance() throws java.io.IOException {
        int zzInput;
        int zzAction;

        // cached fields:
        int zzCurrentPosL;
        int zzMarkedPosL;
        int zzEndReadL = zzEndRead;
        CharSequence zzBufferL = zzBuffer;

        int[] zzTransL = ZZ_TRANS;
        int[] zzRowMapL = ZZ_ROWMAP;
        int[] zzAttrL = ZZ_ATTRIBUTE;

        while (true) {
            zzMarkedPosL = zzMarkedPos;

            zzAction = -1;

            zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

            zzState = ZZ_LEXSTATE[zzLexicalState];

            // set up zzAction for empty match case:
            int zzAttributes = zzAttrL[zzState];
            if ((zzAttributes & 1) == 1) {
                zzAction = zzState;
            }


            zzForAction:
            {
                while (true) {

                    if (zzCurrentPosL < zzEndReadL) {
                        zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
                        zzCurrentPosL += Character.charCount(zzInput);
                    } else if (zzAtEOF) {
                        zzInput = YYEOF;
                        break zzForAction;
                    } else {
                        // store back cached positions
                        zzCurrentPos = zzCurrentPosL;
                        zzMarkedPos = zzMarkedPosL;
                        boolean eof = zzRefill();
                        // get translated positions and possibly new buffer
                        zzCurrentPosL = zzCurrentPos;
                        zzMarkedPosL = zzMarkedPos;
                        zzBufferL = zzBuffer;
                        zzEndReadL = zzEndRead;
                        if (eof) {
                            zzInput = YYEOF;
                            break zzForAction;
                        } else {
                            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
                            zzCurrentPosL += Character.charCount(zzInput);
                        }
                    }
                    int zzNext = zzTransL[zzRowMapL[zzState] + zzCMap(zzInput)];
                    if (zzNext == -1) break zzForAction;
                    zzState = zzNext;

                    zzAttributes = zzAttrL[zzState];
                    if ((zzAttributes & 1) == 1) {
                        zzAction = zzState;
                        zzMarkedPosL = zzCurrentPosL;
                        if ((zzAttributes & 8) == 8) break zzForAction;
                    }

                }
            }

            // store back cached position
            zzMarkedPos = zzMarkedPosL;

            if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
                zzAtEOF = true;
                zzDoEOF();
                return null;
            } else {
                switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
                    case 1: {
                        return VALUE;
                    }
                    // fall through
                    case 25:
                        break;
                    case 2: {
                        return WHITE_SPACE;
                    }
                    // fall through
                    case 26:
                        break;
                    case 3: {
                        yypush(DQSTRING_STATE);
                        return DQUOTE;
                    }
                    // fall through
                    case 27:
                        break;
                    case 4: {
                        yypush(STRING_STATE);
                        return QUOTE;
                    }
                    // fall through
                    case 28:
                        break;
                    case 5: {
                        return SEMICOLON;
                    }
                    // fall through
                    case 29:
                        break;
                    case 6: {
                        return IDENTIFIER;
                    }
                    // fall through
                    case 30:
                        break;
                    case 7: {
                        return LBRACE;
                    }
                    // fall through
                    case 31:
                        break;
                    case 8: {
                        return RBRACE;
                    }
                    // fall through
                    case 32:
                        break;
                    case 9: {
                        return STRING;
                    }
                    // fall through
                    case 33:
                        break;
                    case 10: {
                        yypop();
                        return QUOTE;
                    }
                    // fall through
                    case 34:
                        break;
                    case 11: {
                        yyinitial();
                        return BAD_CHARACTER;
                    }
                    // fall through
                    case 35:
                        break;
                    case 12: {
                        return DQSTRING;
                    }
                    // fall through
                    case 36:
                        break;
                    case 13: {
                        yypop();
                        return DQUOTE;
                    }
                    // fall through
                    case 37:
                        break;
                    case 14: {
                        return INCLUDE_TARGET;
                    }
                    // fall through
                    case 38:
                        break;
                    case 15: {
                        yypop();
                        return SEMICOLON;
                    }
                    // fall through
                    case 39:
                        break;
                    case 16: {
                        yypop();
                        return BAD_CHARACTER;
                    }
                    // fall through
                    case 40:
                        break;
                    case 17: {
                        yypush(LUA_STATE);
                        return LBRACE;
                    }
                    // fall through
                    case 41:
                        break;
                    case 18: {
                        return LUA;
                    }
                    // fall through
                    case 42:
                        break;
                    case 19: {
                        yypop();
                        yypop();
                        return RBRACE;
                    }
                    // fall through
                    case 43:
                        break;
                    case 20: {
                        return COMMENT;
                    }
                    // fall through
                    case 44:
                        break;
                    case 21: {
                        yypush(INCLUDE_STATE);
                        return INCLUDE;
                    }
                    // fall through
                    case 45:
                        break;
                    case 22: {
                        yypush(LUA_BLOCK_STATE);
                        return ACCESS_BY_LUA_BLOCK;
                    }
                    // fall through
                    case 46:
                        break;
                    case 23: {
                        yypush(LUA_BLOCK_STATE);
                        return CONTENT_BY_LUA_BLOCK;
                    }
                    // fall through
                    case 47:
                        break;
                    case 24: {
                        yypush(LUA_BLOCK_STATE);
                        return REWRITE_BY_LUA_BLOCK;
                    }
                    // fall through
                    case 48:
                        break;
                    default:
                        zzScanError(ZZ_NO_MATCH);
                }
            }
        }
    }


}
