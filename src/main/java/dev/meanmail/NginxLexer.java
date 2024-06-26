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
     * initial size of the lookahead buffer
     */
    private static final int ZZ_BUFFERSIZE = 16384;

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
     * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
     * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
     * at the beginning of a line
     * l is of the form l = 2*k, k a non negative integer
     */
    private static final int ZZ_LEXSTATE[] = {
            0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5
    };

    /**
     * Top-level table for translating characters to character classes
     */
    private static final int[] ZZ_CMAP_TOP = zzUnpackcmap_top();

    private static final String ZZ_CMAP_TOP_PACKED_0 =
            "\1\0\25\u0100\1\u0200\11\u0100\1\u0300\17\u0100\1\u0400\247\u0100" +
                    "\10\u0500\u1020\u0100";

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


    /**
     * Second-level tables for translating characters to character classes
     */
    private static final int[] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

    private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
            "\11\0\1\1\1\2\2\3\1\2\22\0\1\1\1\0" +
                    "\1\4\1\5\3\0\1\6\10\0\12\7\1\0\1\10" +
                    "\5\0\32\11\1\0\1\12\2\0\1\13\1\0\1\14" +
                    "\1\15\1\16\1\17\1\20\1\21\2\11\1\22\1\11" +
                    "\1\23\1\24\1\11\1\25\1\26\2\11\1\27\1\30" +
                    "\1\31\1\32\1\11\1\33\1\11\1\34\1\11\1\35" +
                    "\1\36\1\37\7\0\1\3\32\0\1\1\u01df\0\1\1" +
                    "\177\0\13\1\35\0\2\3\5\0\1\1\57\0\1\1" +
                    "\240\0\1\1\377\0\u0100\40";

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

    /**
     * Translates DFA states to action switch labels.
     */
    private static final int[] ZZ_ACTION = zzUnpackAction();

    private static final String ZZ_ACTION_PACKED_0 =
            "\6\0\1\1\1\2\1\3\1\1\1\4\1\5\6\6" +
                    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\13" +
                    "\1\16\1\17\1\20\1\21\1\22\1\23\1\0\2\24" +
                    "\6\6\2\0\1\24\32\6\1\25\56\6\1\26\11\6" +
                    "\1\27\3\6\1\30\1\31\10\6\1\32";

    private static int[] zzUnpackAction() {
        int[] result = new int[142];
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


    /**
     * Translates a state to a row index in the transition table
     */
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();

    private static final String ZZ_ROWMAP_PACKED_0 =
            "\0\0\0\41\0\102\0\143\0\204\0\245\0\306\0\347" +
                    "\0\u0108\0\u0129\0\u0108\0\u0108\0\u014a\0\u016b\0\u018c\0\u01ad" +
                    "\0\u01ce\0\u01ef\0\306\0\306\0\u0210\0\u0108\0\u0231\0\u0252" +
                    "\0\u0108\0\u0273\0\u0294\0\u0108\0\u0108\0\u0108\0\u02b5\0\u0108" +
                    "\0\u02d6\0\u0108\0\u0129\0\u02f7\0\u0318\0\u0339\0\u035a\0\u037b" +
                    "\0\u039c\0\u0231\0\u0273\0\u02d6\0\u03bd\0\u03de\0\u03ff\0\u0420" +
                    "\0\u0441\0\u0462\0\u0483\0\u04a4\0\u04c5\0\u04e6\0\u0507\0\u0528" +
                    "\0\u0549\0\u056a\0\u058b\0\u05ac\0\u05cd\0\u05ee\0\u060f\0\u0630" +
                    "\0\u0651\0\u0672\0\u0693\0\u06b4\0\u06d5\0\u06f6\0\u014a\0\u0717" +
                    "\0\u0738\0\u0759\0\u077a\0\u079b\0\u07bc\0\u07dd\0\u07fe\0\u081f" +
                    "\0\u0840\0\u0861\0\u0882\0\u08a3\0\u08c4\0\u08e5\0\u0906\0\u0927" +
                    "\0\u0948\0\u0969\0\u098a\0\u09ab\0\u09cc\0\u09ed\0\u0a0e\0\u0a2f" +
                    "\0\u0a50\0\u0a71\0\u0a92\0\u0ab3\0\u0ad4\0\u0af5\0\u0b16\0\u0b37" +
                    "\0\u0b58\0\u0b79\0\u0b9a\0\u0bbb\0\u0bdc\0\u0bfd\0\u0c1e\0\u0c3f" +
                    "\0\u0c60\0\u0c81\0\u0ca2\0\u0cc3\0\u0ce4\0\u014a\0\u0d05\0\u0d26" +
                    "\0\u0d47\0\u0d68\0\u0d89\0\u0daa\0\u0dcb\0\u0dec\0\u0e0d\0\u014a" +
                    "\0\u0e2e\0\u0e4f\0\u0e70\0\u014a\0\u014a\0\u0e91\0\u0eb2\0\u0ed3" +
                    "\0\u0ef4\0\u0f15\0\u0f36\0\u0f57\0\u0f78\0\u014a";

    private static int[] zzUnpackRowMap() {
        int[] result = new int[142];
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

    /**
     * The transition table of the DFA
     */
    private static final int[] ZZ_TRANS = zzUnpacktrans();

    private static final String ZZ_TRANS_PACKED_0 =
            "\1\7\3\10\1\11\1\12\1\13\1\7\1\14\1\15" +
                    "\1\7\1\15\1\16\1\15\1\17\3\15\1\20\4\15" +
                    "\1\21\1\22\4\15\1\23\1\7\1\24\1\7\6\25" +
                    "\1\26\3\25\1\27\26\25\4\30\1\31\5\30\1\32" +
                    "\26\30\1\33\3\10\4\33\1\34\30\33\1\35\3\10" +
                    "\31\35\1\36\3\35\37\37\1\40\1\37\1\7\4\0" +
                    "\1\7\1\0\1\7\1\0\30\7\1\0\3\10\76\0" +
                    "\1\12\1\41\1\42\1\0\1\41\1\12\1\41\1\12" +
                    "\1\41\25\12\1\43\1\12\2\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\22\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\3\15\1\44\16\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\13\15\1\45\6\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\12\15\1\46\7\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\5\15\1\47" +
                    "\14\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\5\15\1\50\7\15\1\51\4\15\4\7\6\25" +
                    "\1\0\3\25\1\52\30\25\2\0\34\25\1\0\4\30" +
                    "\1\0\5\30\1\53\30\30\2\0\34\30\1\0\1\33" +
                    "\3\0\4\33\1\0\30\33\37\37\1\0\1\37\2\41" +
                    "\1\42\1\0\32\41\1\54\1\41\1\0\1\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\3\15\1\55" +
                    "\16\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\12\15\1\56\7\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\3\15\1\57\16\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\20\15" +
                    "\1\60\1\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\16\15\1\61\3\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\11\15\1\62\10\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\5\15\1\63\14\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\16\15\1\64\3\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\11\15\1\65" +
                    "\10\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\14\15\1\66\5\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\1\67\21\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\1\70\21\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\15\15\1\71\4\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\5\15\1\72\14\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\17\15\1\73" +
                    "\2\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\7\15\1\74\12\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\2\15\1\75\17\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\3\15" +
                    "\1\76\16\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\15\15\1\77\4\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\12\15\1\100\7\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\4\15\1\101\15\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\16\15\1\102\3\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\21\15\1\103" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\5\15\1\104\14\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\1\105\21\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\16\15\1\106\3\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\5\15\1\107\14\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\5\15\1\110\14\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\1\111\21\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\14\15\1\112\5\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\2\15\1\113\17\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\1\114\21\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\1\115\21\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\11\15\1\116\10\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\16\15\1\117\3\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\21\15\1\120\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\2\15\1\121\17\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\2\15\1\122\17\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\17\15\1\123\2\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\7\15\1\124\12\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\1\125\21\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\21\15\1\126\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\21\15\1\127\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\1\15\1\130\20\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\6\15" +
                    "\1\131\13\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\11\15\1\132\10\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\1\133\21\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\1\134" +
                    "\21\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\1\135\21\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\7\15\1\136\12\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\17\15\1\137" +
                    "\2\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\11\15\1\140\10\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\11\15\1\141\10\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\2\15" +
                    "\1\142\17\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\3\15\1\143\16\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\1\15\1\144\20\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\17\15\1\145\2\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\17\15\1\146\2\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\11\15\1\147" +
                    "\10\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\1\15\1\150\20\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\1\151\21\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\1\15\1\152" +
                    "\20\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\1\15\1\153\20\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\13\15\1\154\6\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\16\15" +
                    "\1\155\3\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\2\15\1\156\17\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\1\157\21\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\1\160" +
                    "\21\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\3\15\1\161\16\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\5\15\1\162\14\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\11\15" +
                    "\1\163\10\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\2\15\1\164\17\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\2\15\1\165\17\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\10\15\1\166\11\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\1\167\21\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\13\15\1\170\6\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\11\15\1\171\10\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\11\15\1\172\10\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\2\15\1\173" +
                    "\17\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\3\15\1\174\16\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\13\15\1\175\6\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\13\15" +
                    "\1\176\6\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\21\15\1\177\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\10\15\1\200\11\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\3\15" +
                    "\1\201\16\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\3\15\1\202\16\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\1\203\21\15\5\7" +
                    "\4\0\1\7\1\0\1\15\1\0\1\15\1\7\10\15" +
                    "\1\204\11\15\5\7\4\0\1\7\1\0\1\15\1\0" +
                    "\1\15\1\7\10\15\1\205\11\15\5\7\4\0\1\7" +
                    "\1\0\1\15\1\0\1\15\1\7\11\15\1\206\10\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\17\15\1\207\2\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\1\15\1\210\20\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\1\211\21\15" +
                    "\5\7\4\0\1\7\1\0\1\15\1\0\1\15\1\7" +
                    "\2\15\1\212\17\15\5\7\4\0\1\7\1\0\1\15" +
                    "\1\0\1\15\1\7\11\15\1\213\10\15\5\7\4\0" +
                    "\1\7\1\0\1\15\1\0\1\15\1\7\13\15\1\214" +
                    "\6\15\5\7\4\0\1\7\1\0\1\15\1\0\1\15" +
                    "\1\7\3\15\1\215\16\15\5\7\4\0\1\7\1\0" +
                    "\1\15\1\0\1\15\1\7\10\15\1\216\11\15\4\7";

    private static int[] zzUnpacktrans() {
        int[] result = new int[3993];
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

    /**
     * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
     */
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();

    private static final String ZZ_ATTRIBUTE_PACKED_0 =
            "\6\0\2\1\1\11\1\1\2\11\11\1\1\11\2\1" +
                    "\1\11\2\1\3\11\1\1\1\11\1\0\1\11\7\1" +
                    "\2\0\143\1";

    private static int[] zzUnpackAttribute() {
        int[] result = new int[142];
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
     * the input device
     */
    private java.io.Reader zzReader;

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
     * Number of characters from the last newline up to the start of the matched text.
     */
    @SuppressWarnings("unused")
    protected int yycolumn;

    /**
     * Number of characters up to the start of the matched text.
     */
    @SuppressWarnings("unused")
    private long yychar;
    /* user code: */
    public NginxLexer() {
        this((java.io.Reader) null);
    }

    Deque<Integer> stack = new ArrayDeque<Integer>();

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
     * Creates a new scanner
     *
     * @param in the java.io.Reader to read input from.
     */
    public NginxLexer(java.io.Reader in) {
        this.zzReader = in;
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

    /**
     * Translates raw input code points to DFA table row
     */
    private static int zzCMap(int input) {
        int offset = input & 255;
        return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
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
                    case 27:
                        break;
                    case 2: {
                        return WHITE_SPACE;
                    }
                    // fall through
                    case 28:
                        break;
                    case 3: {
                        yypush(DQSTRING_STATE);
                        return DQUOTE;
                    }
                    // fall through
                    case 29:
                        break;
                    case 4: {
                        yypush(STRING_STATE);
                        return QUOTE;
                    }
                    // fall through
                    case 30:
                        break;
                    case 5: {
                        return SEMICOLON;
                    }
                    // fall through
                    case 31:
                        break;
                    case 6: {
                        return IDENTIFIER;
                    }
                    // fall through
                    case 32:
                        break;
                    case 7: {
                        return LBRACE;
                    }
                    // fall through
                    case 33:
                        break;
                    case 8: {
                        return RBRACE;
                    }
                    // fall through
                    case 34:
                        break;
                    case 9: {
                        return STRING;
                    }
                    // fall through
                    case 35:
                        break;
                    case 10: {
                        yypop();
                        return QUOTE;
                    }
                    // fall through
                    case 36:
                        break;
                    case 11: {
                        yyinitial();
                        return BAD_CHARACTER;
                    }
                    // fall through
                    case 37:
                        break;
                    case 12: {
                        return DQSTRING;
                    }
                    // fall through
                    case 38:
                        break;
                    case 13: {
                        yypop();
                        return DQUOTE;
                    }
                    // fall through
                    case 39:
                        break;
                    case 14: {
                        return INCLUDE_TARGET;
                    }
                    // fall through
                    case 40:
                        break;
                    case 15: {
                        yypop();
                        return SEMICOLON;
                    }
                    // fall through
                    case 41:
                        break;
                    case 16: {
                        yypop();
                        return BAD_CHARACTER;
                    }
                    // fall through
                    case 42:
                        break;
                    case 17: {
                        yypush(LUA_STATE);
                        return LBRACE;
                    }
                    // fall through
                    case 43:
                        break;
                    case 18: {
                        return LUA;
                    }
                    // fall through
                    case 44:
                        break;
                    case 19: {
                        yypop();
                        yypop();
                        return RBRACE;
                    }
                    // fall through
                    case 45:
                        break;
                    case 20: {
                        return COMMENT;
                    }
                    // fall through
                    case 46:
                        break;
                    case 21: {
                        yypush(INCLUDE_STATE);
                        return INCLUDE;
                    }
                    // fall through
                    case 47:
                        break;
                    case 22: {
                        yypush(LUA_BLOCK_STATE);
                        return SET_BY_LUA_BLOCK;
                    }
                    // fall through
                    case 48:
                        break;
                    case 23: {
                        yypush(LUA_BLOCK_STATE);
                        return ACCESS_BY_LUA_BLOCK;
                    }
                    // fall through
                    case 49:
                        break;
                    case 24: {
                        yypush(LUA_BLOCK_STATE);
                        return CONTENT_BY_LUA_BLOCK;
                    }
                    // fall through
                    case 50:
                        break;
                    case 25: {
                        yypush(LUA_BLOCK_STATE);
                        return REWRITE_BY_LUA_BLOCK;
                    }
                    // fall through
                    case 51:
                        break;
                    case 26: {
                        yypush(LUA_BLOCK_STATE);
                        return SSL_CERTIFICATE_BY_LUA_BLOCK;
                    }
                    // fall through
                    case 52:
                        break;
                    default:
                        zzScanError(ZZ_NO_MATCH);
                }
            }
        }
    }


}
