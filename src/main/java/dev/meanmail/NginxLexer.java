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

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING_STATE = 2;
  public static final int DQSTRING_STATE = 4;
  public static final int LUA_BLOCK_STATE = 6;
  public static final int LUA_STATE = 8;
  public static final int MAP_STATE = 10;
  public static final int MAP_BLOCK_STATE = 12;
  public static final int GEO_STATE = 14;
  public static final int GEO_BLOCK_STATE = 16;
  public static final int IF_STATE = 18;
  public static final int IF_PAREN_STATE = 20;
  public static final int DIRECTIVE_STATE = 22;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7,  7, 
     8,  8,  9,  9, 10, 10, 11, 11
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\25\u0100\1\u0200\11\u0100\1\u0300\17\u0100\1\u0400\u10cf\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
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
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\2\1\1\2\22\0\1\1\1\3"+
    "\1\4\1\5\1\6\2\0\1\7\1\10\1\11\1\12"+
    "\2\0\1\13\2\0\12\14\1\0\1\15\1\0\1\16"+
    "\3\0\32\17\1\0\1\20\1\0\1\21\1\22\1\0"+
    "\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\34\1\43\1\44\1\45\1\46\1\47\1\34\1\50"+
    "\1\51\1\34\1\52\1\0\1\53\1\54\6\0\1\1"+
    "\32\0\1\1\u01df\0\1\1\177\0\13\1\35\0\2\1"+
    "\5\0\1\1\57\0\1\1\240\0\1\1\377\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1280];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
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
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\14\0\1\1\1\2\1\3\6\4\1\5\2\6\1\7"+
    "\1\1\1\10\1\11\1\10\1\1\1\12\1\13\1\12"+
    "\1\14\1\15\1\16\1\17\2\20\1\21\1\22\4\12"+
    "\1\23\4\12\1\24\1\25\3\12\1\26\1\12\1\27"+
    "\1\16\1\27\1\12\1\30\1\27\1\12\1\27\2\4"+
    "\1\31\2\4\1\0\1\3\1\0\1\3\1\32\1\0"+
    "\10\12\1\32\1\33\1\34\1\4\1\35\1\4\1\36"+
    "\2\32\11\12\2\4\11\12\2\4\7\12\1\37\1\12"+
    "\2\4\5\12\1\40\1\12\1\41\2\4\1\42\1\12"+
    "\1\43\1\12\1\44\1\45\1\4\1\46\1\12\1\47"+
    "\1\4\1\50\4\4\1\51";

  private static int [] zzUnpackAction() {
    int [] result = new int[153];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
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
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\55\0\132\0\207\0\264\0\341\0\u010e\0\u013b"+
    "\0\u0168\0\u0195\0\u01c2\0\u01ef\0\u021c\0\u0249\0\u0276\0\u02a3"+
    "\0\u02d0\0\u02fd\0\u032a\0\u0357\0\u0384\0\u021c\0\u03b1\0\u03de"+
    "\0\u021c\0\u040b\0\u0438\0\u021c\0\u0465\0\u0492\0\u04bf\0\u021c"+
    "\0\u04ec\0\u021c\0\u021c\0\u0519\0\u021c\0\u0546\0\u0573\0\u021c"+
    "\0\u021c\0\u05a0\0\u05cd\0\u05fa\0\u0627\0\u021c\0\u0654\0\u0681"+
    "\0\u06ae\0\u06db\0\u021c\0\u021c\0\u0708\0\u0735\0\u0762\0\u021c"+
    "\0\u078f\0\u0708\0\u07bc\0\u07e9\0\u0816\0\u021c\0\u04bf\0\u0843"+
    "\0\u0870\0\u089d\0\u08ca\0\u02d0\0\u08f7\0\u0924\0\u040b\0\u0951"+
    "\0\u0492\0\u097e\0\u09ab\0\u09d8\0\u0a05\0\u0a32\0\u0a5f\0\u0a8c"+
    "\0\u0ab9\0\u0ae6\0\u0b13\0\u0b40\0\u0b6d\0\u0708\0\u04bf\0\u0b9a"+
    "\0\u02d0\0\u0bc7\0\u02d0\0\u021c\0\u0bf4\0\u0c21\0\u0c4e\0\u0c7b"+
    "\0\u0ca8\0\u0cd5\0\u0d02\0\u0d2f\0\u0d5c\0\u0d89\0\u0db6\0\u0de3"+
    "\0\u0e10\0\u0e3d\0\u0e6a\0\u0e97\0\u0ec4\0\u0ef1\0\u0f1e\0\u0f4b"+
    "\0\u0f78\0\u0fa5\0\u0fd2\0\u0fff\0\u102c\0\u1059\0\u1086\0\u10b3"+
    "\0\u10e0\0\u110d\0\u04bf\0\u113a\0\u1167\0\u1194\0\u11c1\0\u11ee"+
    "\0\u121b\0\u1248\0\u1275\0\u04bf\0\u12a2\0\u04bf\0\u12cf\0\u12fc"+
    "\0\u04bf\0\u1329\0\u04bf\0\u1356\0\u04bf\0\u04bf\0\u1383\0\u02d0"+
    "\0\u13b0\0\u04bf\0\u13dd\0\u04bf\0\u140a\0\u1437\0\u1464\0\u1491"+
    "\0\u02d0";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[153];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
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
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\15\2\16\2\15\1\17\11\15\1\20\2\15\7\21"+
    "\1\22\1\21\1\23\2\21\1\24\1\25\12\21\1\15"+
    "\1\26\1\15\5\27\1\30\1\27\1\31\10\27\1\32"+
    "\34\27\4\33\1\34\1\35\12\33\1\36\34\33\1\37"+
    "\2\16\1\37\1\40\1\17\1\41\1\42\5\37\1\43"+
    "\1\37\1\44\2\37\30\44\1\45\1\15\1\37\5\46"+
    "\1\47\45\46\1\50\1\46\1\37\2\16\1\37\1\40"+
    "\1\17\1\41\1\42\5\37\1\43\1\37\1\44\2\37"+
    "\30\44\1\51\1\15\2\37\2\16\1\37\1\40\1\17"+
    "\1\37\1\42\5\37\1\43\10\37\1\52\3\37\1\53"+
    "\1\54\13\37\1\55\2\37\1\15\1\50\2\37\2\16"+
    "\1\37\1\40\1\17\1\41\1\42\5\37\1\43\1\37"+
    "\1\44\2\37\30\44\1\56\1\15\2\37\2\16\1\37"+
    "\1\40\1\17\1\37\1\42\5\37\1\43\10\37\1\57"+
    "\4\37\1\60\6\37\1\61\1\62\6\37\1\15\1\50"+
    "\1\37\1\15\2\16\2\15\1\17\2\15\1\63\41\15"+
    "\1\64\2\15\1\65\2\16\1\66\1\40\1\17\1\67"+
    "\1\42\1\15\1\70\1\65\1\71\1\65\1\15\1\72"+
    "\1\73\2\65\30\73\2\15\1\74\1\37\2\16\1\75"+
    "\1\40\1\17\1\41\1\42\5\37\1\76\1\77\1\44"+
    "\1\37\1\100\30\44\1\64\1\15\1\101\56\0\2\16"+
    "\52\0\2\17\1\0\52\17\14\0\1\20\2\0\1\20"+
    "\2\0\30\20\17\0\1\20\2\0\1\20\2\0\1\102"+
    "\27\21\17\0\1\20\2\0\1\20\2\0\1\102\4\21"+
    "\1\103\22\21\17\0\1\20\2\0\1\20\2\0\1\102"+
    "\5\21\1\104\21\21\17\0\1\20\2\0\1\20\2\0"+
    "\1\102\16\21\1\105\10\21\17\0\1\20\2\0\1\20"+
    "\2\0\1\102\1\106\26\21\3\0\7\27\1\0\10\27"+
    "\1\107\34\27\2\30\1\27\4\30\1\17\10\30\1\110"+
    "\34\30\2\27\1\0\52\27\4\33\1\0\13\33\1\111"+
    "\34\33\2\35\1\33\1\35\1\17\13\35\1\112\34\35"+
    "\2\33\1\0\52\33\1\37\2\0\1\37\2\0\1\37"+
    "\1\0\5\37\1\0\34\37\2\0\2\37\2\0\1\37"+
    "\2\0\1\37\1\0\5\37\1\0\1\37\1\113\2\37"+
    "\30\113\1\114\1\0\2\37\2\0\1\37\2\0\1\37"+
    "\1\0\4\37\1\44\1\0\1\37\1\44\2\37\30\44"+
    "\2\0\1\37\53\46\1\0\1\46\2\47\1\46\50\47"+
    "\1\17\1\47\1\37\2\0\1\37\2\0\1\37\1\0"+
    "\5\37\1\0\11\37\1\115\22\37\2\0\2\37\2\0"+
    "\1\37\2\0\1\37\1\0\5\37\1\0\23\37\1\116"+
    "\10\37\2\0\2\37\2\0\1\37\2\0\1\37\1\0"+
    "\5\37\1\0\22\37\1\117\11\37\2\0\2\37\2\0"+
    "\1\37\2\0\1\37\1\0\5\37\1\0\23\37\1\120"+
    "\10\37\2\0\2\37\2\0\1\37\2\0\1\37\1\0"+
    "\5\37\1\0\11\37\1\121\22\37\2\0\2\37\2\0"+
    "\1\37\2\0\1\37\1\0\5\37\1\0\22\37\1\122"+
    "\11\37\2\0\2\37\2\0\1\37\2\0\1\37\1\0"+
    "\5\37\1\0\25\37\1\123\6\37\2\0\2\37\2\0"+
    "\1\37\2\0\1\37\1\0\5\37\1\0\5\37\1\124"+
    "\26\37\2\0\1\37\1\65\2\0\1\65\2\0\1\65"+
    "\3\0\3\65\1\0\34\65\2\0\2\65\2\0\1\65"+
    "\2\0\1\65\3\0\1\65\1\71\1\65\1\0\1\72"+
    "\33\65\2\0\1\74\1\65\2\0\1\65\2\0\1\65"+
    "\3\0\3\65\1\0\1\65\1\125\2\65\30\125\1\114"+
    "\1\0\2\65\2\0\1\65\2\0\1\65\3\0\3\65"+
    "\1\0\10\65\3\126\17\65\1\126\1\65\2\0\2\65"+
    "\2\0\1\65\2\0\1\65\3\0\2\65\1\73\1\0"+
    "\1\65\1\73\2\65\30\73\2\0\2\65\2\0\1\65"+
    "\2\0\1\65\3\0\1\72\2\65\1\0\34\65\2\0"+
    "\1\65\1\37\2\0\1\37\2\0\1\37\1\0\5\37"+
    "\1\0\1\77\33\37\2\0\1\101\1\37\2\0\1\37"+
    "\2\0\1\37\1\0\5\37\1\0\34\37\2\0\1\127"+
    "\1\37\2\0\1\37\2\0\1\37\1\0\2\37\1\77"+
    "\2\37\1\0\34\37\2\0\1\37\14\0\1\20\2\0"+
    "\1\20\2\0\1\102\1\21\1\130\25\21\17\0\1\20"+
    "\2\0\1\20\2\0\1\102\16\21\1\131\10\21\17\0"+
    "\1\20\2\0\1\20\2\0\1\102\2\21\1\132\24\21"+
    "\17\0\1\20\2\0\1\20\2\0\1\102\17\21\1\133"+
    "\7\21\3\0\2\30\1\0\52\30\2\35\1\0\52\35"+
    "\1\37\2\0\1\37\2\0\1\37\1\0\4\37\1\113"+
    "\1\0\1\37\1\113\2\37\30\113\1\0\1\134\1\37"+
    "\17\0\1\135\2\0\30\135\3\0\1\37\2\0\1\37"+
    "\2\0\1\37\1\0\5\37\1\0\12\37\1\136\21\37"+
    "\2\0\2\37\2\0\1\37\2\0\1\37\1\0\5\37"+
    "\1\0\26\37\1\137\5\37\2\0\2\37\2\0\1\37"+
    "\2\0\1\37\1\0\5\37\1\0\7\37\1\140\24\37"+
    "\2\0\2\37\2\0\1\37\2\0\1\37\1\0\5\37"+
    "\1\0\20\37\1\141\13\37\2\0\2\37\2\0\1\37"+
    "\2\0\1\37\1\0\5\37\1\0\12\37\1\142\5\37"+
    "\1\143\13\37\2\0\2\37\2\0\1\37\2\0\1\37"+
    "\1\0\5\37\1\0\7\37\1\144\24\37\2\0\2\37"+
    "\2\0\1\37\2\0\1\37\1\0\5\37\1\0\23\37"+
    "\1\145\10\37\2\0\2\37\2\0\1\37\2\0\1\37"+
    "\1\0\5\37\1\0\22\37\1\146\11\37\2\0\1\37"+
    "\1\65\2\0\1\65\2\0\1\65\3\0\2\65\1\125"+
    "\1\0\1\65\1\125\2\65\30\125\1\0\1\134\1\65"+
    "\14\0\1\20\2\0\1\20\2\0\1\102\26\21\1\147"+
    "\17\0\1\20\2\0\1\20\2\0\1\102\1\150\26\21"+
    "\17\0\1\135\2\0\1\135\2\0\30\135\1\0\1\134"+
    "\1\0\1\37\2\0\1\37\2\0\1\37\1\0\5\37"+
    "\1\0\5\37\1\151\26\37\2\0\2\37\2\0\1\37"+
    "\2\0\1\37\1\0\5\37\1\0\27\37\1\152\4\37"+
    "\2\0\2\37\2\0\1\37\2\0\1\37\1\0\5\37"+
    "\1\0\20\37\1\153\13\37\2\0\2\37\2\0\1\37"+
    "\2\0\1\37\1\0\5\37\1\0\5\37\1\154\26\37"+
    "\2\0\2\37\2\0\1\37\2\0\1\37\1\0\5\37"+
    "\1\0\5\37\1\155\26\37\2\0\2\37\2\0\1\37"+
    "\2\0\1\37\1\0\5\37\1\0\11\37\1\156\22\37"+
    "\2\0\2\37\2\0\1\37\2\0\1\37\1\0\5\37"+
    "\1\0\20\37\1\157\13\37\2\0\2\37\2\0\1\37"+
    "\2\0\1\37\1\0\5\37\1\0\32\37\1\160\1\37"+
    "\2\0\2\37\2\0\1\37\2\0\1\37\1\0\5\37"+
    "\1\0\13\37\1\161\20\37\2\0\1\37\14\0\1\20"+
    "\2\0\1\20\2\0\1\162\27\21\17\0\1\20\2\0"+
    "\1\20\2\0\1\102\22\21\1\163\4\21\3\0\1\37"+
    "\2\0\1\37\2\0\1\37\1\0\5\37\1\0\30\37"+
    "\1\164\3\37\2\0\2\37\2\0\1\37\2\0\1\37"+
    "\1\0\5\37\1\0\22\37\1\165\11\37\2\0\2\37"+
    "\2\0\1\37\2\0\1\37\1\0\5\37\1\0\30\37"+
    "\1\166\3\37\2\0\2\37\2\0\1\37\2\0\1\37"+
    "\1\0\5\37\1\0\27\37\1\167\4\37\2\0\2\37"+
    "\2\0\1\37\2\0\1\37\1\0\5\37\1\0\30\37"+
    "\1\170\3\37\2\0\2\37\2\0\1\37\2\0\1\37"+
    "\1\0\5\37\1\0\27\37\1\171\4\37\2\0\2\37"+
    "\2\0\1\37\2\0\1\37\1\0\5\37\1\0\30\37"+
    "\1\172\3\37\2\0\2\37\2\0\1\37\2\0\1\37"+
    "\1\0\5\37\1\0\33\37\1\173\2\0\2\37\2\0"+
    "\1\37\2\0\1\37\1\0\5\37\1\0\11\37\1\174"+
    "\22\37\2\0\1\37\14\0\1\20\2\0\1\20\2\0"+
    "\1\102\1\21\1\130\11\21\1\175\13\21\17\0\1\20"+
    "\2\0\1\20\2\0\1\102\10\21\1\176\16\21\3\0"+
    "\1\37\2\0\1\37\2\0\1\37\1\0\5\37\1\0"+
    "\20\37\1\177\13\37\2\0\2\37\2\0\1\37\2\0"+
    "\1\37\1\0\5\37\1\0\5\37\1\200\26\37\2\0"+
    "\2\37\2\0\1\37\2\0\1\37\1\0\5\37\1\0"+
    "\10\37\1\201\23\37\2\0\2\37\2\0\1\37\2\0"+
    "\1\37\1\0\5\37\1\0\15\37\1\202\16\37\2\0"+
    "\2\37\2\0\1\37\2\0\1\37\1\0\5\37\1\0"+
    "\20\37\1\203\13\37\2\0\2\37\2\0\1\37\2\0"+
    "\1\37\1\0\5\37\1\0\11\37\1\204\22\37\2\0"+
    "\2\37\2\0\1\37\2\0\1\37\1\0\5\37\1\0"+
    "\10\37\1\205\23\37\2\0\2\37\2\0\1\37\2\0"+
    "\1\37\1\0\5\37\1\0\26\37\1\206\5\37\2\0"+
    "\1\37\14\0\1\20\2\0\1\20\2\0\1\102\23\21"+
    "\1\207\3\21\17\0\1\20\2\0\1\20\2\0\1\102"+
    "\16\21\1\210\10\21\3\0\1\37\2\0\1\37\2\0"+
    "\1\37\1\0\5\37\1\0\27\37\1\211\4\37\2\0"+
    "\2\37\2\0\1\37\2\0\1\37\1\0\5\37\1\0"+
    "\21\37\1\212\12\37\2\0\2\37\2\0\1\37\2\0"+
    "\1\37\1\0\5\37\1\0\11\37\1\213\22\37\2\0"+
    "\2\37\2\0\1\37\2\0\1\37\1\0\5\37\1\0"+
    "\20\37\1\214\13\37\2\0\2\37\2\0\1\37\2\0"+
    "\1\37\1\0\5\37\1\0\27\37\1\215\4\37\2\0"+
    "\2\37\2\0\1\37\2\0\1\37\1\0\5\37\1\0"+
    "\11\37\1\216\22\37\2\0\1\37\14\0\1\20\2\0"+
    "\1\20\2\0\1\102\1\217\26\21\17\0\1\20\2\0"+
    "\1\20\2\0\1\102\15\21\1\220\11\21\3\0\1\37"+
    "\2\0\1\37\2\0\1\37\1\0\5\37\1\0\11\37"+
    "\1\221\22\37\2\0\2\37\2\0\1\37\2\0\1\37"+
    "\1\0\5\37\1\0\11\37\1\222\22\37\2\0\1\37"+
    "\14\0\1\20\2\0\1\20\2\0\1\223\27\21\3\0"+
    "\1\37\2\0\1\37\2\0\1\37\1\0\5\37\1\0"+
    "\26\37\1\224\5\37\2\0\1\37\14\0\1\20\2\0"+
    "\1\20\2\0\1\102\1\21\1\225\25\21\17\0\1\20"+
    "\2\0\1\20\2\0\1\102\13\21\1\226\12\21\1\147"+
    "\17\0\1\20\2\0\1\20\2\0\1\102\16\21\1\227"+
    "\10\21\17\0\1\20\2\0\1\20\2\0\1\102\2\21"+
    "\1\230\24\21\17\0\1\20\2\0\1\20\2\0\1\102"+
    "\12\21\1\231\14\21\3\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[5310];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
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
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\14\0\1\11\10\1\1\11\2\1\1\11\2\1\1\11"+
    "\3\1\1\11\1\1\2\11\1\1\1\11\2\1\2\11"+
    "\4\1\1\11\4\1\2\11\3\1\1\11\5\1\1\11"+
    "\10\1\1\0\1\1\1\0\2\1\1\0\17\1\1\11"+
    "\75\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[153];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
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

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  protected int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
  public NginxLexer() {
      this((java.io.Reader)null);
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
   * @param   in  the java.io.Reader to read input from.
   */
  public NginxLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
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
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
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
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
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
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { yyinitial(); return BAD_CHARACTER;
            }
          // fall through
          case 42: break;
          case 2:
            { return WHITE_SPACE;
            }
          // fall through
          case 43: break;
          case 3:
            { return COMMENT;
            }
          // fall through
          case 44: break;
          case 4:
            { yypush(DIRECTIVE_STATE); return IDENTIFIER;
            }
          // fall through
          case 45: break;
          case 5:
            { return RBRACE;
            }
          // fall through
          case 46: break;
          case 6:
            { return STRING;
            }
          // fall through
          case 47: break;
          case 7:
            { yypop(); return QUOTE;
            }
          // fall through
          case 48: break;
          case 8:
            { return DQSTRING;
            }
          // fall through
          case 49: break;
          case 9:
            { yypop(); return DQUOTE;
            }
          // fall through
          case 50: break;
          case 10:
            { return VALUE;
            }
          // fall through
          case 51: break;
          case 11:
            { yypush(DQSTRING_STATE); return DQUOTE;
            }
          // fall through
          case 52: break;
          case 12:
            { yypush(STRING_STATE); return QUOTE;
            }
          // fall through
          case 53: break;
          case 13:
            { return SEMICOLON;
            }
          // fall through
          case 54: break;
          case 14:
            { return IDENTIFIER;
            }
          // fall through
          case 55: break;
          case 15:
            { yypush(LUA_STATE); return LBRACE;
            }
          // fall through
          case 56: break;
          case 16:
            { return LUA;
            }
          // fall through
          case 57: break;
          case 17:
            { yypop(); yypop(); return RBRACE;
            }
          // fall through
          case 58: break;
          case 18:
            { yypush(MAP_BLOCK_STATE); return LBRACE;
            }
          // fall through
          case 59: break;
          case 19:
            { yypush(GEO_BLOCK_STATE); return LBRACE;
            }
          // fall through
          case 60: break;
          case 20:
            { yypush(IF_PAREN_STATE); return LPAREN;
            }
          // fall through
          case 61: break;
          case 21:
            { yypop(); return LBRACE;
            }
          // fall through
          case 62: break;
          case 22:
            { yypop(); return RPAREN;
            }
          // fall through
          case 63: break;
          case 23:
            { return BINARY_OPERATOR;
            }
          // fall through
          case 64: break;
          case 24:
            { yypop(); return SEMICOLON;
            }
          // fall through
          case 65: break;
          case 25:
            { yypush(IF_STATE); return IF;
            }
          // fall through
          case 66: break;
          case 26:
            { return VARIABLE;
            }
          // fall through
          case 67: break;
          case 27:
            { return UNARY_OPERATOR;
            }
          // fall through
          case 68: break;
          case 28:
            { return CARET_TILDE;
            }
          // fall through
          case 69: break;
          case 29:
            { yypush(GEO_STATE); return GEO;
            }
          // fall through
          case 70: break;
          case 30:
            { yypush(MAP_STATE); return MAP;
            }
          // fall through
          case 71: break;
          case 31:
            { return GEO_PROXY;
            }
          // fall through
          case 72: break;
          case 32:
            { return GEO_DELETE;
            }
          // fall through
          case 73: break;
          case 33:
            { return GEO_RANGES;
            }
          // fall through
          case 74: break;
          case 34:
            { return MAP_DEFAULT;
            }
          // fall through
          case 75: break;
          case 35:
            { return MAP_INCLUDE;
            }
          // fall through
          case 76: break;
          case 36:
            { return GEO_DEFAULT;
            }
          // fall through
          case 77: break;
          case 37:
            { return GEO_INCLUDE;
            }
          // fall through
          case 78: break;
          case 38:
            { yypush(DIRECTIVE_STATE); return LOCATION;
            }
          // fall through
          case 79: break;
          case 39:
            { return MAP_VOLATILE;
            }
          // fall through
          case 80: break;
          case 40:
            { return MAP_HOSTNAMES;
            }
          // fall through
          case 81: break;
          case 41:
            { yypush(LUA_BLOCK_STATE); return LUA_BLOCK_DIRECTIVE;
            }
          // fall through
          case 82: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
