// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: src/lexercup.flex

/* JF1ex exarnole: partial Java language lexer specification */

import java_cup.runtime.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/* This class is a simple example lexer. */

/* Lexer base tomado de la página de Cup que requiere sym para utilizarse como Lexer */

/* Este lexer es utilizado por el parser generado por BasicLexerCup (parser.java que se genera) */


@SuppressWarnings("fallthrough")
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1, 1
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

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
    "\11\0\1\1\1\2\1\3\1\4\1\5\22\0\1\1"+
    "\1\0\1\6\1\7\3\0\1\10\5\0\1\11\1\12"+
    "\1\13\1\14\11\15\7\0\32\16\1\0\1\17\2\0"+
    "\1\20\1\0\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\2\16\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
    "\1\46\1\47\1\50\12\0\1\3\u01a2\0\2\3\326\0"+
    "\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
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
    "\2\0\1\1\2\2\1\3\1\4\2\1\2\5\24\1"+
    "\1\6\1\7\1\1\2\4\51\0\1\10\1\11\1\12"+
    "\1\13\1\14\1\0\1\15\1\0\1\16\63\0\1\17"+
    "\11\0\1\20\3\0\1\21\13\0\1\22\15\0\1\23"+
    "\3\0\1\24\3\0\1\22\5\0\1\25\2\0\1\26"+
    "\3\0\1\27\1\30\1\0\1\31\16\0\1\32\1\33"+
    "\1\34\5\0\1\35\1\36\11\0\1\37\1\40\1\0"+
    "\1\41\1\42\12\0\1\43\1\0\1\44\4\0\1\45"+
    "\1\46\1\47\2\0\1\50\1\0\1\51\1\52\3\0"+
    "\1\53\1\54\1\55\3\0\1\56\2\0\1\57\2\0"+
    "\1\60\1\61\6\0\1\62\1\63\2\0\1\64\1\0"+
    "\1\65\4\0\1\66\1\67\3\0\1\70\1\71\1\0"+
    "\1\72\1\73";

  private static int [] zzUnpackAction() {
    int [] result = new int[310];
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
    "\0\0\0\51\0\122\0\122\0\173\0\122\0\244\0\315"+
    "\0\366\0\u011f\0\u0148\0\u0171\0\u019a\0\u01c3\0\u01ec\0\u0215"+
    "\0\u023e\0\u0267\0\u0290\0\u02b9\0\u02e2\0\u030b\0\u0334\0\u035d"+
    "\0\u0386\0\u03af\0\u03d8\0\u0401\0\u042a\0\u0453\0\u047c\0\u04a5"+
    "\0\122\0\u04ce\0\122\0\u04f7\0\u0520\0\u0549\0\u0572\0\u059b"+
    "\0\u05c4\0\u05ed\0\u0616\0\u063f\0\u0668\0\u0691\0\u06ba\0\u06e3"+
    "\0\u070c\0\u0735\0\u075e\0\u0787\0\u07b0\0\u07d9\0\u0802\0\u082b"+
    "\0\u0854\0\u087d\0\u08a6\0\u08cf\0\u08f8\0\u0921\0\u094a\0\u0973"+
    "\0\u099c\0\u09c5\0\u09ee\0\u0a17\0\u0a40\0\u0a69\0\u0a92\0\u0abb"+
    "\0\u0ae4\0\u0b0d\0\u0b36\0\u0b5f\0\u0b88\0\122\0\122\0\122"+
    "\0\122\0\122\0\u0bb1\0\u059b\0\u0bda\0\122\0\u0c03\0\u0c2c"+
    "\0\u0c55\0\u0c7e\0\u0ca7\0\u0cd0\0\u0cf9\0\u0d22\0\u0d4b\0\u0d74"+
    "\0\u0d9d\0\u0dc6\0\u0def\0\u0e18\0\u0e41\0\u0e6a\0\u0e93\0\u0ebc"+
    "\0\u0ee5\0\u0f0e\0\u0f37\0\u0f60\0\u0f89\0\u0fb2\0\u0fdb\0\u1004"+
    "\0\u102d\0\u1056\0\u107f\0\u10a8\0\u10d1\0\u10fa\0\u1123\0\u114c"+
    "\0\u1175\0\u119e\0\u11c7\0\u11f0\0\u1219\0\u1242\0\u126b\0\u1294"+
    "\0\u12bd\0\u12e6\0\u130f\0\u1338\0\u1361\0\u138a\0\u13b3\0\u13dc"+
    "\0\u1405\0\122\0\u142e\0\u1457\0\u1480\0\u14a9\0\u14d2\0\u14fb"+
    "\0\u1524\0\u154d\0\u1576\0\122\0\u159f\0\u15c8\0\u15f1\0\122"+
    "\0\u161a\0\u1643\0\u166c\0\u1695\0\u16be\0\u16e7\0\u1710\0\u1739"+
    "\0\u1762\0\u178b\0\u17b4\0\u17dd\0\u1806\0\u182f\0\u1858\0\u1881"+
    "\0\u18aa\0\u18d3\0\u18fc\0\u1925\0\u194e\0\u1977\0\u19a0\0\u19c9"+
    "\0\u19f2\0\122\0\u1a1b\0\u1a44\0\u1a6d\0\122\0\u1a96\0\u1abf"+
    "\0\u1ae8\0\122\0\u1b11\0\u1b3a\0\u1b63\0\u1b8c\0\u1bb5\0\122"+
    "\0\u1bde\0\u1c07\0\122\0\u1c30\0\u1c59\0\u1c82\0\122\0\122"+
    "\0\u1cab\0\122\0\u1cd4\0\u1cfd\0\u1d26\0\u1d4f\0\u1d78\0\u1da1"+
    "\0\u1dca\0\u1df3\0\u1e1c\0\u1e45\0\u1e6e\0\u1e97\0\u1ec0\0\u1ee9"+
    "\0\122\0\122\0\122\0\u1f12\0\u1f3b\0\u1f64\0\u1f8d\0\u1fb6"+
    "\0\122\0\122\0\u1fdf\0\u2008\0\u2031\0\u205a\0\u2083\0\u20ac"+
    "\0\u20d5\0\u20fe\0\u2127\0\122\0\122\0\u2150\0\122\0\122"+
    "\0\u2179\0\u21a2\0\u21cb\0\u21f4\0\u221d\0\u2246\0\u226f\0\u2298"+
    "\0\u22c1\0\u22ea\0\122\0\u2313\0\122\0\u233c\0\u2365\0\u238e"+
    "\0\u23b7\0\122\0\122\0\122\0\u23e0\0\u2409\0\122\0\u2432"+
    "\0\122\0\122\0\u245b\0\u2484\0\u24ad\0\122\0\122\0\122"+
    "\0\u24d6\0\u24ff\0\u2528\0\122\0\u2551\0\u257a\0\122\0\u25a3"+
    "\0\u25cc\0\122\0\122\0\u25f5\0\u261e\0\u2647\0\u2670\0\u2699"+
    "\0\u26c2\0\122\0\122\0\u26eb\0\u2714\0\122\0\u273d\0\122"+
    "\0\u2766\0\u278f\0\u27b8\0\u27e1\0\122\0\122\0\u280a\0\u2833"+
    "\0\u285c\0\122\0\122\0\u2885\0\122\0\122";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[310];
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
    "\1\3\2\4\1\3\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\2\3\1\12\1\13\1\3\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\3\1\27\1\30\1\31\1\3\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\4\3\2\40\1\3\2\40\1\3"+
    "\1\41\10\40\1\42\31\40\53\0\1\4\46\0\2\7"+
    "\1\43\2\7\1\44\43\7\10\0\1\45\54\0\1\46"+
    "\1\13\45\0\1\47\1\0\2\46\45\0\1\50\1\0"+
    "\2\13\53\0\1\51\46\0\1\52\2\0\23\52\1\53"+
    "\4\52\22\0\1\54\1\0\1\55\45\0\1\56\16\0"+
    "\1\57\41\0\1\60\3\0\1\61\5\0\1\62\50\0"+
    "\1\63\37\0\1\64\1\0\1\65\4\0\1\66\2\0"+
    "\1\67\25\0\1\70\7\0\1\71\40\0\1\72\16\0"+
    "\1\73\31\0\1\74\7\0\1\75\53\0\1\76\35\0"+
    "\1\77\3\0\1\100\3\0\1\101\40\0\1\102\13\0"+
    "\1\103\51\0\1\104\55\0\1\105\32\0\1\106\7\0"+
    "\1\107\44\0\1\110\2\0\1\111\54\0\1\112\42\0"+
    "\1\113\3\0\1\114\33\0\1\115\27\0\2\40\1\0"+
    "\2\40\2\0\10\40\1\0\31\40\6\0\1\116\10\0"+
    "\1\117\14\0\1\120\3\0\1\121\1\0\1\122\10\0"+
    "\1\43\56\0\1\123\52\0\1\50\1\0\2\46\47\0"+
    "\2\124\47\0\1\50\1\124\33\0\20\51\1\125\30\51"+
    "\14\0\3\52\1\0\1\126\30\52\14\0\3\52\1\0"+
    "\1\126\4\52\1\127\23\52\40\0\1\130\54\0\1\131"+
    "\36\0\1\132\53\0\1\133\40\0\1\134\56\0\1\135"+
    "\4\0\1\136\46\0\1\137\37\0\1\140\51\0\1\141"+
    "\64\0\1\142\1\0\1\143\27\0\1\144\52\0\1\145"+
    "\55\0\1\146\52\0\1\147\55\0\1\150\40\0\1\151"+
    "\43\0\1\152\65\0\1\153\51\0\1\154\35\0\1\155"+
    "\10\0\1\156\42\0\1\157\52\0\1\160\54\0\1\161"+
    "\3\0\1\162\27\0\1\163\52\0\1\164\54\0\1\165"+
    "\66\0\1\166\25\0\1\167\53\0\1\170\56\0\1\171"+
    "\56\0\1\172\47\0\1\173\27\0\1\174\67\0\1\175"+
    "\10\0\10\176\1\0\6\176\1\177\31\176\13\51\1\43"+
    "\35\51\14\0\3\52\1\0\1\126\17\52\1\200\10\52"+
    "\25\0\1\201\54\0\1\202\61\0\1\203\41\0\1\204"+
    "\55\0\1\205\35\0\1\206\65\0\1\207\37\0\1\210"+
    "\53\0\1\211\51\0\1\212\53\0\1\213\41\0\1\214"+
    "\11\0\1\215\50\0\1\216\45\0\1\217\51\0\1\220"+
    "\47\0\1\221\46\0\1\222\46\0\1\223\35\0\1\224"+
    "\71\0\1\225\33\0\1\226\60\0\1\227\62\0\1\230"+
    "\24\0\1\231\66\0\1\232\47\0\1\233\41\0\1\234"+
    "\47\0\1\235\54\0\1\236\41\0\1\237\50\0\1\240"+
    "\60\0\1\241\56\0\1\242\52\0\1\243\30\0\1\244"+
    "\54\0\1\245\61\0\1\246\37\0\1\247\27\0\1\250"+
    "\40\0\2\176\4\0\43\176\14\0\3\52\1\0\1\126"+
    "\1\251\27\52\23\0\1\252\1\0\1\253\12\0\1\254"+
    "\35\0\1\255\44\0\1\256\60\0\1\257\57\0\1\260"+
    "\52\0\1\261\27\0\1\262\53\0\1\263\50\0\1\264"+
    "\51\0\1\265\44\0\1\266\54\0\1\267\46\0\1\270"+
    "\54\0\1\271\46\0\1\272\50\0\1\273\44\0\1\274"+
    "\52\0\1\275\62\0\1\276\53\0\1\277\51\0\1\300"+
    "\37\0\1\301\62\0\1\302\27\0\1\303\53\0\1\304"+
    "\51\0\1\305\64\0\1\306\43\0\1\307\55\0\1\310"+
    "\41\0\1\311\43\0\1\312\45\0\1\313\62\0\1\314"+
    "\47\0\1\315\55\0\1\316\45\0\1\317\23\0\1\320"+
    "\54\0\3\52\1\0\1\126\13\52\1\321\14\52\43\0"+
    "\1\322\40\0\1\323\42\0\1\324\57\0\1\325\64\0"+
    "\1\326\41\0\1\327\30\0\1\330\50\0\1\331\64\0"+
    "\1\332\40\0\1\333\52\0\1\334\53\0\1\335\46\0"+
    "\1\336\60\0\1\337\37\0\1\340\61\0\1\341\40\0"+
    "\1\342\60\0\1\343\33\0\1\344\62\0\1\345\44\0"+
    "\1\346\40\0\1\347\51\0\1\350\60\0\1\351\44\0"+
    "\1\352\43\0\1\353\64\0\1\354\50\0\1\355\40\0"+
    "\1\356\64\0\1\357\17\0\1\360\54\0\3\52\1\0"+
    "\1\126\14\52\1\361\13\52\25\0\1\362\61\0\1\363"+
    "\41\0\1\364\63\0\1\365\27\0\1\366\71\0\1\367"+
    "\31\0\1\370\1\0\1\371\12\0\1\372\31\0\1\373"+
    "\73\0\1\374\25\0\1\375\54\0\1\376\44\0\1\377"+
    "\60\0\1\u0100\40\0\1\u0101\67\0\1\u0102\56\0\1\u0103"+
    "\26\0\1\u0104\67\0\1\u0105\26\0\1\u0106\64\0\1\u0107"+
    "\45\0\1\u0108\43\0\1\u0109\37\0\3\52\1\0\1\u010a"+
    "\30\52\34\0\1\u010b\35\0\1\u010c\50\0\1\u010d\64\0"+
    "\1\u010e\53\0\1\u010f\31\0\1\u0110\72\0\1\u0111\40\0"+
    "\1\u0112\42\0\1\u0113\50\0\1\u0114\50\0\1\u0115\55\0"+
    "\1\u0116\37\0\1\u0117\62\0\1\u0118\42\0\1\u0119\50\0"+
    "\1\u011a\55\0\1\u011b\60\0\1\u011c\45\0\1\u011d\43\0"+
    "\1\u011e\43\0\1\u011f\61\0\1\u0120\41\0\1\u0121\55\0"+
    "\1\u0122\51\0\1\u0123\35\0\1\u0124\62\0\1\u0125\51\0"+
    "\1\u0126\56\0\1\u0127\42\0\1\u0128\47\0\1\u0129\35\0"+
    "\1\u012a\50\0\1\u012b\60\0\1\u012c\40\0\1\u012d\54\0"+
    "\1\u012e\65\0\1\u012f\45\0\1\u0130\43\0\1\u0131\53\0"+
    "\1\u0132\50\0\1\u0133\56\0\1\u0134\42\0\1\u0135\40\0"+
    "\1\u0136\23\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[10414];
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


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\2\11\1\1\1\11\32\1\1\11\1\1\1\11"+
    "\1\1\51\0\5\11\1\0\1\1\1\0\1\11\63\0"+
    "\1\11\11\0\1\11\3\0\1\11\13\0\1\1\15\0"+
    "\1\11\3\0\1\11\3\0\1\11\5\0\1\11\2\0"+
    "\1\11\3\0\2\11\1\0\1\11\16\0\3\11\5\0"+
    "\2\11\11\0\2\11\1\0\2\11\12\0\1\11\1\0"+
    "\1\11\4\0\3\11\2\0\1\11\1\0\2\11\3\0"+
    "\3\11\3\0\1\11\2\0\1\11\2\0\2\11\6\0"+
    "\2\11\2\0\1\11\1\0\1\11\4\0\2\11\3\0"+
    "\2\11\1\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[310];
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

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    public BufferedWriter outputFile;

    public void createWriter(String root) throws IOException {
        outputFile = new BufferedWriter(new FileWriter(root));
    }

    public void closeWriter() throws IOException {
        if(outputFile != null) {
            outputFile.close();
        }
    }

    public void writeToken(int tokenNum) throws IOException {
        if(outputFile != null) {
            String text = "Token: " + tokenNum + ", Valor: " +yytext() + ", línea: " + yyline + ", columna: " + yycolumn;
            if(tokenNum == sym.ERROR) text += " (Error léxico)";
            text+='\n';
            outputFile.write(text);
            outputFile.flush();
        }
    }


    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
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

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
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
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
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
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
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
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
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
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
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
            switch (zzLexicalState) {
            case YYINITIAL: {
              return symbol(sym.EOF, yytext());
            }  // fall though
            case 311: break;
            default:
          { return new java_cup.runtime.Symbol(sym.EOF); }
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { writeToken(sym.ERROR); return symbol(sym.ERROR, yytext());
            }
          // fall through
          case 60: break;
          case 2:
            { /* Ignore white space */
            }
          // fall through
          case 61: break;
          case 3:
            { string.setLength(0); yybegin(STRING);
            }
          // fall through
          case 62: break;
          case 4:
            { writeToken(sym.COMENTARIO); return symbol(sym.COMENTARIO, yytext());
            }
          // fall through
          case 63: break;
          case 5:
            { writeToken(sym.INT_LITERAL); return symbol(sym.INT_LITERAL, Integer.parseInt(yytext()));
            }
          // fall through
          case 64: break;
          case 6:
            { string.append(yytext());
            }
          // fall through
          case 65: break;
          case 7:
            { yybegin(YYINITIAL); writeToken(sym.STRING_LITERAL); return symbol(sym.STRING_LITERAL, string.toString());
            }
          // fall through
          case 66: break;
          case 8:
            { string.append("\"");
            }
          // fall through
          case 67: break;
          case 9:
            { string.append("\\");
            }
          // fall through
          case 68: break;
          case 10:
            { string.append("\n");
            }
          // fall through
          case 69: break;
          case 11:
            { string.append("\r");
            }
          // fall through
          case 70: break;
          case 12:
            { string.append("\t");
            }
          // fall through
          case 71: break;
          case 13:
            { writeToken(sym.FLOAT_LITERAL); return symbol(sym.FLOAT_LITERAL, Float.parseFloat(yytext()));
            }
          // fall through
          case 72: break;
          case 14:
            { writeToken(sym.IDENTIFICADOR); return symbol(sym.IDENTIFICADOR, yytext());
            }
          // fall through
          case 73: break;
          case 15:
            { writeToken(sym.IF); return symbol(sym.IF, yytext());
            }
          // fall through
          case 74: break;
          case 16:
            { writeToken(sym.ELSE); return symbol(sym.ELSE, yytext());
            }
          // fall through
          case 75: break;
          case 17:
            { writeToken(sym.IGUALDAD); return symbol(sym.IGUALDAD, yytext());
            }
          // fall through
          case 76: break;
          case 18:
            { writeToken(sym.BOOL_LITERAL); return symbol(sym.BOOL_LITERAL, yytext());
            }
          // fall through
          case 77: break;
          case 19:
            { writeToken(sym.BREAK); return symbol(sym.BREAK, yytext());
            }
          // fall through
          case 78: break;
          case 20:
            { writeToken(sym.RETURN); return symbol(sym.RETURN, yytext());
            }
          // fall through
          case 79: break;
          case 21:
            { writeToken(sym.MODULO); return symbol(sym.MODULO, yytext());
            }
          // fall through
          case 80: break;
          case 22:
            { writeToken(sym.PRINT); return symbol(sym.PRINT, yytext());
            }
          // fall through
          case 81: break;
          case 23:
            { writeToken(sym.INCREMENTO); return symbol(sym.INCREMENTO, yytext());
            }
          // fall through
          case 82: break;
          case 24:
            { writeToken(sym.DIVISION); return symbol(sym.DIVISION, yytext());
            }
          // fall through
          case 83: break;
          case 25:
            { writeToken(sym.DOS_PUNTOS); return symbol(sym.DOS_PUNTOS, yytext());
            }
          // fall through
          case 84: break;
          case 26:
            { writeToken(sym.STRING); return symbol(sym.STRING, yytext());
            }
          // fall through
          case 85: break;
          case 27:
            { writeToken(sym.CHAR); return symbol(sym.CHAR, yytext());
            }
          // fall through
          case 86: break;
          case 28:
            { writeToken(sym.FOR); return symbol(sym.FOR, yytext());
            }
          // fall through
          case 87: break;
          case 29:
            { writeToken(sym.DISYUNCION); return symbol(sym.DISYUNCION, yytext());
            }
          // fall through
          case 88: break;
          case 30:
            { writeToken(sym.DECREMENTO); return symbol(sym.DECREMENTO, yytext());
            }
          // fall through
          case 89: break;
          case 31:
            { writeToken(sym.BOOL); return symbol(sym.BOOL, yytext());
            }
          // fall through
          case 90: break;
          case 32:
            { writeToken(sym.DEFAULT); return symbol(sym.DEFAULT, yytext());
            }
          // fall through
          case 91: break;
          case 33:
            { writeToken(sym.SWITCH); return symbol(sym.SWITCH, yytext());
            }
          // fall through
          case 92: break;
          case 34:
            { writeToken(sym.CHAR_LITERAL); return symbol(sym.CHAR_LITERAL, yytext());
            }
          // fall through
          case 93: break;
          case 35:
            { writeToken(sym.ASIGNACION); return symbol(sym.ASIGNACION, yytext());
            }
          // fall through
          case 94: break;
          case 36:
            { writeToken(sym.READ); return symbol(sym.READ, yytext());
            }
          // fall through
          case 95: break;
          case 37:
            { writeToken(sym.CONJUNCION); return symbol(sym.CONJUNCION, yytext());
            }
          // fall through
          case 96: break;
          case 38:
            { writeToken(sym.MAYOR); return symbol(sym.MAYOR, yytext());
            }
          // fall through
          case 97: break;
          case 39:
            { writeToken(sym.SUMA); return symbol(sym.SUMA, yytext());
            }
          // fall through
          case 98: break;
          case 40:
            { writeToken(sym.INTEGER); return symbol(sym.INTEGER, yytext());
            }
          // fall through
          case 99: break;
          case 41:
            { writeToken(sym.MAYOR_IGUAL); return symbol(sym.MAYOR_IGUAL, yytext());
            }
          // fall through
          case 100: break;
          case 42:
            { writeToken(sym.MAIN); return symbol(sym.MAIN, yytext());
            }
          // fall through
          case 101: break;
          case 43:
            { writeToken(sym.POTENCIA); return symbol(sym.POTENCIA, yytext());
            }
          // fall through
          case 102: break;
          case 44:
            { writeToken(sym.NEGACION); return symbol(sym.NEGACION, yytext());
            }
          // fall through
          case 103: break;
          case 45:
            { writeToken(sym.FLOAT); return symbol(sym.FLOAT, yytext());
            }
          // fall through
          case 104: break;
          case 46:
            { writeToken(sym.WHILE); return symbol(sym.WHILE, yytext());
            }
          // fall through
          case 105: break;
          case 47:
            { writeToken(sym.CASE); return symbol(sym.CASE, yytext());
            }
          // fall through
          case 106: break;
          case 48:
            { writeToken(sym.DIFERENTE); return symbol(sym.DIFERENTE, yytext());
            }
          // fall through
          case 107: break;
          case 49:
            { writeToken(sym.MENOR); return symbol(sym.MENOR, yytext());
            }
          // fall through
          case 108: break;
          case 50:
            { writeToken(sym.MENOR_IGUAL); return symbol(sym.MENOR_IGUAL, yytext());
            }
          // fall through
          case 109: break;
          case 51:
            { writeToken(sym.END_EXPR); return symbol(sym.END_EXPR, yytext());
            }
          // fall through
          case 110: break;
          case 52:
            { writeToken(sym.APERTURA_DE_BLOQUE); return symbol(sym.APERTURA_DE_BLOQUE, yytext());
            }
          // fall through
          case 111: break;
          case 53:
            { writeToken(sym.PARENTESIS_APERTURA); return symbol(sym.PARENTESIS_APERTURA, yytext());
            }
          // fall through
          case 112: break;
          case 54:
            { writeToken(sym.MULTIPLICACION); return symbol(sym.MULTIPLICACION, yytext());
            }
          // fall through
          case 113: break;
          case 55:
            { writeToken(sym.CORCHETE_APERTURA); return symbol(sym.CORCHETE_APERTURA, yytext());
            }
          // fall through
          case 114: break;
          case 56:
            { writeToken(sym.RESTA); return symbol(sym.RESTA, yytext());
            }
          // fall through
          case 115: break;
          case 57:
            { writeToken(sym.CIERRE_DE_BLOQUE); return symbol(sym.CIERRE_DE_BLOQUE, yytext());
            }
          // fall through
          case 116: break;
          case 58:
            { writeToken(sym.PARENTESIS_CIERRE); return symbol(sym.PARENTESIS_CIERRE, yytext());
            }
          // fall through
          case 117: break;
          case 59:
            { writeToken(sym.CORCHETE_CIERRE); return symbol(sym.CORCHETE_CIERRE, yytext());
            }
          // fall through
          case 118: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
