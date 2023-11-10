// This is a generated file. Not intended for manual editing.
package com.github.ryosk.mpplplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.ryosk.mpplplugin.language.psi.impl.*;

public interface MpplTypes {

  IElementType ADDITIVE_OPERATOR = new MpplElementType("ADDITIVE_OPERATOR");
  IElementType ARRAY_TYPE = new MpplElementType("ARRAY_TYPE");
  IElementType ASSIGNMENT_STATEMENT = new MpplElementType("ASSIGNMENT_STATEMENT");
  IElementType BLOCK = new MpplElementType("BLOCK");
  IElementType CALL_STATEMENT = new MpplElementType("CALL_STATEMENT");
  IElementType COMPOUND_STATEMENT = new MpplElementType("COMPOUND_STATEMENT");
  IElementType CONDITION_STATEMENT = new MpplElementType("CONDITION_STATEMENT");
  IElementType CONSTANT = new MpplElementType("CONSTANT");
  IElementType EMPTY_STATEMENT = new MpplElementType("EMPTY_STATEMENT");
  IElementType EXIT_STATEMENT = new MpplElementType("EXIT_STATEMENT");
  IElementType EXPRESSION = new MpplElementType("EXPRESSION");
  IElementType EXPRESSIONS = new MpplElementType("EXPRESSIONS");
  IElementType FACTOR = new MpplElementType("FACTOR");
  IElementType FORMAL_PARAMETERS = new MpplElementType("FORMAL_PARAMETERS");
  IElementType INPUT_STATEMENT = new MpplElementType("INPUT_STATEMENT");
  IElementType ITERATION_STATEMENT = new MpplElementType("ITERATION_STATEMENT");
  IElementType LEFT_PART = new MpplElementType("LEFT_PART");
  IElementType MULTIPLICATIVE_OPERATOR = new MpplElementType("MULTIPLICATIVE_OPERATOR");
  IElementType OUTPUT_FORMAT = new MpplElementType("OUTPUT_FORMAT");
  IElementType OUTPUT_STATEMENT = new MpplElementType("OUTPUT_STATEMENT");
  IElementType PROCEDURE_NAME = new MpplElementType("PROCEDURE_NAME");
  IElementType RELATIONAL_OPERATOR = new MpplElementType("RELATIONAL_OPERATOR");
  IElementType RETURN_STATEMENT = new MpplElementType("RETURN_STATEMENT");
  IElementType SIMPLE_EXPRESSION = new MpplElementType("SIMPLE_EXPRESSION");
  IElementType STANDARD_TYPE = new MpplElementType("STANDARD_TYPE");
  IElementType STATEMENT = new MpplElementType("STATEMENT");
  IElementType SUBPROGRAM_DECLARATION = new MpplElementType("SUBPROGRAM_DECLARATION");
  IElementType TERM = new MpplElementType("TERM");
  IElementType TYPE = new MpplElementType("TYPE");
  IElementType VARIABLE = new MpplElementType("VARIABLE");
  IElementType VARIABLE_DECLARATION = new MpplElementType("VARIABLE_DECLARATION");
  IElementType VARIABLE_NAME = new MpplElementType("VARIABLE_NAME");
  IElementType VARIABLE_NAMES = new MpplElementType("VARIABLE_NAMES");

  IElementType AND = new MpplTokenType("AND");
  IElementType ARRAY = new MpplTokenType("ARRAY");
  IElementType ASSIGN = new MpplTokenType("ASSIGN");
  IElementType BEGIN = new MpplTokenType("BEGIN");
  IElementType BOOLEAN = new MpplTokenType("BOOLEAN");
  IElementType BREAK = new MpplTokenType("BREAK");
  IElementType CALL = new MpplTokenType("CALL");
  IElementType CHAR = new MpplTokenType("CHAR");
  IElementType COLON = new MpplTokenType("COLON");
  IElementType COMMA = new MpplTokenType("COMMA");
  IElementType COMMENT = new MpplTokenType("COMMENT");
  IElementType DIV = new MpplTokenType("DIV");
  IElementType DO = new MpplTokenType("DO");
  IElementType DOT = new MpplTokenType("DOT");
  IElementType ELSE = new MpplTokenType("ELSE");
  IElementType END = new MpplTokenType("END");
  IElementType EQUAL = new MpplTokenType("EQUAL");
  IElementType FALSE = new MpplTokenType("FALSE");
  IElementType GR = new MpplTokenType("GR");
  IElementType GREQ = new MpplTokenType("GREQ");
  IElementType IF = new MpplTokenType("IF");
  IElementType INTEGER = new MpplTokenType("INTEGER");
  IElementType LE = new MpplTokenType("LE");
  IElementType LEEQ = new MpplTokenType("LEEQ");
  IElementType LPAREN = new MpplTokenType("LPAREN");
  IElementType LSQPAREN = new MpplTokenType("LSQPAREN");
  IElementType MINUS = new MpplTokenType("MINUS");
  IElementType NAME = new MpplTokenType("NAME");
  IElementType NOT = new MpplTokenType("NOT");
  IElementType NOTEQ = new MpplTokenType("NOTEQ");
  IElementType NUMBER = new MpplTokenType("NUMBER");
  IElementType OF = new MpplTokenType("OF");
  IElementType OR = new MpplTokenType("OR");
  IElementType PLUS = new MpplTokenType("PLUS");
  IElementType PROCEDURE = new MpplTokenType("PROCEDURE");
  IElementType PROGRAM = new MpplTokenType("PROGRAM");
  IElementType READ = new MpplTokenType("READ");
  IElementType READLN = new MpplTokenType("READLN");
  IElementType RETURN = new MpplTokenType("RETURN");
  IElementType RPAREN = new MpplTokenType("RPAREN");
  IElementType RSQPAREN = new MpplTokenType("RSQPAREN");
  IElementType SEMI = new MpplTokenType("SEMI");
  IElementType STAR = new MpplTokenType("STAR");
  IElementType STRING = new MpplTokenType("STRING");
  IElementType THEN = new MpplTokenType("THEN");
  IElementType TRUE = new MpplTokenType("TRUE");
  IElementType VAR = new MpplTokenType("VAR");
  IElementType WHILE = new MpplTokenType("WHILE");
  IElementType WRITE = new MpplTokenType("WRITE");
  IElementType WRITELN = new MpplTokenType("WRITELN");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADDITIVE_OPERATOR) {
        return new MpplAdditiveOperatorImpl(node);
      }
      else if (type == ARRAY_TYPE) {
        return new MpplArrayTypeImpl(node);
      }
      else if (type == ASSIGNMENT_STATEMENT) {
        return new MpplAssignmentStatementImpl(node);
      }
      else if (type == BLOCK) {
        return new MpplBlockImpl(node);
      }
      else if (type == CALL_STATEMENT) {
        return new MpplCallStatementImpl(node);
      }
      else if (type == COMPOUND_STATEMENT) {
        return new MpplCompoundStatementImpl(node);
      }
      else if (type == CONDITION_STATEMENT) {
        return new MpplConditionStatementImpl(node);
      }
      else if (type == CONSTANT) {
        return new MpplConstantImpl(node);
      }
      else if (type == EMPTY_STATEMENT) {
        return new MpplEmptyStatementImpl(node);
      }
      else if (type == EXIT_STATEMENT) {
        return new MpplExitStatementImpl(node);
      }
      else if (type == EXPRESSION) {
        return new MpplExpressionImpl(node);
      }
      else if (type == EXPRESSIONS) {
        return new MpplExpressionsImpl(node);
      }
      else if (type == FACTOR) {
        return new MpplFactorImpl(node);
      }
      else if (type == FORMAL_PARAMETERS) {
        return new MpplFormalParametersImpl(node);
      }
      else if (type == INPUT_STATEMENT) {
        return new MpplInputStatementImpl(node);
      }
      else if (type == ITERATION_STATEMENT) {
        return new MpplIterationStatementImpl(node);
      }
      else if (type == LEFT_PART) {
        return new MpplLeftPartImpl(node);
      }
      else if (type == MULTIPLICATIVE_OPERATOR) {
        return new MpplMultiplicativeOperatorImpl(node);
      }
      else if (type == OUTPUT_FORMAT) {
        return new MpplOutputFormatImpl(node);
      }
      else if (type == OUTPUT_STATEMENT) {
        return new MpplOutputStatementImpl(node);
      }
      else if (type == PROCEDURE_NAME) {
        return new MpplProcedureNameImpl(node);
      }
      else if (type == RELATIONAL_OPERATOR) {
        return new MpplRelationalOperatorImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new MpplReturnStatementImpl(node);
      }
      else if (type == SIMPLE_EXPRESSION) {
        return new MpplSimpleExpressionImpl(node);
      }
      else if (type == STANDARD_TYPE) {
        return new MpplStandardTypeImpl(node);
      }
      else if (type == STATEMENT) {
        return new MpplStatementImpl(node);
      }
      else if (type == SUBPROGRAM_DECLARATION) {
        return new MpplSubprogramDeclarationImpl(node);
      }
      else if (type == TERM) {
        return new MpplTermImpl(node);
      }
      else if (type == TYPE) {
        return new MpplTypeImpl(node);
      }
      else if (type == VARIABLE) {
        return new MpplVariableImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new MpplVariableDeclarationImpl(node);
      }
      else if (type == VARIABLE_NAME) {
        return new MpplVariableNameImpl(node);
      }
      else if (type == VARIABLE_NAMES) {
        return new MpplVariableNamesImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
