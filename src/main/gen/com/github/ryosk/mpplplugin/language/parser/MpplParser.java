// This is a generated file. Not intended for manual editing.
package com.github.ryosk.mpplplugin.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.ryosk.mpplplugin.language.psi.MpplTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MpplParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return mpplFile(b, l + 1);
  }

  /* ********************************************************** */
  // PLUS | MINUS | OR
  public static boolean additiveOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDITIVE_OPERATOR, "<additive operator>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, OR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ARRAY LSQPAREN NUMBER RSQPAREN OF standardType
  public static boolean arrayType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayType")) return false;
    if (!nextTokenIs(b, ARRAY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ARRAY, LSQPAREN, NUMBER, RSQPAREN, OF);
    r = r && standardType(b, l + 1);
    exit_section_(b, m, ARRAY_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // leftPart ASSIGN expression
  public static boolean assignmentStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignmentStatement")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = leftPart(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, ASSIGNMENT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // (variableDeclaration | subprogramDeclaration)* compoundStatement
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, "<block>");
    r = block_0(b, l + 1);
    r = r && compoundStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (variableDeclaration | subprogramDeclaration)*
  private static boolean block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_0", c)) break;
    }
    return true;
  }

  // variableDeclaration | subprogramDeclaration
  private static boolean block_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_0_0")) return false;
    boolean r;
    r = variableDeclaration(b, l + 1);
    if (!r) r = subprogramDeclaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // CALL procedureName (LPAREN expressions RPAREN)?
  public static boolean callStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callStatement")) return false;
    if (!nextTokenIs(b, CALL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CALL);
    r = r && procedureName(b, l + 1);
    r = r && callStatement_2(b, l + 1);
    exit_section_(b, m, CALL_STATEMENT, r);
    return r;
  }

  // (LPAREN expressions RPAREN)?
  private static boolean callStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callStatement_2")) return false;
    callStatement_2_0(b, l + 1);
    return true;
  }

  // LPAREN expressions RPAREN
  private static boolean callStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expressions(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BEGIN statement (SEMI statement)* END
  public static boolean compoundStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundStatement")) return false;
    if (!nextTokenIs(b, BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BEGIN);
    r = r && statement(b, l + 1);
    r = r && compoundStatement_2(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, COMPOUND_STATEMENT, r);
    return r;
  }

  // (SEMI statement)*
  private static boolean compoundStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundStatement_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!compoundStatement_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "compoundStatement_2", c)) break;
    }
    return true;
  }

  // SEMI statement
  private static boolean compoundStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMI);
    r = r && statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF expression THEN statement (ELSE statement)?
  public static boolean conditionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && statement(b, l + 1);
    r = r && conditionStatement_4(b, l + 1);
    exit_section_(b, m, CONDITION_STATEMENT, r);
    return r;
  }

  // (ELSE statement)?
  private static boolean conditionStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionStatement_4")) return false;
    conditionStatement_4_0(b, l + 1);
    return true;
  }

  // ELSE statement
  private static boolean conditionStatement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionStatement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER | FALSE | TRUE | STRING
  public static boolean constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT, "<constant>");
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COMMENT?
  public static boolean emptyStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "emptyStatement")) return false;
    Marker m = enter_section_(b, l, _NONE_, EMPTY_STATEMENT, "<empty statement>");
    consumeToken(b, COMMENT);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // BREAK
  public static boolean exitStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exitStatement")) return false;
    if (!nextTokenIs(b, BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK);
    exit_section_(b, m, EXIT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // simpleExpression (relationalOperator simpleExpression)*
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = simpleExpression(b, l + 1);
    r = r && expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (relationalOperator simpleExpression)*
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_1", c)) break;
    }
    return true;
  }

  // relationalOperator simpleExpression
  private static boolean expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relationalOperator(b, l + 1);
    r = r && simpleExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression (COMMA expression)*
  public static boolean expressions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSIONS, "<expressions>");
    r = expression(b, l + 1);
    r = r && expressions_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA expression)*
  private static boolean expressions_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expressions_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expressions_1", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean expressions_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // variable | constant | LPAREN expression RPAREN | NOT factor | standardType LPAREN expression RPAREN
  public static boolean factor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FACTOR, "<factor>");
    r = variable(b, l + 1);
    if (!r) r = constant(b, l + 1);
    if (!r) r = factor_2(b, l + 1);
    if (!r) r = factor_3(b, l + 1);
    if (!r) r = factor_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN expression RPAREN
  private static boolean factor_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOT factor
  private static boolean factor_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOT);
    r = r && factor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // standardType LPAREN expression RPAREN
  private static boolean factor_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = standardType(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN variableNames COLON type (SEMI variableNames COLON type)* RPAREN
  public static boolean formalParameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameters")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && variableNames(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type(b, l + 1);
    r = r && formalParameters_4(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, FORMAL_PARAMETERS, r);
    return r;
  }

  // (SEMI variableNames COLON type)*
  private static boolean formalParameters_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameters_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!formalParameters_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "formalParameters_4", c)) break;
    }
    return true;
  }

  // SEMI variableNames COLON type
  private static boolean formalParameters_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameters_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMI);
    r = r && variableNames(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (READ | READLN) (LPAREN variable (COMMA variable)* RPAREN)?
  public static boolean inputStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inputStatement")) return false;
    if (!nextTokenIs(b, "<input statement>", READ, READLN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INPUT_STATEMENT, "<input statement>");
    r = inputStatement_0(b, l + 1);
    r = r && inputStatement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // READ | READLN
  private static boolean inputStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inputStatement_0")) return false;
    boolean r;
    r = consumeToken(b, READ);
    if (!r) r = consumeToken(b, READLN);
    return r;
  }

  // (LPAREN variable (COMMA variable)* RPAREN)?
  private static boolean inputStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inputStatement_1")) return false;
    inputStatement_1_0(b, l + 1);
    return true;
  }

  // LPAREN variable (COMMA variable)* RPAREN
  private static boolean inputStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inputStatement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && variable(b, l + 1);
    r = r && inputStatement_1_0_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA variable)*
  private static boolean inputStatement_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inputStatement_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inputStatement_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inputStatement_1_0_2", c)) break;
    }
    return true;
  }

  // COMMA variable
  private static boolean inputStatement_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inputStatement_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE expression DO statement
  public static boolean iterationStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iterationStatement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && statement(b, l + 1);
    exit_section_(b, m, ITERATION_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // variable
  public static boolean leftPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leftPart")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable(b, l + 1);
    exit_section_(b, m, LEFT_PART, r);
    return r;
  }

  /* ********************************************************** */
  // PROGRAM NAME SEMI block DOT
  static boolean mpplFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mpplFile")) return false;
    if (!nextTokenIs(b, PROGRAM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROGRAM, NAME, SEMI);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STAR | DIV | AND
  public static boolean multiplicativeOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLICATIVE_OPERATOR, "<multiplicative operator>");
    r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, AND);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expression (COLON NUMBER)? | STRING
  public static boolean outputFormat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outputFormat")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OUTPUT_FORMAT, "<output format>");
    r = outputFormat_0(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression (COLON NUMBER)?
  private static boolean outputFormat_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outputFormat_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && outputFormat_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLON NUMBER)?
  private static boolean outputFormat_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outputFormat_0_1")) return false;
    outputFormat_0_1_0(b, l + 1);
    return true;
  }

  // COLON NUMBER
  private static boolean outputFormat_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outputFormat_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, NUMBER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (WRITE | WRITELN) (LPAREN outputFormat (COMMA outputFormat)* RPAREN)?
  public static boolean outputStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outputStatement")) return false;
    if (!nextTokenIs(b, "<output statement>", WRITE, WRITELN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OUTPUT_STATEMENT, "<output statement>");
    r = outputStatement_0(b, l + 1);
    r = r && outputStatement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WRITE | WRITELN
  private static boolean outputStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outputStatement_0")) return false;
    boolean r;
    r = consumeToken(b, WRITE);
    if (!r) r = consumeToken(b, WRITELN);
    return r;
  }

  // (LPAREN outputFormat (COMMA outputFormat)* RPAREN)?
  private static boolean outputStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outputStatement_1")) return false;
    outputStatement_1_0(b, l + 1);
    return true;
  }

  // LPAREN outputFormat (COMMA outputFormat)* RPAREN
  private static boolean outputStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outputStatement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && outputFormat(b, l + 1);
    r = r && outputStatement_1_0_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA outputFormat)*
  private static boolean outputStatement_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outputStatement_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!outputStatement_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "outputStatement_1_0_2", c)) break;
    }
    return true;
  }

  // COMMA outputFormat
  private static boolean outputStatement_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outputStatement_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && outputFormat(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NAME
  public static boolean procedureName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureName")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    exit_section_(b, m, PROCEDURE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // EQUAL | NOTEQ | LE | LEEQ | GR | GREQ
  public static boolean relationalOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATIONAL_OPERATOR, "<relational operator>");
    r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, NOTEQ);
    if (!r) r = consumeToken(b, LE);
    if (!r) r = consumeToken(b, LEEQ);
    if (!r) r = consumeToken(b, GR);
    if (!r) r = consumeToken(b, GREQ);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RETURN
  public static boolean returnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnStatement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // (PLUS | MINUS)? term (additiveOperator term)*
  public static boolean simpleExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_EXPRESSION, "<simple expression>");
    r = simpleExpression_0(b, l + 1);
    r = r && term(b, l + 1);
    r = r && simpleExpression_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (PLUS | MINUS)?
  private static boolean simpleExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleExpression_0")) return false;
    simpleExpression_0_0(b, l + 1);
    return true;
  }

  // PLUS | MINUS
  private static boolean simpleExpression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleExpression_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  // (additiveOperator term)*
  private static boolean simpleExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleExpression_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!simpleExpression_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleExpression_2", c)) break;
    }
    return true;
  }

  // additiveOperator term
  private static boolean simpleExpression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleExpression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additiveOperator(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INTEGER | BOOLEAN | CHAR
  public static boolean standardType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standardType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STANDARD_TYPE, "<standard type>");
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, CHAR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // assignmentStatement | conditionStatement | iterationStatement | exitStatement | callStatement | returnStatement | inputStatement | outputStatement | compoundStatement | emptyStatement
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = assignmentStatement(b, l + 1);
    if (!r) r = conditionStatement(b, l + 1);
    if (!r) r = iterationStatement(b, l + 1);
    if (!r) r = exitStatement(b, l + 1);
    if (!r) r = callStatement(b, l + 1);
    if (!r) r = returnStatement(b, l + 1);
    if (!r) r = inputStatement(b, l + 1);
    if (!r) r = outputStatement(b, l + 1);
    if (!r) r = compoundStatement(b, l + 1);
    if (!r) r = emptyStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PROCEDURE procedureName formalParameters? SEMI variableDeclaration? compoundStatement SEMI
  public static boolean subprogramDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subprogramDeclaration")) return false;
    if (!nextTokenIs(b, PROCEDURE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROCEDURE);
    r = r && procedureName(b, l + 1);
    r = r && subprogramDeclaration_2(b, l + 1);
    r = r && consumeToken(b, SEMI);
    r = r && subprogramDeclaration_4(b, l + 1);
    r = r && compoundStatement(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, SUBPROGRAM_DECLARATION, r);
    return r;
  }

  // formalParameters?
  private static boolean subprogramDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subprogramDeclaration_2")) return false;
    formalParameters(b, l + 1);
    return true;
  }

  // variableDeclaration?
  private static boolean subprogramDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subprogramDeclaration_4")) return false;
    variableDeclaration(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // factor (multiplicativeOperator factor)*
  public static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERM, "<term>");
    r = factor(b, l + 1);
    r = r && term_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (multiplicativeOperator factor)*
  private static boolean term_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_1", c)) break;
    }
    return true;
  }

  // multiplicativeOperator factor
  private static boolean term_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicativeOperator(b, l + 1);
    r = r && factor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // standardType | arrayType
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = standardType(b, l + 1);
    if (!r) r = arrayType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // variableName (LSQPAREN expression RSQPAREN)?
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variableName(b, l + 1);
    r = r && variable_1(b, l + 1);
    exit_section_(b, m, VARIABLE, r);
    return r;
  }

  // (LSQPAREN expression RSQPAREN)?
  private static boolean variable_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_1")) return false;
    variable_1_0(b, l + 1);
    return true;
  }

  // LSQPAREN expression RSQPAREN
  private static boolean variable_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LSQPAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RSQPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VAR (variableNames COLON type SEMI)+
  public static boolean variableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR);
    r = r && variableDeclaration_1(b, l + 1);
    exit_section_(b, m, VARIABLE_DECLARATION, r);
    return r;
  }

  // (variableNames COLON type SEMI)+
  private static boolean variableDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variableDeclaration_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!variableDeclaration_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variableDeclaration_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // variableNames COLON type SEMI
  private static boolean variableDeclaration_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variableNames(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NAME
  public static boolean variableName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableName")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    exit_section_(b, m, VARIABLE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // variableName (COMMA variableNames)*
  public static boolean variableNames(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableNames")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variableName(b, l + 1);
    r = r && variableNames_1(b, l + 1);
    exit_section_(b, m, VARIABLE_NAMES, r);
    return r;
  }

  // (COMMA variableNames)*
  private static boolean variableNames_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableNames_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!variableNames_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variableNames_1", c)) break;
    }
    return true;
  }

  // COMMA variableNames
  private static boolean variableNames_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableNames_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && variableNames(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
