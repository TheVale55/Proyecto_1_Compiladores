// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: src/lexercup.flex

/* JF1ex exarnole: partial Java language lexer specification */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java_cup.runtime.*;


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
    "\1\0\1\6\1\7\3\0\1\10\4\0\1\11\1\12"+
    "\1\13\1\14\1\15\11\16\7\0\32\17\1\0\1\20"+
    "\2\0\1\21\1\0\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\2\17\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
    "\1\46\1\47\1\50\1\51\12\0\1\3\u01a2\0\2\3"+
    "\326\0\u0100\3";

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
    "\2\0\1\1\2\2\1\3\1\4\1\1\1\5\1\1"+
    "\2\6\24\1\1\7\1\10\1\1\2\4\52\0\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\0\1\20"+
    "\61\0\1\21\11\0\1\22\3\0\1\23\13\0\1\24"+
    "\14\0\1\25\3\0\1\26\3\0\1\24\5\0\1\27"+
    "\2\0\1\30\3\0\1\31\1\32\1\0\1\33\15\0"+
    "\1\34\1\35\1\36\5\0\1\37\1\40\11\0\1\41"+
    "\1\42\1\0\1\43\12\0\1\44\1\0\1\45\4\0"+
    "\1\46\1\47\1\50\2\0\1\51\1\0\1\52\1\53"+
    "\3\0\1\54\1\55\1\56\3\0\1\57\2\0\1\60"+
    "\2\0\1\61\1\62\6\0\1\63\1\64\2\0\1\65"+
    "\1\0\1\66\4\0\1\67\1\70\3\0\1\71\1\72"+
    "\1\0\1\73\1\74";

  private static int [] zzUnpackAction() {
    int [] result = new int[307];
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
    "\0\0\0\52\0\124\0\124\0\176\0\124\0\250\0\322"+
    "\0\124\0\374\0\u0126\0\u0150\0\u017a\0\u01a4\0\u01ce\0\u01f8"+
    "\0\u0222\0\u024c\0\u0276\0\u02a0\0\u02ca\0\u02f4\0\u031e\0\u0348"+
    "\0\u0372\0\u039c\0\u03c6\0\u03f0\0\u041a\0\u0444\0\u046e\0\u0498"+
    "\0\u04c2\0\124\0\u04ec\0\124\0\u0516\0\u0540\0\u056a\0\u0594"+
    "\0\u05be\0\u05e8\0\u0612\0\u063c\0\u0666\0\u0690\0\u06ba\0\u06e4"+
    "\0\u070e\0\u0738\0\u0762\0\u078c\0\u07b6\0\u07e0\0\u080a\0\u0834"+
    "\0\u085e\0\u0888\0\u08b2\0\u08dc\0\u0906\0\u0930\0\u095a\0\u0984"+
    "\0\u09ae\0\u09d8\0\u0a02\0\u0a2c\0\u0a56\0\u0a80\0\u0aaa\0\u0ad4"+
    "\0\u0afe\0\u0b28\0\u0b52\0\u0b7c\0\u0ba6\0\u0bd0\0\u0bfa\0\124"+
    "\0\124\0\124\0\124\0\124\0\124\0\u05e8\0\u0c24\0\124"+
    "\0\u0c4e\0\u0c78\0\u0ca2\0\u0ccc\0\u0cf6\0\u0d20\0\u0d4a\0\u0d74"+
    "\0\u0d9e\0\u0dc8\0\u0df2\0\u0e1c\0\u0e46\0\u0e70\0\u0e9a\0\u0ec4"+
    "\0\u0eee\0\u0f18\0\u0f42\0\u0f6c\0\u0f96\0\u0fc0\0\u0fea\0\u1014"+
    "\0\u103e\0\u1068\0\u1092\0\u10bc\0\u10e6\0\u1110\0\u113a\0\u1164"+
    "\0\u118e\0\u11b8\0\u11e2\0\u120c\0\u1236\0\u1260\0\u128a\0\u12b4"+
    "\0\u12de\0\u1308\0\u1332\0\u135c\0\u1386\0\u13b0\0\u13da\0\u1404"+
    "\0\u142e\0\124\0\u1458\0\u1482\0\u14ac\0\u14d6\0\u1500\0\u152a"+
    "\0\u1554\0\u157e\0\u15a8\0\124\0\u15d2\0\u15fc\0\u1626\0\124"+
    "\0\u1650\0\u167a\0\u16a4\0\u16ce\0\u16f8\0\u1722\0\u174c\0\u1776"+
    "\0\u17a0\0\u17ca\0\u17f4\0\u181e\0\u1848\0\u1872\0\u189c\0\u18c6"+
    "\0\u18f0\0\u191a\0\u1944\0\u196e\0\u1998\0\u19c2\0\u19ec\0\u1a16"+
    "\0\124\0\u1a40\0\u1a6a\0\u1a94\0\124\0\u1abe\0\u1ae8\0\u1b12"+
    "\0\124\0\u1b3c\0\u1b66\0\u1b90\0\u1bba\0\u1be4\0\124\0\u1c0e"+
    "\0\u1c38\0\124\0\u1c62\0\u1c8c\0\u1cb6\0\124\0\124\0\u1ce0"+
    "\0\124\0\u1d0a\0\u1d34\0\u1d5e\0\u1d88\0\u1db2\0\u1ddc\0\u1e06"+
    "\0\u1e30\0\u1e5a\0\u1e84\0\u1eae\0\u1ed8\0\u1f02\0\124\0\124"+
    "\0\124\0\u1f2c\0\u1f56\0\u1f80\0\u1faa\0\u1fd4\0\124\0\124"+
    "\0\u1ffe\0\u2028\0\u2052\0\u207c\0\u20a6\0\u20d0\0\u20fa\0\u2124"+
    "\0\u214e\0\124\0\124\0\u2178\0\124\0\u21a2\0\u21cc\0\u21f6"+
    "\0\u2220\0\u224a\0\u2274\0\u229e\0\u22c8\0\u22f2\0\u231c\0\124"+
    "\0\u2346\0\124\0\u2370\0\u239a\0\u23c4\0\u23ee\0\124\0\124"+
    "\0\124\0\u2418\0\u2442\0\124\0\u246c\0\124\0\124\0\u2496"+
    "\0\u24c0\0\u24ea\0\124\0\124\0\124\0\u2514\0\u253e\0\u2568"+
    "\0\124\0\u2592\0\u25bc\0\124\0\u25e6\0\u2610\0\124\0\124"+
    "\0\u263a\0\u2664\0\u268e\0\u26b8\0\u26e2\0\u270c\0\124\0\124"+
    "\0\u2736\0\u2760\0\124\0\u278a\0\124\0\u27b4\0\u27de\0\u2808"+
    "\0\u2832\0\124\0\124\0\u285c\0\u2886\0\u28b0\0\124\0\124"+
    "\0\u28da\0\124\0\124";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[307];
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
    "\1\3\2\4\1\0\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\2\3\1\13\1\14\1\3\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\3\1\30\1\31\1\32\1\3\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\4\3\2\41\1\0\2\41"+
    "\1\0\1\42\11\41\1\43\31\41\54\0\1\4\47\0"+
    "\2\7\1\44\2\7\1\45\44\7\2\46\1\0\2\46"+
    "\1\0\2\46\1\0\7\46\1\47\31\46\15\0\1\50"+
    "\1\14\46\0\1\51\1\0\2\50\46\0\1\52\1\0"+
    "\2\14\54\0\1\53\47\0\1\54\2\0\23\54\1\55"+
    "\4\54\23\0\1\56\1\0\1\57\46\0\1\60\16\0"+
    "\1\61\42\0\1\62\3\0\1\63\5\0\1\64\51\0"+
    "\1\65\40\0\1\66\1\0\1\67\4\0\1\70\2\0"+
    "\1\71\26\0\1\72\7\0\1\73\41\0\1\74\16\0"+
    "\1\75\32\0\1\76\7\0\1\77\54\0\1\100\36\0"+
    "\1\101\3\0\1\102\3\0\1\103\41\0\1\104\13\0"+
    "\1\105\52\0\1\106\56\0\1\107\33\0\1\110\7\0"+
    "\1\111\45\0\1\112\2\0\1\113\55\0\1\114\43\0"+
    "\1\115\3\0\1\116\34\0\1\117\27\0\2\41\1\0"+
    "\2\41\2\0\11\41\1\0\31\41\6\0\1\120\11\0"+
    "\1\121\14\0\1\122\3\0\1\123\1\0\1\124\10\0"+
    "\1\44\57\0\1\125\41\0\2\46\4\0\44\46\13\0"+
    "\1\52\1\0\2\50\50\0\2\126\50\0\1\52\1\126"+
    "\33\0\21\53\1\127\30\53\15\0\3\54\1\0\1\130"+
    "\30\54\15\0\3\54\1\0\1\130\4\54\1\131\23\54"+
    "\41\0\1\132\55\0\1\133\37\0\1\134\54\0\1\135"+
    "\41\0\1\136\57\0\1\137\4\0\1\140\47\0\1\141"+
    "\40\0\1\142\52\0\1\143\65\0\1\144\1\0\1\145"+
    "\30\0\1\146\53\0\1\147\56\0\1\150\53\0\1\151"+
    "\56\0\1\152\41\0\1\153\44\0\1\154\66\0\1\155"+
    "\52\0\1\156\36\0\1\157\10\0\1\160\43\0\1\161"+
    "\53\0\1\162\55\0\1\163\3\0\1\164\30\0\1\165"+
    "\53\0\1\166\55\0\1\167\67\0\1\170\26\0\1\171"+
    "\54\0\1\172\57\0\1\173\57\0\1\174\50\0\1\175"+
    "\30\0\1\176\70\0\1\177\10\0\14\53\1\44\35\53"+
    "\15\0\3\54\1\0\1\130\17\54\1\200\10\54\26\0"+
    "\1\201\55\0\1\202\62\0\1\203\42\0\1\204\56\0"+
    "\1\205\36\0\1\206\66\0\1\207\40\0\1\210\54\0"+
    "\1\211\52\0\1\212\54\0\1\213\42\0\1\214\11\0"+
    "\1\215\51\0\1\216\46\0\1\217\52\0\1\220\50\0"+
    "\1\221\47\0\1\222\47\0\1\223\36\0\1\224\72\0"+
    "\1\225\34\0\1\226\61\0\1\227\63\0\1\230\25\0"+
    "\1\231\67\0\1\232\50\0\1\233\42\0\1\234\50\0"+
    "\1\235\55\0\1\236\42\0\1\237\51\0\1\240\61\0"+
    "\1\241\57\0\1\242\53\0\1\243\31\0\1\244\55\0"+
    "\1\245\62\0\1\246\40\0\1\247\34\0\3\54\1\0"+
    "\1\130\1\250\27\54\24\0\1\251\1\0\1\252\12\0"+
    "\1\253\36\0\1\254\45\0\1\255\61\0\1\256\60\0"+
    "\1\257\53\0\1\260\30\0\1\261\54\0\1\262\51\0"+
    "\1\263\52\0\1\264\45\0\1\265\55\0\1\266\47\0"+
    "\1\267\55\0\1\270\47\0\1\271\51\0\1\272\45\0"+
    "\1\273\53\0\1\274\63\0\1\275\54\0\1\276\52\0"+
    "\1\277\40\0\1\300\63\0\1\301\30\0\1\302\54\0"+
    "\1\303\52\0\1\304\65\0\1\305\44\0\1\306\56\0"+
    "\1\307\42\0\1\310\44\0\1\311\46\0\1\312\63\0"+
    "\1\313\50\0\1\314\56\0\1\315\46\0\1\316\30\0"+
    "\3\54\1\0\1\130\13\54\1\317\14\54\44\0\1\320"+
    "\41\0\1\321\43\0\1\322\60\0\1\323\65\0\1\324"+
    "\42\0\1\325\31\0\1\326\51\0\1\327\65\0\1\330"+
    "\41\0\1\331\53\0\1\332\54\0\1\333\47\0\1\334"+
    "\61\0\1\335\40\0\1\336\62\0\1\337\41\0\1\340"+
    "\61\0\1\341\34\0\1\342\63\0\1\343\45\0\1\344"+
    "\41\0\1\345\52\0\1\346\61\0\1\347\45\0\1\350"+
    "\44\0\1\351\65\0\1\352\51\0\1\353\41\0\1\354"+
    "\65\0\1\355\24\0\3\54\1\0\1\130\14\54\1\356"+
    "\13\54\26\0\1\357\62\0\1\360\42\0\1\361\64\0"+
    "\1\362\30\0\1\363\72\0\1\364\32\0\1\365\1\0"+
    "\1\366\12\0\1\367\32\0\1\370\74\0\1\371\26\0"+
    "\1\372\55\0\1\373\45\0\1\374\61\0\1\375\41\0"+
    "\1\376\70\0\1\377\57\0\1\u0100\27\0\1\u0101\70\0"+
    "\1\u0102\27\0\1\u0103\65\0\1\u0104\46\0\1\u0105\44\0"+
    "\1\u0106\40\0\3\54\1\0\1\u0107\30\54\35\0\1\u0108"+
    "\36\0\1\u0109\51\0\1\u010a\65\0\1\u010b\54\0\1\u010c"+
    "\32\0\1\u010d\73\0\1\u010e\41\0\1\u010f\43\0\1\u0110"+
    "\51\0\1\u0111\51\0\1\u0112\56\0\1\u0113\40\0\1\u0114"+
    "\63\0\1\u0115\43\0\1\u0116\51\0\1\u0117\56\0\1\u0118"+
    "\61\0\1\u0119\46\0\1\u011a\44\0\1\u011b\44\0\1\u011c"+
    "\62\0\1\u011d\42\0\1\u011e\56\0\1\u011f\52\0\1\u0120"+
    "\36\0\1\u0121\63\0\1\u0122\52\0\1\u0123\57\0\1\u0124"+
    "\43\0\1\u0125\50\0\1\u0126\36\0\1\u0127\51\0\1\u0128"+
    "\61\0\1\u0129\41\0\1\u012a\55\0\1\u012b\66\0\1\u012c"+
    "\46\0\1\u012d\44\0\1\u012e\54\0\1\u012f\51\0\1\u0130"+
    "\57\0\1\u0131\43\0\1\u0132\41\0\1\u0133\23\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[10500];
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
    "\2\0\2\11\1\1\1\11\2\1\1\11\30\1\1\11"+
    "\1\1\1\11\1\1\52\0\6\11\1\1\1\0\1\11"+
    "\61\0\1\11\11\0\1\11\3\0\1\11\13\0\1\1"+
    "\14\0\1\11\3\0\1\11\3\0\1\11\5\0\1\11"+
    "\2\0\1\11\3\0\2\11\1\0\1\11\15\0\3\11"+
    "\5\0\2\11\11\0\2\11\1\0\1\11\12\0\1\11"+
    "\1\0\1\11\4\0\3\11\2\0\1\11\1\0\2\11"+
    "\3\0\3\11\3\0\1\11\2\0\1\11\2\0\2\11"+
    "\6\0\2\11\2\0\1\11\1\0\1\11\4\0\2\11"+
    "\3\0\2\11\1\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[307];
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
    public static final int ERROR = -1;
    public static final int COMENTARIO = -2;
    public BufferedWriter outputFile;

    public void createWriter(String root) throws IOException {
        outputFile = new BufferedWriter(new FileWriter(root));
    }

    public void closeWriter() throws IOException {
        if(outputFile != null) {
            outputFile.close();
        }
    }


    public void writeToken(int tokenNum, Object value) throws IOException {
        if(outputFile != null) {
            String text = "";
            if(tokenNum == ERROR) text += "Error léxico: ";
            else if(tokenNum == COMENTARIO) text += "Comentario: ";
            else text += "Token: " + tokenNum + ", Valor: ";
            text += value + ", línea: " + (yyline + 1) + ", columna: " + (yycolumn + 1) + '\n';
            outputFile.write(text);
            outputFile.flush();
        }
    }


    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline + 1, yycolumn + 1, value);
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
            case 308: break;
            default:
          { return new java_cup.runtime.Symbol(sym.EOF); }
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { writeToken(ERROR, yytext());
            }
          // fall through
          case 61: break;
          case 2:
            { /* Ignore white space */
            }
          // fall through
          case 62: break;
          case 3:
            { string.setLength(0); yybegin(STRING);
            }
          // fall through
          case 63: break;
          case 4:
            { writeToken(COMENTARIO, yytext());
            }
          // fall through
          case 64: break;
          case 5:
            { writeToken(sym.COMMA, yytext()); return symbol(sym.COMMA, yytext());
            }
          // fall through
          case 65: break;
          case 6:
            { writeToken(sym.INT_LITERAL, Integer.parseInt(yytext())); return symbol(sym.INT_LITERAL, Integer.parseInt(yytext()));
            }
          // fall through
          case 66: break;
          case 7:
            { string.append(yytext());
            }
          // fall through
          case 67: break;
          case 8:
            { yybegin(YYINITIAL); writeToken(sym.STRING_LITERAL, string.toString()); return symbol(sym.STRING_LITERAL, string.toString());
            }
          // fall through
          case 68: break;
          case 9:
            { string.append("\"");
            }
          // fall through
          case 69: break;
          case 10:
            { string.append("\\");
            }
          // fall through
          case 70: break;
          case 11:
            { string.append("\n");
            }
          // fall through
          case 71: break;
          case 12:
            { string.append("\r");
            }
          // fall through
          case 72: break;
          case 13:
            { string.append("\t");
            }
          // fall through
          case 73: break;
          case 14:
            { writeToken(sym.CHAR_LITERAL, yytext()); return symbol(sym.CHAR_LITERAL, yytext());
            }
          // fall through
          case 74: break;
          case 15:
            { writeToken(sym.FLOAT_LITERAL, Float.parseFloat(yytext())); return symbol(sym.FLOAT_LITERAL, Float.parseFloat(yytext()));
            }
          // fall through
          case 75: break;
          case 16:
            { writeToken(sym.IDENTIFICADOR, yytext()); return symbol(sym.IDENTIFICADOR, yytext());
            }
          // fall through
          case 76: break;
          case 17:
            { writeToken(sym.IF, yytext()); return symbol(sym.IF, yytext());
            }
          // fall through
          case 77: break;
          case 18:
            { writeToken(sym.ELSE, yytext()); return symbol(sym.ELSE, yytext());
            }
          // fall through
          case 78: break;
          case 19:
            { writeToken(sym.IGUALDAD, yytext()); return symbol(sym.IGUALDAD, yytext());
            }
          // fall through
          case 79: break;
          case 20:
            { writeToken(sym.BOOL_LITERAL, yytext()); return symbol(sym.BOOL_LITERAL, yytext());
            }
          // fall through
          case 80: break;
          case 21:
            { writeToken(sym.BREAK, yytext()); return symbol(sym.BREAK, yytext());
            }
          // fall through
          case 81: break;
          case 22:
            { writeToken(sym.RETURN, yytext()); return symbol(sym.RETURN, yytext());
            }
          // fall through
          case 82: break;
          case 23:
            { writeToken(sym.MODULO, yytext()); return symbol(sym.MODULO, yytext());
            }
          // fall through
          case 83: break;
          case 24:
            { writeToken(sym.PRINT, yytext()); return symbol(sym.PRINT, yytext());
            }
          // fall through
          case 84: break;
          case 25:
            { writeToken(sym.INCREMENTO, yytext()); return symbol(sym.INCREMENTO, yytext());
            }
          // fall through
          case 85: break;
          case 26:
            { writeToken(sym.DIVISION, yytext()); return symbol(sym.DIVISION, yytext());
            }
          // fall through
          case 86: break;
          case 27:
            { writeToken(sym.DOS_PUNTOS, yytext()); return symbol(sym.DOS_PUNTOS, yytext());
            }
          // fall through
          case 87: break;
          case 28:
            { writeToken(sym.STRING, yytext()); return symbol(sym.STRING, yytext());
            }
          // fall through
          case 88: break;
          case 29:
            { writeToken(sym.CHAR, yytext()); return symbol(sym.CHAR, yytext());
            }
          // fall through
          case 89: break;
          case 30:
            { writeToken(sym.FOR, yytext()); return symbol(sym.FOR, yytext());
            }
          // fall through
          case 90: break;
          case 31:
            { writeToken(sym.DISYUNCION, yytext()); return symbol(sym.DISYUNCION, yytext());
            }
          // fall through
          case 91: break;
          case 32:
            { writeToken(sym.DECREMENTO, yytext()); return symbol(sym.DECREMENTO, yytext());
            }
          // fall through
          case 92: break;
          case 33:
            { writeToken(sym.BOOL, yytext()); return symbol(sym.BOOL, yytext());
            }
          // fall through
          case 93: break;
          case 34:
            { writeToken(sym.DEFAULT, yytext()); return symbol(sym.DEFAULT, yytext());
            }
          // fall through
          case 94: break;
          case 35:
            { writeToken(sym.SWITCH, yytext()); return symbol(sym.SWITCH, yytext());
            }
          // fall through
          case 95: break;
          case 36:
            { writeToken(sym.ASIGNACION, yytext()); return symbol(sym.ASIGNACION, yytext());
            }
          // fall through
          case 96: break;
          case 37:
            { writeToken(sym.READ, yytext()); return symbol(sym.READ, yytext());
            }
          // fall through
          case 97: break;
          case 38:
            { writeToken(sym.CONJUNCION, yytext()); return symbol(sym.CONJUNCION, yytext());
            }
          // fall through
          case 98: break;
          case 39:
            { writeToken(sym.MAYOR, yytext()); return symbol(sym.MAYOR, yytext());
            }
          // fall through
          case 99: break;
          case 40:
            { writeToken(sym.SUMA, yytext()); return symbol(sym.SUMA, yytext());
            }
          // fall through
          case 100: break;
          case 41:
            { writeToken(sym.INTEGER, yytext()); return symbol(sym.INTEGER, yytext());
            }
          // fall through
          case 101: break;
          case 42:
            { writeToken(sym.MAYOR_IGUAL, yytext()); return symbol(sym.MAYOR_IGUAL, yytext());
            }
          // fall through
          case 102: break;
          case 43:
            { writeToken(sym.MAIN, yytext()); return symbol(sym.MAIN, yytext());
            }
          // fall through
          case 103: break;
          case 44:
            { writeToken(sym.POTENCIA, yytext()); return symbol(sym.POTENCIA, yytext());
            }
          // fall through
          case 104: break;
          case 45:
            { writeToken(sym.NEGACION, yytext()); return symbol(sym.NEGACION, yytext());
            }
          // fall through
          case 105: break;
          case 46:
            { writeToken(sym.FLOAT, yytext()); return symbol(sym.FLOAT, yytext());
            }
          // fall through
          case 106: break;
          case 47:
            { writeToken(sym.WHILE, yytext()); return symbol(sym.WHILE, yytext());
            }
          // fall through
          case 107: break;
          case 48:
            { writeToken(sym.CASE, yytext()); return symbol(sym.CASE, yytext());
            }
          // fall through
          case 108: break;
          case 49:
            { writeToken(sym.DIFERENTE, yytext()); return symbol(sym.DIFERENTE, yytext());
            }
          // fall through
          case 109: break;
          case 50:
            { writeToken(sym.MENOR, yytext()); return symbol(sym.MENOR, yytext());
            }
          // fall through
          case 110: break;
          case 51:
            { writeToken(sym.MENOR_IGUAL, yytext()); return symbol(sym.MENOR_IGUAL, yytext());
            }
          // fall through
          case 111: break;
          case 52:
            { writeToken(sym.END_EXPR, yytext()); return symbol(sym.END_EXPR, yytext());
            }
          // fall through
          case 112: break;
          case 53:
            { writeToken(sym.APERTURA_DE_BLOQUE, yytext()); return symbol(sym.APERTURA_DE_BLOQUE, yytext());
            }
          // fall through
          case 113: break;
          case 54:
            { writeToken(sym.PARENTESIS_APERTURA, yytext()); return symbol(sym.PARENTESIS_APERTURA, yytext());
            }
          // fall through
          case 114: break;
          case 55:
            { writeToken(sym.MULTIPLICACION, yytext()); return symbol(sym.MULTIPLICACION, yytext());
            }
          // fall through
          case 115: break;
          case 56:
            { writeToken(sym.CORCHETE_APERTURA, yytext()); return symbol(sym.CORCHETE_APERTURA, yytext());
            }
          // fall through
          case 116: break;
          case 57:
            { writeToken(sym.RESTA, yytext()); return symbol(sym.RESTA, yytext());
            }
          // fall through
          case 117: break;
          case 58:
            { writeToken(sym.CIERRE_DE_BLOQUE, yytext()); return symbol(sym.CIERRE_DE_BLOQUE, yytext());
            }
          // fall through
          case 118: break;
          case 59:
            { writeToken(sym.PARENTESIS_CIERRE, yytext()); return symbol(sym.PARENTESIS_CIERRE, yytext());
            }
          // fall through
          case 119: break;
          case 60:
            { writeToken(sym.CORCHETE_CIERRE, yytext()); return symbol(sym.CORCHETE_CIERRE, yytext());
            }
          // fall through
          case 120: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
